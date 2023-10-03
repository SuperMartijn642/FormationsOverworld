package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 14/09/2023 by SuperMartijn642
 */
public class RaftStructure extends StructureConfigurator {

    public RaftStructure(){
        super("raft");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_OCEAN.location())
            .set(StructureSets.RAFTS)
            .terrainAdjustment(TerrainAdjustment.NONE)
            .simpleType(properties -> properties.templatePool("rafts").placement(StructurePlacement.ON_WATER));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("rafts")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()), "raft1", "raft2", "raft3");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("raft")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 10)
                    .lootTableEntry("minecraft", "gameplay/fishing/fish", 10)
                    .lootTableEntry("minecraft", "gameplay/fishing/junk", 5)
                    .lootTableEntry("minecraft", "gameplay/fishing/treasure", 3)
            );
    }
}
