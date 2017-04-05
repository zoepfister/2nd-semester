#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int recursion(int n);
int iterative(int n);

int main(int argc, char *argv[]) {
	printf("%d\n", recursion(14));
	printf("%d\n", iterative(14));
	return EXIT_SUCCESS;
}

int recursion(int n){
	if (n==4) {
		return n;
	} else if (n%2==1) {
		return recursion(3*n+1);
	} else if (n%2==0) {
		return recursion(n/2);
	}
	exit(EXIT_FAILURE);
}

int iterative(int n){
	while (true) {
		if (n==4) {
			return n;
		} else if (n%2==1) {
			n = (3*n+1);
		} else if (n%2==0) {
			n = (n/2);
		}
		printf("%d, ", n);
	}
}