# Word-Count-Analyzer

# Summary #
I wrote this Java program to analyze a block of text in a textfile and keep count of each instance of a word in the text file. The output file will contain all the words, ordered by the size of the word (how many characters), arranged in the number of times they appeared in the text file (by descending order - meaning most common word on top). 

In the English language, the word "The" is the most common, and with it being a 3 letter word, it is safe to assume that this would be the most common word of 3 letter word length in the text file. If you look at "out.txt" in the repo, this was the case. 

# Technologies Used #
I used a Hash Table to store all the words that were parsed from the text file. Hash Table was a good choice because of the O(1) addition and look-up time. I then used an ArrayList to sort the words per each word length - for instance and although both 3 letter words, "The" was more common than "and", hence "The" needed to be the first word for the 3 letter word "bin". 

# Files #
Most of the code is in Bard.java and storeValue.java. The rest of the files in the repository are input/output files. This program works for text files, but can be modified to handle inputs from all potential input sources (Word, PDF, JSON, etc.).
