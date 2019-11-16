

public class ERRORI extends Exception {
	public ERRORI () {
	super ("Problemi con te");	
	}

	
	public String toString() {
		return getMessage() + "ciao";
	}
	
	}