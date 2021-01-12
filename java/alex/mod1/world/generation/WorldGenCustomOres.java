package alex.mod1.world.generation;

import java.util.Random;

import alex.mod1.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
    private WorldGenerator mod1_ore, mod1_blocktest, dirt;

    public WorldGenCustomOres()
    {
        mod1_ore = new WorldGenMinable(BlockInit.MOD1_ORE.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.SAND));
        mod1_blocktest = new WorldGenMinable(BlockInit.MOD1_BLOCKTEST.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.SAND));
        dirt = new WorldGenMinable(Blocks.DIRT.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.END_STONE));

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimension())
        {
            case -1:                                  // nether

                break;
            case 0:										// overworld
                runGenerator(mod1_blocktest, world, random, chunkX, chunkZ, 150, 2, 255);
                runGenerator(mod1_ore, world, random, chunkX, chunkZ, 150, 2, 255);
                break;
            case 1:																				// ender
                runGenerator(dirt, world, random, chunkX, chunkZ, 150, 2, 255);
                break;

        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
    {
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
            throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;

        for(int i = 0; i < chance; i++)
        {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            gen.generate(world, rand, new BlockPos(x, y, z));

        }

    }

}
