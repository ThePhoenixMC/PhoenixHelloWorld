package com.lss233.demo;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.config.ConfigurationManager;
import com.lss233.phoenix.config.json.JsonConfiguration;
import com.lss233.phoenix.logging.Logger;
import com.lss233.phoenix.module.Module;
import com.lss233.phoenix.module.PhoenixModule;

import java.io.IOException;

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

        Phoenix.getEventManager().registerListener(this, new DemoEventListener());
        try {
            JsonConfiguration configuration = Phoenix.getConfigurationManager().getConfig(this);
            configuration.set("blah", "2");
            configuration.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {

    }
}
