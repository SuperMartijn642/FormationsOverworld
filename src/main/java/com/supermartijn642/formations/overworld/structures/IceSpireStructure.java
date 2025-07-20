package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 20/07/2025 by SuperMartijn642
 */
public class IceSpireStructure extends StructureConfigurator {

    public IceSpireStructure(){
        super("ice_spire");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.ICE_SPIKES)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("ice_spires").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("ice_spires")
            .entry("ice_spire", entry -> entry.groundLevel(1));
    }
}
