#!/bin/bash 
# Script 2
if (( $# < 3 ))	# if number of arguments is smaller three..
then
printf "%b" "Error. Not enough arguments.\n" >&2
printf "%b" "usage: myscript file1 op file2\n" >&2
exit 1
elif (( $# > 3 ))	# ..or greater than three 
then 
printf "%b" "Error. Too many arguments.\n" >&2
printf "%b" "usage: myscript file1 op file2\n" >&2 # redirect output to stderror output
												# ">" is redirection 
exit 2	# print error and usage tips
else	# if number of arguments is three, print
printf "%b" "Argument count correct. Proceeding...\n"
# end of if statement indicated by fi
fi

 # Exit status (https://goo.gl/xAkiY4):
 # 0	if OK,
 # 1	if minor problems (e.g., cannot access subdirectory),
 # 2	if serious trouble (e.g., cannot access command-line argument).