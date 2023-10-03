package com.supermartijn642.formations.overworld;

import com.supermartijn642.formations.generators.StructureResourceGenerators;
import com.supermartijn642.formations.overworld.structures.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
public class FormationsOverworld implements ModInitializer {

    public static final String MODID = "formationsoverworld";

    @Override
    public void onInitialize(){
        if(FabricLoader.getInstance().isModLoaded("supermartijn642corelib") && FabricLoader.getInstance().isDevelopmentEnvironment())
            registerGenerators();
    }

    private static void registerGenerators(){
        StructureResourceGenerators generators = new StructureResourceGenerators(MODID);

        generators.addStructure(new BambooHutStructure());
        generators.addStructure(new CampsiteStructure());
        generators.addStructure(new CopperSpireStructure());
        generators.addStructure(new DesertHousesStructure());
        generators.addStructure(new FarmlandFieldStructure());
        generators.addStructure(new FountainStructure());
        generators.addStructure(new GraveyardStructure());
        generators.addStructure(new HobbitHoleStructure());
        generators.addStructure(new LargeTempleStructure());
        generators.addStructure(new LogShelterStructure());
        generators.addStructure(new LogSpikesStructure());
        generators.addStructure(new MesoamericanTempleStructure());
        generators.addStructure(new MeteorStructure());
        generators.addStructure(new OfferingStructure());
        generators.addStructure(new RaftStructure());
        generators.addStructure(new SmallHouseStructure());
        generators.addStructure(new SmallStatueStructure());
        generators.addStructure(new SmallTempleStructure());
        generators.addStructure(new StoneOreSpikesStructure());
        generators.addStructure(new StoneTowerStructure());
        generators.addStructure(new TinyHouseStructure());
        generators.addStructure(new TowerRemnantStructure());
        generators.addStructure(new WagonStructure());
        generators.addStructure(new WellStructure());
        generators.addStructure(new WitchTowerStructure());

        generators.register();
    }
}
