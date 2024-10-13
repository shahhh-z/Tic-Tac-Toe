
public class Data {
	// Initialize the instance variables.
	private String config;
	private int score;
	
	
	public Data(String config, int score) {
		// Set the instance variables equal to the given parameters.
		this.config = config;
		this.score = score;
	}
	
	
	public String getConfiguration() {
		// Return the configuration.
		return config;
	}
	
	
	public int getScore() {
		// Return the score.
		return score;
	}
}
