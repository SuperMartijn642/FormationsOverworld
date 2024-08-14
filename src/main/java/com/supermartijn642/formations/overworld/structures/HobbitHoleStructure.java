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
public class HobbitHoleStructure extends StructureConfigurator {

    public HobbitHoleStructure(){
        super("hobbit_hole");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.DESERT, Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("hobbit_holes").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("hobbit_holes")
            .commonEntries(entry -> entry.groundLevel(6).processors(new BiomeReplacementProcessor(), new BedColorProcessor(), new PlantGrowthProcessor(0, 1), new ChiseledBookshelfProcessor(0.4f), new BrewingStandProcessor(0.2f, 3)), "hobbit_hole1", "hobbit_hole2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("hobbit_hole/common")
            .pool(pool ->
                pool.uniformRolls(5, 8)
                    .itemEntry(Items.STICK, 5, 16, 10)
                    .itemEntry(Items.GLASS_BOTTLE, 2, 7, 10)
                    .itemEntry(Items.POPPY, 1, 5, 10)
                    .itemEntry(Items.DANDELION, 1, 5, 10)
                    .itemEntry(Items.BLUE_ORCHID, 1, 5, 10)
                    .itemEntry(Items.OXEYE_DAISY, 1, 5, 10)
                    .itemEntry(Items.RED_MUSHROOM, 1, 6, 3)
                    .itemEntry(Items.BROWN_MUSHROOM, 1, 6, 3)
                    .itemEntry(Items.GHAST_TEAR, 1, 3, 1)
                    .itemEntry(Items.EXPERIENCE_BOTTLE, 1, 5, 1)
            )
            .pool(pool ->
                pool.uniformRolls(1, 3)
                    .itemEntry(Items.STONE_SWORD)
                    .itemEntry(Items.STONE_PICKAXE)
                    .itemEntry(Items.STONE_AXE)
                    .itemEntry(Items.STONE_SHOVEL)
                    .itemEntry(Items.LEATHER_HELMET)
                    .itemEntry(Items.LEATHER_CHESTPLATE)
                    .itemEntry(Items.LEATHER_LEGGINGS)
                    .itemEntry(Items.LEATHER_BOOTS)
                    .itemEntry(Items.IRON_HELMET)
                    .itemEntry(Items.IRON_CHESTPLATE)
                    .itemEntry(Items.IRON_LEGGINGS)
                    .itemEntry(Items.IRON_BOOTS)
                    .itemEntry(Items.SHEARS)
                    .itemEntry(Items.SHIELD)
                    .itemEntry(Items.LEAD)
                    .itemEntry(Items.CLOCK)
                    .enchantedItemEntry(Items.BOOK, 30, 1)
            );
        generator.lootTable("hobbit_hole/food")
            .pool(pool ->
                pool.uniformRolls(4, 6)
                    .itemEntry(Items.CARROT, 2, 4, 5)
                    .itemEntry(Items.BAKED_POTATO, 2, 5, 5)
                    .itemEntry(Items.COOKED_SALMON, 2, 5, 5)
                    .itemEntry(Items.COOKED_COD, 2, 5, 5)
                    .itemEntry(Items.COOKED_BEEF, 2, 5, 5)
                    .itemEntry(Items.COOKIE, 2, 5, 5)
                    .itemEntry(Items.BREAD, 2, 5, 5)
                    .itemEntry(Items.GOLDEN_APPLE)
                    .itemEntry(Items.CAKE)
                    .itemEntry(Items.SUSPICIOUS_STEW)
                    .itemEntry(Items.PUMPKIN_PIE, 1, 2, 3)
            );
    }
}
