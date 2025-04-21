package me.whereareiam.myplugin.common.command;

import me.whereareiam.yue.api.annotation.Command;
import me.whereareiam.yue.api.output.CommandBase;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
public class ExampleCommand implements CommandBase {
	@Command(name = "example")
	public void onCommand(SlashCommandInteractionEvent event) {
		event.reply("Hello World!").setEphemeral(true).queue();
	}
}
