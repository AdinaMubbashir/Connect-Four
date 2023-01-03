/**
* Description: The class tests public
* functions in board class that have to do with winning
* and updating board
* @author  Adina Mubbashir
*/

package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* you will need to add test methods and likely change the
setup method as well.  The samples that are here are just so that
you can see how junit works.

Tests are run on build unless specifically excluded with -x test.
The test results are reported in the reports subfolder of the build directory */


public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    @Test 
    public void testhasGameEnded(){

        Assert.assertEquals(true, tester.hasGameEnded(0));
        tester.setPosition(1);
        tester.fillBoard(1);
        tester.setPosition(2);
        tester.fillBoard(2);
        tester.setPosition(1);
        tester.fillBoard(3);
        tester.setPosition(2);
        tester.fillBoard(4);
        tester.setPosition(1);
        tester.fillBoard(5);
        tester.setPosition(2);
        tester.fillBoard(6);
        tester.setPosition(1);
        tester.fillBoard(7);
        Assert.assertEquals(false, tester.hasGameEnded(8));

}

  @Test 
  public void testWinner(){

        tester.setPosition(1);
        tester.fillBoard(0);
        tester.setPosition(0);
        tester.fillBoard(1);
        tester.setPosition(2);
        tester.fillBoard(2);
        tester.setPosition(6);
        tester.fillBoard(3);
        tester.setPosition(3);
        tester.fillBoard(4);
        tester.setPosition(0);
        tester.fillBoard(5);
        tester.setPosition(4);
        tester.fillBoard(6);

     Assert.assertEquals('1', tester.winner());

}


  @Test 
  public void testWinnerHorizontal(){

        tester.setPosition(1);
        tester.fillBoard(0);
        tester.setPosition(1);
        tester.fillBoard(1);
        tester.setPosition(2);
        tester.fillBoard(2);
        tester.setPosition(2);
        tester.fillBoard(3);
        tester.setPosition(3);
        tester.fillBoard(4);
        tester.setPosition(3);
        tester.fillBoard(5);
        tester.setPosition(4);
        tester.fillBoard(6);

     Assert.assertEquals('1', tester.winnerHorizontal());

}

  @Test 
  public void testWinnerVertical(){

        tester.setPosition(1);
        tester.fillBoard(1);
        tester.setPosition(2);
        tester.fillBoard(2);
        tester.setPosition(1);
        tester.fillBoard(3);
        tester.setPosition(2);
        tester.fillBoard(4);
        tester.setPosition(1);
        tester.fillBoard(5);
        tester.setPosition(2);
        tester.fillBoard(6);
        tester.setPosition(1);
        tester.fillBoard(7);

    Assert.assertEquals('2', tester.winnerVertical());

}

  @Test 
  public void testWinnerDiagonal(){

        tester.setPosition(0);
        tester.fillBoard(1);
        tester.setPosition(2);
        tester.fillBoard(2);
        tester.setPosition(1);
        tester.fillBoard(3);
        tester.setPosition(2);
        tester.fillBoard(4);
        tester.setPosition(2);
        tester.fillBoard(5);
        tester.setPosition(3);
        tester.fillBoard(6);
        tester.setPosition(3);
        tester.fillBoard(7);
        tester.setPosition(5);
        tester.fillBoard(8);
        tester.setPosition(6);
        tester.fillBoard(9);

    Assert.assertEquals('0', tester.winnerDiagonal());

 }

  @Test 
  public void testFillBoard(){

        tester.setPosition(1);
        tester.fillBoard(1);
        tester.setPosition(1);
        tester.fillBoard(2);
        tester.setPosition(1);
        tester.fillBoard(3);
        tester.setPosition(1);
        tester.fillBoard(4);
        tester.setPosition(1);
        tester.fillBoard(5);
        tester.setPosition(1);
        tester.fillBoard(6);
        tester.setPosition(1);
        tester.fillBoard(7);

     Assert.assertEquals(false, tester.fillBoard(8));

}

}