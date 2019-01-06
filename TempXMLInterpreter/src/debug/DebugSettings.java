package debug;

public class DebugSettings {
	private static boolean debugMode = false;
	private static boolean borderMode = false;
	private static boolean positiveErrorMessages = false;
	
	public static boolean getDebugMode() {
		return debugMode;
	}
	public static void setDebugMode(boolean debugMode) {
		DebugSettings.debugMode = debugMode;
	}
	public static boolean getBorderMode() {
		return borderMode;
	}
	public static void setBorderMode(boolean borderMode) {
		DebugSettings.borderMode = borderMode;
	}
	public static boolean getPositiveErrorMessages() {
		return positiveErrorMessages;
	}
	public static void setPositiveErrorMessages(boolean positiveErrorMessages) {
		DebugSettings.positiveErrorMessages = positiveErrorMessages;
	}
	
	
}
