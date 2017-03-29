#!/bin/bash
# Script 1
#
for FN in "$@" 	# go through every argument where FN is the
				# argument name and "$@" the number of arguments.
do				# change file modes or Access Control Lists to 
				# -rwxr-x--- (https://goo.gl/gtTC9Z) of FN (octal)
chmod 0750 "$FN" # 1 (read) 1 (write) 1 (execute) = 7
				# this sets up a shell script for execution
done			# end program