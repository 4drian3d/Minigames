package au.com.mineauz.minigames.objects;

import be.seeseemelk.mockbukkit.UnimplementedOperationException;
import be.seeseemelk.mockbukkit.block.BlockStateMock;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created for the AddstarMC Project. Created by Narimm on 9/01/2019.
 */
public class MockSign extends BlockStateMock implements Sign {

    private final LinkedList<String> lines = new LinkedList<>();
    private boolean edittable = false;

    public MockSign(MaterialData data, boolean edittable) {
        super(data);
        this.edittable = edittable;
        lines.add("");
        lines.addLast("");
        lines.addLast("");
        lines.addLast("");
    }

    @Override
    public @NotNull List<Component> lines() {
        return Arrays.stream(getLines())
                .<Component>map(LegacyComponentSerializer.legacySection()::deserialize)
                .toList();
    }

    @Override
    public @NotNull Component line(int i) throws IndexOutOfBoundsException {
        return LegacyComponentSerializer.legacySection().deserialize(getLine(i));
    }

    @Override
    public void line(int i, @NotNull Component component) throws IndexOutOfBoundsException {
        setLine(i, LegacyComponentSerializer.legacySection().serialize(component));
    }

    @Override
    public String[] getLines() {
        String[] out = new String[lines.size()];
        return lines.toArray(out);
    }

    @Override
    public String getLine(int i) throws IndexOutOfBoundsException {
        return lines.get(i);
    }


    @Override
    public void setLine(int i, String s) throws IndexOutOfBoundsException {
        lines.set(i, s);
    }

    @Override
    public boolean isEditable() {
        return edittable;
    }

    @Override
    public void setEditable(boolean b) {
        edittable = b;
    }

    @Override
    public boolean isGlowingText() {
        return false;
    }

    @Override
    public void setGlowingText(boolean b) {

    }

    @Override
    public Location getLocation(Location loc) {
        return super.getLocation(loc);
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public @Unmodifiable @NotNull Collection<ItemStack> getDrops() {
        return List.of();
    }

    @Override
    public @Unmodifiable @NotNull Collection<ItemStack> getDrops(@Nullable ItemStack itemStack) {
        return List.of();
    }

    @Override
    public @Unmodifiable @NotNull Collection<ItemStack> getDrops(@NotNull ItemStack itemStack, @Nullable Entity entity) {
        return List.of();
    }

    @Override
    public @NotNull PersistentDataContainer getPersistentDataContainer() {
        throw new UnimplementedOperationException("This is not yet implemented");
    }

    @Override
    public boolean isSnapshot() {
        return false;
    }

    @Override
    public @Nullable DyeColor getColor() {
        return null;
    }

    @Override
    public void setColor(DyeColor color) {

    }
}
