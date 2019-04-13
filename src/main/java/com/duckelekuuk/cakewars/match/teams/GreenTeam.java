package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.Set;
import java.util.stream.Collectors;

public class GreenTeam implements ITeam {

    private GameManager gameManager;

    public GreenTeam(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public String getTeamName() {
        return "GREEN";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.GREEN;
    }

    @Override
    public GameManager getGameManager() {
        return gameManager;
    }
}
