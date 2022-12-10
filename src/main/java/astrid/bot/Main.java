package astrid.bot;

import astrid.bot.commands.AllCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    
    public static void main(String[] args) {
        JDA bot = JDABuilder.createDefault(System.getenv("BOT_TOKEN"))
                .setActivity(Activity.playing("the trans girl national anthem"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .addEventListeners(new BotEventHandler())
                .build();
        AllCommands.registerCommands(bot.updateCommands());
    }
}