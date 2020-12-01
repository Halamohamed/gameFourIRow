package se.ecutb.game;


public class FourIRow {

    private String player;
    public String[][] board;
    private int row;
    private int column;
    private int button_row;

    public FourIRow(){
        player = "X";

        board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
            {"","","","","","",""}};
        //button_row = 5;
    }

    public String nextPlayer(){
        player = player == "X" ? "O" : "X";
        return player;
    }

    public void setIColumn(int col, String currentMarker) throws Exception {
        button_row = 5;
       do {
           if(col < 0 || col > 7){
               throw new Exception("Column must be between 1 and 7");
           }
           for (int i=5; i>=0; i--) {
               if (board[i][col] == "") {
                   board[i][col] = currentMarker;
                   return;
               }
           }
           System.out.println("Column " + col + " is full");
        }while (true);


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
    public void newBoardGame(){

        System.out.println("---------------------------");
        for (int i =0; i < 6; i++) {
            for (int j = 0; j < 7 ; j++) {
                board[i][j] = "";
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");


    }




}
