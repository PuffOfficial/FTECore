package com.puffofficial.ftecore.api.helpers;

import com.tterrag.registrate.util.nullness.NonNullSupplier;
import lombok.NonNull;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.util.FastColor;

import java.awt.*;
import java.util.function.Supplier;

public class ColorHelper {
    public static int hexToRGB(int hex) {
        Color color = new Color(hex);
        int a = color.getAlpha();
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        return FastColor.ARGB32.color(a, r,g,b);
    }

    public static NonNullSupplier<Supplier<ItemColor>> itemTintFromHex(int hex, int tint) {
        return () -> () -> (stack, tintIndex) -> {
            if (tintIndex == tint) {
                return hex;
            }
            return 0xFFFFFFFF;
        };
    }
}
