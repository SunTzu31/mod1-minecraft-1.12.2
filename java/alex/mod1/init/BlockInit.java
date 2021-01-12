package alex.mod1.init;

import java.util.ArrayList;
import java.util.List;

import alex.mod1.objects.blocks.BlockBase;
import alex.mod1.objects.blocks.BlockOreMod;
import alex.mod1.objects.blocks.BlockSpecial;
import alex.mod1.objects.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;



public class BlockInit 
{
	public static List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block MOD1_BLOCKTEST = new BlockBase("mod1_blocktest", Material.TNT);
	public static final Block MOD1_DAESH_EXPLOSIVE = new BlockSpecial("mod1_daesh_explosive", Material.WOOD);
	
	//Ores
	public static final Block MOD1_ORE = new BlockOreMod("mod1_ore", Material.ROCK, SoundType.SAND);
	
	
	
	
} 



