package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import com.supermartijn642.formations.structure.processors.FormationsBlockAgeProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class SmallHouseStructure extends StructureConfigurator {

    public SmallHouseStructure(){
        super("small_house");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_JUNGLE.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("small_houses").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("small_houses")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(0.1f, 0, 0)), "small_house/house1")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor()), "small_house/house2", "small_house/house3", "small_house/house4");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("small_house/intact")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(2, 3)
                    .itemEntry(Items.BOOK, 2, 5, 15)
                    .itemEntry(Items.COOKED_SALMON, 2, 8, 20)
                    .itemEntry(Items.GOLDEN_CARROT, 3, 8, 1)
                    .itemEntry(Items.COOKIE, 3, 8, 15)
                    .itemEntry(Items.APPLE, 3, 8, 20)
            )
            .pool(pool ->
                pool.uniformRolls(0, 1)
                    .itemEntry(Items.CAKE)
                    .itemEntry(Items.PUMPKIN_PIE)
                    .itemEntry(Items.PUMPKIN_PIE)
            )
            .pool(pool ->
                pool.uniformRolls(1, 2)
                    .enchantedItemEntry(Items.BOOK, 20, true, 5)
                    .enchantedItemEntry(Items.WOODEN_SWORD, 20, true, 1)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 20, true, 1)
                    .enchantedItemEntry(Items.IRON_AXE, 20, true, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_HELMET, 20, true, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_CHESTPLATE, 20, true, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_LEGGINGS, 20, true, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_BOOTS, 20, true, 1)
            );
        generator.lootTable("small_house/degraded")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 5)
                    .itemEntry(Items.COBWEB, 6, 16, 10)
                    .itemEntry(Items.BOOK, 2, 5, 15)
                    .itemEntry(Items.GOLDEN_CARROT, 3, 8, 1)
            )
            .pool(pool ->
                pool.uniformRolls(0, 1)
                    .enchantedItemEntry(Items.BOOK, 20, true, 5)
                    .enchantedItemEntry(Items.WOODEN_SWORD, 20, true, 2)
                    .enchantedItemEntry(Items.IRON_SWORD, 20, true, 2)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 20, true, 2)
                    .enchantedItemEntry(Items.IRON_AXE, 20, true, 2)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 20, true, 2)
                    .enchantedItemEntry(Items.CHAINMAIL_HELMET, 20, true, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_CHESTPLATE, 20, true, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_LEGGINGS, 20, true, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_BOOTS, 20, true, 1)
                    .enchantedItemEntry(Items.IRON_HELMET, 20, true, 1)
                    .enchantedItemEntry(Items.IRON_CHESTPLATE, 20, true, 1)
                    .enchantedItemEntry(Items.IRON_LEGGINGS, 20, true, 1)
                    .enchantedItemEntry(Items.IRON_BOOTS, 20, true, 1)
            );
        generator.lootTable("small_house/fireplace")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 7)
                    .itemEntry(Items.COAL, 4, 4, 20)
                    .itemEntry(Items.COAL_BLOCK, 1, 5)
                    .itemEntry(Items.GUNPOWDER, 2, 4, 10)
                    .itemEntry(Items.FIRE_CHARGE, 1, 3, 10)
                    .itemEntry(Items.BLAZE_POWDER, 2, 3, 1)
            );
    }
}
