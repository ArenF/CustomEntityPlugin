package org.aren.pathfinder;

import net.minecraft.server.v1_16_R3.*;

import java.util.EnumSet;

public class PathfinderGoalPet extends PathfinderGoal {

    private final EntityInsentient a; //our pet;
    private EntityLiving b; // owner;

    private final double f; //speed
    private final float g;

    private double c;
    private double d;
    private double e;

    public PathfinderGoalPet(EntityInsentient a, double speed, float distance) {
        this.a = a;
        this.f = speed;
        this.g = distance;
        this.a(EnumSet.of(Type.MOVE));
    }


    @Override
    public boolean a() {
        this.b = this.a.getGoalTarget();
        if (this.b == null)
            return false;
        else if (this.a.getDisplayName() == null)
            return false;
        else if (!(this.b.h(this.a) > (double) (this.g * this.g))) {
//            만약 b 와 a의 거리가 범위의 제곱 이상이 아닐 때
            a.setPosition(this.b.locX(), this.b.locY(), this.b.locZ());
            return false;
        } else {
            // follow the owner

            Vec3D vec = RandomPositionGenerator.a((EntityCreature) this.a, 16, 7, this.b.getPositionVector());

            if (vec == null)
                return false;

            this.c = this.b.locX();
            this.d = this.b.locY();
            this.e = this.b.locZ();
            return true;
        }
    }

    @Override
    public void c() {
        this.a.getNavigation().a(this.c, this.d, this.e, this.f);
    }

    @Override
    public boolean b() {
//        run after c
//        run every tick as long as its true (repeats c)
        return !this.a.getNavigation().m() && this.b.h(this.a) <
                (double) (this.g * this.g);
    }

    @Override
    public void d() {
        this.b = null;
    }
}
