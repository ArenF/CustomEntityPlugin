package org.aren.command;

import net.minecraft.server.v1_16_R3.WorldServer;
import org.aren.entity.UndeadSkeleton;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PetCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;

        if (s.equalsIgnoreCase("pet")) {
            WorldServer worldServer = ((CraftWorld)player.getWorld()).getHandle();

            UndeadSkeleton skeleton = new UndeadSkeleton(player.getLocation());
            skeleton.setOwner(player);
            skeleton.setName("&a" + player.getName() + "의 스켈레톤");

            worldServer.addEntity(skeleton);

            return true;
        }

        return false;
    }
}
