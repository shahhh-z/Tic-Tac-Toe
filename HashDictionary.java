
public class HashDictionary implements DictionaryADT {
	// Initialize the instance variables.
	private int size;
	private Data[] recordDict;
	private Data DELETED = new Data("",-1);
	private int countRecords = 0;
	
	
	public HashDictionary(int size) {
		// Create the hash dictionary and set the value for size.
		recordDict = new Data[size];
		this.size = size;
	}
	
	
	public int put(Data record) throws DictionaryException {
		// Check to see if the configuration is in the dictionary.
		if (get(record.getConfiguration()) != -1) {
			// Throw an exception if it is in the dictionary.
			throw new DictionaryException();
		}
		
		else {
			// Initialize the position and return value.
			int position = h(record.getConfiguration());
			int returnValue = 0;
			
			// Search through the dictionary if the current position is not empty.
			while ((recordDict[position] != null) &&
			(recordDict[position] != DELETED)) {
				// Update the return value and position.
				returnValue = 1;
				position = (position + 1) % size;
			}
			
			// Update the dictionary and number of records.
			recordDict[position] = record;
			countRecords++;
			// Return the return value.
			return returnValue;
		}
	}
	
	
	public void remove(String config) throws DictionaryException {
		// Check to see if the configuration is in the dictionary.
		if (get(config) == -1) {
			// Throw an exception if it is not in the dictionary.
			throw new DictionaryException();
		}
		
		else {
			// Initialize the position.
			int position = h(config);
			
			/*
			 *  Search through the dictionary if the current position does not
			 *  have the correct configuration.
			 */
			while (!((recordDict[position].getConfiguration()).equals(config))) {
				// Update position.
				position = (position + 1) % size;
			}
			
			// Update the dictionary and number of records.
			recordDict[position] = DELETED;
			countRecords--;
		}
	}
	
	
	public int get(String config) {
		// Initialize the position and the counter.
		int position = h(config);
		int counter = 0;
		
		// Search through the dictionary if the current position is empty.
		while ((recordDict[position] != null)) {
			// Check the current position.
			if ((recordDict[position] != DELETED) &&
			((recordDict[position].getConfiguration()).equals(config))) {
				// Break if found.
				break;
			}
			// Update the counter.
			counter++;
			if (counter == size) {
				// Return -1 if the entire dictionary has been searched.
				return -1;
			}
			// Update the position.
			position = (position + 1) % size;
		}
		
		// Return the score if it exists, return -1 if not.
		if (recordDict[position] == null) {
			return -1;
		}
		else if (recordDict[position] == DELETED) {
			return -1;
		}
		else {
			return recordDict[position].getScore();
		}
	}
	
	
	public int numRecords() {
		// Return the number of records in the dictionary.
		return countRecords;
	}
	
	
	private int h(String config) {
		// Initialize the sum.
		int sum = 0;
		
		// Go through the configuration.
		for (int i = 0; i < config.length(); i++) {
			// Add the ASCII value of each character to the sum.
			sum = ((sum * 11) + (int) config.charAt(i)) % size;
		}
		
		//  Return the remainder of the sum divided by the dictionary size.
		return sum % size;
	}
}
