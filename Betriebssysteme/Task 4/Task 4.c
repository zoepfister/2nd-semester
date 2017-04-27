#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
	// pid of parrent process
	pid_t pid = getpid();
	printf("Parent PID: %d.\n", pid);
	
	pid_t child_pid = fork();
	if (child_pid < 0) {
		printf("Fork error!\n");
		abort();
	} else if (child_pid == 0) {
		pid_t child_pid = getpid();
		printf(" → Child with PID of %d created!\n", child_pid);
		exit(0);
	} else {
	// wait for process with pid of child_pid to finish
	waitpid(child_pid, NULL, 0);
	printf(" ♦ Child with PID %ld exited.", (long)child_pid);
	}
	
	return EXIT_SUCCESS;
}