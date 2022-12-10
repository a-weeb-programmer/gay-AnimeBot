package astrid.bot.interfaces;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.ArrayList;
import java.util.List;

public interface ISlashCommand {

    /**
     * Registration for commands, pwease don't override or call this method anywhere else
     * */
    default void register(CommandListUpdateAction list) {
        list.addCommands(Commands.slash(getName(), getDescription())
                .addOptions(getOptionData())
                .setDefaultPermissions(getDefaultMemberPermissions()).
                addSubcommands(getSubcommandData())).queue();
    }

    String getName();

    String getDescription();

    default List<OptionData> getOptionData() {
        return new ArrayList<>();
    }

    default DefaultMemberPermissions getDefaultMemberPermissions() {
        return DefaultMemberPermissions.ENABLED;
    }

    default List<SubcommandData> getSubcommandData() {
        return new ArrayList<>();
    }

    /**
     * <p>Gets called during command execution</p>
     * <p>why am I actually commenting my code</p>
     * @param event The instance of the event that's triggered when slash command is executed
     * @return true when successfully executed, false if otherwise
     */
    boolean execute(SlashCommandInteractionEvent event);
}
