import java.util.*;
import java.io.*;

public class LeggoScrivoFile {
	// questo metodo controlla se esiste il file
	public boolean controllofile() throws IOException, FileNonTrovato {
		try {
			FileReader InputFile = new FileReader("EMPORIO.txt");
			BufferedReader righe = new BufferedReader(InputFile);
			righe.close();
			return true;
		} catch (FileNonTrovato E) {
			throw new FileNonTrovato();
		}
	}

	// Se esiste, allora questo metodo permette di leggerlo
	public String[] leggifile() throws IOException {
		FileReader InputFile = new FileReader("EMPORIO.txt");
		BufferedReader righe = new BufferedReader(InputFile);
		ArrayList<String> lista = new ArrayList<String>();
		String riga = null;
		do {
			riga = righe.readLine();
			if (riga == null)
				break;
			lista.add(riga);
		} while (true);
		righe.close();
		return lista.toArray(new String[lista.size()]);
	}

	// questo metodo scrive un nuovo prodotto sul file
	public boolean scrivifile(char CategoriaNuova, char UnitaNuova, double QuantitaNuova, double PrezzoNuovo,
			String CodiceUnivocoNuovo, String NomeNuovo, String CaratteristicheNuove)
			throws IOException, FileNonTrovato {

		try {
			FileWriter OutputFile = new FileWriter("EMPORIO.txt", true);
			BufferedWriter ScritturaFileNuovo = new BufferedWriter(OutputFile);
			ScritturaFileNuovo.write(CategoriaNuova + ";" + UnitaNuova + ";" + QuantitaNuova + ";" + PrezzoNuovo + ";"
					+ CodiceUnivocoNuovo + ";" + NomeNuovo + ";" + CaratteristicheNuove + "\r");
			ScritturaFileNuovo.flush();
			ScritturaFileNuovo.close();
			return false;
		} catch (FileNonTrovato E) {
			throw new FileNonTrovato();

		}
	}

}
