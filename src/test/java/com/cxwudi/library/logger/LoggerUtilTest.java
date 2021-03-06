package com.cxwudi.library.logger;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cxwudi.library.jul_logger.predefined.MyPredefinedFormatter;
import com.cxwudi.library.jul_logger.predefined.MyPredefinedHandler;
import com.cxwudi.library.jul_logger.predefined.MyPredefinedLogger;
import com.cxwudi.library.jul_logger.util.AutoflushedStreamHandler;
import com.cxwudi.library.jul_logger.util.HandlerUtil;
import com.cxwudi.library.jul_logger.util.LoggerUtil;

class LoggerUtilTest {

	@Test
	public void testDefaultUsage() {
		LoggerUtil.setupGlobalLogger(
				HandlerUtil.setupHandler(new AutoflushedStreamHandler(System.out),
				MyPredefinedFormatter.getOrCreateNokiaStyleFormatter()));
		
		Logger.getGlobal().info("Hello Miku");
		
		var myLogger = LoggerUtil.setupLogger(Logger.getLogger("Miku"), 
				HandlerUtil.setupHandler(new AutoflushedStreamHandler(System.out), 
				MyPredefinedFormatter.getOrCreateMySimplyFormatter()));
		
		myLogger.warning("Rin and Len");
		
		var myLogger2 = LoggerUtil.setupLogger(Logger.getLogger("Len"), 
				MyPredefinedHandler.createDefaultHandlers(
						MyPredefinedFormatter.getOrCreateVisierStyleFormatter()));
		myLogger2.warning("Luka is here");
		myLogger2.info("miku and luka");
		
		var myLogger3 = MyPredefinedLogger.setupInvincibleLoggerFor("Best Miku Logger");
		myLogger3.info("haha");
		myLogger3.warning("Oh no");
		
		assertTrue(true);
	}
}
