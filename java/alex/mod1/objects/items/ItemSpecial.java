package alex.mod1.objects.items;

import alex.mod1.Main;
import alex.mod1.init.ItemInit;
import alex.mod1.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;




public class ItemSpecial extends Item implements IHasModel
{
		
		public ItemSpecial(String name) 
		{
			setUnlocalizedName(name);
			setRegistryName(name);
			setMaxDamage(25);
			setMaxStackSize(1);
			setCreativeTab(CreativeTabs.TOOLS);
			
			ItemInit.ITEMS.add(this);
		}
		
		@Override
		public void registerModels() 
		{
			Main.proxy.registerItemRenderer(this, 0);
			
		}
		
		@Override
		public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
			
			if(!worldIn.isRemote) 
			{
				player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE,1 ,0)); //time in tick, level 
				player.sendMessage(new TextComponentTranslation("message.item.special.right.click"));
				worldIn.playSound(player, player.getPosition(), SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
			
				return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
			}
			else 
			{
				return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
			}
			
			
			
		
		}
		
		//@Override
		public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,EnumFacing facing, float hitX, float hitY, float hitZ) 
		{
			ItemStack stack = player.getHeldItem(hand);
			if(!worldIn.isRemote) 
			{
				player.addItemStackToInventory(new ItemStack(ItemInit.MOD1_CHESTPLATE, 1));
				stack.damageItem(1, player);
				return EnumActionResult.SUCCESS;
			
			}
			else 
			{
				return EnumActionResult.PASS;
			}
			
		}
			
			
		
			
			
			
			
			
		
		
		
	

	
	
	
	
	
	
	
	
	
	
	
}
