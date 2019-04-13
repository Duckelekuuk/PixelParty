package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.Set;
import java.util.stream.Collectors;

public interface ITeam {

    String getTeamName();

    ChatColor getPrefix();

    GameManager getGameManager();

    default Set<GamePlayer> getMembers() {
        return getGameManager().getGamePlayers().stream().filter(gamePlayer -> gamePlayer.getTeam().equals(this)).collect(Collectors.toSet());
    }
}
