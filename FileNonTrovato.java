import java.io.FileNotFoundException;

public class FileNonTrovato extends FileNotFoundException {
	FileNonTrovato() {
		super();
		System.out.println("File non trovato");
	}
}
