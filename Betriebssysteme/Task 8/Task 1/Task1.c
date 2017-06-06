#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <pthread.h>

// FILE *inputFiles[10];
pthread_t id[10];
int i = 0;

int get_random_number_between_0(int and);
void cancel_thread_50_50(void);

static void cleanup_routine(void *arg){
	printf("Called clean-up handler\n");
	fclose(arg);
}

void *thread_routine(void *arg){
	sleep(get_random_number_between_0(2));
	printf("Thread %d (%d) opened\n", (int)arg, (int)id[i]);
	char filename[13] = "thread0.txt";
	FILE *file; 
	sprintf(filename, "thread%d.txt", (int)arg);
	file = fopen(filename, "a");
	pthread_cleanup_push(cleanup_routine, file);
	fprintf(file, "%ld", (long)pthread_self());
	fclose(file);
	i++;
	pthread_cleanup_pop(cleanup_routine);
	pthread_exit(arg);
}

int main() {
	srand(time(NULL));

	for (int i = 0; i < 10; ++i) {
		pthread_create(&id[i], NULL, &thread_routine, i);
	}
	
	cancel_thread_50_50();
	
	for (int i = 0; i < 10; ++i) {
		pthread_join(id[i], NULL);
	}

	printf("Waited for all threads, exiting...\n");
	
	return EXIT_SUCCESS;
}

int get_random_number_between_0(int and){
	// splitted args to allow 0
	int r = rand();
	return r % (and+1);
}

void cancel_thread_50_50(void){
	for (int i = 0;i < 10; ++i) {
			if (get_random_number_between_0(1) == 0) {
				printf("Thread with id %d canceled!\n", (int)id[i]);
				pthread_cancel(id[i]);
			}
		}
}