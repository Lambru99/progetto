
import java.io.IOException;
import java.util.*;

public class Menu implements MetodiDelMenu {
	public void menu()// questo è il menù e partirà all'inizio del programma e deve implementare
						// l'interfaccia MetodiDelMenu

	{
		try {
			System.out.println("Benvenuto!\nPremi invio per accedere al menu'\n");
			new Scanner(System.in).nextLine();
			clearScreen();
			System.out.println("		MENU'\n1> Visualizzare il valore totale\n2> Inserire un nuovo prodotto\n3> "
					+ "Cercare un prodotto nel sistema\n4> Vendere il prodotto\n5> Visualizzare tutti gli articoli "
					+ "disponibili\n6> Chiudi il programma");
			System.out.println("\nSelezionare l'opzione desiderata");
			int input = new Scanner(System.in).nextInt();
			switch (input) {
			case 1:
				Valore_Totale();
				;
				break;
			case 2:
				Inserire_Prodotto();
				break;
			case 3:
				Ricerca();
				break;
			case 4:
				Vendita();
				break;
			case 5:
				ProdottiDelMagazzino();
				break;
			case 6:
				Chiusura();
				break;
			default:
				System.out.println("Scelta non valida!");
				menu();
				break;
			}
		} catch (InputMismatchException Lettere) {
			System.out.println("Scelta non valida!");
			menu();
		}

	}

// questo metodo se richiamato stampa stringhe vuote a video per pulire lo schermo
	private static void clearScreen() {

		for (int i = 0; i < 40; ++i)
			System.out.println();
	}

//stampa gli elementi
	public void ProdottiDelMagazzino() {
		int z;
		for (z = 0; z < ProgettoMain.VettoreArticoli.size(); z++) {
			System.out.println(ProgettoMain.VettoreArticoli.elementAt(z));
		}
		System.out.println("Sono presenti: " + z + " elementi");
		menu();
	}

//stampa il totale del valore degli oggetti contenuti nel magazzino
	public void Valore_Totale() {
		double valore = 0.0;
		double ValoreDaSommare;
		for (int z = 0; z < ProgettoMain.Prezzi.size(); z++) {
			ValoreDaSommare = Double.parseDouble(ProgettoMain.Prezzi.elementAt(z));
			valore = valore + ValoreDaSommare;

		}
		System.out.println(valore + " €\nGrazie!\n");
		menu();
	}

// permette di vendere un oggetto
	public void Vendita() throws ArrayIndexOutOfBoundsException {
		LeggoScrivoFile scritturafile = new LeggoScrivoFile();
		try {
			System.out.println("Scrivi il codice univoco relativo al prodotto che vuoi vendere");
			int CodiceUnivocoPerRicerca = new Scanner(System.in).nextInt();
			String CodiceInStringa = Integer.toString(CodiceUnivocoPerRicerca);
			Magazzino vuoto = new Magazzino();
			for (int cont = 0; cont < ProgettoMain.VettoreArticoli.size(); cont++) {
				switch (ProgettoMain.VettoreArticoli.elementAt(cont).getCodice_univoco().compareTo(CodiceInStringa)) {
				case 0:
					System.out.println(ProgettoMain.VettoreArticoli.elementAt(cont) + "è stato venduto");
					ProgettoMain.VettoreArticoli.set(cont, vuoto);
				}
			}

			return;
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Il prodotto non è presente nel Database");
			menu();
		} catch (NullPointerException f) {
			System.out.println("Prodotto non trovato!");
			menu();
		}
		menu();
	}

// cerca un oggetto e lo stampa
	public void Ricerca() {
		try {
			System.out.println("Scrivi il codice univoco relativo al prodotto che vuoi visualizzare");
			int CodiceUnivocoPerRicerca = new Scanner(System.in).nextInt();
			String CodiceInStringa = Integer.toString(CodiceUnivocoPerRicerca);
			for (int conta = 0; conta < ProgettoMain.VettoreArticoli.capacity(); conta++) {
				switch (ProgettoMain.VettoreArticoli.elementAt(conta).getCodice_univoco().compareTo(CodiceInStringa)) {
				case 0:
					System.out.println(ProgettoMain.VettoreArticoli.elementAt(conta));
					return;

				default:
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Il prodotto non è presente nel Database");
			menu();
		} catch (NullPointerException k) {
			System.out.println("Prodotto non trovato!");
			menu();
		}
		menu();
	}

// richiama il metodo creazione
	public void Inserire_Prodotto() {
		Magazzino NuovoProdotto = new Magazzino();
		NuovoProdotto.Creazione();

	}

// permette di spegnere il programma che alla fine di ogni operazione si riavvia 
	public boolean Chiusura() {
		System.out.println("Sto chiudendo il programma... Arrivederci!");
		System.out.println("Programma chiuso.");
		return false;

	}

}