#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>

#define CHILDREN_AMOUNT 9

int main(int argc, char *argv[]) {
	
	// pid of parrent process
	//	pid_t pid = getpid();
	//	int status = 0;
	
	// create array of 9 process id's
	pid_t pids[CHILDREN_AMOUNT];
	int i;
	int n = CHILDREN_AMOUNT;
	
	for (i = 0; i < n; i++) {
			// Create child process and check if errors occured
			pids[i] = fork();
			if (pids[i] < 0) {
				perror("fork");
				abort();
			} else if (pids[i] == 0) {
				printf("I am a child: %d with PID: %d\n",i, getpid());
				printf("Child will exit now...\n");
				// forces the child out of the cpu
				// Very, very important!
				exit(0); 
			} 
		}

	// wait for all processes to finish if something weird happens
	// wait removes the child process information from the kernel!
	wait(NULL);	
	return EXIT_SUCCESS;
}