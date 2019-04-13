package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import lombok.Getter;

@Getter
public class Match {

    private Cakewars cakewars;

    private MatchStatus matchStatus;
    private MapConfig mapConfig;

    private boolean loaded;

    public Match(Cakewars cakewars) {
        this.cakewars = cakewars;
        this.matchStatus = MatchStatus.LOBBY;
        this.mapConfig = new MapConfig(cakewars);
        this.loaded = false;
    }
}
