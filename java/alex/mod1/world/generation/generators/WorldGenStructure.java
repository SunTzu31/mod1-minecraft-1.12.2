package alex.mod1.world.generation.generators;

import java.util.Random;

import alex.mod1.util.Reference;
import alex.mod1.util.interfaces.IStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenStructure extends WorldGenerator implements IStructure
{

    public String structureName;
    
    public WorldGenStructure(String name)
    {
        this.structureName = name;
        System.out.println("mon nom est : " + this.structureName);
    }
    
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        this.generateStructure(worldIn, position);
        System.out.println("je suis " + this.structureName +" et commence à me générer");
        return true;
    }
    
   
    
    
    
    public void generateStructure(World world, BlockPos pos) 
    {
        MinecraftServer mcServer = world.getMinecraftServer();
        TemplateManager manager = worldServer.getStructureTemplateManager();
        ResourceLocation location = new ResourceLocation(Reference.MODID, structureName);
        Template template = manager.get(mcServer, location);
        
        if (template != null) 
        {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
            template.addBlocksToWorldChunk(world, pos, settings);
        }
    }

}
