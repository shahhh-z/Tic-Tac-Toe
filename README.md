# Tic-Tac-Toe

This is my implementation of a tic-tac-toe game!


NOTE: This repository only contains the files which I coded myself. Any other files needed to run this program can be found in this [Google Drive folder](https://drive.google.com/drive/folders/1MRvhglQzEu9l7O7xeJmihh6QT1G4BsLa?usp=sharing). These files DO NOT belong to me. Read the disclaimer within the folder for more details.


HOW TO RUN THE FILES ON YOUR OWN:
Create a new Java project (no package).

Extract the files in src_provided_files.zip and place them in the src folder. Place the 3 java files in this repository in the src folder.

Extract the images in other_provided_files.zip and place them in the project folder (the parent folder of the src folder).

Provide 3 positive integer arguments to the Play.java file. The first argument is the size of the square board, the second argument is the number of adjacent tiles needed to win a game (height of the game tree), the third argument is the depth of the game-tree to be explored (difficulty). The game tree is a tree of all possible outcomes of the game and the computer explores it to see what is the best move to make. Careful when passing arguments since larger values for height and depth can result in the program taking extremely long to run. I suggest passing the arguments "3 3 2" to the file.

Run the Play.java file and play the tic-tac-toe game that pops up. Follow the instructions in the CLI once you're done.


Here is a demonstration of how the game should run:

