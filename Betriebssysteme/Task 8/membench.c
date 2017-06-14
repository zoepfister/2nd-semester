#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <pthread.h>

int T;
int N;
int S;
void *global_base = NULL;

struct block_meta {
	size_t size;
	struct block_meta *next;
	int free;
	int magic; // For debugging only. TODO: remove this in non-debug mode.
};

#define META_SIZE sizeof(struct block_meta)

static void cleanup_routine(void *arg){
}

void *thread_routine(void *arg){
	printf("T: %d, N:%d, S:%d \n", T, N, S);
	
	for(int j = 0; j < N; j++){
		void* allocate = malloc(S);
		free(allocate);
	}
	pthread_exit(arg);
}

struct block_meta *find_free_block(struct block_meta **last, size_t size) {
	struct block_meta *current = global_base;
	while (current && !(current->free && current->size >= size)) {
		*last = current;
		current = current->next;
	}
	return current;
}

struct block_meta *request_space(struct block_meta* last, size_t size) {
	struct block_meta *block;
	block = sbrk(0);
	void *request = sbrk(size + META_SIZE);
	assert((void*)block == request); // Not thread safe.
	if (request == (void*) -1) {
		return NULL; // sbrk failed.
	}

	if (last) { // NULL on first request.
		last->next = block;
	}
	block->size = size;
	block->next = NULL;
	block->free = 0;
	block->magic = 0x12345678;
	return block;
}

void *malloc_best(size_t size) {
	struct block_meta *block;
	// TODO: align size?

	if (size <= 0) {
		return NULL;
	}

	if (!global_base) { // First call.
		block = request_space(NULL, size);
		if (!block) {
			return NULL;
		}
		global_base = block;
	} else {
		struct block_meta *last = global_base;
		block = find_free_block(&last, size);
		if (!block) { // Failed to find free block.
			block = request_space(last, size);
			if (!block) {
				return NULL;
			}
		} else {      // Found free block
			// TODO: consider splitting block here.
			block->free = 0;
			block->magic = 0x77777777;
		}
	}

	return(block+1);
}

void free_best(void *ptr) {
	if (!ptr) {
		return;
	}

	// TODO: consider merging blocks once splitting blocks is implemented.
	struct block_meta* block_ptr = get_block_ptr(ptr);
	assert(block_ptr->free == 0);
	assert(block_ptr->magic == 0x77777777 || block_ptr->magic == 0x12345678);
	block_ptr->free = 1;
	block_ptr->magic = 0x55555555;
}

int main(int argc, char *argv[]) {
	
	if (argc != 4) {
		printf("Usage: ./membench T N S");
		return EXIT_FAILURE;
	}
	T = atoi(argv[1]);
	N = atoi(argv[2]);
	S = atoi(argv[3]);
	
	pthread_t id[T];

	for (int i = 0; i < T; ++i) {
		pthread_create(&id[i], NULL, &thread_routine, NULL);
	}
	
	for (int i = 0; i < T; ++i) {
		pthread_join(id[i], NULL);
	}

	printf("Waited for all threads, exiting...\n");
	
	return EXIT_SUCCESS;
}
