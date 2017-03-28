#!/bin/bash
# Script 2
#

if (( $# != 1 ))	# if number of arguments is smaller three..
then
printf "%b" "Error. Invalid argument count.\n" >&2
printf "%b" "usage: myscript file1 op file2\n" >&2
exit 1
fi

if [[ ! -d "$@" ]]; then
	mkdir "$@"
fi

for file in *
do	
found_item="false"

	for backup in $@/*; do
		# printf "$file, $backup\n"

		if [[ -a $@/$file ]]; then
			if [ "$file" -nt "$backup" ]; then
				if [[ "$file" != $@ ]]; then
					cp -R "$file" "$@"
					printf "'$file' has been updated within $@.\n"
					found_item="true"
					# echo $found_item
					break
				fi
			fi
		fi
		if [[ ! -a $@/$file ]]; then
			if [[ "$file" != $@ ]]; then
				cp -R "$file" "$@"
				printf "'$file' has been added to $@.\n"
				found_item="false"
		fi
	fi
		#echo $found_item
	done
	
done

