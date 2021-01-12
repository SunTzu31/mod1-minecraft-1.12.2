package alex.mod1.objects.items.sexObjects;

import alex.mod1.Main;
import alex.mod1.init.ItemInit;
import alex.mod1.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


public class sperme extends Item implements IHasModel
{
	public sperme(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		
		
		setCreativeTab(CreativeTabs.FOOD);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0);
		
	}
	
	
}
