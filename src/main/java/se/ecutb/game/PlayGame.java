package se.ecutb.game;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static se.ecutb.game.GameIO.save;
import static se.ecutb.game.SaveFile.FILE;
import static se.ecutb.game.SaveFile.writeText;


public class PlayGame extends Game{
    private int play_number;
    public final FourIRow fourIRow;
    public boolean winner= false;
    String marker;
    String[][] myBoard ;
    private int count;
    Scanner read = new Scanner(System.in);
    public List<String> list = new ArrayList<>();
   // public static File file = new File("textFile/games.txt");

    public PlayGame()  {
        this.play_number =1;
        fourIRow = new FourIRow();
        myBoard = fourIRow.board;
        count = 0;


    }

     public void start() throws IOException {
         System.out.println("enter how many you want to play: 1, 2, 3, 4, 5");
         play_number = read.nextInt();
         myBoard = fourIRow.newBoardGame();
         while (!winner || count <= play_number){
             count++;
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

    public void controlWinner() throws IOException {
        winner = getWinner();

        if( winner && count < play_number){
            System.out.println(winnerGame() + " winner");
            list.add("winner : " + winnerGame() );
            myBoard = fourIRow.newBoardGame();

            count++;
        }else
        if(gameOver() ){
            winner = false;
            SaveFile.readText(FILE);
            start();
        }else
        if(winner && count >= play_number){
            System.out.println(winnerGame() + " winner");
            count=0;
            winner = false;
            list.add("winner : " + winnerGame());
            start();
        }
        SaveFile.writeText(FILE,list);
    }


    private void printColNo() {
        System.out.println("set in a column ");
        for (int i = 1; i < 8; i++) {
            System.out.print(i + "  ");
        }
    }

    public void setInCol(String player, int colP) {
        try {
            fourIRow.setIColumn(colP -1, player);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        for (int i = 5; i >=0; i--) {
            if(getStringHoriz(i)){
                winner = true;
                System.out.println("horiz " + winner);
                return true;
            }
        }
        return false;
    }

    public boolean diagonalWinner(){
        return getStringDiag() || getStringDiag1() || getStringDiag2();
    }
    public String winnerGame(){
        return marker;
    }

    public boolean getWinner() {
        return diagonalWinner()||
                verticalWinner()||
                horizontalWinner();
    }

    public boolean compare(StringBuilder st) {
        if ((st.toString().toUpperCase().contains("XXXX"))){
            marker = "X";
            return true;
        } else if ((st.toString().toUpperCase().contains("OOOO"))) {
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


}
