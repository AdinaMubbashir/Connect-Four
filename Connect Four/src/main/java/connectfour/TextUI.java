/**
* Description: The class takes user input and
* displays the baord to user
* @author  Adina Mubbashir
*/

package connectfour;
import java.util.Scanner;


public class TextUI{


  public void gameStart(Board obj,int i){

    Scanner  ptr = new Scanner(System.in);
    ConnectFour obj2 = new ConnectFour();
    char choice;
    String saveGame = "";
    System.out.println(obj.getPlace());
    System.out.println();
    //print board
    obj.printBoard();
    //display turn to user
    System.out.println("Turn = " + (obj2.getTurn(i)));
    obj2.setTurn(i);
    userInput(obj);

    //make sure user input is valid
    while(!obj.fillBoard(i)){
      userInput(obj);
    }

    //asking user if they want to save game board
    do{
       System.out.println("Would you like to save the current board to file\n"
       + "type either 'y' for yes or 'n' for no");
       choice = ptr.next().charAt(0);
       ptr.nextLine(); 
   } while(((choice != 'y') && (choice != 'n')) && ((choice != 'Y') && (choice != 'N')));

   //asking user to enter file name
   if(choice == 'y' || choice == 'Y'){
      System.out.println("Enter what you would like the filed to be called (Ex. board.csv)");
      saveGame = ptr.nextLine();
      obj.printBoardToFile(saveGame);
   }

  }

public void userInput(Board game){

        Scanner input = new Scanner(System.in);
        String userInput = "";

        //asking user to input position on board
        do {
        System.out.print("Enter Position between 0 and 6:\n");
        userInput = input.nextLine();
        } while (!errorHandling(userInput));

        int index = Integer.parseInt(userInput);
        game.setPosition(index);
}

 public boolean errorHandling(String num) {
    int value;
    //Returns false if user enters string
    try {
      value = Integer.parseInt(num);
    } catch (Exception e) {
      System.out.println("Please enter a number");
      return false;
    }

    if (value > 6) { 
      System.out.println("Error - Out of Bounds:");
      //Returns false if user enters a value that does not exist on board
      return false;
    } else if (value < 0) {
      System.out.println("Error - Value entered is negative:");
      //Returns false if user enters a negative value
      return false;
    }


    return true;
  }


  public void printWinner(char player){

    //print winner or if there is no winner, print tie to user
    if(player == '1'){
        System.out.println("1 has won the game!");
        System.out.println();
    }else if(player == '2'){
        System.out.println("2 has won the game!");
        System.out.println();
    }else if(player == '0'){
      System.out.println("Game was a tie!");
      System.out.println();
    }


  }


public void loadFromFile(Board check){

  Scanner user = new Scanner(System.in);
  char load;
  String file = "";

  //ask user if they want to loard boad from file

  do{
      System.out.println("\nWelcome to Connect Four, would you like to load a saved board from file\n"
      + "type either 'y' for yes or 'n' to continue to new game");
       load = user.next().charAt(0);
       user.nextLine(); 
  } while(((load != 'y') && (load != 'n')) && ((load != 'Y') && (load != 'N')));


   //ask user which file they want to load board from
  if(load == 'y' || load == 'Y'){
    System.out.println("Enter file from which you wish to load board");
    file = user.nextLine();
    check.setLines(file);
    check.getBoardFromFile();
   }

}

public String toString(){

    return "Display and Input";

}


}