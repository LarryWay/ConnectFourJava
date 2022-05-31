# ConnectFourJava

Board size: 8x8

Computer Procedure: Place a piece in every row, and scan right, bottom, and down-right
                    for the highest number of in-a-row pieces


Win Algorithm: Scan from top to bottom, left to right, checking for
                four in a rows to the right, downwards, and down-right


Structure of program:
    - Column class: hold an int to represent which column it represents, takes care of gravity mechanism
    
    - Piece class: Holds cords relative to the board, and the char tile to represent players
    
    - UI Class: Manage prints to the console and player input
    
    - Board Class: Class that holds the 2D array of Pieces, object shared with UI, Computer, and Column Classes

    - Constants Class: Holds Constants
    
    - main Class: Driver class


Modularity
    - CONSTANTS.HORIZONTAL_SPACES can be changed to set the width of the board
    - CONSTANTS.HORIZONTAL_SPACES can be changed to set the height of each column
    - CONSTANTS.IN_A_ROW can be changed such that the win condition changes from 4 to any number
    - CONSTANTS.PLAYER_ONE can change player one's tile
    - CONSTANTS.PLAYER_TWO can change player two's tile


Known issue: Changing the CONSTANTS.VERTICAL_SPACES or CONSTANTS.HORIZONTAL_SPACES may not
             immediately update. I'm honestly not sure why, but it has nothing to do with
             the code itself, and more with the compilation process. In other words, the
             out_of_range error may occur when adjusting one of the following constants to
             a value higher than the default.
