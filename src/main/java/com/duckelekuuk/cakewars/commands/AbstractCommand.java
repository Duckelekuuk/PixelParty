package com.duckelekuuk.cakewars.commands;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.GamePlayer;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractCommand {

    private @Getter Cakewars plugin;

    public AbstractCommand(Cakewars plugin) {
        this.plugin = plugin;
    }

    protected abstract void onCommand(GamePlayer player, CommandSender sender, String[] args);
}
