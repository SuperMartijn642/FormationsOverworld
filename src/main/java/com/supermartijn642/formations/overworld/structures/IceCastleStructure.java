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
public class IceCastleStructure extends StructureConfigurator {

    public IceCastleStructure(){
        super("ice_castle");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.FROZEN_RIVER, Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.NONE)
            .simpleType(properties -> properties.templatePool("ice_castles").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("ice_castles")
            .commonEntries(entry -> entry.groundLevel(1), "ice_castle1", "ice_castle2");
    }
}
