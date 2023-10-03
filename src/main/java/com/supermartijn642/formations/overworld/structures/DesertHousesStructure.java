package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BedColorProcessor;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import com.supermartijn642.formations.structure.processors.ChiseledBookshelfProcessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class DesertHousesStructure extends StructureConfigurator {

    public DesertHousesStructure(){
        super("desert_houses");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.DESERT)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("desert_houses").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("desert_houses")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new BedColorProcessor(), new ChiseledBookshelfProcessor(0.2f)), "desert_houses1", "desert_houses2", "desert_houses3");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("desert_houses")
            .pool(pool ->
                pool.uniformRolls(5, 8)
                    .itemEntry(Items.SAND, 1, 8, 5)
                    .itemEntry(Items.WHEAT, 1, 8, 5)
                    .itemEntry(Items.STICK, 1, 10, 4)
                    .itemEntry(Items.BREAD, 1, 5, 3)
                    .itemEntry(Items.GLASS_BOTTLE, 1, 8, 2)
                    .itemEntry(Items.LEATHER_HELMET, 1, 2)
                    .itemEntry(Items.SADDLE, 1, 1)
                    .itemEntry(Items.BRUSH, 1, 1)
                    .itemEntry(Items.MUSIC_DISC_STRAD, 1, 1)
            );
    }
}
