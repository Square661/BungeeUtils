package me.squarecodes.events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerEvents implements Listener {
    @EventHandler
    public void onServerChange(ServerSwitchEvent e) {
        ServerInfo fromServer = e.getFrom();
        if(fromServer != null) {
            if (e.getPlayer().hasPermission("bungeeutils.staff")) {
                for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                    if (player.hasPermission("bungeeutils.staff")) {

                        player.sendMessage(new TextComponent("§c[S] §4" + e.getPlayer().getName() + " §7joined §c" + e.getPlayer().getServer().getInfo().getName() + "§7 from §c" + e.getFrom().getName()));
                    }
                }
            }
        } else {
            return;
        }

    }

    @EventHandler
    public void onDisconnect(PlayerDisconnectEvent e) {
        if (e.getPlayer().hasPermission("bungeeutils.staff")) {
            for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                if (player.hasPermission("bungeeutils.staff")) {

                    player.sendMessage(new TextComponent("§c[S] §4" + e.getPlayer().getName() + " §7disconnected from §c" + e.getPlayer().getServer().getInfo().getName()));
                }
            }
        }
    }

    @EventHandler
    public void onProxyJoin(ServerConnectEvent e) {
        if (e.getReason().equals(ServerConnectEvent.Reason.JOIN_PROXY)) {
            ProxiedPlayer p = e.getPlayer();
            ServerInfo server = e.getTarget();
            if (e.getPlayer().hasPermission("bungeeutils.staff")) {
                for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                    if (player.hasPermission("bungeeutils.staff")) {

                        player.sendMessage(new TextComponent("§c[S] §4" + p.getName() + " §7has joined §c" + server.getName()));
                    }
                }
            }


        } else {
            return;
        }

    }

}



