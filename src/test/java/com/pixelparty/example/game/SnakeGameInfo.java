package com.pixelparty.example.game;

import com.pixelparty.api.games.AbstractGameInfo;

public class SnakeGameInfo extends AbstractGameInfo<SnakeGame> {

    public SnakeGameInfo() {
        super("Snake", "Simple test game");
    }

    @Override
    public SnakeGame createGame() {
        return new SnakeGame(this);
    }
}
