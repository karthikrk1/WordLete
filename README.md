# WordLete

![WordLete](https://raw.github.com/karthikrk1/WordLete/master/app/src/main/res/drawable/word_logo.png)

## Introduction

WordLete is an word completion game that is played between 2 or more players. The objective of the game is to start with a random character (chosen by the app) and try to think of the longest word starting with it. The game starts by the first player adding the second character of the word he/she chose to the text box. The challenge of the game is that the second player cannot enter the same character as the first player. This is the same for each of the turns. 

The winner is chosen at the end by checking who had the longest dictionary word among all the players. This game aims to develop vocabulary and improve knowledge of words.

## Google Applied CS 

Google Applied CS with Android is a workshop run by Google for improving knowledge in Data Structures and Algorithms through the use of Android Apps. This app was designed by 

***Badhrinath Santhanam***

***Karthik Ramakrishnan***

as part of the Code Sprint. 

## Play Store 

[Play Store Link to be added] (#)

## Data Structures Used

### Trie
We have used Trie for creating a dictionary of words which gives efficient traversal

### HashMap
We used a HashMap to store the prefix and the longest word in the prefix

### Priority Queue
We used a Max PQ to retrieve the longest word given a prefix. This gives only the length and the longest word is then checked from the HashMap using the prefix.

## Fixes and Features Planned for Version 1.1 and Beyond

* Version 1.0 contains a subset of the dictionary chosen online and contains most but not all of the English words in the dictionary. We aim to develop this dictionary to match the English dictionary. 

* Layout support is currently set to Android 12 and above, which doesn't have support for complex UI design and additional styling. We aim to fix this by removing support for legacy Android phones

* Currently this game supports only one user who plays against a computer player. Additional users support will be added 






