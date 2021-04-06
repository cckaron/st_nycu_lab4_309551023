import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Game Start!
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
        Game game = new Game();

        // Player1
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        String gestureOfPlayer1 = input.nextLine();
        game.validate(gestureOfPlayer1);

        // Player2
        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        String gestureOfPlayer2 = input.nextLine();
        game.validate(gestureOfPlayer2);

        // Judge
        String result = game.judge(gestureOfPlayer1, gestureOfPlayer2);
        System.out.println(result);
    }
}
