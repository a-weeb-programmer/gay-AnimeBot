package astrid.bot.commands.executions;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

/**
 * All methods in this class are used to reference execution functions for BaseSlashCommand instances
 * DO NOT EXPLICITLY CALL METHODS IN THIS CLASS, REFERENCE THEM INSTEAD
 * I probably gotta think of a more efficient system for this, but here you go uwu
 * */
public class CommandExecutions {
    public static boolean nyaaExec(SlashCommandInteractionEvent event) {
        event.reply("nyaaaaa~").setEphemeral(true).queue();
        return true;
    }
}
