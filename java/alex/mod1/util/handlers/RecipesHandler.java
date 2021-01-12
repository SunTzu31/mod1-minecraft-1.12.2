package alex.mod1.util.handlers;

import alex.mod1.init.BlockInit;
import alex.mod1.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesHandler
{
    public static void registerRecipes()
    {
        // Block or item input, output, xp
        GameRegistry.addSmelting(Blocks.WOOL, new ItemStack(Items.DIAMOND, 5), 5.f);
        GameRegistry.addSmelting(BlockInit.MOD1_BLOCKTEST, new ItemStack(ItemInit.MOD1_INGOT, 9), 5.f);
        GameRegistry.addSmelting(ItemInit.MOD1_INGOT, new ItemStack(ItemInit.MOD1_SWORD, 1), 5.f);

    }

}
