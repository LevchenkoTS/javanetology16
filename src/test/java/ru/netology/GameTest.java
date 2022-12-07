package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    Game game = new Game();
    Player player1 = new Player(1, "Peter", 100);
    Player player2 = new Player(2, "Ben", 150);
    Player player3 = new Player(3,"Kate", 100);




    @Test
    public void firstPlayerStronger() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Peter","Ben");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void SecondPlayerStronger() {
        game.register(player2);
        game.register(player1);

        int expected = 1;
        int actual = game.round("Ben", "Peter");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void strengthEqual() {
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Peter","Kate");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredFirstPlayer () {

        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ben", "Peter"));
    }
    @Test
    public void notRegisteredSecondPlayer () {

        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Peter", "Ben"));
    }
}

