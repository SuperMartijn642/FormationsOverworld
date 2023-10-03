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
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class LogSpikesStructure extends StructureConfigurator {

    public LogSpikesStructure(){
        super("log_spikes");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_FOREST.location())
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("log_spikes").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("log_spikes")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()), "log_spikes1", "log_spikes2", "log_spikes3", "log_spikes4");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("log_spikes")
            .pool(pool ->
                pool.uniformRolls(6, 8)
                    .itemEntry(Items.STRING, 1, 4, 20)
                    .itemEntry(Items.ARROW, 1, 4, 20)
                    .itemEntry(Items.BONE, 1, 4, 20)
                    .itemEntry(Items.BONE_MEAL, 1, 3, 20)
                    .itemEntry(Items.ROTTEN_FLESH, 1, 4, 15)
            )
            .pool(pool ->
                pool.uniformRolls(0, 1)
                    .enchantedItemEntry(Items.WOODEN_SWORD, 15, false, 1)
                    .enchantedItemEntry(Items.STONE_SWORD, 15, false, 2)
                    .enchantedItemEntry(Items.IRON_SWORD, 15, false, 1)
                    .enchantedItemEntry(Items.BOW, 15, false, 2)
                    .itemEntry(Items.SHIELD)
                    .itemEntry(Items.NAME_TAG)
                    .itemEntry(Items.LEATHER_HORSE_ARMOR)
                    .itemEntry(Items.IRON_HORSE_ARMOR)
                    .itemEntry(Items.GOLDEN_HORSE_ARMOR)
            );
    }
}
