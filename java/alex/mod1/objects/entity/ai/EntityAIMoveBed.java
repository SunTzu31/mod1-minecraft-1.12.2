package alex.mod1.objects.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class EntityAIMoveBed extends EntityAIBase
{
    private final EntityCreature creature;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private final double movementSpeed;
    private int x, y, z;

    public EntityAIMoveBed(EntityCreature creatureIn, double speedIn, int x, int y, int z)
    {
        this.creature = creatureIn;
        this.movementSpeed = speedIn;
        this.setMutexBits(1);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if((int)this.creature.posX == this.x && (int)this.creature.posY == this.y && (int)this.creature.posZ == this.z)
        {
            return false;
        }
        else
        {
            BlockPos blockpos = new BlockPos(this.x, this.y, this.z);

            this.movePosX = blockpos.getX();
            this.movePosY = blockpos.getY();
            this.movePosZ = blockpos.getZ();
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        return !this.creature.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.creature.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.movementSpeed);
    }
}
