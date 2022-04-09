package me.squarecodes.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AdminChatCommand extends Command {
    public AdminChatCommand() {
        super("adminchat", "", "ac");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if(args.length == 1) {
                if(player.hasPermission("adminchat.use")) {

                    StringBuilder message = new StringBuilder();
                    for(String arg : args) {
                        message.append(arg).append(" ");
                    }
                    String msg = message.toString().trim();
                    for(ProxiedPlayer onlinePlayer : ProxyServer.getInstance().getPlayers()) {
                        if(onlinePlayer.hasPermission("adminchat.view")) {
                            onlinePlayer.sendMessage(new TextComponent("§c[AC] " + "§3[" + player.getServer().getInfo().getName() + "§3] §4" + player.getDisplayName() + "§7: §c" + msg));
                        }
                    }
                } else {
                    player.sendMessage(new TextComponent("§cYou do not have permission to use this command."));
                }
            } else {
                player.sendMessage(new TextComponent("§cUsage: /adminchat <message>"));
            }

        } else {
            commandSender.sendMessage(new TextComponent("§cYou must be a player to use this command."));
        }
    }
}
