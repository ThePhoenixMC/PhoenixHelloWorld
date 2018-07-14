package com.lss233.demo;

import com.lss233.phoenix.command.*;
import com.lss233.phoenix.data.key.Keys;
import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.item.inventory.Inventory;
import com.lss233.phoenix.item.inventory.InventoryType;
import com.lss233.phoenix.item.inventory.ItemStack;
import com.lss233.phoenix.item.inventory.ItemType;
import com.lss233.phoenix.item.inventory.property.InventoryDimension;
import com.lss233.phoenix.item.inventory.property.InventoryTitle;
import com.lss233.phoenix.text.Text;
import com.lss233.phoenix.text.TextColor;
import com.lss233.phoenix.text.TextStyle;

import java.util.Arrays;

/**
 * .
 */

@PhoenixCommand(label="demo")
public class DemoCommandExecutor implements Command {
    @CommandRouter(args="help", permission = "demo.help", sender = CommandRouter.Sender.ALL)
    public CommandResult onRoot(CommandSender sender, CommandContent args){
        sender.sendMessage(new String[]{
                "*",
                "* Hello World",
                "* -----------",
                "* /demo echo <msg> - Echo test",
                "* /demo echo_2 <msg1> <msg2> - Echo + router test",
                "* /demo echo_a <msg...> - Echo + array test",
                "* /demo inventory - Inventory test",
                "* /demo <anything_expect_above> - Mismatch test"
        });
        return CommandResult.success();
    }

    @CommandRouter(args = "echo <msg>")
    public CommandResult echo(CommandSender sender, CommandContent args){
        sender.sendMessage(args.getString("msg"));
        return CommandResult.success();
    }
    @CommandRouter(args = "echo_2 <msg1> <msg2>")
    public CommandResult echo_2(CommandSender sender, CommandContent args){
        sender.sendMessage("[Echo] msg1: " + args.getString("msg1") + " msg2: " + args.getString("msg2"));
        return CommandResult.success();
    }
    @CommandRouter(args = "echo_a <msg...>")
    public CommandResult echo_a(CommandSender sender, CommandContent args){
        sender.sendMessage( args.getStrings("msg..."));
        return CommandResult.success();
    }

    @CommandRouter(args = "inventory", sender = CommandRouter.Sender.Player)
    public CommandResult inventory(CommandSender sender, CommandContent args){
        Player player = (Player)sender;
        Inventory inventory = Inventory.builder()
                .setType(InventoryType.CHEST)
                .setProperty(new InventoryDimension(9,6))
                .setProperty(new InventoryTitle(Text.of("Demo Inventory")))
                .build();
        inventory.setItem(1, ItemStack.builder()
                .setItemType(ItemType.WOOL)
                .setQuantity(4)
                .add(Keys.DISPLAY_NAME, Text.of("A lovely wool"))
                .add(Keys.ITEM_LORE, Arrays.asList(Text.of("This"),
                        Text.of("Is"),
                        Text.of("A"),
                        Text.builder("Phoenix")
                            .setColor(TextColor.BLUE)
                            .setStyle(TextStyle.BLOD)
                            .build(),
                        Text.of("Demo"),
                        Text.of("I wish it works.")))
                .build());
        player.openInventory(inventory);
        return CommandResult.success();
    }

    @Override
    public CommandResult onMissHandled(CommandSender commandSender, com.lss233.phoenix.command.CommandContent commandContent) {
        commandSender.sendMessage("What the hell?");
        return CommandResult.notFound();
    }
}
