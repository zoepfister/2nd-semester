CFLAGS = -Wall -Wextra -Werror -std=c99 -O2

# Chances are this isn't the case, but you may potentially 
# have a file named clean in your main directory. 
# In such a case Make will be confused because by 
# default the clean target would be associated with 
# this file and Make will only run it when the file 
# doesn't appear to be up-to-date with regards to its dependencies.

.PHONY: all
all: testvector 

.PHONY: clean
clean:
	$(RM) testvector testvector.o

testvector: testvector.o
	
testvector.o: btree.c btree.h
	gcc -c btree.c -o testvector.o $(CFLAGS)

