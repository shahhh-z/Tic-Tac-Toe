# Tic-Tac-Toe

This is my implementation of a tic-tac-toe game!


NOTE: This repository only contains the files which I coded myself. Any other files needed to run this program can be found in this [Google Drive folder](https://drive.google.com/drive/folders/1MRvhglQzEu9l7O7xeJmihh6QT1G4BsLa?usp=sharing). These files DO NOT belong to me. Read the disclaimer within the folder for more details.


HOW TO RUN THE FILES ON YOUR OWN:
Create a new Java project (do not make a package, use the deafult).

1. Extract the files in src_provided_files.zip and place them in the src folder. Place the 3 java files in this repository in the src folder.

2. Extract the images in other_provided_files.zip and place them in the project folder (the parent folder of the src folder).

3. Provide 3 positive integer arguments to the Play.java file. The first argument is the size of the square board, the second argument is the number of adjacent tiles needed to win a game, the third argument is the depth of the game-tree to be explored. The game tree is a tree of all possible outcomes of the game and the computer explores it to see what is the best move to make. If the depth of the game tree is greater, than the difficulty of the game will be greater as well since the computer can explore more potential outcomes. Careful when passing arguments since larger values for length and depth can result in the program taking extremely long to run. I suggest passing the arguments "3 3 4" to the file.

4. Run the Play.java file and play the tic-tac-toe game that pops up. Follow the instructions in the CLI once you're done.


Here is a demonstration of how the game should run:

https://github.com/user-attachments/assets/b62a496c-793d-4678-a97c-6683be7e6eb3
