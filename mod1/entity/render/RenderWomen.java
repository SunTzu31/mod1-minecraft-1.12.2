package alex.mod1.entity.render;

import alex.mod1.entity.EntityWomen;
import alex.mod1.util.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWomen extends RenderLiving<EntityWomen>
{
    private static final ResourceLocation DEFAULT_RES_LOC = new ResourceLocation(Reference.MODID + ":textures/entity/women.png");

    public RenderWomen(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBiped(), 0.5f); // , , taille ombre
        bindTexture(DEFAULT_RES_LOC);

    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityWomen entity)
    {
        return DEFAULT_RES_LOC;
    }

}