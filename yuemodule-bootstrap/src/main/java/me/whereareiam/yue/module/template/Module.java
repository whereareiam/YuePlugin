package me.whereareiam.yue.module.template;

import me.whereareiam.yue.api.output.module.YueModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Module extends YueModule {
	private final Logger logger = LoggerFactory.getLogger(Module.class);

	@Override
	public void onLoad() {
		logger.info("Module loaded");
	}

	@Override
	public void onEnable() {
		logger.info("Module enabled");
	}

	@Override
	public void onDisable() {
		logger.info("Module disabled");
	}

	@Override
	public void onUnload() {
		logger.info("Module unloaded");
	}
}
