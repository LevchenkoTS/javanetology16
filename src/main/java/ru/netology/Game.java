package ru.netology;


import java.util.ArrayList;
import java.util.HashMap;

public class Game {


    HashMap<Integer, Player> players = new HashMap<>();


    public void register(Player player) {
        players.put(player.getId(), player);
    }

    public Player findByName(String name) {
        for (Player player : players.values()) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
