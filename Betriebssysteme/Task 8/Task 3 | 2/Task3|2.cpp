#include <iostream>
#include <queue>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <sys/syscall.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <pthread.h>

using namespace std;

pthread_t id[4];
pthread_cond_t full = PTHREAD_COND_INITIALIZER;
pthread_cond_t empty = PTHREAD_COND_INITIALIZER;
pthread_mutex_t myMutex = PTHREAD_MUTEX_INITIALIZER;
std::queue<unsigned> producerQueue;
int i = 0;

void *thread_routine(void *arg){
	unsigned sum = 0;
	// How can I make every thread continue after the queue is filled?
	while (producerQueue.size()<100000) {};
	pthread_cond_wait(&cond, &myMutex);
	while (true) {
		if (producerQueue.front() != 0) {
			sum += producerQueue.front();
			producerQueue.pop();
		} else {
		break;
		}
	}
	printf("Customer%d's sum: %u\n", i++, sum);
	return EXIT_SUCCESS;
}

int main(int argc, char *argv[]) {
	
	for (int i = 0; i < 4; ++i) {
		pthread_create(&id[i], NULL, &thread_routine, NULL);
	}
	
	for (int i = 0; i < 100000;i++) {
		producerQueue.push(1);
	}
	for (int i = 0;i < 4;i++) {
		producerQueue.push(0);
	}
	
//	printf("%lu", producerQueue.size());
	
	for (int i = 0; i < 4; ++i) {
		pthread_join(id[i], NULL);
	}
	
	pthread_mutex_destroy(&myMutex);
	pthread_cond_destroy(&cond);
	
	return EXIT_SUCCESS;
}