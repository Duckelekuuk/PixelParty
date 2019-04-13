package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import lombok.Getter;
import org.bukkit.ChatColor;

import java.util.Set;
import java.util.stream.Collectors;

public class YellowTeam implements ITeam {

    private GameManager gameManager;

    public YellowTeam(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public String getTeamName() {
        return "YELLOW";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.YELLOW;
    }

    @Override
    public GameManager getGameManager() {
        return gameManager;
    }
}
