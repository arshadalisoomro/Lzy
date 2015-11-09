package free.lzy.log;

public class Logger {
	
	private org.apache.log4j.Logger logger;
	
	private Logger(org.apache.log4j.Logger logger) {
		this.logger = logger;
	}

	public static Logger newInstance(String logger) {
		return new Logger(org.apache.log4j.Logger.getLogger(logger));
	}

	public static Logger newInstance(Class<?> logger) {
		return newInstance(logger.getName());
	}
	
	public void info(Object message) {
		logger.info(message);
	}

	public void info(Object message, Throwable t) {
		logger.info(message, t);
	}

	public void debug(Object message) {
		logger.debug(message);
	}
	
	public void debug(Object message, Throwable t) {
		logger.debug(message, t);
	}
	
	public void warn(Object message) {
		logger.warn(message);
	}
	
	public void warn(Object message, Throwable t) {
		logger.warn(message, t);
	}
	
	public void error(Object message) {
		logger.error(message);
	}
	
	public void error(Object message, Throwable t) {
		logger.error(message, t);
	}
}
