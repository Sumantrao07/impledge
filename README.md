In this program for finding the longest and the second longest compund words we use a simple approach, the first step for this is to have right collection of data structures,example for this program the ost suitable data structures are lists,set.And then we sorting for efficiency then after that we identify compound words in that case we remove the from the word set to avoid self matching.After that we check the compound word formation,we iterate all the possible prefix splits of a word.Its a greedy approach which proivides quick identification.
however there is also a alternative method for this  through dynamic programming approach,but intead of that we are using greedy,substring matching approach which is easier in comparison to dynamic programming.
Algorithm:- 
Firstly we are reading input file 
Second step we are sorting the words in descending order of length so that the longest words are checked first.
Now we are finding compound words,we use dynamicprogramming approach.
Now in next step we are cheacking whether its a compiund word or not.
last we are printing the longest and the secong longest compund word along with the execution time.
