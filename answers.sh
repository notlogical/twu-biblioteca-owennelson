#!/bin/bash

for n in {1..5}
do
	echo -e "Question $n:\nQuery:" >> SQLAnswers.txt
	cat q$n.sql >> SQLAnswers.txt
	echo -e "\nResult:" >> SQLAnswers.txt
	sqlite3 biblioteca.sqlite < q$n.sql >> SQLAnswers.txt
	echo -e "\n" >> SQLAnswers.txt
done
