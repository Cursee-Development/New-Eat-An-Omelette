package com.cursee.eat_an_omelette;

import com.cursee.eat_an_omelette.core.registry.RegistryFabric;
import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;

public class EatAnOmeletteFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        EatAnOmelette.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);
        RegistryFabric.register();
    }
}
