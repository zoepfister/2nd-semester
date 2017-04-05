#include <stdio.h>
#include <stdlib.h>


struct node {
	int data;
	struct node* next;
};

// Two glboal variables to store address of front and rear nodes.
struct node* front = NULL;
struct node* rear = NULL;

// O(1)
void Enqueue(int value) {
	struct node* temp = malloc(sizeof(struct node));
	temp->data = value;
	temp->next = NULL;

	// If there is no other item in queue
	if (front == NULL && rear == NULL) {
		// front and rear pointers to temp
		front = temp;
		rear = temp;
		return;
	} else {
		// else set the next rear element to temp
		rear->next = temp;
		// and make it the new rear of the queue
		rear = temp;
	}

}

// O(1)
void Dequeue() {
	// create temp var to test if
	struct node* temp = front;

	if (front == NULL) {
		printf("Queue is Empty\n");
		return;

	} else if (front == rear) {
		front = rear = NULL;

	} else {
		front = front->next;
	}

	free(temp);
}

// O(n)
void Print() {
	struct node* temp = front;
	printf("Queue: ");
	while (temp != NULL) {
		if (temp->next != NULL)
		{
			printf("%d <- ", temp->data);
		} else {
			printf("%d", temp->data);
		}

		temp = temp->next;
	}
	printf("\n");
}

// O(n) – could be constant
int size() {
	int size = 0;
	struct node* temp = front;

	do {
		temp = temp->next;
		size += 1;
	} while (temp != NULL);

	return size;
}

int main(void) {

	Enqueue(2); Print();
	Enqueue(4); Print();
	Enqueue(6); Print();
	Dequeue();  Print();
	Enqueue(8); Print();
	printf("Length of Queue: %d\n", size());


}