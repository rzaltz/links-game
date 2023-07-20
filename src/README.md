# **Links Game**
_Written by Rachel Zaltz_

 The goal of the game is to collect more points than your opponent. The number of links will be randomly generated for each game; it will be between 5 to 100 links. The values of the links will also be randomly assigned and range in size from -100 to 100 inclusive. Player 1 will always go first.

- Run 'LinksGame.java' from your IDE
- Valid Game Inputs: 'First' or 'Last'

****Installation:****
- JDK 17
- JUnit 4
- _Optional:_ IntelliJ IDEA 2022.3.2 (Community Edition)

****Navigating the Code:**** 
- `LinksGame.java`: This class contains the `main` method. It starts with an immutable LinksGameModel.
- `LinksGameModel.java`: This class contains player one's score and player two's score which are both initialized to zero. It also contains a boolean called playerOnesTurn which is initialized as true because player One always goes first. Finally, it contains a Linked List of integers which has all the links that are utilized in the game.
- `LinksGameImplTest.java:` This contains all the unit test for the Links Game. It leverages the JUnit testing framework.

****Optimal Strategy:**** 
In order to win the game, you need to understand that your opponent will also be trying to find the optimal strategy. 

If we have an array and i is the first element and j is the last element consider the following:
- Option 1: if player 1 chooses the first element player 2 is left with [i+1, j] 
  - If player 2 chooses the first element i+1, we are left with [i+2, j]
  - If player 2 chooses the last element j, we are left with [i+1, j-1]
- Option 2: if player 1 chooses the last element player 2 is left with [i, j-1]
  - If player 2 chooses the first element i+1, we are left with [i+1, j-1].
  - If player 2 chooses the last element i+1, we are left with [i, j-2].

**Optimal Strategy Formula:**
F[i][j] = Max{ (i+Min(F[i+2,j],F[i+1,j-1]), (j +Min(F[i+1,j-1],F[i,j-2]) }