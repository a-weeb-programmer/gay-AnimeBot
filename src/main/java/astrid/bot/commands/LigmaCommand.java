package astrid.bot.commands;

import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.Random;

public class LigmaCommand implements ISlashCommand {

    @Override
    public String getName() {
        return "ligma";
    }

    @Override
    public String getDescription() {
        return "hehe~ funni";
    }

    @Override
    public boolean execute(SlashCommandInteractionEvent event) {
        int random = new Random().nextInt(3);
        switch (random) {
            case 1 -> event.reply("steve jobs").setEphemeral(true).queue();
            case 2 -> event.reply("joe mamaaa").setEphemeral(true).queue();
        }
        return true;
    }
}
