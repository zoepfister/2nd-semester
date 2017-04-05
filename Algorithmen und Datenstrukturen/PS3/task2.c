#include <stdio.h>
#include <stdlib.h>

// Typical linked list structure
struct node{
	int data;
	struct node *next;
};
typedef struct node node;

// Initialise head with NULL
void init_stack(struct node* head){
	head = NULL;
}

// O(1)
struct node* push(struct node* head, int data){
	// Create temporary node 
	struct node* temp = malloc(sizeof(struct node));
	// Malloc NULL check
	if(temp == NULL)
	{
		exit(EXIT_FAILURE);
	}
	
	temp->data = data;
	temp->next = head;
	// temporary node becomes the new head
	head = temp;
	return head;
}

// O(1)
// The int pointer to element allows us to print the element later
struct node* pop(struct node *head, int *element) {
	struct node* temp = head;
	*element = head->data;
	// change the head to the next element in stack
	head = head->next;
	free(temp);
	return head;
}

// O(n)
int size(struct node *head){
	if (head == NULL) {
		printf("There is nothing here!\n");
		return 0;
	}
	int size = 0;
	struct node* temp = head;
	do {
		size += 1;
		temp = temp->next;
	} while (temp != NULL);
	return size;
}

// O(n)
void print_stack(struct node* head)
{
	struct node *current;
	current = head;
	if(current!= NULL)
	{
		printf("Stack: ");
		do
		{
			printf("%d ",current->data);
			current = current->next;
		}
		while (current!= NULL);
		printf("\n");
	}
	else
	{
		printf("The Stack is empty\n");
	}
 
}

int main(int argc, char *argv[]) {
	struct node* head = NULL;
	int element;
		
		head = push(head, 12); print_stack(head);
		head = push(head, 11); print_stack(head);
		printf("Elements in Stack: %d\n", size(head));
		head = push(head, 14); print_stack(head);
		head = pop(head, &element); print_stack(head);
		head = pop(head, &element);
		
		print_stack(head);
		printf("Elements in Stack: %d\n", size(head));

	return EXIT_SUCCESS;
}