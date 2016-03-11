```
       _/_/_/                                                      _/        _/  _/
     _/         _/_/    _/_/_/    _/_/_/      _/_/      _/_/_/  _/_/_/_/    _/  _/
    _/       _/    _/  _/    _/  _/    _/  _/_/_/_/  _/          _/        _/_/_/_/
   _/       _/    _/  _/    _/  _/    _/  _/        _/          _/            _/
    _/_/_/   _/_/    _/    _/  _/    _/    _/_/_/    _/_/_/      _/_/        _/
    								~~magic inside
```
#Connect 4 report
##Backend
At its core, the game is one class called `connect4` this class holds the game
states and methods. Basicly it is 2 dimentional array that maps directly to
the connect 4 board, with group of function that manipulate that array, and
some auxillary data.
###*The game states
####1.`Array`
The array is declared as ```int [][] Array;``` and initialized in the default
constructor as
```java
Array = new int[ROWS][COLUMNS];
```
_Array_ cells hold _1_ for coins
inserted by player number _1_, _2_ for coins inserted by player number _2_ or zero
for cells that still untouched.This array is filled bottom up,`Array[i+1][j] =0`
implies that the element `Array[i][j]` is also zero.
####2.`CurrentPlayer`
Hold exactly what its name suggests. It is initialzed by the default constructor as
```java
CurrentPlayer=1;
```
####3.Miscellaneous
Other less important class states but heavily used are the `ROWS` and the
`COLUMNS` they are evaluated at compile time yet they can be used to create
different vairiation other than the standard connect4 game.
###*Methods
####1. `getArray()`
Takes no parameters and return the current `Array` state
####2. `switchPlayers()`
This function alternates the current player between 2 values 1 and 2
####3.`getPlayer()`
Returns the current player
####4.`getWinner()`
This function iterates over the whole array starting from `Array[0][0]` till
`Array[6][7]` if that cell is proved to _not_ be a _zero_ it will test if one
of the following patter exits where the `[x]` resembles cell patterns that will
be checked

