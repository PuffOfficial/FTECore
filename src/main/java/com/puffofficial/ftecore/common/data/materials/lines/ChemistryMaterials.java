package com.puffofficial.ftecore.common.data.materials.lines;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;

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

        VanadiumPentoxide = registerDustChemical("vanadium_pentoxide", "V2O5", 0xff7d38, Vanadium, 2, Oxygen, 5);
        MolybdenumTrioxide = registerDustChemical("molybdenum_trioxide", "MoO3", 0xddd76a, 0x454322, Molybdenum, 1,
                Oxygen, 3);

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

        SodiumDisulfide = registerDustChemical("sodium_disulfide", "Na2S2", 0x823d50, Sodium, 1, Sulfur, 2);
        Soot = registerDustChemical("soot", "C", 0x141414);
    }
}
