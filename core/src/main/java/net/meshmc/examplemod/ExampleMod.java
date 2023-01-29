package net.meshmc.examplemod;

import net.meshmc.mesh.loader.MeshLoader;
import net.meshmc.mesh.loader.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod implements Mod.Initializer {
    public static final Logger LOGGER = LogManager.getLogger("Example Mod");

    @Mod.Instance
    public static ExampleMod INSTANCE;

    @Mod.Interface
    private ITest test;

    @Override
    public void init(Mod mod) {
        LOGGER.info("Example Mod loaded in {} {}!",
                MeshLoader.getInstance().getRuntime().name().toLowerCase(),
                MeshLoader.getInstance().getGameVersion());
        if(!mod.isVersionLoaded()) return;

        INSTANCE.test.test();
    }
}