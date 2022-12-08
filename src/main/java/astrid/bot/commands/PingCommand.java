package astrid.bot.commands;

import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

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
        long time = System.currentTimeMillis();
        event.replyFormat("Ping from bot is: %d ms", System.currentTimeMillis() - time)
                .setEphemeral(true)
                .flatMap(v -> v.editOriginalFormat("Ping from bot is: %d ms", System.currentTimeMillis() - time)).queue();
        return true;
    }
}
