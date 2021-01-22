package alex.mod1.objects.blocks;

import alex.mod1.Main;
import alex.mod1.init.BlockInit;
import alex.mod1.init.ItemInit;
import alex.mod1.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import scala.xml.persistent.SetStorage;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase (String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setHardness(8.0F);
		
		
		//setHarvestLevel();
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
		
		
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
