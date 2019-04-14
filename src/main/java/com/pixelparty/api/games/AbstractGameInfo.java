package com.pixelparty.api.games;

import lombok.Getter;

public abstract class AbstractGameInfo<T extends AbstractGame> {

    @Getter
    private final String prettyName, description;

    public AbstractGameInfo(String prettyName, String description) {
        this.prettyName = prettyName;
        this.description = description;
    }

    public abstract T createGame();
}
