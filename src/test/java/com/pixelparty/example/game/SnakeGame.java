package com.pixelparty.example.game;

import com.pixelparty.api.games.AbstractGame;
import com.pixelparty.api.inventory.AbstractInventory;
import org.bukkit.entity.Player;

import java.util.Collection;

public class SnakeGame extends AbstractGame<SnakeGameInfo> {

    private int points;
    private int lives;

    public SnakeGame(SnakeGameInfo gameInfo) {
        super(gameInfo);
    }

    @Override
    public AbstractInventory startNewGame(Collection<Player> playersWhichPlay) {
        //TODO: BOOM BOOM BOOM START
        return null;
    }
}
