package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.client.renderer.cover.ICoverRenderer;
import com.gregtechceu.gtceu.client.renderer.cover.IOCoverRenderer;
import com.gregtechceu.gtceu.common.cover.ConveyorCover;
import com.gregtechceu.gtceu.common.cover.PumpCover;
import com.gregtechceu.gtceu.common.cover.RobotArmCover;
import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.render.CoverRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FTECovers {

    public static final List<CoverDefinition> ALL_COVERS = new ArrayList<>(3);

    public static CoverDefinition ULV_ROBOT_ARM = registerULV("robot_arm", RobotArmCover::new,
            () -> () -> CoverRenderer.ROBOT_ARM_RENDERER);

    public static CoverDefinition ULV_PUMP = registerULV("pump",
            (def,cov,side,tier) -> new PumpCover(def,cov,side,GTValues.ULV,32),
            () -> () -> IOCoverRenderer.PUMP_LIKE_COVER_RENDERER);

    public static CoverDefinition ULV_CONVEYOR = registerULV("conveyor", ConveyorCover::new,
            () -> () -> CoverRenderer.CONVEYOR_RENDERER);


    public static CoverDefinition registerULV(
            String id,
            CoverDefinition.TieredCoverBehaviourProvider behavior,
            Supplier<Supplier<ICoverRenderer>> renderer
    ) {
        return register(
                id,
                (def, cov, side) -> behavior.create(def, cov, side, GTValues.ULV),
                renderer);
    }

    public static CoverDefinition register(
            String id,
            CoverDefinition.CoverBehaviourProvider behavior,
            Supplier<Supplier<ICoverRenderer>> renderer
    ) {

        var definition = new CoverDefinition(FTECore.id(id), behavior, renderer);
        ALL_COVERS.add(definition);
        return definition;
    }
}
