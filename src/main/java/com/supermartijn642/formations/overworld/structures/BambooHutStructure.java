package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.PlantGrowthProcessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class BambooHutStructure extends StructureConfigurator {

    public BambooHutStructure(){
        super("bamboo_hut");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.BAMBOO_JUNGLE)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("bamboo_huts").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("bamboo_huts")
            .entry("bamboo_hut", entry -> entry.groundLevel(1).processors(new PlantGrowthProcessor(0.3f, 1)));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("bamboo_hut")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(3, 5)
                    .itemEntry(Items.MELON_SEEDS, 1, 3, 5)
                    .itemEntry(Items.BAMBOO, 6, 16, 10)
                    .itemEntry(Items.MELON_SLICE, 6, 12, 10)
                    .itemEntry(Items.GLISTERING_MELON_SLICE, 1, 5, 1)
                    .enchantedItemEntry(Items.FISHING_ROD, 10, false, 1)
            );
    }
}
