package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.teams.*;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

    private @Getter Cakewars plugin;
    private @Getter Set<ITeam> teams;
    private @Getter Set<GamePlayer> gamePlayers;
    private @Getter Match activeMatch;

    public GameManager(Cakewars plugin) {
        this.plugin = plugin;
        initialize();
    }

    public GamePlayer getGameplayer(CommandSender player, boolean createIfNull) {
        if(!(player instanceof Player)){
            return null;
        }

        for(ITeam team : teams) {
            for (GamePlayer teamPlayer : team.getMembers()) {
                if (teamPlayer.equals(player)) return teamPlayer;
            }
        }

        if (createIfNull) {

        }
        return null;
    }

    public void assignTeam(GamePlayer gamePlayer, ITeam team) {
        gamePlayer.setTeam(team);
    }

    private void initialize() {
        this.activeMatch = new Match(plugin);
        this.gamePlayers = new HashSet<>();
        this.teams = new HashSet<ITeam>() {{
            add(new BlueTeam(plugin.getGameManager()));
            add(new GreenTeam(plugin.getGameManager()));
            add(new RedTeam(plugin.getGameManager()));
            add(new YellowTeam(plugin.getGameManager()));
        }};
    }
}
