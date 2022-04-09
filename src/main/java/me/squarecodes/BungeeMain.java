package me.squarecodes;

import me.squarecodes.commands.*;
import me.squarecodes.events.ServerEvents;
import net.md_5.bungee.api.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BungeeMain extends Plugin {
    private Connection connection;
    public String host, database, username, password;
    public int port;


    @Override
    public void onEnable() {
        mysqlSetup();
        getLogger().info("BungeeUtils has loaded.");
        getProxy().getPluginManager().registerCommand(this, new PingCommand());
        getProxy().getPluginManager().registerCommand(this, new HubCommand());
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());
        getProxy().getPluginManager().registerCommand(this, new AdminChatCommand());
        getProxy().getPluginManager().registerCommand(this, new ReportCommand());
        getProxy().getPluginManager().registerListener(this, new ServerEvents());
    }

    public void mysqlSetup() {
        host = "136.243.134.184";
        port = 3306;
        database = "s1_BungeeUtils";
        username = "u1_9DSAXlCExQ";
        password = "A38XCwWLt+pw@cLN48E0D.+i";

        try {
            synchronized (this) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
            }
                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false", username, password));

                getLogger().info("§aSuccessfully connected to database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        mysqlOpenConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    private void mysqlOpenConnection(){

    }

}