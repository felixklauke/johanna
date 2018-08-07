package de.d3adspace.johanna.extension.module;

import com.google.inject.AbstractModule;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class JohannaModule extends AbstractModule {

    /**
     * The server instance.
     */
    private final Server server;

    /**
     * Create a new module by its server instance.
     *
     * @param server The server instance.
     */
    public JohannaModule(Server server) {
        this.server = server;
    }

    @Override
    protected void configure() {

        bind(Server.class).toInstance(server);
        bind(PluginManager.class).toInstance(server.getPluginManager());
        bind(BukkitScheduler.class).toInstance(server.getScheduler());
        bind(ScoreboardManager.class).toInstance(server.getScoreboardManager());
        bind(ServicesManager.class).toInstance(server.getServicesManager());
        bind(Messenger.class).toInstance(server.getMessenger());
        bind(ItemFactory.class).toInstance(server.getItemFactory());
        bind(ConsoleCommandSender.class).toInstance(server.getConsoleSender());
    }
}
