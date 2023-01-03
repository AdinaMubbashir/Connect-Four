# Project Title

Connect Four is played between 2 players in a six by seven board. The goal of the game is to get the same symbol four times in a row
horizontally, vertically, and diagonally.

## Description

The game connect four is played between two players, 1 and 2. When the program runs, the user can either start a new game or load a game baord from file. 
Once they pick either, player 1 will go first, then player 2. While playing the game, after each player goes, they can chose to save their game baord to a file (the user gets to pick file name) or continue playing. For example, if user input is 4, it will replace row zero index 4 with either 1 or 2, depending on turn. The will go on until a playr has got the same symbol four times in a row horizontally, vertically, and diagonally, or all the spots in the game board
are full. User input handling has been done for out of bounds, entering a string instead of number, and entering invalid option.


### Dependencies

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter; 


### Executing program

Compile: gradle build

Run: java -cp build/classes/java/main connectfour.ConnectFour
```
use code blocks for commands
```



