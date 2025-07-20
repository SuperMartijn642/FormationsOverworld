package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.FormationsBlockAgeProcessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 20/07/2025 by SuperMartijn642
 */
public class CobbleHoleStructure extends StructureConfigurator {

    public CobbleHoleStructure(){
        super("cobble_hole");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomes(Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("cobble_holes").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("cobble_holes")
            .commonEntries(entry -> entry.groundLevel(4).processors(new FormationsBlockAgeProcessor(0.6f, 0, 0)), "cobble_hole1", "cobble_hole2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("cobble_hole")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(1, 2)
                    .itemEntry(Items.IRON_NUGGET, 2, 5, 5)
                    .itemEntry(Items.GOLD_NUGGET, 2, 5, 5)
                    .enchantedItemEntry(Items.CHAINMAIL_HELMET, 5, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_CHESTPLATE, 5, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_LEGGINGS, 5, 1)
                    .enchantedItemEntry(Items.CHAINMAIL_BOOTS, 5, 1)
                    .enchantedItemEntry(Items.IRON_SWORD, 5, 1)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 5, 1)
            )
            .pool(pool ->
                pool.uniformRolls(2, 4)
                    .itemEntry(Items.ARROW, 2, 9, 5)
                    .itemEntry(Items.BONE, 1, 4, 2)
                    .itemEntry(Items.ROTTEN_FLESH, 2, 5, 2)
            );
    }
}
