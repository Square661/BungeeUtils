package me.squarecodes.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReportCommand extends Command {
    public ReportCommand() {
        super("report", "", "report");
    }
    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            // Arguments: /report <player> <reason>
            // Args : /report arg0<Player> arg1<Reason>

            if(args.length == 0) {
                player.sendMessage(new TextComponent("§cUsage: /report <player> <reason>"));
            }
            else if(args.length == 1) {
                player.sendMessage(new TextComponent("§cUsage: /report <player> <reason>"));
            }
            else if(args.length == 2) {
                // Check if the player is online
                String target = String.valueOf(ProxyServer.getInstance().getPlayer(args[0]));
                ProxiedPlayer targetPlayer = ProxyServer.getInstance().getPlayer(target);
                if(target != null) {
                    player.sendMessage(new TextComponent("§aYour report has been successfully sent to all staff. We will §alook into it."));

                    for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                        if(players.hasPermission("bungeeutils.staff")) {
                            TextComponent message = new TextComponent("§8» §d[R]§5 " + player.getName() + "§7 has reported §5" + target + " §7for§f " + args[1] + "§7.");
                            String targetServer = ProxyServer.getInstance().getPlayer(target).getServer().getInfo().getName();

                            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Servers§7:"
                                    + "\n" + "§8- §4" + player.getServer().getInfo().getName() + " §7(§c" + player.getDisplayName() + "'s server§7)"
                                    + "\n" + "§8- §4" + targetPlayer.getServer().getInfo().getName() + " §7(§c" + targetPlayer.getDisplayName() + "'s server§7)" ).create()));




                            players.sendMessage(message);
                        }

                    }

                } else {
                    player.sendMessage(new TextComponent("§cPlayer not found."));
                }

            }



        } else {
            commandSender.sendMessage(new TextComponent("§cYou must be a player to use this command."));
        }
    }
}
