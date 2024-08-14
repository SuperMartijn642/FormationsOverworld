package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BedColorProcessor;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import com.supermartijn642.formations.structure.processors.FormationsBlockAgeProcessor;
import com.supermartijn642.formations.structure.processors.PlantGrowthProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class TinyHouseStructure extends StructureConfigurator {

    public TinyHouseStructure(){
        super("tiny_house");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_JUNGLE.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("tiny_houses").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("tiny_houses")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(0.1f, 0, 0), new PlantGrowthProcessor(0.1f, 1), new BedColorProcessor()), "tiny_house1", "tiny_house2")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(), new PlantGrowthProcessor(0.1f, 1), new BedColorProcessor()), "tiny_house1", "tiny_house2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("tiny_house")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(6, 8)
                    .itemEntry(Items.BOOK, 1, 3, 15)
                    .itemEntry(Items.COOKED_SALMON, 2, 4, 5)
                    .itemEntry(Items.GOLDEN_CARROT, 3, 5, 3)
                    .itemEntry(Items.CARROT, 2, 4, 15)
                    .itemEntry(Items.APPLE, 2, 4, 20)
                    .itemEntry(Items.TORCH, 1, 4, 20)
                    .itemEntry(Items.WHEAT, 2, 5, 20)
                    .itemEntry(Items.PAPER, 3, 5, 5)
                    .enchantedItemEntry(Items.BOOK, 15, 1)
            );
    }
}
