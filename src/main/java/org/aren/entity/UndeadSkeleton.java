package org.aren.entity;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.*;
import org.aren.pathfinder.PathfinderGoalPet;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;

public class UndeadSkeleton extends EntityCreature {
    public UndeadSkeleton(Location location) {
        super(EntityTypes.SKELETON, ((CraftWorld)location.getWorld()).getHandle());
        this.setPosition(location.getX(), location.getY(), location.getZ());

        this.setBaby(true);
        this.setInvulnerable(true);
    }

    @Override
    protected void initPathfinder() {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));

        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(1, new PathfinderGoalPet(this, 1.0, 25));
    }

    public void setOwner(Player player) {
        this.setGoalTarget((EntityLiving) ((CraftPlayer)player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, false);
    }

    public void setItem(EnumItemSlot slot, ItemStack item) {
        this.setSlot(slot, CraftItemStack.asNMSCopy(item));
    }

    public void setName(String name) {
        this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&', name)));
        this.setCustomNameVisible(true);
    }
}
