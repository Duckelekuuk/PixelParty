package com.duckelekuuk.cakewars.commands;

import com.duckelekuuk.cakewars.Cakewars;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;

public class CommandManager implements CommandExecutor {

    private Cakewars plugin;
    private HashSet<AbstractCommand> commands;

    public CommandManager(Cakewars plugin) {
        this.plugin = plugin;
        this.commands = new HashSet<>();

        // Register the command to Spigot
        plugin.getCommand("cakewars").setExecutor(this);

        // Register the internal commands
        registerCommand(new HelpCommand(plugin));
    }

    public void registerCommand(AbstractCommand command) {
        this.commands.add(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // We need to make sure there is at least 1 argument
        if(args.length < 1){
            // No arguments are given.
            // TODO show/build help menus
            return true;
        }

        for (AbstractCommand command : commands) {
            // Get the commandInfo annotation if exist, otherwise skip.
            CommandInfo commandInfo = command.getClass().getAnnotation(CommandInfo.class);
            if(commandInfo == null) continue;

            // Check if any of the aliases matches the first argument
            if(Arrays.stream(commandInfo.aliases()).anyMatch(alias -> alias.equalsIgnoreCase(args[0]))){

                // Check if OP is required and if the player is OP
                if(commandInfo.op() && !sender.isOp()){
                    // TODO person is not OP
                    return true;
                }

                // Check if command can only be executed from ingame
                if(commandInfo.player_only() && !(sender instanceof Player)){
                    // TODO can only be called from ingame
                    return true;
                }

                // Remove the first argument from the array and execute the command.
                command.onCommand(plugin.getGameManager().getGameplayer(sender ,false), sender, Arrays.copyOfRange(args, 1, args.length));
                return true;
            }
        }

        // No commands have been found that matches any of the aliases
        // TODO
        return true;
    }
}
