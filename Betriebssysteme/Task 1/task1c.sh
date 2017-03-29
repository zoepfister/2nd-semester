#!/bin/bash
# Script 3
INFILE=$1	# The input file (1st argument)
OUTFILE=$2	# The output file (2nd argument)

if [ -e "$INFILE" ]	 # if file from argument 1 exists, 
then
if [ -w "$OUTFILE" ] # and the outfile exists and is writeable 
then
cat "$INFILE" >> "$OUTFILE"	# append text from infile at 
							# the end ouf outfile (don't use same i/o)
							# using cat (concatenate and print files)
else
echo "can not write to $OUTFILE"	# if outfile is not writeble, endif
fi
else								# if infile does not exist, endif
echo "can not read from $INFILE"
fi