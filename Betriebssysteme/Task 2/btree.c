// Github:
// https://github.com/Buchenherz/2nd-semester/tree/master/Betriebssysteme/Task%202

#include "btree.h"

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

/*==================================
=            Structures            =
==================================*/

struct btree {
	struct btree_node *root;
	size_t size;
};

struct btree_node {
	int value;
	// you could add a *parent here to make a pointer 
	// based implementation easier
	struct btree_node *right;
	struct btree_node *left;
};

/*=====  End of Structures  ======*/

int main(void) {
//	int x = -3;
//
//	btree *tree = btree_create();
//	btree_insert(tree, 4);
//	btree_insert(tree, 7);
//	btree_insert(tree, 3);
//	btree_remove(tree, 4);
//	btree_insert(tree, 2);
//	btree_insert(tree, -3);
//	btree_insert(tree, 6);
//	btree_insert(tree, 9);
//	btree_insert(tree, 11);
//	btree_remove(tree, 2);
//	btree_remove(tree, 4);
//	btree_remove(tree, 4);
//	btree_remove(tree, 10);

//	printf("Contains %d: %s\n", x, btree_contains(tree, x) ? "true" : "false");
//	printf("Root: %d\n", tree->root->value);
//	printf("Minimum: %d\n", btree_minimum(tree));
//	printf("Maximum: %d\n", btree_maximum(tree));
//	btree_print(tree, stdout);
//	btree_destroy(tree);

// btree-test.c main

	btree *ta = btree_create();

	assert(btree_size(ta) == 0);
	assert(btree_contains(ta, 4) == false);
	btree_print(ta, stdout);

	btree_insert(ta, 4);
	btree_insert(ta, 7);
	btree_insert(ta, 3);

	assert(btree_size(ta) == 3);
	assert(btree_contains(ta, 4) == true);
	assert(btree_minimum(ta) == 3);
	assert(btree_maximum(ta) == 7);
	btree_print(ta, stdout);

	btree_remove(ta, 4);

	assert(btree_size(ta) == 2);
	assert(btree_contains(ta, 4) == false);
	assert(btree_minimum(ta) == 3);
	assert(btree_maximum(ta) == 7);
	btree_print(ta, stdout);

	btree_insert(ta, 2);
	btree_insert(ta, -3);
	btree_insert(ta, 6);
	btree_insert(ta, 9);

	assert(btree_size(ta) == 6);
	btree_print(ta, stdout);
	btree_remove(ta, 6);
	assert(btree_size(ta) == 5);
	assert(btree_contains(ta, 6) == false);
	btree_print(ta, stdout);

	btree_insert(ta, 5);
	btree_insert(ta, 5);

	assert(btree_size(ta) == 6);
	assert(btree_contains(ta, 5) == true);
	btree_print(ta, stdout);

	btree_insert(ta, 6);
	btree_insert(ta, 4);
	btree_remove(ta, 7);
	btree_remove(ta, 7);
	btree_remove(ta, 6);

	assert(btree_size(ta) == 6);
	assert(btree_contains(ta, 7) == false);
	btree_print(ta, stdout);

	btree_destroy(ta);

	return EXIT_SUCCESS;
}

/*=================================
=            Functions            =
=================================*/

/*----------  Static functions  ----------*/

static btree_node* create_node(int d) {
	btree_node *new_node = malloc(sizeof(struct btree_node));
	if (new_node == NULL) {
		printf("There has been a allocation error!");
		exit(EXIT_FAILURE);
	}
	
	// Set defaults for new node
	new_node->value = d;
	new_node->left = NULL;
	new_node->right = NULL;
	
	return new_node;
}

static void increase_counter(btree* t) {
	t->size += 1;
}

static void decrease_counter(btree* t){
	t->size -= 1;
}

static void delete_tree(btree_node* root) {
	if (root != NULL) {
		delete_tree(root->left);
		delete_tree(root->right);
		// Delete node
		free(root);
	}
}

// FIXME: This print does not do what it is supposed to do...
static void print_tree(btree_node* cursor, int max_value, int min_value) {
	if (cursor != NULL) {
	// Use fprint, change parameters to take FILE* out as a parameter,

	
	print_tree(cursor->left, max_value, min_value);

	if (cursor->left == NULL && cursor->right == NULL) {
		printf("(%d)", cursor->value);
		// Add recursion here
	} else if (cursor->left != NULL && cursor->right != NULL) {
		printf(", %d, ", cursor->value);
	} else if (cursor->right == NULL) {
		printf(", %d)", cursor->value);
	} else if (cursor->left == NULL) {
		printf(", (%d", cursor->value);
	}
//		printf("%d ", cursor->value);
	print_tree(cursor->right, max_value, min_value);
	
	}
}

/*----------  Header functions  ----------*/

void btree_print(const btree* t, FILE* out) {
	if (t->root == NULL) {
		printf("( NIL ) : 0\n");
		return;
	}

	
	if (out == stderr){
		printf("There has been an error!");
		return;
	} else {
		btree_node* cursor = t->root;	
		print_tree(cursor, btree_maximum(t), btree_minimum(t));
		printf(" : %zu\n", btree_size(t));		
	}
}

btree* btree_create() {
	// create an empty root node
	btree *tree = malloc(sizeof(struct btree));
	// default value of 0
	tree->root = NULL;
	tree->size = 0;
	return tree;
}

void btree_destroy(btree* t) {
	// Using static function above, which makes more
	// sense to me.
	delete_tree(t->root);
	free(t);
}

/// Returns the smallest number in tree 't'
int btree_minimum(const btree* t) {
	btree_node* node = t->root;
	// As long as next node on the left isn't NULL,
	// go one node more to the left.
	while (node->left != NULL) {
		node = node->left;
	}
	return node->value;
}

/// Returns the largest number in tree 't'
int btree_maximum(const btree* t) {
	// Same as min for right node.
	btree_node* node = t->root;
	while (node->right != NULL) {
		node = node->right;
	}
	return node->value;
}

void btree_insert(btree* t, int d) {
	if (t->root == NULL) {
		btree_node* root = create_node(d);
		t->root = root;
	} else if (btree_contains(t, d)) {
		// if this value is already in the tree 
		// return without doing anything
		return;
		
	} else {

		bool is_left = false;
		btree_node* cursor = t->root;
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
	}
	increase_counter(t);
}

bool btree_contains(const btree* t, int d) {
	btree_node* root = t->root;
	
	if (root == NULL) {
		return false;
	}
	
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


size_t btree_size(const btree* t) {
	// Such constant
	return t->size;
}


void btree_remove(btree* t, int d) {
	// If we have very large values, we should just change the
	// pointers to avoid copying.
	if (t == NULL) {
		printf("This tree does not exist!\n");
		return;
	}

	if (!(btree_contains(t, d))) {
		printf("This data does not exist in this tree!\n");
		return;
	}

	decrease_counter(t);
	
	// helper variables 
	btree_node* root = t->root;
	btree_node* previous = NULL;
	btree_node* next_left = NULL;
	btree_node* next_right = NULL;
	btree_node* cursor = root;
	
	// There are two large cases:
		
	// 1) root get's deleted
	if (root->value == d) {
		
		// We will free previous_root later on
		btree_node* previous_root = t->root;

		// helper
		next_left = t->root->left;
		next_right = t->root->right;

		// a) In case there are nodes on both sides,
		// I pull up the right node to be the root
		if ((next_right != NULL) && (next_left != NULL)) {
			
			// change the root to the next on the right and
			// create a cursor
			t->root = next_right;
			cursor = t->root;

			// get to the smallest element of the new root
			while (cursor->left != NULL) {
				cursor = cursor->left;
			}
			// and connect the next smallest element to the elements on 
			// the left side on the tree
			// (next left still has the info of the old root left)
			cursor->left = next_left;
			
		// b) if there is no right tree branch
		} else if (next_right == NULL) {
			// set the root to the next node on the left
			t->root = next_left;
			
		// c) if there is no left tree breanch
		} else if (next_left == NULL) {
			t->root = next_right;
		// d) root is the only one
		} else {
			free(t->root);
		}
		// free the previous root
		free(previous_root);
		return;
	}

	// 2) For the other cases
	// copied from btree_contains
	while (true) {
		// remember the previous node to delete next node later
		previous = cursor;

		if (d > cursor->value) {
			cursor = cursor->right;

		} else if (d < cursor->value) {
			cursor = cursor->left;
		}

		next_left = cursor->left;
		next_right = cursor->right;

		// Found the node we're looking for
		if (cursor->value == d) {
			// If there is no more element after cursor
			if ((next_left == NULL) && (next_right == NULL)) {
				free(cursor);
				if (d > previous->value) {
					// remove reference to this element
					previous->right = NULL;
					// Readability
				} else if (d < previous->value) {
					previous->left = NULL;
				}
				break;
				
				// If there is at least one element after cursor
			} else {
				free(cursor);

				// we'll have 3 cases: next_left = NULL; next_right = NULL, both != NULL
				
				// Node has two childs
				if ((next_left != NULL) && (next_right != NULL)) {
					// If value was on right side
					if (d > previous->value) {
						// Set the connection from the previous one to next_right,
						// if the value of the deleted node's next right node if next_left is smaller (draw)
						previous->right = next_left->value > next_right->value ? next_right : next_left;
					} else if (d < previous->value) {
						previous->left = next_left->value > next_right->value ? next_left : next_right;
					}
				// Node has right child	
				} else if (next_left == NULL) {
					if (d > previous->value) {
						previous->right = next_right;
					} else if (d < previous->value) {
						previous->left = next_right;
					}
				// Node has left child
				} else if (next_right == NULL) {
					if (d > previous->value) {
						previous->right = next_left;
					} else if (d < previous->value) {
						previous->left = next_left;
					}
				}
				break;
			}

		}

	}
	
}

/*=====  End of Functions  ======*/