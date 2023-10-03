package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BedColorProcessor;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class CampsiteStructure extends StructureConfigurator {

    public CampsiteStructure(){
        super("campsite");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_SAVANNA.location())
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("campsites").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("campsites")
            .entry("campsite1", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new BedColorProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("campsite")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 6)
                    .itemEntry(Items.COOKED_BEEF, 1, 4, 5)
                    .itemEntry(Items.COOKED_CHICKEN, 1, 4, 5)
                    .itemEntry(Items.STICK, 1, 8, 5)
                    .itemEntry(Items.LEATHER, 1, 6, 2)
                    .itemEntry(Items.FEATHER, 1, 6, 5)
                    .itemEntry(Items.SWEET_BERRIES, 1, 5, 2)
                    .itemEntry(Items.EGG, 1, 4, 2)
                    .itemEntry(Items.TORCH, 2, 6, 5)
            )
            .pool(pool ->
                pool.uniformRolls(0, 2)
                    .itemEntry(Items.COMPASS)
                    .itemEntry(Items.SPYGLASS)
                    .itemEntry(Items.BRUSH)
                    .itemEntry(Items.NAME_TAG)
                    .itemEntry(Items.MAP)
                    .itemEntry(Items.SADDLE)
                    .itemEntry(Items.GOAT_HORN)
            );
    }
}
