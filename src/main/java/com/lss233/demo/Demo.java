package com.lss233.demo;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.logging.Logger;
import com.lss233.phoenix.module.Module;
import com.lss233.phoenix.module.PhoenixModule;

/**
 * .
 */
@PhoenixModule(name="DemoModule",version="1.0.0",modid="demomodule")
public class Demo extends Module{
    private Logger logger = Phoenix.getLogger("DemoModule");
    @Override
    public void onInitial() {

    }

    @Override
    public void onEnable() {
        logger.info("Demo has enabled.");
        Phoenix.getCommandManager().registerCommand(this,new DemoCommandExecutor());
    }

    @Override
    public void onDisable() {

    }
}
