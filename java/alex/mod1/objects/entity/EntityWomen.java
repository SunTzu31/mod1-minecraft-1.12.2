package alex.mod1.objects.entity;

import alex.mod1.init.ItemInit;
import alex.mod1.objects.entity.ai.EntityAIMoveBed;
import alex.mod1.util.handlers.SoundHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerInteract;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityWomen extends EntityVillager
{
    public EntityWomen(World worldIn)
    {
        super(worldIn);
    }

    protected void initEntityAI()
    {

        /*
         * this.tasks.addTask(0, new EntityAISwimming(this));
         * this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
         * this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityEvoker.class, 12.0F, 0.8D, 0.8D));
         * this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVindicator.class, 8.0F, 0.8D, 0.8D));
         * this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVex.class, 8.0F, 0.6D, 0.6D));
         * this.tasks.addTask(2, new EntityAIMoveIndoors(this));
         * this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
         * this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
         */
        int x = 0;
        int z = 0;

        int y = 0;

        for(int i = 0; i < 256; i++)
        {
            BlockPos pos = new BlockPos(x, i, z);
            if(this.world.getBlockState(pos).getBlock() == Blocks.AIR && this.world.getBlockState(pos.up(2)).getBlock() == Blocks.AIR)
            {
                y = pos.getY();
                break;
            }
        }

        this.tasks.addTask(5, new EntityAIMoveBed(this, 0.6D, x, y, z));

        /*
         * this.tasks.addTask(6, new EntityAIVillagerMate(this));
         * this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
         * this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
         * this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
         */

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);

    }

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if(itemstack.getItem() == ItemInit.MOD1_MONEY)
        {

            /*
             * player.playSound(SoundHandler.MOD1_BRUH, 1.0F, 0F);
             * BlockPos pos = new BlockPos(this).add(0, 0, 2);
             * this.world.setBlockState(pos, Blocks.BED.getDefaultState());
             * Vec3d v3d = RandomPositionGenerator.findRandomTargetBlockTowards(this, 16, 7, new Vec3d((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()));
             * this.getNavigator().tryMoveToXYZ(v3d.x, v3d.y, v3d.z, 0.8d);
             */
            return true;
        }
        else
        {
            return super.processInteract(player, hand);
        }

    }

    protected boolean canDespawn()
    {
        return false;
    }

}
