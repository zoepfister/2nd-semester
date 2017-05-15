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

#define SHMSZ 27

int main(int argc, char *argv[]) {
	
	// For the shared_mem
	int *sharedInt;
	int shmid;
	key_t key = 5678;
	
	// For the FIFO
	FILE *fp_fifo;
	int count;
	char buf[4096];
	unlink("RESULT_FIFO");
	
	/*========== Create shared mem segment ===========*/
		
	if ((shmid = shmget(key, sizeof(int*), IPC_CREAT | 0666)) < 0) {
		perror("shmget");
		exit(EXIT_FAILURE);
	}
	
	if ((sharedInt = (int*) shmat(shmid, NULL, 0)) == (int*) -1) {
		perror("shmat");
		exit(EXIT_FAILURE);
	}
	
	// Setting the shm startingpoint to 0
	int* sharedIntStart = sharedInt;
	*sharedIntStart++ = 0;
	
	/*========== Create FIFO ===========*/
	
	if (mkfifo("RESULT_FIFO", 0777) == -1) {
		perror("mkfifo");
		exit(EXIT_FAILURE);
	}
	
	// open file for reading
	
	if ((fp_fifo = fopen("RESULT_FIFO", "r")) == NULL) {
		perror("fopen");
		exit(EXIT_FAILURE);
	}
	
	// print what you got
	printf("I got: ");
	while ((count = fscanf(fp_fifo, "%s", buf)) > 0) {
		printf("%s", buf);
	}
	printf("\n");
	
	// close file after that
	if (fclose(fp_fifo) == EOF) {
		perror("fclose");
		exit(EXIT_FAILURE);
	}
	
	if (unlink("RESULT_FIFO") == -1) {
		perror("unlink");
		exit(EXIT_FAILURE);
	}
		
	shmdt(sharedInt);
	shmctl(shmid, IPC_RMID, NULL);
		
	
	return EXIT_SUCCESS;
}