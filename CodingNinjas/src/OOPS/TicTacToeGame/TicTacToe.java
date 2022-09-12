package OOPS.TicTacToeGame;
import java.util.Scanner;

public class TicTacToe {
    private Player player1 , player2;
    private Board board;

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        // player input
        player1 = takePlayerInput(1);
        player2 = takePlayerInput(2);
        while (player1.getSymbol()==player2.getSymbol()){
            System.out.println("Symbol is Already Taken !! Please pick Another Symbol !!");
            char symbol = sc.next().charAt(0);
            player2.setSymbol(symbol);
        }
        // create board
        board = new Board(player1.getSymbol() , player2.getSymbol());

        // conduct game
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while(status == Board.INCOMPLETE){
            if(player1Turn){
                System.out.println("Player 1" + player1.getName() + "'s turn");
                System.out.println("Enter X : ");
                int x = sc.nextInt();
                System.out.println("Enter Y : ");
                int y = sc.nextInt();
                status = board.move(player1.getSymbol() , x ,y);
                if(status!=Board.INVALID){
                    player1Turn = false;
                    board.print();
                }
                else{
                    System.out.println("Invalid Move !! Try Again !!");
                    status = Board.INCOMPLETE;
                }
            }
            else{
                System.out.println("Player 2" + player2.getName() + "'s turn");
                System.out.println("Enter X : ");
                int x = sc.nextInt();
                System.out.println("Enter Y : ");
                int y = sc.nextInt();
                status = board.move(player2.getSymbol() , x ,y);
                if(status!=Board.INVALID){
                    player1Turn = true;
                    board.print();
                }
                else{
                    System.out.println("Invalid Move !! Try Again !!");
                    status = Board.INCOMPLETE;
                }
            }
        }

        if(status == Board.PLAYER_1_WINS){
            System.out.println("Player 1 - " + player1.getName() + " wins!!");
        }
        else if(status == Board.PLAYER_2_WINS){
            System.out.println("Player 2 - " + player2.getName() + " wins!!");
        }
        else{
            System.out.println("Draw !!");
        }
    }
    private Player takePlayerInput(int num){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter player " + num + " name : ");
        String name = sc.nextLine();
        System.out.println("Enter player " + num + " symbol : ");
        char symbol = sc.next().charAt(0);
        Player p = new Player(name,symbol);
        return p;
    }

    public static void main(String[] args) {
    TicTacToe t = new TicTacToe();
    t.startGame();
    }
}
