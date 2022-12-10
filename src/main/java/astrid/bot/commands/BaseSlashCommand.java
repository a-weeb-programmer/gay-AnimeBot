package astrid.bot.commands;

import astrid.bot.interfaces.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.function.Function;

public class BaseSlashCommand implements ISlashCommand {
    private String name;
    private String description;
    private Function<SlashCommandInteractionEvent, Boolean> execution_function;
    /**
     * Constructor for a basic slash command
     *
     * @param name name of the command
     *
     * @param description command's description
     *
     * @param execution Function that the command will call when executed. Rather than making a lambda directly when filling this argument,
     * create a static method in {@link astrid.bot.commands.executions.CommandExecutions}, then reference it to fill in this argument.
     * If the execution function is greater than 15 lines, create a class with {@link BaseSlashCommand} as its superclass and
     * then make the execution function inside that class*/
    public BaseSlashCommand(String name, String description, Function<SlashCommandInteractionEvent, Boolean> execution) {
        this.name = name;
        this.description = description;
        this.execution_function = execution;
    }

    public BaseSlashCommand setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public BaseSlashCommand setDescription(String description){
        this.description = description;
        return this;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public BaseSlashCommand setExecutionFunction(Function<SlashCommandInteractionEvent, Boolean> execution_function) {
        this.execution_function = execution_function;
        return this;
    }

    @Override
    public boolean execute(SlashCommandInteractionEvent event) {
        return this.execution_function.apply(event);
    }
}
