package astrid.bot.commands;

import astrid.bot.commands.executions.CommandExecutions;
import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

public class AllCommands {

    public static final ISlashCommand[] COMMANDS = {
            new PingCommand(),
            new QuitCommand(),
            new LigmaCommand(),
            new BaseSlashCommand("nyaaa", "cat uwu", CommandExecutions::nyaaExec),
    };
    public static void registerCommands(CommandListUpdateAction list){
        for(ISlashCommand command : COMMANDS) {
            command.register(list);
        }
    }
}
