# Rail-Bike-Sort

Work in progress

This project aimed to make an wasier setup for bikes on a railroad track
There are 11 possible two seaters (Tandems) and 9 possible four seaters (Quads)
There are five tours a day. 

The project will take the number of Tandems/Quads from the user for each tour, and the number of combos.
The user will then be asked to input the number of tandems then quads in the combo

The program will then take this and output the optimal setup fro the beginning of the day to do the least amount of switching necessary. If any switches are needed it will say so in the output.

As it stands now, the project can take in all of the above information and can track changes. It cannot yet sort the combos, as I decided to change the methodology last minute to get rid of the method class 
all-together, and instead store the combos as a string and traverse the string.
