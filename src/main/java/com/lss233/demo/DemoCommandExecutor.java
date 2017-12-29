package com.lss233.demo;

import com.lss233.phoenix.command.*;

import java.util.Set;

/**
 * .
 */

@PhoenixCommand(label="demo")
public class DemoCommandExecutor implements Command {
    @CommandRouter(args="help", permission = "demo.help", sender = CommandRouter.Sender.ALL)
    public boolean help(CommandSender sender, String label, Set<Argument> args){
        return false;
    }

    @CommandRouter(args = "say <msg>")
    public boolean say(CommandSender sender, String label, String[] args){
        return false;
    }

    @Override
    public boolean onMissHandled(CommandSender sender, String label, ArgumentsMap args) {
        return false;
    }
}
