#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>
#include <unistd.h>

#define CHILDREN_AMOUNT 1

volatile sig_atomic_t print_flag = false;

void sig_handler(int signo)
{
	if (signo == SIGUSR1){
		printf("received SIGUSR1\n");
	} else if (signo == SIGUSR2) {
		printf("received SIGUSR2\n");
	} else if (signo == SIGALRM) {
		print_flag = true;
	}
}

int main(int argc, char *argv[]) {
	signal(SIGALRM, sig_handler);
	struct sigaction sa;
	
	sa.sa_handler = &sig_handler;
	sa.sa_flags = SA_RESTART;
	

	// pid of parrent process
	pid_t pid = getpid();
	printf("Parent PID: %d.\n", pid);
	
	pid_t child_pid = fork();
	if (child_pid < 0) {
		printf("Fork error!\n");
		abort();
	} else if (child_pid == 0) {
		pid_t child_pid = getpid();
		printf(" → Child width PID of %d created!\n", child_pid);
		for(int i = 3; i == 0; i--){
			pause();
			if ((sigaction(SIGUSR1, &sa, NULL)) == -1) {
				printf("Cannot handle SIGUSR1!\n");
			}
		}
		exit(0);
	} else {
	
	for (int j = 0; j < 5;j++) {
		// Alarm start
		alarm(2);
		while (true){
			if (print_flag) {
				print_flag = false;
				printf("Hello!\n");
				kill(child_pid, SIGUSR1);
				kill(child_pid, SIGUSR2);
				break;
			}
		
		}
		// Alarm end
		
		
	}
}
	
	
	
	
	
//	wait(NULL);	
//	printf(" ♦ Child with PID %ld exited with status 0x%x.\n", (long)child_pid, status);

	
	return EXIT_SUCCESS;
}