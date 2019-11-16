
import java.util.*;

public class ProgettoMain {

	public static Vector<Magazzino> VettoreArticoli = new Vector<Magazzino>();
	public static Vector<String> Raccoglitore = new Vector<String>();
	public static Vector<String> Prezzi = new Vector<String>();
	public static Vector<String> Elementi = new Vector<String>();

	public static void main(String[] args) throws Exception {
		char UnitaProvvisoria = 'p';
		char CategoriaProvvisoria = 'p';
		double QuantitaProvvisoria = 0;
		double PrezzoProvvisorio = 0;
		LeggoScrivoFile AcquisizioneFile = new LeggoScrivoFile();
		if (AcquisizioneFile.controllofile() == false)
			return;
		String[] ArrayFile = AcquisizioneFile.leggifile();
		for (int i = 0; i < (ArrayFile.length); i++) {
			String raccoglimento, tuttiiprezzi, numeroelementi = "";
			String oggetto = ArrayFile[i];
			String[] split = oggetto.split(";");

//Tutti gli elementi splittati vengono messi nelle rispettive variabili per 
//poi essere utilizzati come parametri per il nuovo oggetto magazzino

			String CategoriaSplittata = split[0];
			String UnitaSplittata = split[1];
			String QuantitaSplittata = split[2];
			String PrezzoSplittato = split[3];
			String CodiceUnivocoSplittato = split[4];
			String NomeProvvisorio = split[5];
			String CaratteristicheSplittate = split[6];
			CategoriaProvvisoria = CategoriaSplittata.charAt(0);
			UnitaProvvisoria = UnitaSplittata.charAt(0);
			QuantitaProvvisoria = Double.parseDouble(QuantitaSplittata);
			PrezzoProvvisorio = Double.parseDouble(PrezzoSplittato);
			VettoreArticoli.add(new Magazzino(CategoriaProvvisoria, UnitaProvvisoria, QuantitaProvvisoria,
					PrezzoProvvisorio, CodiceUnivocoSplittato, NomeProvvisorio, CaratteristicheSplittate));
			/*
			 * Questi sono i vettori e gli array che ci permetteranno di fare il controllo
			 * del codice univoco, di stampare il prezzo totale e di fare le varie ricerche
			 * !!Attenzione!! i vettori richiamati qua sotto sono stati inizializzati sopra
			 * in modo statico
			 */
			String[] ArreyPrezzoProvvisorio = { split[3] };
			String[] ArreyDiCodici = { split[4] };
			for (int p = 0; p < ArreyDiCodici.length; p++) {
				raccoglimento = ArreyDiCodici[p];
				tuttiiprezzi = ArreyPrezzoProvvisorio[p];
				Raccoglitore.add(raccoglimento);
				Prezzi.add(tuttiiprezzi);
				Elementi.add(numeroelementi);
			}

		}

		Menu InizioProgramma = new Menu();
		InizioProgramma.menu();

	}
}