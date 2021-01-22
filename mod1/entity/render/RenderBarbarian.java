package alex.mod1.entity.render;

import alex.mod1.entity.EntityBarbarian;
import alex.mod1.entity.model.ModelBarbarian;
import alex.mod1.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBarbarian extends RenderLiving<EntityBarbarian>
{
    
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/barbarian.png");

    public RenderBarbarian(RenderManager manager)
    {
        super(manager, new ModelBarbarian(), 0.5f);       
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityBarbarian entity)
    {
        
        return TEXTURES;
    }
    
    @Override
    protected void applyRotations(EntityBarbarian entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
