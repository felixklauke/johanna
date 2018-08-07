import de.d3adspace.johanna.extension.JohannaExtension;
import net.minecraft.server.v1_12_R1.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
@ExtendWith(JohannaExtension.class)
public class ExampleTest {

    @Test
    public void testServerIsRunning() {

        System.out.println("Starting test... ");

        Server server = Bukkit.getServer();

        Assertions.assertNotNull(server, "Server instance should not be null.");

        Assertions.assertTrue(MinecraftServer.getServer().isRunning(), "Mine craft server should be running.");

        System.out.println("Ended test...");
    }
}
