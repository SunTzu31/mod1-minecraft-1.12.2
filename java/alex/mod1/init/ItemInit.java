package alex.mod1.init;

import java.util.ArrayList;
import java.util.List;

import alex.mod1.objects.items.ItemBase;
import alex.mod1.objects.items.ItemSpecial;
import alex.mod1.objects.items.itemCustomFood;
import alex.mod1.objects.items.armor.ItemArmorMod;
import alex.mod1.objects.items.sexObjects.god;
import alex.mod1.objects.items.sexObjects.money;
import alex.mod1.objects.items.sexObjects.sperme;
import alex.mod1.objects.items.tools.ItemAxeMod;
import alex.mod1.objects.items.tools.ItemPickakeMod;
import alex.mod1.objects.items.tools.ItemShovelMod;
import alex.mod1.objects.items.tools.ItemSwordMod;
import alex.mod1.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	public static List<Item> ITEMS = new ArrayList<Item>();
	
	
	//Tools materials
	// name, harvestLevel, maxUses, efficiency, damage, enchantability
	public static final ToolMaterial MOD1_TOOL = EnumHelper.addToolMaterial("mod1_tool", 5, 2500, 25.0f, 2000.0f, 24);
	public static final ToolMaterial MOD1_VIKING_MATERIAL = EnumHelper.addToolMaterial("mod1_viking_material", 5, 500, 25.0f, 10.0f, 15);
	
	//Armor materials 
	// name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness
	public static final ArmorMaterial MOD1_ARMOR = EnumHelper.addArmorMaterial("mod1_armor" , Reference.MODID + ":mod1", 150,  new int[] {5, 12, 10, 4}, 24, SoundEvents.BLOCK_NOTE_GUITAR , 1.0f);
	
	
	public static final Item MOD1_INGOT = new ItemBase("mod1_ingot");
	
	
	//Tools
	
	public static final Item MOD1_PICKAXE = new ItemPickakeMod("mod1_pickaxe", MOD1_TOOL);
	public static final Item MOD1_SHOVEL = new ItemShovelMod("mod1_shovel", MOD1_TOOL);
	public static final Item MOD1_SWORD = new ItemSwordMod("mod1_sword", MOD1_TOOL);
	public static final Item MOD1_AXE = new ItemAxeMod("mod1_axe", MOD1_TOOL);
	
	//armor
	public static final Item MOD1_HELMET = new ItemArmorMod("mod1_helmet", MOD1_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item MOD1_CHESTPLATE = new ItemArmorMod("mod1_chestplate", MOD1_ARMOR, 1, EntityEquipmentSlot.CHEST);
	public static final Item MOD1_LEGINGS = new ItemArmorMod("mod1_legings", MOD1_ARMOR, 2, EntityEquipmentSlot.LEGS);
	public static final Item MOD1_BOOTS = new ItemArmorMod("mod1_boots", MOD1_ARMOR, 1, EntityEquipmentSlot.FEET);

	//specials
	public static final Item MOD1_STICK = new ItemSpecial("mod1_stick");
	
	//foods
	public static final Item MOD1_ALLAH_COUSCOUS = new itemCustomFood("mod1_allah_couscous", 14, true);
	
	//viking axe
	public static final Item MOD1_BERSERKER = new ItemSwordMod("mod1_berserker", MOD1_VIKING_MATERIAL);
	
	//sexual objects
	public static final Item MOD1_GOD = new god("mod1_god");
	public static final Item MOD1_SPERME = new sperme("mod1_sperme");
	public static final Item MOD1_MONEY = new money("mod1_money");
}


