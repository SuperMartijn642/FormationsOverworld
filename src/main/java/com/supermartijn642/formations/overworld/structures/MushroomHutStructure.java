package com.supermartijn642.formations.overworld.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.overworld.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 20/07/2025 by SuperMartijn642
 */
public class MushroomHutStructure extends StructureConfigurator {

    public MushroomHutStructure(){
        super("mushroom_hut");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.MUSHROOM_FIELDS)
            .set(StructureSets.UNCOMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("mushroom_huts").placement(StructurePlacement.SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("mushroom_huts")
            .commonEntries(entry -> entry.groundLevel(1), "mushroom_hut1", "mushroom_hut2", "mushroom_hut3", "mushroom_hut4", "mushroom_hut5", "mushroom_hut6", "mushroom_hut7", "mushroom_hut8", "mushroom_hut9");
    }
}
