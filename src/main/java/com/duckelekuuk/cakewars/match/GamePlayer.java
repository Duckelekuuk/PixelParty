package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.match.teams.ITeam;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

@Getter
public class GamePlayer {

    private Player player;
    private @Setter ITeam team;

    private @Setter boolean spectator;

    public GamePlayer(Player player){
        this.player = player;
    }

    public void makeSpectator() {

    }
}
