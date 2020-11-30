package se.ecutb.game;

import java.util.Scanner;

public class PlayGame extends Game{
    private int play_number;
    private FourIRow fourIRow;
    private boolean winner= false;
    String marker;
    String[][] myBoard ;
    private int count= 1;
    Scanner read = new Scanner(System.in);

    public PlayGame(int play_number)  {
        this.play_number = play_number;
        fourIRow = new FourIRow();
        myBoard = fourIRow.board;

    }

     public void start(){
         do{
             String player2, player1 = fourIRow.nextPlayer();
             System.out.println("Player1 : " + player1);
             printColNo();
             int colP1 = read.nextInt();

             setInCol(player1, colP1);
             //winner = verticalWinner();
             controlWinner();

             player2 = fourIRow.nextPlayer();
             System.out.println("Player2 : " + player2);
             printColNo();
             int colP2 = read.nextInt();

             setInCol(player2,colP2);

             fourIRow.boardGame();

             controlWinner();
             System.out.println("Winner : " + winner);
             System.out.println("count : " + count);

         }while (!winner || play_number<= count);
     }

    private void controlWinner() {
        winner = getWinner();
        if(winner){
            System.out.println(winnerGame() + " winner");
            count++;
            fourIRow.newBoardGame();
        }
        if(gameOver()){
            fourIRow.newBoardGame();
            count++;
        }
    }

    public String winnerGame(){
        winner= getWinner();
        return marker;
    }

    private boolean getWinner() {
        String play;
        if(verticalWinner())
            return true;

        if(horizontalWinner())
            return true;


        /*for (int i = 5; i >=0; i--) {
                if((fourIRow.board[i][0].equals("X") && fourIRow.board[i][1].equals("X")&& fourIRow.board[i][2].equals("X") && fourIRow.board[i][3].equals("X")) ||
                        (fourIRow.board[i][0].equals("O") && fourIRow.board[i][1].equals("O")&& fourIRow.board[i][2].equals("O") && fourIRow.board[i][3].equals("O"))){
                    marker = fourIRow.board[i][0];
                    return true;
            }else if((fourIRow.board[i][1].equals("X") && fourIRow.board[i][2].equals("X")&& fourIRow.board[i][3].equals("X") && fourIRow.board[i][4].equals("X")) ||
            (fourIRow.board[i][1].equals("O") && fourIRow.board[i][2].equals("O")&& fourIRow.board[i][3].equals("O") && fourIRow.board[i][4].equals("O"))){
                marker = fourIRow.board[i][1];
                return true;
            }else if((fourIRow.board[i][2].equals("X") && fourIRow.board[i][3].equals("X")&& fourIRow.board[i][4].equals("X") && fourIRow.board[i][5].equals("X")) ||
            (fourIRow.board[i][2].equals("O") && fourIRow.board[i][3].equals("O")&& fourIRow.board[i][4].equals("O") && fourIRow.board[i][5].equals("O"))){
                marker = fourIRow.board[i][2];
                return true;
            }else if((fourIRow.board[i][3].equals("X") && fourIRow.board[i][4].equals("X")&& fourIRow.board[i][5].equals("X") && fourIRow.board[i][6].equals("X")) ||
            (fourIRow.board[i][3].equals("O") && fourIRow.board[i][4].equals("O")&& fourIRow.board[i][5].equals("O") && fourIRow.board[i][6].equals("O"))){
                marker = fourIRow.board[i][2];
                return true;
            }else if((fourIRow.board[0][i].equals("X") && fourIRow.board[1][i].equals("X")&& fourIRow.board[2][i].equals("X") && fourIRow.board[3][i].equals("X")) ||
            (fourIRow.board[0][i].equals("O") && fourIRow.board[1][i].equals("O")&& fourIRow.board[2][i].equals("O") && fourIRow.board[3][i].equals("O"))){
                marker = fourIRow.board[0][i];
                return true;
            }else if((fourIRow.board[1][i].equals("X") && fourIRow.board[2][i].equals("X")&& fourIRow.board[3][i].equals("X") && fourIRow.board[4][i].equals("X")) ||
            (fourIRow.board[1][i].equals("O") && fourIRow.board[2][i].equals("O")&& fourIRow.board[3][i].equals("O") && fourIRow.board[4][i].equals("O"))){
                marker = fourIRow.board[1][i];
                return true;
            }else if((fourIRow.board[2][i].equals("X") && fourIRow.board[3][i].equals("X")&& fourIRow.board[4][i].equals("X") && fourIRow.board[5][i].equals("X")) ||
            (fourIRow.board[2][i].equals("O") && fourIRow.board[3][i].equals("O")&& fourIRow.board[4][i].equals("O") && fourIRow.board[5][i].equals("O"))){
                marker = fourIRow.board[i][0];
                return true;
            }
        }*/
        return false;
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
    public void diagonalWinner(){

    }

    public boolean getStringVert(int col){
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            st.append(myBoard[i][col]);
        }
        if (compare(st)) return true;
        return false;
    }
    public boolean getStringHoriz(int row){
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            st.append(myBoard[row][i]);
        }
        if (compare(st)) return true;
        return false;
    }

    private boolean compare(StringBuilder st) {
        System.out.print( st.toString());
        if (st.toString().equalsIgnoreCase("XXXX")) {
            //marker = "X";
            return true;
        } else if (st.toString().equalsIgnoreCase("OOOO")) {
            //System.out.println("O Wins");
            //marker = "O";
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

}
