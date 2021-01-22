package alex.mod1.util.handlers;

import alex.mod1.entity.EntityBarbarian;
import alex.mod1.entity.EntityWomen;
import alex.mod1.entity.render.RenderBarbarian;
import alex.mod1.entity.render.RenderWomen;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityWomen.class, new IRenderFactory<EntityWomen>()
        {

            @Override
            public Render<? super EntityWomen> createRenderFor(RenderManager manager)
            {
                return new RenderWomen(manager);

            }
        });
        
        RenderingRegistry.registerEntityRenderingHandler(EntityBarbarian.class, new IRenderFactory<EntityBarbarian>() 
        {
            @Override
            public Render<? super EntityBarbarian> createRenderFor(RenderManager manager)
            {
                return new RenderBarbarian(manager);
            }
        });
        

    }

}
