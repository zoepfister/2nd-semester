#include <stdio.h> 
#include <stdlib.h> 
#include <stdbool.h> 
#include <unistd.h> 
#include <sys/types.h> 
#include <sys/wait.h> 

int main(int argc, char * argv[]) {
	int fd[2]; 

	pid_t child_1, child_2;
	
	// Create the char_arrays with the arguments
	char* ls_args[] =  {"ls", "-l", 0}; 
	char* grep_args[] =  {"grep", argv[1], 0}; 
				
	// Create the pipe for future use
	if (pipe(fd) == -1) {
		perror("Pipe failed"); 
		exit(EXIT_FAILURE); 
	}

	if ((child_1 = fork()) == 0){
		// Child 1 code:
		// Closing stdout
		close(STDOUT_FILENO); 
		// replacing stdout with pipe write 
		dup(fd[1]); 

		// closing pipe read
		close(fd[0]); 
		close(fd[1]); 

		// Executing the commands
		execvp(ls_args[0], ls_args); 
		perror("execvp of ls failed"); 
		exit(EXIT_FAILURE); 
	}

	if ((child_2 = fork()) == 0){
		// Child 2 code

		// closing stdin
		close(STDIN_FILENO); 
		// replacing stdin with pipe read
		dup(fd[0]); 

		// closing pipe write
		close(fd[1]); 
		close(fd[0]); 
					
		// Executing the commands
		execvp(grep_args[0], grep_args); 
		perror("execvp of wc failed"); 
		exit(EXIT_FAILURE); 
	}
	
		close(fd[0]); 
		close(fd[1]); 

		// Wait for both childs to finish
		wait(NULL); 
		wait(NULL); 
		return EXIT_SUCCESS; 
}