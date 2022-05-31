import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        UI game = new UI();
        Scanner input = new Scanner(System.in);

        game.displayBoard();

        while(true){
            System.out.print("Enter a spot 0 - " + (CONSTANTS.HORIZONTAL_SPACES - 1) + ": ");
            game.addPiece(input.nextInt());
            game.displayBoard();


        }



    }
}
