public class Game {
    public String validate(String gesture){
        if (! (gesture.equals("rock") || gesture.equals("paper") || gesture.equals("scissors")))
            throw new IllegalArgumentException("Bad Choice!");
        return gesture;
    }

    public String judge(String gesture1, String gesture2) {
        if (gesture1.equals(gesture2)) {
            return "Draw!";
        } else if (gesture1.equals("scissors") && gesture2.equals("paper") ||
                gesture1.equals("rock") && gesture2.equals("scissors") ||
                gesture1.equals("paper") && gesture2.equals("rock")) {
            return "Player 1 win!";
        } else {
            return "Player 2 win!";
        }
    }
}
