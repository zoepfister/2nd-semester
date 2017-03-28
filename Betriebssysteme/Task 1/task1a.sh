#!/bin/bash
# Script 1
#
for FN in "$@" 	# go through every argument where FN is the
				# argument name and "$@" the number of arguments.
do				# change file modes or Access Control Lists to 
				# -rwxr-x--- (https://goo.gl/gtTC9Z) of FN (octal)
chmod 0750 "$FN" # comment to check backup
				# this sets up a shell script for execution
done			# end program