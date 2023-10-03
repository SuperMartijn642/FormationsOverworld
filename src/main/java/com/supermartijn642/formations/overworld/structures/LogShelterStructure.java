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
public class LogShelterStructure extends StructureConfigurator {

    public LogShelterStructure(){
        super("log_shelter");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_SAVANNA.location())
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("log_shelters").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("log_shelters")
            .entry("log_shelter", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("log_shelter")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(6, 8)
                    .itemEntry(Items.BREAD, 1, 3, 5)
                    .itemEntry(Items.TORCH, 1, 3, 5)
                    .itemEntry(Items.TROPICAL_FISH)
            )
            .pool(pool ->
                pool.uniformRolls(1, 2)
                    .itemEntry(Items.LEATHER_HELMET)
                    .itemEntry(Items.LEATHER_CHESTPLATE)
                    .itemEntry(Items.LEATHER_LEGGINGS)
                    .itemEntry(Items.LEATHER_BOOTS)
                    .itemEntry(Items.IRON_SWORD)
                    .itemEntry(Items.SHIELD)
            );
    }
}
