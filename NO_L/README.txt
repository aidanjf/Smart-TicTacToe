1. Introduce the program

    Growing up, one of the best ways to spend time was to play tic-tac-toe.
    We could spend hours playing a simple game on paper with 9 squares.
    However, when playing games, winning makes the game twice as fun. 
    When tic-tac-toe is played perfectly, the only outcomes are winning or drawing and 
    losing is not an option.
    Our team was inspired to make NO-L, an automatic tic-tac-toe bot users users can play agasint
    which always outputs the best moves.
    In the worst case scenario for the smart NO-L, the result will be a draw.
    It is IMPOSSIBLE for the smart NO-L to lose.
    The user will have the choice to either play against the easy NO-L, which they have a chance
    to win against, or the smart NO-L if they are up for the challenge.

2. How to run the program?

    To run the program type in the command "javac NO_L.java && java NO_L; rm *.class" in the console

3. How to use the program?
    
    Once running, Here's how to use the program: 
    
    In the console, reply "yes" or "no" when prompted with "Fancy a game of Tic Tac Toe (yes or no)?"
    If your response is yes, you will be promted for your opponent of choice with "Would you like to play a  smart computer (yes or no)? ". 
    You will play against a "dumb" computer if your response is "no". The program will assign you as "X" and prompt you for the coordinates 
    to a row and a coloumn respectively of a 3 x 3 board:
        - Valid inputs are only integers from 1 to 3. 
        - If the input is out of bounds or if the square is already occupied, you will be reprompted for a valid response. 
        - If your input is not an integer, an InputMismatchException will be thrown.

   Once you've responded with a valid coordinate, the computer will make a move and prompt you for your next move. The board will
   be displayed upon each response.
       
    Reference this diagram of the board to mark your move: 

         col 1  col 2  col 3       
   row 1  1,1 :  1,2 :  1,3    
         --------------------
   row 2  2,1 :  2,2 :  2,3 
         --------------------
   row 3  3,1 :  3,2 :  3,3
    
User Guide Video:

https://drive.google.com/file/d/1GaAzfHFNmhcLCqvOmoH5x7Z22oucVcP_/view?usp=sharing 





