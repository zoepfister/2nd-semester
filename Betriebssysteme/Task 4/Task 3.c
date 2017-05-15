#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>
#include <unistd.h>


// Questions:
/*
	- What is the flow of such a program?
	- How to block signals for a duration of seconds?
*/

#define CHILDREN_AMOUNT 1

// Here is my signal handler
void handle_signal(int signal) {
	// Find out which signal we're handling
	switch (signal) {
		case SIGUSR1:
			printf("Got SIGUSR1, continuing...\n");
			break;
		case SIGUSR2:
			printf("Caught SIGUSR2, exiting now...\n");
			exit(0);
		default:
			fprintf(stderr, "Caught wrong signal: %d\n", signal);
			return;
	}
}

// A seperate handler for sigalrm
void handle_sigalrm(int signal) {
	if (signal != SIGALRM) {
		fprintf(stderr, "Caught wrong signal: %d\n", signal);
	}
}

// Function that uses the alarm function to make a func wait.
void do_sleep(int seconds){
	struct sigaction sa;
	sigset_t mask;
		
	sa.sa_handler = &handle_sigalrm; // Intercept and ignore SIGALRM
	sa.sa_flags = SA_RESETHAND; // Remove the handler after first signal
	sigfillset(&sa.sa_mask);
	sigaction(SIGALRM, &sa, NULL);
		
		// Get the current signal mask
	sigprocmask(0, NULL, &mask);

		// Unblock SIGALRM
	sigdelset(&mask, SIGALRM);

		// Wait with this mask
	alarm(seconds);
	sigsuspend(&mask);
}

int main(int argc, char *argv[]) {
	
	// Prepare sigaction
	struct sigaction sa;
	
	// pid of parrent process
	pid_t pid = getpid();
	printf("Parent PID: %d.\n", pid);
	
	// sigaction prep
	sa.sa_handler = &handle_signal;
	sigfillset(&sa.sa_mask);
	
	// Create a child process with it's on pid
	pid_t child_pid = fork();
	
	// Success check
	if (child_pid < 0) {
		printf("Fork error!\n");
		abort();
		
	// Child starts here
	} else if (child_pid == 0) {
		
		pid_t child_pid = getpid();
		printf(" → Child width PID of %d created!\n", child_pid);

		// Signal receiver
		signal(SIGUSR1, handle_signal);
		signal(SIGUSR2, handle_signal);
		
		pause();
		while(true);
		
		// How do you do the above with sigaction()?
		
		//			if (sigaction(SIGUSR1, &sa, NULL) < 0) {
		//				printf("Cannot handle SIGUSR1!\n");
		//			}
		//			if (sigaction(SIGUSR2, &sa, NULL) < 0) {
		//				printf("Cannot handle SIGUSR2!\n");
		//			}
		//			printf("Signal recieved!\n");
	
	} else {
		// Parent section
		sa.sa_handler = SIG_DFL;
		sigaction(SIGUSR1, &sa, NULL);
		sigaction(SIGUSR2, &sa, NULL);
		
		// Need to sleep here because otherwise, forloop would run
		// twice on startup
		do_sleep(1);
		
		for (int j = 0; j < 3;j++) {
			
		if (kill(child_pid, SIGUSR1) == 0){
			printf("Signal SIGUSR1 sent!\n");
		}		
		do_sleep(5);
	}
	if (kill(child_pid, SIGUSR2) == 0){
			printf("Signal SIGUSR2 sent!\n");
	}
}

	wait(NULL);	
	printf(" ♦ Child with PID %d exited.\n", child_pid);
	printf(" ♦ Parent with PID %d exited.\n", getpid());
	
	return EXIT_SUCCESS;
}