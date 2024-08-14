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
public class TowerRemnantStructure extends StructureConfigurator {

    public TowerRemnantStructure(){
        super("tower_remnant");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomeTags(BiomeTags.IS_TAIGA.location(), BiomeTags.IS_FOREST.location(), BiomeTags.IS_SAVANNA.location())
            .biomes(Biomes.PLAINS, Biomes.SNOWY_PLAINS, Biomes.DESERT)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("tower_remnants").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("tower_remnants")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new FormationsBlockAgeProcessor()), "remnants/tower_remnant1", "remnants/tower_remnant2", "remnants/tower_remnant3", "remnants/tower_remnant4");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("tower_remnant")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 5)
                    .itemEntry(Items.ARROW, 4, 10, 20)
                    .itemEntry(Items.BREAD, 1, 6, 10)
                    .itemEntry(Items.IRON_NUGGET, 4, 8, 3)
            )
            .pool(pool ->
                pool.uniformRolls(0, 1)
                    .enchantedItemEntry(Items.SHIELD, 10, 5)
                    .enchantedItemEntry(Items.BOW, 10, 5)
                    .enchantedItemEntry(Items.IRON_SWORD, 10, 5)
                    .enchantedItemEntry(Items.DIAMOND_SWORD, 15, 1)
            );
    }
}
