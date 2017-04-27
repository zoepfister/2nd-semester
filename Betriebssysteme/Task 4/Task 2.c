#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>

#define CHILDREN_AMOUNT 16

int main(int argc, char *argv[]) {
	// pid of parrent process
	pid_t pid;
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
	

	while (n > 0) {
		pid = wait(&status);
		printf("♦ Child with PID %ld exited with status 0x%x.\n", (long)pid, status);
		n--;
	}
	printf("\n ──────────────────────────────────\n");
	printf("%d child processes have been created!\n", CHILDREN_AMOUNT);

	
	return EXIT_SUCCESS;
}