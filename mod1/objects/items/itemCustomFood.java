package alex.mod1.objects.items;

import alex.mod1.Main;
import alex.mod1.init.ItemInit;
import alex.mod1.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class itemCustomFood extends ItemFood implements IHasModel
{
	public itemCustomFood(String name, int amount, boolean isWolfFood) 
	{
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
		setAlwaysEdible(); //toujours mangeable même si barre de bouffe pleine
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		
		if(!worldIn.isRemote) {
			
			player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION,20*30 ,1 ));
			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION,2400, 1));
		}
		super.onFoodEaten(stack, worldIn, player);
	}
}
