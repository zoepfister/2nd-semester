#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/sem.h>

#define CHILDREN_AMOUNT 100
#define SHMSZ 27

int main(int argc, char *argv[]) {
	
	// For the shared_mem
	int *sharedInt;
	int shmid;
	key_t key = 5678;
	
	// For the FIFO
	FILE *fp_fifo;
//	int count;
//	char buf[4096];

	int semid;
	union semun arg;
	
	// create array of 100 process id's
	pid_t pids[CHILDREN_AMOUNT];
	int i;
	int n = CHILDREN_AMOUNT;
	
	if ((shmid = shmget(key, sizeof(int*), 0666)) < 0) {
		perror("shmget");
		exit(EXIT_FAILURE);
	}
		
	if ((sharedInt = (int*) shmat(shmid, NULL, 0)) == (int*) -1) {
		perror("shmat");
		exit(EXIT_FAILURE);
	}
	
	if (( semid = semget(5L, 1, IPC_CREAT | 0666) ) < 0 ) {
	perror("semget failed");
	exit(EXIT_FAILURE);
	}	
	
	/* initialize semaphore #0 to 1: */
	arg.val = 1;
	if (semctl(semid, 0, SETVAL, arg) == -1) {
	perror("semctl");
	exit(EXIT_FAILURE); 
	}
	
	struct sembuf sb = {0, -1, 0};  /* set to allocate resource */
	
	 /* grab the semaphore set */
	if ((semid = semget(5L, 1, 0)) == -1) {
		perror("semget");
		exit(EXIT_FAILURE); 
	}
		
	for (i = 0; i < n; i++) {
			// Create child process and check if errors occured
			pids[i] = fork();
			if (pids[i] < 0) {
				perror("fork");
				abort();
			} else if (pids[i] == 0) {
				printf("I am a child: %d with PID: %d\n",i, getpid());
				

				if (semop(semid, &sb, 1) == -1) {
						perror("semop");
				exit(1); }

				int* sharedIntStart = sharedInt;
				for (int i = 0; i < 100; i++){
					*sharedIntStart += 1;
				}
				
				sb.sem_op = 1; /* free resource */
				if (semop(semid, &sb, 1) == -1) {
				perror("semop");
				exit(EXIT_FAILURE); 
				}
				
				
				// forces the child out of the cpu
				// Very, very important!
				printf("Child will exit now...\n");
				exit(0); 
			}
			wait(NULL); 
		}
		
		int* sharedIntStart = sharedInt;
		printf("%d\n", *sharedIntStart);
		 
		if ((fp_fifo = fopen("RESULT_FIFO", "w")) == NULL) {
			perror("fopen");
			exit(EXIT_FAILURE);
		}
		
		fprintf(fp_fifo, "%d", *sharedIntStart);
		
		if ( fclose(fp_fifo) == EOF ) {
			perror("fclose");
			exit(EXIT_FAILURE);
		}
		
		
	
		shmdt(sharedInt);
		shmctl(shmid, IPC_RMID, NULL);
		
		//sem_destroy(sem);
		
	// wait for all processes to finish if something weird happens
	// wait removes the child process information from the kernel!
	wait(NULL);	
	return EXIT_SUCCESS;
}