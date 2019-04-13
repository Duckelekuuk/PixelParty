package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import org.bukkit.ChatColor;

public class RedTeam implements ITeam {

    private GameManager gameManager;

    public RedTeam(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public String getTeamName() {
        return "RED";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.RED;
    }

    @Override
    public GameManager getGameManager() {
        return gameManager;
    }
}
