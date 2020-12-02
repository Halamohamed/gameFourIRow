package se.ecutb.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame extends Game{
    private int play_number;
    private final FourIRow fourIRow;
    private boolean winner= false;
    String marker;
    String[][] myBoard ;
    private int count;
    Scanner read = new Scanner(System.in);
    public List<FourIRow> list = new ArrayList<>();

    public PlayGame()  {
        this.play_number = 1;
        fourIRow = new FourIRow();
        myBoard = fourIRow.board;

    }

     public void start(){
         System.out.println("enter how many you want to play: 1, 2, 3, 4, 5");
         play_number = read.nextInt();
         myBoard = fourIRow.newBoardGame();
         while (!winner || count <= play_number){
             count = 1;
             //play the player1
             setPlayer();
             //control if there is winner
             controlWinner();

             //play the player2
             setPlayer();
             //printout board
             fourIRow.boardGame();
             //control if there is winner
             controlWinner();

             System.out.println("\ncount : " + count);

         }
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

        if( winner && count < play_number){
            myBoard = fourIRow.newBoardGame();
        }
        if(gameOver() ){
            winner = false;
            start();
            count++;
        }
        if(winner){
            System.out.println(winnerGame() + " winner");
            count++;
            winner = false;
            list.add(fourIRow);
            start();
        }
    }

    public String winnerGame(){
        return marker;
    }

    private boolean getWinner() {
        return diagonalWinner()||
                verticalWinner()||
                horizontalWinner();
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
                System.out.println("horiz " + winner);
                winner = true;
                return true;
            }
        }
        return false;
    }
    public boolean diagonalWinner(){
        return getStringDiag() || getStringDiag1() || getStringDiag2();
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
        for (int col = 0; col < 7; col++) {
            stringBuilder.append(myBoard[row][col]);
        }
        return compare(stringBuilder);
    }

    public boolean getStringDiag1(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0,j=0 ; i < 6 ; i++) {
            stringBuilder.append(myBoard[i][j++]);
        }
        return compare(stringBuilder);
    }
    public boolean getStringDiag2(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0,j=6 ; i < 6 ; i++) {
            stringBuilder.append(myBoard[i][j--]);
        }
        return compare(stringBuilder);
    }

    public boolean getStringDiag(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 5,j=0 ; i >=0 ; i--) {
            stringBuilder.append(myBoard[i][j++]);
        }
        return compare(stringBuilder);
    }

    public boolean compare(StringBuilder st) {

        if ((st.toString().equalsIgnoreCase("XXXX"))){
            marker = "X";
            return true;
        } else if ((st.toString().equalsIgnoreCase("OOOO"))) {
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
     /* ||
                (st.toString().equalsIgnoreCase("OXXXX")) ||
                        (st.toString().equalsIgnoreCase("XXXXO")) ||
                                (st.toString().equalsIgnoreCase("OOXXXX")) ||
                                        (st.toString().equalsIgnoreCase("XXXXOO")) ||
                                                (st.toString().equalsIgnoreCase("OOOXXXX")) ||
                                                        (st.toString().equalsIgnoreCase("XXXXOOO")) ||
                (st.toString().equalsIgnoreCase("OOXXXXO")) ||
                (st.toString().equalsIgnoreCase("OXXXXOO"))) */
