package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.Set;
import java.util.stream.Collectors;

public class BlueTeam implements ITeam {

    private GameManager gameManager;

    public BlueTeam(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public String getTeamName() {
        return "BLUE";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.BLUE;
    }

    @Override
    public GameManager getGameManager() {
        return gameManager;
    }
}
