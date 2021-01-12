package alex.mod1.objects.items.tools;

import alex.mod1.Main;
import alex.mod1.init.ItemInit;
import alex.mod1.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class ItemSwordMod extends ItemSword implements IHasModel
{
	public ItemSwordMod(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		setFull3D();
		
		ItemInit.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0);
	}
	
	
	
	
}
