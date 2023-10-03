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
 * Created 04/09/2023 by SuperMartijn642
 */
public class FountainStructure extends StructureConfigurator {

    public FountainStructure(){
        super("fountain");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_JUNGLE.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.PLAINS, Biomes.SNOWY_PLAINS, Biomes.SUNFLOWER_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .piecedType(properties -> properties.maxDepth(2).startPool("fountain/fountains").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("fountain/fountains")
            .commonEntries(entry -> entry.groundLevel(2).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor()), "fountain/fountain_entry", "fountain/fountain1", "fountain/fountain2", "fountain/fountain3");
        generator.pool("fountain/chambers")
            .commonEntries(entry -> entry.processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor()), "fountain/chamber_lava_trap", "fountain/chamber_note_blocks", "fountain/chamber_tnt_trap", "fountain/chamber_weathered");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("fountain/rich_chest")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(3, 8)
                    .itemEntry(Items.DIAMOND, 1, 4, 1)
                    .itemEntry(Items.IRON_INGOT, 2, 8, 5)
                    .itemEntry(Items.GOLD_INGOT, 3, 15, 5)
                    .itemEntry(Items.EMERALD, 1, 4, 1)
                    .enchantedItemEntry(Items.BOOK, 3, true, 3)
                    .itemEntry(Items.WHEAT, 3, 20, 20)
                    .itemEntry(Items.BONE, 3, 20, 20)
                    .itemEntry(Items.STRING, 5, 15, 10)
            );
        generator.lootTable("fountain/lesser_chest")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(3, 5)
                    .itemEntry(Items.ROTTEN_FLESH, 3, 8, 20)
                    .itemEntry(Items.GOLD_NUGGET, 3, 9, 10)
                    .itemEntry(Items.BONE, 2, 8, 15)
            );
    }
}
