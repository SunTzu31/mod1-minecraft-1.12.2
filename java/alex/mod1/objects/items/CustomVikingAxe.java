package alex.mod1.objects.items;

import alex.mod1.Main;
import alex.mod1.init.ItemInit;
import alex.mod1.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

public class CustomVikingAxe extends ItemSword implements IHasModel
{

	public CustomVikingAxe(String name, ToolMaterial material) {
		
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
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
		
		
		ResourceLocation soundNameIn = new ResourceLocation("mod1_bruh");
		if(!worldIn.isRemote) 
		{
			playerIn.sendMessage(new TextComponentTranslation("message.item.special.right.click"));
			playerIn.playSound(new SoundEvent(soundNameIn), 5.0f, 0);
			return EnumActionResult.SUCCESS;
		
		}
		else 
		{
			return EnumActionResult.PASS;
		}
		
		
		
		
		
		
	}
	

}
