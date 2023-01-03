/**
* Description: The class updates the board after
* each turn, prints board to file and
* loads board from file
* @author  Adina Mubbashir
*/

package connectfour;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter;   
public class Board{

    private char[] place = {'0', '|', '1', '|', '2', '|', '3', '|', '4', '|', '5', '|', '6', '|'};
    private ArrayList<List<Character>> board = new ArrayList<>(Arrays.asList(
        Arrays.asList('0','0','0','0','0','0','0'), 
        Arrays.asList('0','0','0','0','0','0','0'), 
        Arrays.asList('0','0','0','0','0','0','0'), 
        Arrays.asList('0','0','0','0','0','0','0'), 
        Arrays.asList('0','0','0','0','0','0','0'), 
        Arrays.asList('0','0','0','0','0','0','0')
    ));
    private int position;
    private Path path;
    private String fileLoad = "";
    

public Board(){
 position = 0;
}

//set file name
public void setLines(String name){
  this.fileLoad = name;
}

// set user input
public void setPosition(int playerPos){
    this.position = playerPos;
}

//gets board
public ArrayList<List<Character>> getBoard(){
    return this.board;
}

//sets board
 public void setBoard(ArrayList<List<Character>> board1){
    this.board = board1;
}

//get array of rows
public char[] getPlace(){
    return place;
}


/**
 Method to print board
 @param aParameter none
 @return none
 . . .
*/
public void printBoard(){
    for(int i = 0; i < 6; i++){
        for(int j = 0; j < 7; j++){
            System.out.print(board.get(i).get(j) + "|");
        }
        System.out.println();
   }
}

/**
 Finds if there is a winner, tie, or continue game
 @param aParameter int turn
 @return true if there is no winner or tie, else false
 . . .
*/
public boolean hasGameEnded(int turn){

    TextUI output = new TextUI();

    if (winner() == '1') {
        printBoard();
        output.printWinner('1');
        return false;
    }else if (winner() == '2') {
        printBoard();
        output.printWinner('2');
        return false;
    }else if ((winner() == '0') && (turn == 42)){
        printBoard();
        output.printWinner('0');
        return true;
    }

    return true;
}

/**
 Finds player who won
 @param aParameter none
 @return winner
 . . .
*/
public char winner(){
    char winner = '0';
    //check to find winner
    if(winnerHorizontal()=='1'|| winnerVertical()=='1'|| winnerDiagonal() =='1'){
      winner = '1';
    }else if(winnerHorizontal() =='2'|| winnerVertical()=='2'|| winnerDiagonal() == '2'){
      winner = '2';
    }
    return winner;
  }

/**
 Finds player with same symbol horizontally
 @param aParameter none
 @return 1,2, or 0
 . . .
*/
public char winnerHorizontal(){
    //compare positions horizontally
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 4; j++){
        if(board.get(i).get(j).equals(board.get(i).get(j+1)) 
            && board.get(i).get(j).equals(board.get(i).get(j+2)) 
            && board.get(i).get(j).equals(board.get(i).get(j+3)) 
            && !board.get(i).get(j).equals('0')){
          return board.get(i).get(j);
        }
      }
    }
    return '0';
  }

/**
 Finds player with same symbol vertically
 @param aParameter none
 @return 1,2, or 0
 . . .
*/
public char winnerVertical(){
    //compare positions vertically
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 7; j++){
        if(board.get(i).get(j).equals(board.get(i+1).get(j)) 
            && board.get(i).get(j).equals(board.get(i+2).get(j)) 
            && board.get(i).get(j).equals(board.get(i+3).get(j)) 
            && !board.get(i).get(j).equals('0')){
          return board.get(i).get(j);
        }
      }
    }
    return '0';
  }

/**
 Finds player with same symbol diagonally (left to right and right to left)
 @param aParameter none
 @return 1,2, or 0
 . . .
*/
public char winnerDiagonal(){
    //compare positions diagonally left to right
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 4; j++){
        if(board.get(i).get(j).equals(board.get(i+1).get(j+1)) 
            && board.get(i).get(j).equals(board.get(i+2).get(j+2)) 
            && board.get(i).get(j).equals(board.get(i+3).get(j+3)) 
            && !board.get(i).get(j).equals('0')){
          return board.get(i).get(j);
        }
      }
    }
    //compare positions diagonally right to left
    for(int i = 0; i < 3; i++){
      for(int j = 6; j > 2; j--){
        if(board.get(i).get(j).equals(board.get(i+1).get(j-1)) 
            && board.get(i).get(j).equals(board.get(i+2).get(j-2)) 
            && board.get(i).get(j).equals(board.get(i+3).get(j-3)) 
            && !board.get(i).get(j).equals('0')){
          return board.get(i).get(j);
        }
      }
    }
    return '0';
  }

 
 /**
 Fills game board with users input
 @param aParameter int counter
 @return true if postion in board is changed, else false
 . . .
*/
public boolean fillBoard(int counter){
    ConnectFour obj2 = new ConnectFour();
    char player = obj2.getTurn(counter);

    //if the top row is not 0, it is full
    if(board.get(0).get(position).equals('1') || board.get(0).get(position).equals('2')){
        System.out.println("This column is full.");
        return false;
    }

    //go through array backwards to check if position is taken
    for (int i = 5; i >= 0;i--) {
        
        if(board.get(i).get(position).equals('0')){
            board.get(i).set(position,player);
            setBoard(board);
            return true;
        }
    }

    return false;
}

/**
 Reads from file
 @param aParameter none
 @return line
 . . .
*/
public String readLines() {
        String line = null;
        try{
            //get path to file
            path = FileSystems.getDefault().getPath("./assets", fileLoad);
            line = Files.readString(path);
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
        return line;
}

/**
 Prints game board to file
 @param aParameter String nameOfFile
 @return none
 . . .
*/
public void printBoardToFile(String nameOfFile){
    String allFile = "./assets/" + nameOfFile;
    try {
      FileWriter myWriter = new FileWriter(allFile);
      //loop here to write board to file
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 7; j++){
            myWriter.write(board.get(i).get(j) + ",");
            if (j == 6) {
                myWriter.write("\n");
            }
        }
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}
  

/**
 Loads game board from fil
 @param aParameter none
 @return none
 . . .
*/
public void getBoardFromFile() throws NullPointerException{
    int n = 0;
    String line = readLines();
    try{
        //throw exception for null
     if (line == null) {
         throw new NullPointerException("file is empty or does not exist");
     }
    }catch(NullPointerException e){
        System.out.println("Invalid file\n");
     }
     if(line != null){
        char[] arr = {};
        List<Character> chars = new ArrayList<>();
        for (char ch : line.toCharArray()) {
            if (ch == ',') {
                continue;
            }
            if (ch == '\n') {
                n++;
            }else{
                //increment row 
                 arr = Arrays.copyOf(arr, arr.length + 1);
                 arr[arr.length - 1] = ch;
            }
        }
        int k = 0;
        //set board from file
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if (board.get(i).get(j) != arr[k]) {
                    board.get(i).set(j,arr[k]);
                }
                k++;
            }
        }
    }   

}

/**
 Converts board to string
 @param aParameter none
 @return boardString
 . . .
*/
public String toString(){
    String boardString = "";
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
        boardString += this.board.get(i).get(j) + ",";
      }
      boardString += this.board.get(i).get(6) + "";
      boardString += "\n";
    }
    return boardString;
  }


}