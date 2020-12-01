package se.ecutb.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame extends Game{
    private int play_number;
    private FourIRow fourIRow;
    private boolean winner= false;
    String marker;
    String[][] myBoard ;
    private int count= 1;
    Scanner read = new Scanner(System.in);
    List<FourIRow> list = new ArrayList<>();
    //StringBuilder stringBuilder;

    public PlayGame(int play_number)  {
        this.play_number = play_number;
        fourIRow = new FourIRow();
        myBoard = fourIRow.board;

    }

     public void start(){
         do{
             setPlayer();
             controlWinner();

             setPlayer();

             fourIRow.boardGame();
             controlWinner();

             System.out.println("\ncount : " + count);

         }while (!winner || play_number<= count);
     }

    public void setPlayer() {
        String player = fourIRow.nextPlayer();
        System.out.println("Player : " + player);
        printColNo();
        int colP = read.nextInt();
        setInCol(player,colP);
    }

    private void controlWinner() {
        winner = getWinner();

        if(gameOver() && count < play_number){
            fourIRow.newBoardGame();
            count++;
        }
        if(winner && count < play_number){
            System.out.println(winnerGame() + " winner");
            count++;
            list.add(fourIRow);
            fourIRow.newBoardGame();
        }if(winner && count >= play_number){
            System.out.println(winnerGame() + " winner");
            start();
            //fourIRow.newBoardGame();
        }
    }

    public String winnerGame(){
        return marker;
    }

    private boolean getWinner() {
        return diagonalWinner()|| verticalWinner() || horizontalWinner();
    }

    public boolean verticalWinner(){
        for (int i = 0; i < 7; i++) {
            if(getStringVert(i)){
                winner = true;
                return true;
            }
        }
        return false;

    }
    public boolean horizontalWinner(){
        for (int i = 0; i < 6; i++) {
            if(getStringHoriz(i)){
                winner = true;
                return true;
            }
        }
        return false;
    }
    public boolean diagonalWinner(){
        return getStringDiag() || getStringDiag1();
    }

    public boolean getStringVert(int col){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(myBoard[i][col]);
        }

        return compare(stringBuilder);
    }
    public boolean getStringHoriz(int row){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            stringBuilder.append(myBoard[row][i]);
        }
        return compare(stringBuilder);
    }
    public boolean getStringDiag1(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0,j=0 ; i < 6 ; i++) {
            stringBuilder.append(myBoard[i++][j++]);
        }
        return compare(stringBuilder);
    }
    public boolean getStringDiag(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 5,j=0 ; i >=0 ; i--) {
            stringBuilder.append(myBoard[i--][j++]);
        }
        return compare(stringBuilder);
    }

    public boolean compare(StringBuilder st) {
        //System.out.print( st.toString());
        if ((st.toString().equals("XXXX"))
               /* ||
                (st.toString().equalsIgnoreCase("OXXXX")) ||
                        (st.toString().equalsIgnoreCase("XXXXO")) ||
                                (st.toString().equalsIgnoreCase("OOXXXX")) ||
                                        (st.toString().equalsIgnoreCase("XXXXOO")) ||
                                                (st.toString().equalsIgnoreCase("OOOXXXX")) ||
                                                        (st.toString().equalsIgnoreCase("XXXXOOO")) ||
                (st.toString().equalsIgnoreCase("OOXXXXO")) ||
                (st.toString().equalsIgnoreCase("OXXXXOO"))) */
        ){
            marker = "X";
            return true;
        } else if ((st.toString().equals("OOOO"))
              /*  ||
                (st.toString().equalsIgnoreCase("XOOOO")) ||
                        (st.toString().equalsIgnoreCase("OOOOX")) ||
                                (st.toString().equalsIgnoreCase("XXOOOO")) ||
                                        (st.toString().equalsIgnoreCase("OOOOXX")) ||
                                                (st.toString().equalsIgnoreCase("XXXOOOO")) ||
                                                        (st.toString().equalsIgnoreCase("OOOOXXX")) ||
        (st.toString().equalsIgnoreCase("XOOOOXX")) ||
                (st.toString().equalsIgnoreCase("XXOOOOX"))*/
        ) {
            //System.out.println("O Wins");
            marker = "O";
            return true;
        }
        return false;
    }

    public boolean gameOver(){
         for (int i = 5; i >= 0; i--) {
             for (int j = 6; j >= 0; j--) {
                 if(myBoard[i][j].equals("")){
                     return false;
                 }
             }
         }return true;
     }

    private void printColNo() {
        System.out.println("set in a column ");
        for (int i = 1; i < 8; i++) {
            System.out.print(i + "  ");
        }
    }

    private void setInCol(String player, int colP) {
        try {
            fourIRow.setIColumn(colP -1, player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //System.out.println("winner : " + fourIRow.winnerGame());
       /*
        @Contract(mutates = "param3")
public void getChars(int srcBegin,
                     int srcEnd,
                     @NotNull char[] dst,
                     int dstBegin)
                      //String string = st.toString().getChars(0,3,st.toString().toCharArray(),0);

        char[] chars = new char[4];
        for (int i = 0; i < 4; i++) {
            chars[i] = st.toString().charAt(i);
        }
         */

}
