package alex.mod1.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.AbstractIllager;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */

@SideOnly(Side.CLIENT)
public class ModelBarbarian extends ModelBase
{
    public ModelRenderer LeftArmArmor;
    public ModelRenderer RightLegArmor;
    public ModelRenderer RightArmArmor;
    public ModelRenderer Helmet;
    public ModelRenderer LeftLegArmor;
    public ModelRenderer RightArm;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer LeftArm;
    public ModelRenderer LeftLeg;
    public ModelRenderer BodyClothes;

    public ModelBarbarian()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LeftArmArmor = new ModelRenderer(this, 48, 48);
        this.LeftArmArmor.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftArmArmor.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.LeftLeg = new ModelRenderer(this, 16, 48);
        this.LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RightLegArmor = new ModelRenderer(this, 0, 32);
        this.RightLegArmor.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.RightLegArmor.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.BodyClothes = new ModelRenderer(this, 16, 32);
        this.BodyClothes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyClothes.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
        this.Helmet = new ModelRenderer(this, 32, 0);
        this.Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Helmet.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.RightLeg = new ModelRenderer(this, 0, 16);
        this.RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.LeftArm = new ModelRenderer(this, 32, 48);
        this.LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LeftLegArmor = new ModelRenderer(this, 0, 48);
        this.LeftLegArmor.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.LeftLegArmor.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.RightArm = new ModelRenderer(this, 40, 16);
        this.RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RightArmArmor = new ModelRenderer(this, 40, 32);
        this.RightArmArmor.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightArmArmor.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.LeftArmArmor.render(f5);
        this.LeftLeg.render(f5);
        this.RightLegArmor.render(f5);
        this.BodyClothes.render(f5);
        this.Helmet.render(f5);
        this.RightLeg.render(f5);
        this.Body.render(f5);
        this.LeftArm.render(f5);
        this.LeftLegArmor.render(f5);
        this.Head.render(f5);
        this.RightArm.render(f5);
        this.RightArmArmor.render(f5);
        
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    /*
     * @Override
     * public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
     * {
     * super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
     * copyModelAngles(this.LeftLeg, this.LeftLegArmor);
     * copyModelAngles(this.RightLeg, this.RightLegArmor);
     * copyModelAngles(this.LeftArm, this.LeftArmArmor);
     * copyModelAngles(this.RightArm, this.RightArmArmor);
     * copyModelAngles(this.Body, this.BodyClothes);
     * this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing* 0.6665F)* 1.4F * limbSwingAmount;
     * /*this.Head.rotateAngleY = netHeadYaw * 0.17453292F;
     * this.Head.rotateAngleY = headPitch * 0.17453292F;
     * this.Helmet.rotateAngleY = netHeadYaw * 0.17453292F;
     * this.Helmet.rotateAngleY = headPitch * 0.17453292F;
     */

    // }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.Head.rotateAngleX = headPitch * 0.017453292F;
        this.Helmet.rotateAngleY = netHeadYaw * 0.017453292F;
        this.Helmet.rotateAngleX = headPitch * 0.017453292F;
        //this.arms.rotationPointY = 3.0F;
        //this.arms.rotationPointZ = -1.0F;
        //this.arms.rotateAngleX = -0.75F;
        this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.LeftLeg.rotateAngleY = 0.0F;
        this.RightLeg.rotateAngleY = 0.0F;
        AbstractIllager.IllagerArmPose abstractillager$illagerarmpose = ((AbstractIllager)entityIn).getArmPose();

        if(abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.ATTACKING)
        {
            float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
            this.RightArm.rotateAngleZ = 0.0F;
            this.LeftArm.rotateAngleZ = 0.0F;
            this.RightArm.rotateAngleY = 0.15707964F;
            this.LeftArm.rotateAngleY = -0.15707964F;
            this.RightArmArmor.rotateAngleZ = 0.0F;
            this.LeftArmArmor.rotateAngleZ = 0.0F;
            this.RightArmArmor.rotateAngleY = 0.15707964F;
            this.LeftArmArmor.rotateAngleY = -0.15707964F;

            if(((EntityLivingBase)entityIn).getPrimaryHand() == EnumHandSide.RIGHT)
            {
                this.RightArm.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.LeftArm.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
                this.RightArm.rotateAngleX += f * 2.2F - f1 * 0.4F;
                this.LeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
                this.RightArmArmor.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.LeftArmArmor.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
                this.RightArmArmor.rotateAngleX += f * 2.2F - f1 * 0.4F;
                this.LeftArmArmor.rotateAngleX += f * 1.2F - f1 * 0.4F;
            }
            else
            {
                this.RightArm.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
                this.LeftArm.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.RightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
                this.LeftArm.rotateAngleX += f * 2.2F - f1 * 0.4F;
                this.RightArmArmor.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
                this.LeftArmArmor.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.RightArmArmor.rotateAngleX += f * 1.2F - f1 * 0.4F;
                this.LeftArmArmor.rotateAngleX += f * 2.2F - f1 * 0.4F;
            }

            this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            this.RightArmArmor.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.LeftArmArmor.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.RightArmArmor.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            this.LeftArmArmor.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        }
        else if(abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.SPELLCASTING)
        {
            this.RightArm.rotationPointZ = 0.0F;
            this.RightArm.rotationPointX = -5.0F;
            this.LeftArm.rotationPointZ = 0.0F;
            this.LeftArm.rotationPointX = 5.0F;
            this.RightArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.LeftArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.RightArm.rotateAngleZ = 2.3561945F;
            this.LeftArm.rotateAngleZ = -2.3561945F;
            this.RightArm.rotateAngleY = 0.0F;
            this.LeftArm.rotateAngleY = 0.0F;
            this.RightArmArmor.rotationPointZ = 0.0F;
            this.RightArmArmor.rotationPointX = -5.0F;
            this.LeftArmArmor.rotationPointZ = 0.0F;
            this.LeftArmArmor.rotationPointX = 5.0F;
            this.RightArmArmor.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.LeftArmArmor.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.RightArmArmor.rotateAngleZ = 2.3561945F;
            this.LeftArmArmor.rotateAngleZ = -2.3561945F;
            this.RightArmArmor.rotateAngleY = 0.0F;
            this.LeftArmArmor.rotateAngleY = 0.0F;
        }
        else if(abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.BOW_AND_ARROW)
        {
            this.RightArmArmor.rotateAngleY = -0.1F + this.Head.rotateAngleY;
            this.RightArmArmor.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
            this.LeftArmArmor.rotateAngleX = -0.9424779F + this.Head.rotateAngleX;
            this.LeftArmArmor.rotateAngleY = this.Head.rotateAngleY - 0.4F;
            this.LeftArmArmor.rotateAngleZ = ((float)Math.PI / 2F);
            this.RightArmArmor.rotateAngleY = -0.1F + this.Head.rotateAngleY;
            this.RightArmArmor.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
            this.LeftArmArmor.rotateAngleX = -0.9424779F + this.Head.rotateAngleX;
            this.LeftArmArmor.rotateAngleY = this.Head.rotateAngleY - 0.4F;
            this.LeftArmArmor.rotateAngleZ = ((float)Math.PI / 2F);
        }
    }
    public ModelRenderer getArm(EnumHandSide p_191216_1_)
    {
        return p_191216_1_ == EnumHandSide.LEFT ? this.LeftArm : this.RightArm;
    } 
}
