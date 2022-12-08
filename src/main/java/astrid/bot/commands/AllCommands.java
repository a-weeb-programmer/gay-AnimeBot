package astrid.bot.commands;

import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

public class AllCommands {
    public static final ISlashCommand[] COMMANDS = {
            new PingCommand(),
            new QuitCommand(),
            new LigmaCommand(),
    };
    public static void registerCommands(CommandListUpdateAction list){
        for(ISlashCommand command : COMMANDS) {
            command.register(list);
        }
    }
}
