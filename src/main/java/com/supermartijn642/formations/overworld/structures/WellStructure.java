package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class WellStructure extends StructureConfigurator {

    public WellStructure(){
        super("well");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.DESERT, Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("wells").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("wells")
            .commonEntries(entry -> entry.groundLevel(4).processors(new BiomeReplacementProcessor()), "well1", "well2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("well")
            .pool(pool ->
                pool.uniformRolls(4, 6)
                    .itemEntry(Items.IRON_NUGGET, 3, 8, 20)
                    .itemEntry(Items.EMERALD, 1, 5, 5)
                    .itemEntry(Items.GOLDEN_APPLE, 1, 1)
                    .itemEntry(Items.NAME_TAG, 1, 1)
                    .itemEntry(Items.PRISMARINE_CRYSTALS, 1, 4, 5)
            );
    }
}
