public class SizeException extends Exception {
	public SizeException() {
		System.err.println("Vous ne pouvez pas entrer un opérateur alorq que votre pile est vide");
	}
}
