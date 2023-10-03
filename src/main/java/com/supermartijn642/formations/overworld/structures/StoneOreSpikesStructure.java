package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class StoneOreSpikesStructure extends StructureConfigurator {

    public StoneOreSpikesStructure(){
        super("stone_ore_spikes");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_MOUNTAIN.location())
            .biomes(Biomes.DESERT, Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("stone_ore_spikes").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("stone_ore_spikes")
            .commonEntries(entry -> entry.groundLevel(5).processors(new BiomeReplacementProcessor()), "stone_ore_spikes1", "stone_ore_spikes2");
    }
}
