package astrid.bot.commands;

import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.util.ArrayList;
import java.util.List;

public class QuitCommand implements ISlashCommand {
    @Override
    public String getName() {
        return "shutdown";
    }

    @Override
    public String getDescription() {
        return "kills bot. Only empresses may use";
    }

    @Override
    public DefaultMemberPermissions getDefaultMemberPermissions() {
        return DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR);
    }

    @Override
    public List<SubcommandData> getSubcommandData() {
        List<SubcommandData> data = new ArrayList<>();
        data.add(new SubcommandData("calmly", "Shuts down the bot. Only empresses may use"));
        data.add(new SubcommandData("force", "forces bot shutdown. Only empresses may use"));
        return data;
    }

    @Override
    public boolean execute(SlashCommandInteractionEvent event) {
        if(event.getSubcommandName() != null && event.getSubcommandName().equals("force")) {
            event.getJDA().shutdownNow();
        } else {
            event.getJDA().shutdown();
        }
        return true;
    }
}
