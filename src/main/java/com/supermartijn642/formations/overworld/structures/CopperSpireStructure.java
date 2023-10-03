package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class CopperSpireStructure extends StructureConfigurator {

    public CopperSpireStructure(){
        super("copper_spire");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.DESERT, Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .simpleType(properties -> properties.templatePool("copper_spires").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("copper_spires")
            .entry("copper_spire", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()));
    }
}
