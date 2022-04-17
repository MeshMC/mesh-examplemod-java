package net.meshmc.examplemod;

import dev.tigr.simpleevents.listener.EventHandler;
import dev.tigr.simpleevents.listener.EventListener;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.events.render.RenderEvent;
import net.meshmc.mesh.util.render.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mesh.Mod(modid = "examplemod", name = "Example Mod", version = "1.0-SNAPSHOT", description = "An example mod using the Mesh platform")
public class ExampleMod implements Mesh.Initializer {
    public static final Logger LOGGER = LogManager.getLogger("Example Mod");
    public static final Mesh MESH = Mesh.getMesh();

    @Override
    public void init() {
        LOGGER.info("Example Mod loaded in {} {}!", MESH.getLoaderType().name().toLowerCase(), MESH.getLoaderVersion());

        MESH.getEventManager().register(this);
    }

    @EventHandler
    private final EventListener<RenderEvent.Hud> hudRenderEventListener = new EventListener<>(event -> {
        MESH.getMinecraft().getTextRenderer().drawText("Hello " + MESH.getMinecraft().getSession().getUsername(), 0F, 0F, Color.WHITE);
    });
}