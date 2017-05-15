#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>

#define CHILDREN_AMOUNT 16

int main(int argc, char *argv[]) {
	
	// pid of parrent process
	pid_t pid = getpid();
	int status = 0;
	
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
			printf("→ I am a child: %d with PID: %d\n",i, getpid());
			exit(0); // forces the child out of the cpu
		}
	} 

	printf("\n ──────────────────────────────────\n");
	printf("%d child processes have been created!\n", CHILDREN_AMOUNT);
	printf("──────────────────────────────────\n\n");

	// Wait for all children
	while (n > 0) {
		// For printing the correct child_pid
		pid = wait(&status);
		printf("♦ Child with PID %d exited.\n", pid);
		n--;
	}
	
	return EXIT_SUCCESS;
}