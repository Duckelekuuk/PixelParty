package com.duckelekuuk.cakewars.commands;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.GamePlayer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;

@CommandInfo(
        description = "This is the default help command",
        usage = "help",
        aliases = {"help", "?", "h"}
)
public class HelpCommand extends AbstractCommand {

    public HelpCommand(Cakewars plugin) {
        super(plugin);
    }

    @Override
    protected void onCommand(GamePlayer player, CommandSender sender, String[] args) {
        sender.sendMessage(StringUtils.join(args, " "));
    }
}
