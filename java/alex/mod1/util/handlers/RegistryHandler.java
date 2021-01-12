package alex.mod1.util.handlers;

import alex.mod1.init.BlockInit;
import alex.mod1.init.EntityInit;
import alex.mod1.init.ItemInit;
import alex.mod1.util.interfaces.IHasModel;
import alex.mod1.world.generation.WorldGenCustomOres;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent evnt)
    {
        for(Item item : ItemInit.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }

        for(Block block : BlockInit.BLOCKS)
        {
            if(block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }

    }

    public static void preInitRegistries()
    {
        EntityInit.registerEntities();
        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
        RenderHandler.registerEntityRenders();
    }

    public static void initRegistries()
    {
        RecipesHandler.registerRecipes();
        SoundHandler.registerSounds();
    }
}
