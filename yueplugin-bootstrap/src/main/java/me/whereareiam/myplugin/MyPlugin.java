package me.whereareiam.myplugin;

import me.whereareiam.myplugin.adapter.config.template.PluginCommandsTemplate;
import me.whereareiam.yue.api.model.config.Commands;
import me.whereareiam.yue.api.output.config.ConfigurationLoader;
import me.whereareiam.yue.api.output.plugin.YuePlugin;
import me.whereareiam.yue.api.output.service.CommandService;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Path;

public class MyPlugin extends YuePlugin {
	@Autowired
	private ConfigurationLoader configLoader;
	@Autowired
	private CommandService commandService;
	@Autowired
	private Path pluginPath;

	public MyPlugin(PluginWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void start() {
		super.start();

		commandService.register(
				getApplicationContext(),
				configLoader.load(pluginPath.resolve("commands"), Commands.class, new PluginCommandsTemplate())
		);
	}

	@Override
	public void stop() {
		super.stop();

		commandService.unregister("example");
	}
}
