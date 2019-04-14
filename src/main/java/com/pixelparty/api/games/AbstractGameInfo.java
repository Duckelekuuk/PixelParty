package com.pixelparty.api.games;

import lombok.Getter;

public abstract class AbstractGameInfo {

    @Getter
    private final String prettyName, description;

    public AbstractGameInfo(String prettyName, String description) {
        this.prettyName = prettyName;
        this.description = description;
    }
}
