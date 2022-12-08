package astrid.bot;

import astrid.bot.commands.AllCommands;
import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotEventHandler extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        for(ISlashCommand c : AllCommands.COMMANDS) {
            if(event.getName().equals(c.getName())) {
                if(!c.execute(event)) {
                    System.err.printf("Error executing %s D:\n", c.getName());
                }
            }
        }
    }
}
