#include "btree.h"

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

struct btree{
	struct btree_node *root;
	int count;
};

struct btree_node{
	int value;
	struct btree_node *right;
	struct btree_node *left;
};

static btree_node* getNode(btree* t){
	return t->root;
}

static btree_node* create_node(int d){
	btree_node *new_node = malloc(sizeof(struct btree_node));
	if (new_node == NULL) {
		printf("There has been a allocation error!");
		exit(EXIT_FAILURE);
	}
	
	new_node->value = d;
	new_node->left = NULL;
	new_node->right = NULL;
	return new_node;
}

static void raiseCounter(btree* t){
	t->count += 1;
}

int main(int argc, char *argv[]) {
	int x = 12;
	
	btree *tree = btree_create();
	btree_insert(tree, 10);
	btree_insert(tree, 12); 
	btree_insert(tree, 2);
	btree_insert(tree, 4);
	btree_insert(tree, 11);
//	btree_remove(tree, 2);
//	btree_remove(tree, 12);
//	btree_remove(tree, 4);
	btree_remove(tree, 10);
	
	printf("Contains %d: %s\n", x, btree_contains(tree, x) ? "true" : "false");
	printf("Root: %d\n", tree->root->value);
	printf("Minimum: %d\n", btree_minimum(tree));
	printf("Maximum: %d\n", btree_maximum(tree));
	btree_destroy(tree);
	return EXIT_SUCCESS; 
}

btree* btree_create(){
	// create an empty root node
	btree *tree = malloc(sizeof(struct btree));
	// default value of 0
	tree->root = NULL;
	tree->count = 1;
	return tree;
}

static void delete_tree(btree_node* root){
	if (root != NULL) {
		delete_tree(root->left);
		delete_tree(root->right);
		// Delete node
		free(root);
	}
}

void btree_destroy(btree* t){
	// Using static function above, which makes more 
	// sense to me.
	delete_tree(getNode(t));
}

/// Returns the smallest number in tree 't'
int btree_minimum(const btree* t){
	btree_node* node = t->root;
	// As long as next node on the left isn't NULL,
	// go one node more to the left.	
	while (node->left != NULL) {
		node = node->left;
	}
	return node->value;
}

/// Returns the largest number in tree 't'
int btree_maximum(const btree* t){
	// Same as min for right node.
	btree_node* node = t->root;
	while (node->right != NULL) {
		node = node->right;
	}
	return node->value;	
}

void btree_insert(btree* t, int d){
	if (t->root == NULL) {
		btree_node* root = create_node(d);
		t->root = root;
		raiseCounter(t);
	} else {
		
		bool is_left = false;
		btree_node* cursor = getNode(t);
		btree_node* previouse_node = NULL;
		
		while (cursor != NULL) {
			previouse_node = cursor;
			if (d > cursor->value) {
				is_left = false;
				cursor = cursor->right;
			} else if (d < cursor->value) {
				is_left = true;
				cursor = cursor->left;
			}
		}
		if (is_left) {
			previouse_node->left = create_node(d);
		} else {
			previouse_node->right = create_node(d);
		}
		raiseCounter(t);
	}
}

bool btree_contains(const btree* t, int d){
	btree_node* root = t->root;
	
	// in case root is desired value
	if (root->value == d) {
		return true;
	}
	
    // So we don't get lost in nodes
	btree_node* cursor = root;
	
	while (true) {
		// if the value is greater, check if the next to right is NULL,
		// if not, go further to the right
		if (d > cursor->value) {
			if (cursor->right != NULL) {
				cursor = cursor->right;
			} else {
				return false;
			}
		// Explicitly writing else if for readability
		// Same as above with left
		} else if (d < cursor->value) {
			if (cursor->left != NULL) {
				cursor = cursor->left;
			} else {
				return false;
			}
		}
				
		if (cursor->value == d) {
			return true;
		}
		
	}
	
	return false;

}

void btree_remove(btree* t, int d){
	if (t == NULL) {
		printf("This tree does not exist!\n");
		return;
	}
	
	if (!(btree_contains(t, d))) {
		printf("This data does not exist in this tree!\n");
		return;
	}
	
	btree_node* root = t->root;
	btree_node* previous = NULL;
	btree_node* next_left = NULL;
	btree_node* next_right = NULL;
	btree_node* cursor = root;
	
	// if the root get's deleted
	if (root->value == d) {
		btree_node* previous_root = t->root;
		
		next_left = t->root->left;
		next_right = t->root->right;
		
		// in case there are values on both sides,
		// I pull up the right side
		if ((next_right != NULL) && (next_left != NULL)) {
			// change the root to the next on the ride and
			// create a cursor
			
			t->root = next_right;
			cursor = t->root;
			
			// get to the smallest element of the new root 
			while (cursor->left != NULL) {
				cursor = cursor->left;
			}
			// and set the next smallest element of the roots
			// smallest element to the previous roots left element.
			// (next left still has the info of the old root left)
			cursor->left = next_left;
		} else if (next_right == NULL) {
			t->root = next_left;
			cursor = t->root;
			
			while (cursor->right != NULL) {
				cursor = cursor->right;
			}
			cursor->right = next_right;
			
		} else if (next_left == NULL) {
			t->root = next_right;
			cursor = t->root;
			
			while (cursor->left != NULL) {
				cursor = cursor->left;
			}
			cursor->left = next_left;
		} else {
			free(t->root);
		}
		// free the previous root
		free(previous_root);
		return;
	}
	
	// For the other cases
	// copied from btree_contains
	while (true) {
		// remember the previous node to delete next node later
		previous = cursor;
		
		
		// if the value is greater, check if the next to right is NULL,
		// if not, go further to the right
		if (d > cursor->value) {
			cursor = cursor->right;
				
		// Explicitly writing else if for readability
		// Same as above with left
		} else if (d < cursor->value) {
			cursor = cursor->left;				
		}
		
		next_left = cursor->left;
		next_right = cursor->right;
					
		if (cursor->value == d) {
			// If there is no more element after cursor
			if ((cursor->left == NULL) && (cursor->right == NULL)) {
				free(cursor);
				if (d > previous->value) {
					// remove reference to next element
					previous->right = NULL;
					
					// Readability
				} else if (d < previous->value) {
					previous->left = NULL;
				}
				break;
				// if there is at least one element after cursor
			} else {
				free(cursor);
				
				// we'll have 3: next_left = NULL; next_right = NULL, both != NULL
				// both != NULL
				if ((next_left != NULL) && (next_right != NULL)) {
					if (d > previous->value) {
						previous->right = next_left->value > next_right->value ? next_right : next_left;					
					} else if (d < previous->value){
						previous->left = next_left->value > next_right->value ? next_left : next_right;
					}
				} else if (next_left == NULL) {
					if (d > previous->value) {
						previous->right = next_right;					
					} else if (d < previous->value){
						previous->left = next_right;
					}
				} else if (next_right == NULL) {
					if (d > previous->value) {
						previous->right = next_left;					
					} else if (d < previous->value){
						previous->left = next_left;
					}
				}
				break;
			}
			
		}
						
	}

}





