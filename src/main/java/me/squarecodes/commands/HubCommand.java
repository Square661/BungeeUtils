package me.squarecodes.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {
    public HubCommand() {
        super("hub", "", "lobby", "l");
    }
    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            ServerInfo target = ProxyServer.getInstance().getServerInfo("Hub-01");


            if(player.getServer().getInfo().getName().equalsIgnoreCase("Hub-01")) {
                player.sendMessage(new TextComponent(ChatColor.GREEN + "You are already in the Hub."));
                return;
            } else {
                player.sendMessage(new TextComponent(ChatColor.GREEN + "Sending you to the Hub..."));
                player.connect(target);
            }

        }
    }
}
