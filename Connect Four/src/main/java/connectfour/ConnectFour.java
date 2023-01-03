
/**
* Description: The class runs the connect four game and
* sets the turn of player
* @author  Adina Mubbashir
*/

package connectfour;

public class ConnectFour{

private int countTurn = 0;
private char playerTurn;

 public ConnectFour() {
    playerTurn = 'R';
  }


//Setting turn of players
public void setTurn(int i) {
    if (i % 2 == 0){
            playerTurn = '1';
        } else {
            playerTurn = '2';
        }
}

//Getting turn of players
public char getTurn(int i){
    if (i % 2 == 0){
            return '1';
        } 
    return '2';
}

    public static void main(String[] args) {

        Board obj = new Board();
        TextUI obj2 = new TextUI();
        int i = 0;

        //load board from file
        obj2.loadFromFile(obj);

        //game continues until there is a tie or winner
        while(obj.hasGameEnded(i)){

            obj2.gameStart(obj,i);
            i++;
        }
    }

public String toString(){

    return "Starting and keeping track of turns";

}


}
