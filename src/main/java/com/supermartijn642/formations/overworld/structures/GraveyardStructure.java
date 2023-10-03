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
public class GraveyardStructure extends StructureConfigurator {

    public GraveyardStructure(){
        super("graveyard");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location())
            .biomes(Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("graveyards").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("graveyards")
            .commonEntries(entry -> entry.groundLevel(6).processors(new BiomeReplacementProcessor()), "graveyard1", "graveyard2", "graveyard3");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("graveyard/tomb")
            .pool(pool ->
                pool.uniformRolls(5, 10)
                    .itemEntry(Items.BONE, 1, 5, 20)
                    .itemEntry(Items.ROTTEN_FLESH, 1, 5, 20)
                    .itemEntry(Items.COBWEB, 1, 10)
                    .itemEntry(Items.GOLD_NUGGET, 5, 10, 1)
            )
            .pool(pool ->
                pool.uniformRolls(0, 1)
                    .enchantedItemEntry(Items.IRON_SWORD, 10, true, 5)
                    .enchantedItemEntry(Items.IRON_AXE, 10, true, 5)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 10, true, 5)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 10, true, 5)
                    .enchantedItemEntry(Items.IRON_HELMET, 10, true, 5)
                    .enchantedItemEntry(Items.DIAMOND_SWORD, 20, true, 1)
                    .enchantedItemEntry(Items.DIAMOND_AXE, 20, true, 1)
                    .enchantedItemEntry(Items.DIAMOND_PICKAXE, 20, true, 1)
                    .enchantedItemEntry(Items.DIAMOND_SHOVEL, 20, true, 1)
                    .enchantedItemEntry(Items.DIAMOND_HELMET, 20, true, 1)
                    .enchantedItemEntry(Items.BOOK, 20, true, 5)
            );
        generator.lootTable("graveyard/grave")
            .pool(pool ->
                pool.uniformRolls(4, 7)
                    .itemEntry(Items.BONE, 1, 5, 20)
                    .itemEntry(Items.ROTTEN_FLESH, 1, 5, 20)
                    .itemEntry(Items.GOLD_NUGGET, 5, 10, 5)
                    .itemEntry(Items.NAME_TAG, 5, 10, 1)
            );
        generator.lootTable("graveyard/trapped_grave")
            .pool(pool ->
                pool.uniformRolls(4, 8)
                    .itemEntry(Items.GOLD_NUGGET, 1, 6, 5)
                    .itemEntry(Items.GOLD_INGOT, 2, 5, 5)
                    .itemEntry(Items.EMERALD, 1, 5, 5)
                    .itemEntry(Items.DIAMOND, 1, 4, 5)
                    .itemEntry(Items.ROTTEN_FLESH, 1, 7, 15)
            );
    }
}
