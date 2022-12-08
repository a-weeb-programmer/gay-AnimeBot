package astrid.bot.commands;

import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class PingCommand implements ISlashCommand {

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "server ping uwuu";
    }

    @Override
    public boolean execute(SlashCommandInteractionEvent event) {
        boolean deez = event.getOption("ligma", false, OptionMapping::getAsBoolean);
        long time = System.currentTimeMillis();
        event.replyFormat("Ping from bot is: %d ms", System.currentTimeMillis() - time)
                .setEphemeral(true)
                .flatMap(v -> v.editOriginalFormat("Ping from bot is: %d ms", System.currentTimeMillis() - time)).queue();
        return true;
    }
}
