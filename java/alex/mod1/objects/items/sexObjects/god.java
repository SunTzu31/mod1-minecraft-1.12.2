package alex.mod1.objects.items.sexObjects;

import alex.mod1.Main;
import alex.mod1.init.ItemInit;
import alex.mod1.util.handlers.SoundHandler;
import alex.mod1.util.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.audio.ISound.AttenuationType;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

import java.util.Random;

public class god extends Item implements IHasModel
{
    public god(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxDamage(25);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.MATERIALS);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        Random rand = new Random();
        int i = rand.nextInt(2);
        
        ItemStack stack = playerIn.getHeldItem(handIn);

        if(i == 1)
        {
            if(worldIn.isRemote)
            {
                playerIn.playSound(SoundHandler.MOD1_BRUH, 4.0f, 1.0f);
                playerIn.sendMessage(new TextComponentTranslation("message.dropfailed.sperme"));
            }
            else
            {
                stack.damageItem(1, playerIn);
                //playerIn.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20 * 60, 0));
            }

            return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
        }
        else
        {
            if(worldIn.isRemote)
            {
                playerIn.sendMessage(new TextComponentTranslation("message.drop.sperme"));
                playerIn.playSound(SoundHandler.MOD1_SPLASH, 4.0f, 1.0f);
            }
            else
            {
                playerIn.addItemStackToInventory(new ItemStack(ItemInit.MOD1_SPERME, 10));
                playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20 * 60, 1));
                stack.damageItem(1, playerIn);
            }

            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        }
    }
}
