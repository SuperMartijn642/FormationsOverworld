package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BedColorProcessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 20/07/2025 by SuperMartijn642
 */
public class IglooStructure extends StructureConfigurator {

    public IglooStructure(){
        super("igloo");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("igloos").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("igloos")
            .entry("igloo", entry -> entry.groundLevel(1).processors(new BedColorProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("igloo")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 9)
                    .itemEntry(Items.SNOWBALL, 1, 5, 20)
                    .itemEntry(Items.SNOW_BLOCK, 1, 3, 5)
                    .itemEntry(Items.WHITE_WOOL, 1, 3, 3)
                    .itemEntry(Items.PUMPKIN)
            )
            .pool(pool ->
                pool.uniformRolls(3, 4)
                    .itemEntry(Items.COD, 2, 6, 10)
                    .itemEntry(Items.SALMON, 2, 6, 10)
                    .itemEntry(Items.FISHING_ROD, 3)
                    .enchantedItemEntry(Items.FISHING_ROD, 3, 10, 1)
            );
    }
}
