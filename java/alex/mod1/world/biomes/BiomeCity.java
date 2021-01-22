package alex.mod1.world.biomes;

import alex.mod1.init.BlockInit;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeCity extends Biome
{
   

    public BiomeCity()
    {
        
        super(new BiomeProperties("city_biome").setBaseHeight(0.125F).setHeightVariation(0.0F).setTemperature(0.8F).setRainfall(0F));
        
        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();
        
        
        
        this.decorator.coalGen = new WorldGenMinable(BlockInit.MOD1_ORE.getDefaultState(), 10);
    
        this.decorator.treesPerChunk = 0;
        
        this.spawnableMonsterList.clear();
    }
    
    

}
