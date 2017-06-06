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
static pthread_spinlock_t spinlock;
std::queue<unsigned> producerQueue;
int i = 0;

void *thread_routine(void *arg){
	unsigned sum = 0;
	// How can I make every thread continue after the queue is filled?
	while (producerQueue.size()<100000) {continue;};
	while (true) {
		pthread_spin_lock(&spinlock);
		if (producerQueue.front() != 0) {
			sum += producerQueue.front();
			producerQueue.pop();
		pthread_spin_unlock(&spinlock);
		} else {
		pthread_spin_unlock(&spinlock);
		break;
		}
	}
	printf("Customer%d's sum: %u\n", i++, sum);
	return EXIT_SUCCESS;
}

int main(int argc, char *argv[]) {
	
	pthread_spin_init(&spinlock, 0);
	
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
	
	pthread_mutex_destroy(&zaehler_mutex);
	
	return EXIT_SUCCESS;
}