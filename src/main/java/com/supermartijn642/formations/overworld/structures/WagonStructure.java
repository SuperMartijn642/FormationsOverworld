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
public class WagonStructure extends StructureConfigurator {

    public WagonStructure(){
        super("wagon");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_TAIGA.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.DESERT, Biomes.PLAINS, Biomes.SNOWY_PLAINS, Biomes.SUNFLOWER_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("wagons").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("wagons")
            .entry("wagon", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("wagon")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 5)
                    .itemEntry(Items.WHEAT, 1, 3, 10)
                    .itemEntry(Items.APPLE, 1, 5, 3)
                    .itemEntry(Items.GLISTERING_MELON_SLICE, 1, 6, 1)
                    .enchantedItemEntry(Items.FISHING_ROD, 10, false, 1)
            )
            .pool(pool ->
                pool.uniformRolls(1, 2)
                    .itemEntry(Items.MELON_SEEDS, 1, 6, 1)
                    .itemEntry(Items.BEETROOT_SEEDS, 1, 6, 1)
                    .itemEntry(Items.PUMPKIN_SEEDS, 1, 6, 1)
                    .itemEntry(Items.WHEAT_SEEDS, 1, 6, 1)
                    .itemEntry(Items.TORCHFLOWER_SEEDS, 1, 5, 1)
                    .itemEntry(Items.POTATO, 1, 6, 1)
                    .itemEntry(Items.CARROT, 1, 6, 1)
            );
    }
}
