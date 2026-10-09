package com.puffofficial.ftecore.common.materials.lines;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.api.helpers.MaterialHelper.*;

public class ChemistryMaterials {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MATERIALS);
    }

    public static Material Acetaldehyde, MaleicAnhydride, DiethylSuccinate, VanadiumPentoxide, MolybdenumTrioxide;
    public static Material CavumTenebraeAir, UnitasAir, AbydosAir, ChulakAir, RimaAir;
    public static Material PolysulfideRubber, DichlorodiethylFormal, EthyleneChlorohydrin, PolysulfideHermetic,
            SodiumDisulfide, Soot;
    public static Material PolylacticAcid, LacticAcid, EthylhexanoicAcid, Propylene, TinDioxide, RawStarch, Starch,
            StannousOctoate;
    public static Material SaltMixture;
    public static Material GravelSlurry, SandSlurry, DirtSlurry, NetherrackSlurry, EndstoneSlurry;
    public static Material NetherImbuedLava, ManaFusedLPG;

    public static void init() {
        // Air stuff idk
        CavumTenebraeAir = registerGasChemical("cavum_tenebrae_air", 0x391b0f);
        UnitasAir = registerGasChemical("unitas_air", 0xffe600);
        AbydosAir = registerGasChemical("abydos_air", 0xcbd468);
        ChulakAir = registerGasChemical("chulak_air", 0x98cec);
        RimaAir = registerGasChemical("rima_air", 0x9aee3b);

        // Ethanol Dehydrogrenation
        Acetaldehyde = registerFluidChemical("acetaldehyde", "C2H4O", 0xcbcbcb);
        MaleicAnhydride = registerFluidChemical("maleic_anhydride", "C4H2O3", 0xbbffff);
        DiethylSuccinate = registerFluidChemical("diethyl_succinate", "C8H14O4", 0xb6adad);

        VanadiumPentoxide = registerDustChemical("vanadium_pentoxide", 0xff7d38, Vanadium, 2, Oxygen, 5);
        MolybdenumTrioxide = registerDustChemical("molybdenum_trioxide", 0xfeffa8, Molybdenum, 1, Oxygen, 3);

        // Polysulfide Rubber
        DichlorodiethylFormal = registerFluidChemical("dicholorodiethyl_formal", "C5H10Cl2O2", 0xe3e3e3);
        EthyleneChlorohydrin = registerFluidChemical("ethylene_chlorohydrin", "C2H5OCl", 0xfffce8);
        PolysulfideRubber = registerFluidChemical("polysulfide_rubber", "C23H29NO3", 0x70382f);
        PolysulfideHermetic = new Material.Builder(FTECore.id("polysulfide_hermetic"))
                .fluid()
                .polymer()
                .color(0xa37a6d).iconSet(MaterialIconSet.ROUGH)
                .fluidPipeProperties(530, 6500, true, true, true, false)
                .buildAndRegister();

        SodiumDisulfide = registerDustChemical("sodium_disulfide", 0x823d50, Sodium, 2, Sulfur, 2);
        Soot = registerDustChemical("soot", "C", 0x141414);

        // Polylactic Acid
        EthylhexanoicAcid = registerFluidChemical("2_ethylhexanoic_acid", "C7H15CO2", 0xFAFAD2);
        Propylene = registerFluidChemical("propylene", "C2H4", 0xaaaa69);
        LacticAcid = registerFluidChemical("lactic_acid", "C3H6O3", 0xE6F7FF);
        PolylacticAcid = new Material.Builder(FTECore.id("polylactic_acid"))
                .fluid()
                .polymer()
                .color(0xFFF5E6).iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_PLATE)
                .buildAndRegister();

        StannousOctoate = registerDustChemical("stannous_octoate", "Sn(C7H15CO2)", 0xFFFACD, 0x454322);
        TinDioxide = registerDustChemical("tin_dioxide", "SnO2", 0xF8F8FF);
        RawStarch = registerDustChemical("raw_starch", 0xa7d19d, 0xa66b49);
        Starch = registerDustChemical("starch", 0xd4d4d4, 0xa66b49);

        // Mixtures/Slurries
        SaltMixture = registerMixture("salt_mixture", 0x4854da, SaltWater, 1, RockSalt, 1);

        GravelSlurry = registerFluidChemical("gravel_slurry", 0x645b5b);
        SandSlurry = registerFluidChemical("sand_slurry", 0xd1ba8a);
        DirtSlurry = registerFluidChemical("dirt_slurry", 0x593d29);
        NetherrackSlurry = registerFluidChemical("netherrack_slurry", 0x411616);
        EndstoneSlurry = registerFluidChemical("endstone_slurry", 0xf6fabd);

        // Fuels
        NetherImbuedLava = registerFuel("nether_imbued_lava", "Nether-Imbued Lava", 0xff2323, 1500);
        ManaFusedLPG = registerFluidChemical("mana_fused_lpg", "Mana-Fused LPG", 0x309ca8);
    }
}
