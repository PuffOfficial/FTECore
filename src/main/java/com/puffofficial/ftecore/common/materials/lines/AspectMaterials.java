package com.puffofficial.ftecore.common.materials.lines;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;

import com.puffofficial.ftecore.FTECore;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AspectMaterials {

    public static ArrayList<Material> Aspects = new ArrayList<>();

    private static Material registerAspect(String name, String formula, int color) {
        return new Material.Builder(FTECore.id(name))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).disableBucket().customStill())
                .color(color)
                .formula(formula)
                .buildAndRegister();
    }

    private static Material registerAspect(String name, int color, Object... components) {
        return new Material.Builder(FTECore.id(name))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).disableBucket().customStill())
                .components(components)
                .color(color)
                .buildAndRegister();
    }

    public static Material Terra, Ordo, Ignis, Aer, Perditio, Aqua;
    public static Material Gelum, Lux, Motus, Permutatio, Potentia, Tempestas, Vacuos, Venenum, Victus, Vitreus;
    public static Material Bestia, Fames, Herba, Iter, Limus, Metallum, Mortuus, Praecantatio, Sano, Tenebrae, Volatus;
    public static Material Alienis, Arbor, Auram, Corpus, Exanimis, Spiritus, Vitium;
    public static Material Cognitio, Sensus;
    public static Material Humanus;
    public static Material Instrumentum, Lucrum, Messis, Perfodio;
    public static Material Fabrico, Machina, Meto, Pannus, Telum, Tutamen;

    public static void init() {
        // Primal
        Terra = registerAspect("terra", "☷", 0x54c200);
        Ordo = registerAspect("ordo", "☰", 0xdbd4e4);
        Ignis = registerAspect("ignis", "☲", 0xe5650c);
        Aer = registerAspect("aer", "☴", 0xf8fc74);
        Perditio = registerAspect("perditio", "☳", 0x414244);
        Aqua = registerAspect("aqua", "☵", 0x50d7ff);
        // Tier 1
        Gelum = registerAspect("gelum", 0xe6ffff, Ignis, 1, Perditio, 1);
        Lux = registerAspect("lux", 0xe3e06f, Ignis, 1, Aer, 1);
        Motus = registerAspect("motus", 0xa2a3c1, Ordo, 1, Aer, 1);
        Permutatio = registerAspect("permutatio", 0x5f8c65, Ordo, 1, Perditio, 1);
        Potentia = registerAspect("potentia", 0xcffffa, Ordo, 1, Ignis, 1);
        Tempestas = registerAspect("tempestas", 0xfdfcf8, Aer, 1, Aqua, 1);
        Vacuos = registerAspect("vacuos", 0x847f79, Aer, 1, Perditio, 1);
        Venenum = registerAspect("venenum", 0x81dd00, Aqua, 1, Perditio, 1);
        Victus = registerAspect("victus", 0xd10005, Aqua, 1, Terra, 1);
        Vitreus = registerAspect("vitreus", 0x7cfffe, Ordo, 1, Terra, 1);
        // Tier 2
        Bestia = registerAspect("bestia", 0x9c630a, Motus, 1, Victus, 1);
        Fames = registerAspect("fames", 0x9b0101, Vacuos, 1, Victus, 1);
        Herba = registerAspect("herba", 0x288f0a, Terra, 1, Victus, 1);
        Iter = registerAspect("iter", 0xd75d58, Motus, 1, Terra, 1);
        Limus = registerAspect("limus", 0x12e922, Aqua, 1, Victus, 1);
        Metallum = registerAspect("metallum", 0xb5b7ce, Terra, 1, Vitreus, 1);
        Mortuus = registerAspect("mortuus", 0x7e727c, Perditio, 1, Victus, 1);
        Praecantatio = registerAspect("praecantatio", 0x9300ac, Potentia, 1, Vacuos, 1);
        Sano = registerAspect("sano", 0xff292e, Ordo, 1, Victus, 1);
        Tenebrae = registerAspect("tenebrae", 0x2c2b29, Lux, 1, Vacuos, 1);
        Volatus = registerAspect("volatus", 0xe5e6d8, Aer, 1, Motus, 1);
        // Tier 3
        Alienis = registerAspect("alienis", 0x775570, Tenebrae, 1, Vacuos, 1);
        Arbor = registerAspect("arbor", 0x8e6932, Aer, 1, Herba, 1);
        Auram = registerAspect("auram", 0xe4b9d7, Aer, 1, Praecantatio, 1);
        Corpus = registerAspect("corpus", 0xf4448d, Bestia, 1, Mortuus, 1);
        Exanimis = registerAspect("exanimis", 0x373f03, Mortuus, 1, Motus, 1);
        Spiritus = registerAspect("spiritus", 0x525252, Mortuus, 1, Victus, 1);
        Vitium = registerAspect("vitium", 0x8a007e, Perditio, 1, Praecantatio, 1);
        // Tier 4
        Cognitio = registerAspect("cognitio", 0xf8c2b6, Ignis, 1, Spiritus, 1);
        Sensus = registerAspect("sensus", 0x22cfef, Aer, 1, Spiritus, 1);
        // Tier 5
        Humanus = registerAspect("humanus", 0xffd4ba, Bestia, 1, Cognitio, 1);
        // Tier 6
        Instrumentum = registerAspect("instrumentum", 0x615bbd, Humanus, 1, Ordo, 1);
        Lucrum = registerAspect("lucrum", 0xe0be40, Humanus, 1, Fames, 1);
        Messis = registerAspect("messis", 0xc6a778, Herba, 1, Humanus, 1);
        Perfodio = registerAspect("perfodio", 0xded3db, Humanus, 1, Terra, 1);
        // Tier 7
        Fabrico = registerAspect("fabrico", 0x808e77, Instrumentum, 1, Humanus, 1);
        Machina = registerAspect("machina", 0x817fa4, Instrumentum, 1, Motus, 1);
        Meto = registerAspect("meto", 0xebae82, Instrumentum, 1, Messis, 1);
        Pannus = registerAspect("pannus", 0xe6e6c4, Instrumentum, 1, Bestia, 1);
        Telum = registerAspect("telum", 0xab4e58, Instrumentum, 1, Ignis, 1);
        Tutamen = registerAspect("tutamen", 0x00c5c5, Instrumentum, 1, Terra, 1);

        for (Field field : AspectMaterials.class.getDeclaredFields()) {
            if (field.getType() == Material.class) {
                try {
                    Aspects.add((Material) field.get(null));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
