# Kylan Dixon HashTable/Linear Probing

## OVERVIEW:

 Reads files (from different data sources) into 2 different hash tables, one using linear probing
 and one using double hashing methods. 


## INCLUDED FILES:

 * LinearProbe.java - source file
 * DoubleHashing.java - source file
 * HashTest.java - source file
 * HashObject.java - source file
 * README - this file
 * my-results.txt


## COMPILING AND RUNNING:

 $ javac *.java

 Run the compiled class file with the command:
 $ java HashTest

 Console output will give the results after the program finishes.


## PROGRAM DESIGN AND IMPORTANT CONCEPTS:

The HashTable source file creates a generic array. It takes in 
3 parameters of size, loadFactor and the addressing method.
The HashFunction method takes parameters of key and failure. 
Failure is the amount of probes that failed during the search.
It will return 2 methods, of which there are two classes that will
be explained later. The main portion of this file is the put/insert method.
which has a while loop while if there are still more sections to go through
it will either find the location or it will not have a location.

The first Function method is linear probing which has math INCLUDED
and second is the double hashing method which also has math included.

HashTest is the driver code of the project and runs it checks whether
user input is correct or not, if not it will exit system. If correct
it will run through and output the results.

## TESTING:

 I was having a divide by zero issue for a while , but after setting
 manual output breakpoints I could see that it wasn't even making it
 to the while loop in which the main logic is performed. I was able to 
 realize that I had simply made a mistake in the args input line in test.
 This was a quick fix that was incredibly important.


## DISCUSSION:
 
The logic of this project was relatively straightforward. After doing
extra reading and seeing how others implemented hashtables I was able
to create a plan and execute it. There were quite a few small issues
but with simple checks they were taken care of.
 

----------------------------------------------------------------------------
