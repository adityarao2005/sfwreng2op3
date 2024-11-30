**Draw the UML of each core class and explain your design.**

![SVG Image](step1.drawio.svg)

**How does your design reflect the encapsulation principle?**

The Board class encapsulates the board data of the game and the logic to display the board and retrieve the board and thus uses encapsulation principle. The Player class encapsulates its symbol data and the logic to access and mutate the symbol and the logic to make its turn on the Board given a Board class. The Game class encapsulates the 2 players required for the game as well as the Board needed for the game and the logic for a game loop and the logic for the win conditions. Thus my desgin reflects the encapsulation principle.

**How does the game flow reflect good design principles?**

It uses chain of responsibility and divide and conquer principle to separate the game flow into smaller sub problems which can be grouped together into separate classes. For example, things related to the actions and attributes of the Player (marker, making a move) stay in the Player class. Things regarding the Board (display the board, checking validity of move, claiming square, getting cells at row and column) stay in the Board class. Things regarding the game itself (like the game logic, game loop, checking for the winner and the end) stay in the Game class. By using these principles, not only will we be able to split large problems into smaller sub problems, but we will also be able to narrow down the cause of a bug/error in our program down to a particular class or method which is responsible for implementing that section.

**What challenges did you face in handling user input?**

The challenges I faced with handling user input was with regards to where should I initialize the Scanner (method level, top level, global) and how I should prompt the user and validate their response. I solved the first part by initializing the Scanner as a static element of the Player since it is only the Player at the moment accessing the user input but it is subject to change. I solved the second part by realizing that the Player class contains the symbol so whenever I would nee dot prompt them, I just need to add the player symbol in the prompt to identify the turn of the player. For the third problem, I created a isValidMove method in the Board class where from the Board I can check if the cell attempted to be claimed already has been claimed. So I will continue to get their choices until their choice is valid.

**How did you implement polymorphism in your player classes?**

I implemented polymorphism by having the Player class becoming an abstract class while having HumanPlayer and ComputerPlayer implement the underlying makeTurn method. Then when initializing the game I would assign Player 1 and Player 2 to be either computer or human based on what the user chooses. Then when the it is the players turn, I invoke the Player's makeTurn method which results in dynamic dispatching it to either the human variant or the computer variant.

**How does dynamic dispatch improve the flexibility of your game?**

Dynamic dispatch improves the flexibility of the game because if I wanted I could even have not just players responding from the console or as a bot but I could even make a GUI version or a version which works using the internet. All I would require to do is by creating the underlying implementation of those classes and add it as an option in the main game. Whereas without dynamic dispatch I would have to manually program (hard code) every feature as a condition and that is not sustainable, maintainable, or proper design.

**How did you check for winning condition?**

I first went row after row to see if the entire row has been filled by either only 'X's or only 'O's. Then I applied the similar process with checking column after column and seeing if the entire column has only 'X's or only 'O's. Then I checked the left diagonal and right diagonal to see if that had only 'X's or only 'O's.

**How did you structure the game to allow for restarts without duplicating code?**

In the main function, I created a do-while loop which initially runs the game loop and prompts the user if they wish to restart the entire game. If not then the user will break out of the loop and the program would end. This allows me to allow the game to restart without duplicating or modifying any of the code I built in the Game class.

**What improvements did you make during refactoring?**

I changed the constructor of Board to take in a row and column instead of hardcoding the values to support flexibility of the creation of the board. I also shifted the initialization of the game from the constructor to another method called initializeGame which the constructor calls to make game restarts more flexible. I also added a method to start the game play which contains the do-while loop for the game loop. I also modified the win condition and the display board methods checking to work off of the board rows and columns instead of hardcoded values. 

**How does your final codebase adhere to the OOP principles?**

The final codebase adheres to the OOP Principles: Encapsulation principle, Interface principle, Information hiding principle, Open closed principle, and single-responsibility principle. An example of how the codebase adheres to the encapsulation principle is that the Board class encapsulates the board's state (NxN grid), rows, and columns and provides methods to interact with these states (displayBoard, isValidMove, getValidMoves, claimSquare etc). The internal representation of the board is hidden from other classes. Similarly the Player class encapsulates the player's symbol and provides methods to interact with it (getSymbol, setSymbol). An example of how the interface principle is being used in the codebase is that Player class is an abstract class and allows the implementation of its abstract functions (makeTurn) to be defined by its subclasses (HumanPlayer, ComputerPlayer). This provides an interface between the user or computer and with the program without sacrificing the ability to support other mediums of making a turn. An example of how the information hiding principle is implemented in the codebase is the Board class by hiding how the board allows the players to get the valid moves or claim a square without the player knowing how it is done internally. The Game class is an example of Open-Closed principle where if we wanted to create an extension of the Game for example instead of 3x3 board we make an NxN board, we just have to subclass Game and override the createBoard method. Lastly, each of classes in the codebase (Board, Player, Game, App) each have a single responsibility (Board - manage the state of the Board, Player - manage state of player and players actions, Game - manage state of game and game flow, App - run the app). 

