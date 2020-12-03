package se.ecutb.game;


public class FourIRow {

    private String player;
    public String[][] board;
    private int button_row;


    public FourIRow(){
        player = "X";
        board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
            {"","","","","","",""}};

    }

    public String nextPlayer(){
        player = player == "X" ? "O" : "X";
        return player;
    }

    public void setIColumn(int col, String currentMarker) throws Exception {
        button_row = 5;

           if(col < 0 || col > 7){
               throw new Exception("Column must be between 1 and 7");
           }
           for (int i=5; i>=0; i--) {
               if (board[i][col].equals("")) {
                   board[i][col] = currentMarker;
                   return;
               }
           }
           if(board[0][col] != ""){
               System.out.println("Column " + col + " is full");
           }
    }

    public void boardGame(){

        System.out.println("---------------------------");
        for (int i =0; i < 6; i++) {
            for (int j = 0; j < 7 ; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");


    }
    public String[][] newBoardGame(){

        System.out.println("---------------------------");
        for (int i =0; i < 6; i++) {
            for (int j = 0; j < 7 ; j++) {
                board[i][j] = "";
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
        return board;

    }
   /* public boolean verticalWinner(){
        for (int i = 0; i < 7; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                stringBuilder.append(board[i][j]);
            }if(game.compare(stringBuilder)){
                game.winner = true;
                return true;
            }
        }
        return false;
    }*/
}
