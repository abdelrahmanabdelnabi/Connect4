#Connect 4 report
##Backend
At its core, the game is one class called `connect4` this class holds the game
states and methods. Basicly it is 2 dimentional array that maps directly to
the connect 4 board, with group of function that manipulate that array, and
some auxillary data.
###The game states
####1. The array
The array is declared as ```java int [][] Array;``` and initialized in the default
constructor as
```java
Array = new int[ROWS][COLUMNS];
```
_Array_ cells hold _1_ for coins
inserted by player number _1_, _2_ for coins inserted by player number _2_ or zero
for cells that still untouched.
