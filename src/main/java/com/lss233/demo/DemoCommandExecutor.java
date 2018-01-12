package com.lss233.demo;

import com.lss233.phoenix.command.*;

import java.util.Set;

/**
 * .
 */

@PhoenixCommand(label="demo")
public class DemoCommandExecutor implements Command {
    @CommandRouter(args="help", permission = "demo.help", sender = CommandRouter.Sender.ALL)
    public boolean help(CommandSender sender, String label, ArgumentsMap args){
        sender.sendMessage(new String[]{
                "*",
                "* Hello World",
                "* -----------",
                "* /demo echo <msg> - Echo test",
                "* /demo echo_2 <msg1> <msg2> - Echo + router test",
                "* /demo echo_a <msg...> - Echo + array test",
                "* /demo <Anything_expect_above> - Mismatch test"
        });
        return true;
    }

    @CommandRouter(args = "echo <msg>")
    public boolean echo(CommandSender sender, String label, ArgumentsMap args){
        sender.sendMessage(args.getString("msg"));
        return true;
    }
    @CommandRouter(args = "echo_2 <msg1> <msg2>")
    public boolean echo_2(CommandSender sender, String label, ArgumentsMap args){
        sender.sendMessage("[Echo] msg1: " + args.getString("msg1") + " msg2: " + args.getString("msg2"));
        return true;
    }
    @CommandRouter(args = "echo_a <msg...>")
    public boolean echo_a(CommandSender sender, String label, ArgumentsMap args){
        sender.sendMessage( args.getStrings("msg..."));
        return false;
    }

    @Override
    public boolean onMissHandled(CommandSender sender, String label, String[] args) {
        sender.sendMessage("What the hell?");
        return false;
    }
}
