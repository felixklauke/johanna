package de.d3adspace.johanna.extension;

import net.minecraft.server.v1_12_R1.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.Main;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.event.Listener;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class JohannaExtension implements Extension, TestInstancePostProcessor, BeforeAllCallback, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) throws Exception {

        MinecraftServer.getServer().stop();
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

        new Thread(() -> {
            System.out.println("Running Main...");
            Main.main(new String[]{  });
            System.out.println("Spigot ended.");
        }).start();

        // TODO: Better waiting, this is bullshit.
        Thread.sleep(15000);
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {


    }
}
