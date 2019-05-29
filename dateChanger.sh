#!/bin/bash
from="Sun Mar 3 00:00:00y 2019 +0000"
to="Sun Mar 4 00:00:00y 2019 +0000"
new="Thu Mar 14"
new=$1
echo $new


date=$(git log -n 1 | grep "Date:")
time=$(echo $date | awk '{ print $5 }')
year=$(echo $date | awk '{ print $7 }')
timezone=$(echo $date | awk '{ print $9 }')
echo $date
newDate=$(echo "$new $time $year $timezone")
echo $newDate
echo "git commit --amend --date=\"$newDate\""
git commit --amend --date="$newDate"

exit 0
list=$(git log --since="$from" --until="to" -n $1 --reverse | grep "commit" | awk '{ print $2 }')

for comm in $list
do
	echo "$comm"
	git checkout $comm
	date=$(git log -n 1 | grep "Date:")
	time=$(echo $date | awk '{ print $5 }')
	year=$(echo $date | awk '{ print $7 }')
	timezone=$(echo $date | awk '{ print $9 }')
	echo $date
	newDate=$(echo "$new $time $year $timezone")
	echo $newDate
	echo "git commit --amend --date=\"$newDate\""
	#git commit --amend --date="$newDate"
done

git checkout master
