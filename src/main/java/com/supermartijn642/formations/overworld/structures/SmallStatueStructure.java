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
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class SmallStatueStructure extends StructureConfigurator {

    public SmallStatueStructure(){
        super("small_statue");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_FOREST.location(), BiomeTags.IS_TAIGA.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.DESERT, Biomes.PLAINS, Biomes.SNOWY_PLAINS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("small_statues").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("small_statues")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()), "small_statue1", "small_statue2", "small_statue3", "small_statue4");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("small_statue")
            .pool(pool ->
                pool.uniformRolls(5, 8)
                    .itemEntry(Items.GOLD_INGOT, 1, 5, 10)
                    .itemEntry(Items.GOLD_NUGGET, 3, 8, 20)
                    .itemEntry(Items.IRON_NUGGET, 3, 12, 5)
                    .itemEntry(Items.EMERALD, 1, 5, 3)
                    .itemEntry(Items.GOLDEN_APPLE, 1, 1)
                    .itemEntry(Items.COBWEB, 1, 10)
            );
    }
}
