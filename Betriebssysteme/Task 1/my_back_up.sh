#!/bin/bash
# my_backup_up.sh
# Clemens Pfister, Github: https://git.io/vyAS3
#

if (( $# != 1 ))	# if number of arguments is smaller three..
then
printf "%b" "Error. Invalid argument count.\n" >&2
printf "%b" "usage: myscript file1 op file2\n" >&2
exit 1
fi

# If there's no directory with the argument name,
# create one
if [[ ! -d "$@" ]]; then
	mkdir "$@"
fi

# for each file in current directory
for file in *
do	
	# for each file in the specified backup dir
	for backup in $@/*; do
		# printf "$file, $backup\n"
		
		# if a file with the name file exists in backup dir
		if [[ -a $@/$file ]]; then
			# and was updated
			if [ "$file" -nt "$@/$file" ]; then
				# and is NOT the backup directory
				if [[ "$file" != $@ ]]; then
					# update the file
					cp -R "$file" "$@"
					printf "'$file' has been updated within $@.\n"
					# so the new file gets updated to current modification time
					touch "$@/$file"
					break
				fi
			fi
		fi
		# if there was no item found 
		if [[ ! -a $@/$file ]]; then
			# and is NOT the backup directory
			if [[ "$file" != $@ ]]; then
				# add the file
				cp -R "$file" "$@" # use preserve=all to copy with timestamps
				printf "'$file' has been added to $@.\n"
			fi
		fi
	done
done

