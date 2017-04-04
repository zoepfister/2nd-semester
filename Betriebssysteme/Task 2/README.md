# README.md – [Github](https://github.com/Buchenherz/2nd-semester/tree/master/Betriebssysteme/Task%202)

## When would you use a sorted binary tree over a linked list?

A sorted binary tree exceeds a standard linked list if you need to have values sorted immediately while inserting. Imagine you needed to sort a linked list every time a new element is inserted. A binary search tree is much more efficient in this case because inserted values are automatically dropped of at the correct, sorted spot. A disadvantage of a BST is that there cannot be two identical elements. 

## What would you change if the tree had to support not just integers, but any type of data?

In the `struct btree_node` , I could just add non integer types as options. For example:


    struct btree_node {
            int value;
            float double_value;
            char[10] string_value;
            struct some_type some_value;
            
            struct btree_node *right;
            struct btree_node *left;
    };

I now would be able to add values of type `float` (line 3), `char[10]` (char-array line 4), and even of type `some_type` .

## Why do we use modules instead of putting everything a single ﬁle?
1. For the sake of organisation when implementing functions and to stay organised when working on big projects (splitting up different parts of a program). 
2. This slide from Introduction to Programming (Michael Felderer) sums it up pretty good in my opinion. If `file2.c` uses a function of `file1.c` one can simply implement it by importing it’s header.
https://www.dropbox.com/s/4gslu8jwgceoub7/Screenshot%202017-04-04%2018.08.32.png?dl=1



## Is the development cycle (i.e. changing a source ﬁle, recompiling and running tests) faster when using modules? Explain your answer.

As suggested above, if different parts of a larger project use the same functions, we can simply implement said functions by adding a header (header must have that function declared obviously). So we do not need to implement this function again. 

## What is a header guard and why is it needed?

With a header guard we check if the preprocessor already knows *BTREE_H_GUARD*. If this is not the case, we define it so we do not include it multiple times. So basically it protects us from including the same header file multiple times in one source file:


    // A.h
    void get_element(parameter);
    ...


    // B.h
    #include "A.h"
    ...

If we use both includes in our program without header guards…

    //program.c
    #include "A.h"
    #include "B.h"
    int main(){ ... }

The program won’t compile without errors, because `A.h` get defined two times.

## Why are btree and btree_node not deﬁned in the header ﬁle? What are the implications?

Imagine following situation: We have two separate implementations of a binary tree, A and B. A stores not only int values, but also a small char array in it’s node structure. B just uses int values. Because we did not define any specifics for `btree` and `btree_node` in our header, we can use the same header file across implementations A and B. 

To sum up: 

- Private structures should go in the .c file, with a declaration in the .h file if they are used by any functions in the .h. Source: [StackOverflow](http://stackoverflow.com/questions/6316987/should-struct-definitions-go-in-h-or-c-file)
## Explain the const in the parameter list of btree_print, is it required?

I kinda tricked my way out of this one in my implementation 😉

## Explain memory leaks. Why are memory leaks bad? You should know how to use valgrind to check your program for memory leaks.

When a program needs to store some temporary information during execution, it can dynamically request a chunk of memory from the system. However, the system has a fixed amount of total memory available. If one application uses up all of the system’s free memory, then other applications will not be able to obtain the memory that they require. This results from *not so bad stuff* like gentle shutdowns or exit of a program to *really bad stuff* like an unexpected crash. [Source](https://msdn.microsoft.com/en-us/library/ms859408.aspx)

## What is the reason behind writing everything in English?

The world of Computer Science is basically all English. If we were to work with people from all over the world, our language I/O most certainly will be English.

## Why should you use static for non-exported functions?

Because function that use the static keyword are only visible inside the file they are declared in.
[Wikipedia](http://en.wikipedia.org/wiki/Static_variable): 
In the C programming language, static is used with global variables and functions to set their scope to the containing file. In local variables, static is used to store the variable in the statically allocated memory instead of the automatically allocated memory. While the language does not dictate the implementation of either type of memory, statically allocated memory is typically reserved in data segment of the program at compile time, while the automatically allocated memory is normally implemented as a transient call stack.

## Why should we comment our source code? Is it always need? What should the comment state? What is self-documenting code?

Comments will help us, but even more other people understand our code better in a short amount of time. There are plenty of opportunities where comments should not be included:


    // Decides if x is greater than y and sets max to x if yes
    if (x > y){
      max = x;
    }

This comment isn’t necessary because the code is readable even for beginners of C-language. A comment should state what the programmer had in mind while implementing like: 


    // We now have three different cases if the root get's deleted:
    // First, if the root had two nodes attached
    if(condition){ ... };
    // Second, if the root only had a left node attached
    ...
    // Thrid, if the root only had a right node attached
    ...

At least that’s what I have in mind while writing comments. When code is self-documenting, it is readable from top to bottom. Every line of code is written in a way that every programmer involved in the project immediately understands it without the need of comments.

## Why should the module not output debug messages?

I unfortunately don’t know…

## Why and when should you use assert?

The assert macro is used to check expressions that ought to be true as long as the program is running correctly. It is a convenient way to insert sanity checks. 
If the preceding algorithm has generated an invalid value, it's likely that the condition in the assertion will not be true. Typical behavior when the assert fails is for the program to exit.
We use assert primarily to find bugs.

## What are the beneﬁts of using make over calling the compiler by hand?

Make allows us to compile our code by simply writing `make -option` in the console instead of something like `gcc -Wall -Werror -Wextra -std=c99 -O2 btree.c -o btree` . We can also define options like `clean` to remove files no longer needed.

## Imagine it was your job to design the interface for the btree module (writing btree.h). What would you have done diﬀerently, and why?

For specific Functions (like `btree_insert` ,  `btree_destroy` , etc.) I would have used different parameters. To be more specific, instead of constantly using the parameter `btree* t` I would directly ask for the root node of type `btree_node* node`. Implementations of functions like the ones mentioned above are in my opinion easier using a `btree_node*` directly. 

