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
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class StoneTowerStructure extends StructureConfigurator {

    public StoneTowerStructure(){
        super("stone_tower");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_MOUNTAIN.location(), BiomeTags.IS_FOREST.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.PLAINS, Biomes.SNOWY_PLAINS, Biomes.DESERT)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("stone_towers").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("stone_towers")
            .entry("stone_tower1", entry -> entry.groundLevel(2).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(0.1f, 0, 0), new BedColorProcessor(), new PlantGrowthProcessor(0.3f, 1), new BrewingStandProcessor(0.5f, 8), new ChiseledBookshelfProcessor(0.3f)))
            .entry("stone_tower1", entry -> entry.groundLevel(2).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(), new BedColorProcessor(), new PlantGrowthProcessor(0.3f, 1), new BrewingStandProcessor(0.5f, 8), new ChiseledBookshelfProcessor(0.3f)))
            .entry("stone_tower2", entry -> entry.groundLevel(9).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(0.1f, 0, 0), new BedColorProcessor(), new PlantGrowthProcessor(0.3f, 1), new BrewingStandProcessor(0.5f, 8), new ChiseledBookshelfProcessor(0.3f)))
            .entry("stone_tower2", entry -> entry.groundLevel(9).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(), new BedColorProcessor(), new PlantGrowthProcessor(0.3f, 1), new BrewingStandProcessor(0.5f, 8), new ChiseledBookshelfProcessor(0.3f)));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("stone_tower/bedroom")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 8)
                    .itemEntry(Items.COOKIE, 1, 4, 10)
                    .itemEntry(Items.BREAD, 2, 4, 10)
                    .itemEntry(Items.GOLDEN_CARROT, 3, 5, 3)
                    .itemEntry(Items.AMETHYST_SHARD, 1, 10, 1)
                    .itemEntry(Items.BAMBOO, 2, 4, 5)
                    .itemEntry(Items.MANGROVE_PROPAGULE, 1, 3, 5)
                    .itemEntry(Items.CHERRY_SAPLING, 1, 3, 5)
                    .itemEntry(Items.CRIMSON_FUNGUS, 1, 3, 1)
                    .itemEntry(Items.WARPED_FUNGUS, 1, 3, 1)
                    .itemEntry(Items.BROWN_MUSHROOM, 1, 3, 5)
                    .itemEntry(Items.RED_MUSHROOM, 1, 3, 5)
                    .itemEntry(Items.SCUTE, 1, 3, 1)
                    .itemEntry(Items.MOSS_BLOCK, 1, 3, 1)
                    .itemEntry(Items.POPPY, 1, 3, 5)
                    .itemEntry(Items.DANDELION, 1, 3, 5)
                    .itemEntry(Items.BLUE_ORCHID, 1, 3, 5)
                    .itemEntry(Items.WHITE_TULIP, 1, 3, 5)
            )
            .pool(pool ->
                pool.uniformRolls(1, 2)
                    .itemEntry(Items.SPYGLASS)
                    .itemEntry(Items.AXOLOTL_BUCKET)
                    .itemEntry(Items.FLINT_AND_STEEL)
                    .itemEntry(Items.NAME_TAG)
                    .itemEntry(Items.COMPASS)
                    .itemEntry(Items.FISHING_ROD)
                    .itemEntry(Items.BRUSH)
                    .itemEntry(Items.CLOCK)
                    .itemEntry(Items.MAP)
                    .itemEntry(Items.MINECART)
                    .itemEntry(Items.MUSIC_DISC_BLOCKS)
            );
        generator.lootTable("stone_tower/smithing")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 6)
                    .itemEntry(Items.IRON_NUGGET, 3, 6, 10)
                    .itemEntry(Items.CHAIN, 1, 5, 5)
                    .itemEntry(Items.COAL, 1, 5, 5)
                    .itemEntry(Items.LANTERN)
            )
            .pool(pool ->
                pool.uniformRolls(0, 2)
                    .enchantedItemEntry(Items.CHAINMAIL_HELMET, 10, false, 12)
                    .enchantedItemEntry(Items.CHAINMAIL_CHESTPLATE, 10, false, 12)
                    .enchantedItemEntry(Items.CHAINMAIL_LEGGINGS, 10, false, 12)
                    .enchantedItemEntry(Items.CHAINMAIL_BOOTS, 10, false, 12)
                    .enchantedItemEntry(Items.IRON_HELMET, 10, false, 5)
                    .enchantedItemEntry(Items.IRON_CHESTPLATE, 10, false, 5)
                    .enchantedItemEntry(Items.IRON_LEGGINGS, 10, false, 5)
                    .enchantedItemEntry(Items.IRON_BOOTS, 10, false, 5)
                    .enchantedItemEntry(Items.IRON_SWORD, 10, false, 5)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 10, false, 5)
                    .enchantedItemEntry(Items.IRON_AXE, 10, false, 5)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 10, false, 5)
            );
        generator.lootTable("stone_tower/basement")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(1, 3)
                    .itemEntry(Items.COBWEB, 1, 25)
                    .itemEntry(Items.COAL, 1, 7, 5)
                    .itemEntry(Items.RAW_GOLD, 1, 6, 5)
                    .itemEntry(Items.RAW_IRON, 1, 6, 5)
                    .itemEntry(Items.EMERALD, 1, 4, 2)
                    .itemEntry(Items.LAPIS_LAZULI, 1, 12, 4)
                    .itemEntry(Items.DIAMOND, 1, 4, 2)
                    .itemEntry(Items.NAME_TAG)
                    .enchantedItemEntry(Items.BOOK, 30, true, 1)
                    .enchantedItemEntry(Items.IRON_HELMET, 30, true, 1)
                    .itemEntry(Items.MUSIC_DISC_FAR)
            );
    }
}
