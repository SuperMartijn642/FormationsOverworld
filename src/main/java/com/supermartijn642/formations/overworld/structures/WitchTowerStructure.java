package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.*;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class WitchTowerStructure extends StructureConfigurator {

    public WitchTowerStructure(){
        super("witch_tower");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_JUNGLE.location(), BiomeTags.IS_TAIGA.location())
            .set(StructureSets.RARE)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("witch_towers").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("witch_towers")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(0.1f, 0, 0), new PlantGrowthProcessor(0.1f, 1), new BedColorProcessor(), new BrewingStandProcessor(0.5f, 5), new ChiseledBookshelfProcessor(0.35f)), "witch_tower1", "witch_tower2")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(), new PlantGrowthProcessor(0.5f, 1), new BedColorProcessor(), new BrewingStandProcessor(0.5f, 5), new ChiseledBookshelfProcessor(0.35f)), "witch_tower1", "witch_tower2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("witch_tower/arrow_trap")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(3, 8)
                    .itemEntry(Items.ARROW, 1, 10, 1)
            );
        generator.lootTable("witch_tower/potions")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 7)
                    .itemEntry(Items.POTION, 1, 5)
                    .itemEntry(Items.GLASS_BOTTLE, 1, 4, 20)
                    .itemEntry(Items.GLOWSTONE_DUST, 3, 5, 3)
                    .itemEntry(Items.REDSTONE, 3, 6, 3)
                    .itemEntry(Items.GUNPOWDER, 2, 5, 1)
            )
            .pool(pool ->
                pool.uniformRolls(1, 3)
                    .itemEntry(Items.FERMENTED_SPIDER_EYE)
                    .itemEntry(Items.GHAST_TEAR)
                    .itemEntry(Items.RABBIT_FOOT)
                    .itemEntry(Items.MAGMA_CREAM)
                    .itemEntry(Items.PUFFERFISH)
                    .itemEntry(Items.GLISTERING_MELON_SLICE)
                    .itemEntry(Items.PHANTOM_MEMBRANE)
            );
        generator.lootTable("witch_tower/botany")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(6, 10)
                    .itemEntry(Items.MOSS_BLOCK, 1, 4, 2)
                    .itemEntry(Items.BAMBOO, 3, 6, 5)
                    .itemEntry(Items.SUGAR_CANE, 3, 6, 5)
                    .itemEntry(Items.DANDELION, 1, 3, 5)
                    .itemEntry(Items.POPPY, 1, 3, 5)
                    .itemEntry(Items.BLUE_ORCHID, 1, 3, 5)
                    .itemEntry(Items.ALLIUM, 1, 3, 5)
                    .itemEntry(Items.AZURE_BLUET, 1, 3, 5)
                    .itemEntry(Items.RED_TULIP, 1, 3, 5)
                    .itemEntry(Items.ORANGE_TULIP, 1, 3, 5)
                    .itemEntry(Items.WHITE_TULIP, 1, 3, 5)
                    .itemEntry(Items.PINK_TULIP, 1, 3, 5)
                    .itemEntry(Items.OXEYE_DAISY, 1, 3, 5)
                    .itemEntry(Items.CORNFLOWER, 1, 3, 5)
                    .itemEntry(Items.LILY_OF_THE_VALLEY, 1, 3, 5)
                    .itemEntry(Items.LILY_PAD, 1, 3, 2)
                    .itemEntry(Items.GLOW_BERRIES, 1, 3, 2)
            )
            .pool(pool ->
                pool.uniformRolls(2, 4)
                    .itemEntry(Items.CHERRY_SAPLING)
                    .itemEntry(Items.SPRUCE_SAPLING)
                    .itemEntry(Items.ACACIA_SAPLING)
                    .itemEntry(Items.OAK_SAPLING)
                    .itemEntry(Items.BIRCH_SAPLING)
                    .itemEntry(Items.JUNGLE_SAPLING)
                    .itemEntry(Items.DARK_OAK_SAPLING)
                    .itemEntry(Items.MANGROVE_PROPAGULE)
                    .itemEntry(Items.CRIMSON_FUNGUS, 1, 3, 1)
                    .itemEntry(Items.WARPED_FUNGUS, 1, 3, 1)
                    .itemEntry(Items.CACTUS, 1, 4, 1)
                    .itemEntry(Items.BROWN_MUSHROOM, 1, 3, 1)
                    .itemEntry(Items.RED_MUSHROOM, 1, 3, 1)
            );
        generator.lootTable("witch_tower/smithing")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 7)
                    .itemEntry(Items.IRON_NUGGET, 2, 5, 10)
                    .itemEntry(Items.CHAIN, 1, 4, 5)
                    .itemEntry(Items.IRON_INGOT, 1, 5, 1)
                    .itemEntry(Items.GOLD_NUGGET, 1, 5, 1)
                    .itemEntry(Items.RAW_IRON, 1, 5, 1)
                    .itemEntry(Items.RAW_GOLD, 1, 5, 1)
            )
            .pool(pool ->
                pool.uniformRolls(1, 2)
                    .itemEntry(Items.SHEARS)
                    .itemEntry(Items.BUCKET)
                    .itemEntry(Items.LAVA_BUCKET)
                    .itemEntry(Items.FLINT_AND_STEEL)
                    .itemEntry(Items.FIRE_CHARGE)
            )
            .pool(pool ->
                pool.uniformRolls(0, 2)
                    .enchantedItemEntry(Items.IRON_SWORD, 20, 20)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 20, 20)
                    .enchantedItemEntry(Items.IRON_AXE, 20, 20)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 20, 20)
                    .enchantedItemEntry(Items.IRON_HOE, 20, 15)
                    .enchantedItemEntry(Items.IRON_HELMET, 20, 20)
                    .enchantedItemEntry(Items.IRON_CHESTPLATE, 20, 20)
                    .enchantedItemEntry(Items.IRON_LEGGINGS, 20, 20)
                    .enchantedItemEntry(Items.IRON_BOOTS, 20, 20)
                    .enchantedItemEntry(Items.DIAMOND_SWORD, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_PICKAXE, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_AXE, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_SHOVEL, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_HOE, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_HELMET, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_CHESTPLATE, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_LEGGINGS, 25, 1)
                    .enchantedItemEntry(Items.DIAMOND_BOOTS, 25, 1)
            );
    }
}
