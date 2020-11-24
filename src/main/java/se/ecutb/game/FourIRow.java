package se.ecutb.game;

import java.util.Arrays;

public class FourIRow {

    private String currentPlayer;
    private String[][] board;
    private int row;
    private int column;
    private int button_row;

    public FourIRow(){
        currentPlayer = "X";
        row = 6;
        column = 7;
        board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
            {"","","","","","",""}};
        button_row = row-1;
    }

    public String nextPlayer(){
        currentPlayer = currentPlayer == "X" ? "O" : "X";
        return currentPlayer;
    }

    public void setIColumn(int col, String currentMarker) throws Exception {
        button_row = 5;
        if(board[button_row][col] == "" ){
            board[button_row][col] = currentMarker;
            button_row--;
        }
        if(col < 0 || col > 7){
            throw new Exception("can not set here");
        }
        if(board[button_row][col] != "" || board[button_row][col]== "X" || board[button_row][col]== "O"){
            board[button_row--][col] = currentMarker;
        }

    }

    private void insertI(int col, String currentMarker, int i) {
        if (board[i][col] == "")
            board[i][col] = currentMarker;
    }

    public String winnerGame(){
        String marker = null;
        for (int i = 5; i >=0; i--) {
            for (int j = 6; j >=0; j--) {
                if(board[i][j].equals("X") || board[i][j].equals("O") ){
                    marker = board[i][j];
                }
            }

        }return marker;
    }
    public void boardGame(){

        System.out.println("---------------------------");
        for (int i =0; i < 6; i++) {
            for (int j = 0; j < 7 ; j++) {
                System.out.print(board[i][j] + " | ");
                ;
            }
            System.out.println();
        }
        System.out.println("---------------------------");


    }
    public boolean GameOver(){
        String[][] myBoard = null;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(board[i][j] == "" ){
                   return false;
                }
            }

        }return true;
    }




}
