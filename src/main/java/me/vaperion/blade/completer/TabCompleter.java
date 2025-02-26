package me.vaperion.blade.completer;

import me.vaperion.blade.command.container.BladeCommand;
import me.vaperion.blade.command.service.BladeCommandService;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface TabCompleter {
    void init(@NotNull BladeCommandService commandService);

    default boolean isDefault() {
        return false;
    }

    default boolean hasPermission(@NotNull Player player, @NotNull BladeCommand command) {
        if ("op".equals(command.getPermission())) return player.isOp();
        if (command.getPermission() == null || command.getPermission().trim().isEmpty()) return true;
        return player.hasPermission(command.getPermission());
    }
}
