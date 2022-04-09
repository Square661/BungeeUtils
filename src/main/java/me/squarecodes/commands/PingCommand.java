package me.squarecodes.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {
    public PingCommand() {
        super("ping");
    }
    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            int ping = player.getPing();

            if(ping < 150) {
                player.sendMessage(new TextComponent("§ePing: §a" + ping + "ms"));
                return;
            }
            if(ping < 250) {
                player.sendMessage(new TextComponent("§ePing: §e" + ping + "ms"));
                return;
            }
            if(ping > 250) {
                player.sendMessage(new TextComponent("§ePing: §c" + ping + "ms"));
                return;
            }
        }
    }
}
