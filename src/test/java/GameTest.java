import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    private static Stream<Arguments> provideStringsForDraw(){
        return Stream.of(
                Arguments.of(new String[]{"paper", "paper"}, "Draw!"),
                Arguments.of(new String[]{"scissors", "scissors"}, "Draw!"),
                Arguments.of(new String[]{"rock", "rock"}, "Draw!")
        );
    }

    private static Stream<Arguments> provideStringsForOneWinner(){
        return Stream.of(
                Arguments.of(new String[]{"paper", "scissors"}, "Player 2 win!"),
                Arguments.of(new String[]{"paper", "rock"}, "Player 1 win!"),
                Arguments.of(new String[]{"scissors", "paper"}, "Player 1 win!"),
                Arguments.of(new String[]{"scissors", "rock"}, "Player 2 win!"),
                Arguments.of(new String[]{"rock", "paper"}, "Player 2 win!"),
                Arguments.of(new String[]{"rock", "scissors"}, "Player 1 win!")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"paper", "scissors", "rock"})
    void legal_input(String input) {
        assertTrue(game.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"lizard", "spock"})
    void illegal_input(String input) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            game.validate(input);
        });
    }

    @ParameterizedTest
    @MethodSource("provideStringsForDraw")
    void draw(String[] input, String expected) {
        assertEquals(expected, game.judge(input[0], input[1]));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForOneWinner")
    void one_winner(String[] input, String expected) {
        assertEquals(expected, game.judge(input[0], input[1]));
    }

}