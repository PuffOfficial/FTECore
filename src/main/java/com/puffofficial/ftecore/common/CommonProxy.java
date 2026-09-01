package com.puffofficial.ftecore.common;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.data.lang.FTELangHandler;
import com.tterrag.registrate.providers.ProviderType;

public class CommonProxy {
    public static void init() {
        FTECore.FTERegister.addDataGenerator(ProviderType.LANG, FTELangHandler::init);
    }
}
