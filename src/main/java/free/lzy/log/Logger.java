package free.lzy.log;

import org.slf4j.LoggerFactory;

public class Logger {
	
private org.slf4j.Logger logger;
	
	private Logger(org.slf4j.Logger logger) {
		this.logger = logger;
	}

	public static Logger newInstance(String logger) {
		return new Logger(LoggerFactory.getLogger(logger));
	}

	public static Logger newInstance(Class<?> logger) {
		return newInstance(logger.getName());
	}
	
	public void info(String message) {
		logger.info(message);
	}

	public void info(String message, Throwable t) {
		logger.info(message, t);
	}

	public void debug(String message) {
		logger.debug(message);
	}
	
	public void debug(String message, Throwable t) {
		logger.debug(message, t);
	}
	
	public void warn(String message) {
		logger.warn(message);
	}
	
	public void warn(String message, Throwable t) {
		logger.warn(message, t);
	}
	
	public void error(String message) {
		logger.error(message);
	}
	
	public void error(String message, Throwable t) {
		logger.error(message, t);
	}
}
