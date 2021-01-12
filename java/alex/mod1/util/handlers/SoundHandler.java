package alex.mod1.util.handlers;

import alex.mod1.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler 
{
	public static SoundEvent MOD1_SPLASH;
	public static SoundEvent MOD1_BRUH;
	
	public static void registerSounds() 
	{
		MOD1_SPLASH = registerSound("mod1_splash");
		MOD1_BRUH = registerSound("mod1_bruh");
	}
	
	private static SoundEvent registerSound(String name) 
	{
		ResourceLocation location = new ResourceLocation("mod1", name);
		SoundEvent soundEvent = new SoundEvent(location);
		soundEvent.setRegistryName(location);
		ForgeRegistries.SOUND_EVENTS.register(soundEvent);
		return soundEvent;
	
	 
	
	
	}
	
	
}
	

