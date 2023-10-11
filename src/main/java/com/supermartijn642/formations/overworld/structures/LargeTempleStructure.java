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
public class LargeTempleStructure extends StructureConfigurator {

    public LargeTempleStructure(){
        super("large_temple");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_JUNGLE.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.DESERT)
            .set(StructureSets.RARE)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("large_temples").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("large_temples")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor(0.3f, 0, 0)), "large_temple1", "large_temple2", "large_temple3", "large_temple4")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor()), "large_temple1", "large_temple2", "large_temple3", "large_temple4");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("large_temple/pillar_chest")
            .pool(pool ->
                pool.uniformRolls(5, 7)
                    .itemEntry(Items.REDSTONE, 3, 6, 5)
                    .itemEntry(Items.GOLD_INGOT, 2, 4, 3)
                    .itemEntry(Items.GOLD_NUGGET, 3, 5, 6)
                    .itemEntry(Items.BONE, 1, 5, 8)
                    .itemEntry(Items.EMERALD, 1, 5, 3)
            );
        generator.lootTable("large_temple/rich_chest")
            .pool(pool ->
                pool.uniformRolls(6, 8)
                    .itemEntry(Items.REDSTONE, 3, 6, 5)
                    .itemEntry(Items.GOLD_INGOT, 2, 4, 3)
                    .itemEntry(Items.GOLD_NUGGET, 3, 5, 6)
                    .itemEntry(Items.BONE, 1, 5, 8)
                    .itemEntry(Items.EMERALD, 1, 5, 3)
                    .itemEntry(Items.SUSPICIOUS_STEW)
            )
            .pool(pool ->
                pool.uniformRolls(0, 1)
                    .itemEntry(Items.ENCHANTED_GOLDEN_APPLE)
                    .enchantedItemEntry(Items.BOOK, 25, false, 1)
                    .enchantedItemEntry(Items.DIAMOND_SWORD, 25, false, 1)
                    .enchantedItemEntry(Items.TRIDENT, 15, false, 1)
            );
    }
}
