package alex.mod1.util.handlers;

import alex.mod1.client.renderer.entity.RenderWomen;
import alex.mod1.objects.entity.EntityWomen;
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

    }

}
