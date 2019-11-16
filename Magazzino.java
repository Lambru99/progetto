
import java.io.*;
import java.util.*;

public class Magazzino {
	Menu Errore = new Menu();
	LeggoScrivoFile AcquisizioneFile = new LeggoScrivoFile();
	private char categoria;
	private char unita;
	private double quantita;
	private double prezzo;
	private String codice_univoco;
	private String nome;
	private String caratteristiche;

	Magazzino() {
	};

	Magazzino(char categoria, char unita, double quantita, double prezzo, String codice_univoco, String nome,
			String caratteristiche) {
		setCategoria(categoria);
		setUnita(unita);
		setQuantita(quantita);
		setPrezzo(prezzo);
		setCodice_univoco(codice_univoco);
		setNome(nome);
		setCaratteristiche(caratteristiche);
	}

//qui iniziano i set e i get delle variabili che abbiamo reso private, qui ci saranno i controlli
// la categoria deve essere E F L, non altro
	public boolean setCategoria(char categoria) {
		switch (categoria) {
		case 'E':
			this.categoria = categoria;
			break;
		case 'F':
			this.categoria = categoria;
			break;
		case 'L':
			this.categoria = categoria;
			break;
		case 'e':
			this.categoria = categoria;
			break;
		case 'f':
			this.categoria = categoria;
			break;
		case 'l':
			this.categoria = categoria;
			break;
		default:
			System.out.print("Categoria Errata: Sono accetate solo E,F,L\n\n\n\n\n ");
			Errore.menu();
			return false;
		}
		return true;
	}

// l'unità deve essere U K L, non altro
	public boolean setUnita(char unita) {
		switch (unita) {
		case 'U':
			this.unita = unita;
			break;
		case 'K':
			this.unita = unita;
			break;
		case 'L':
			this.unita = unita;
			break;
		case 'u':
			this.unita = unita;
			break;
		case 'k':
			this.unita = unita;
			break;
		case 'l':
			this.unita = unita;
			break;
		default:
			System.out.print("Unita' Errata: Sono accetate solo U,K,L\n\n\n\n\n");
			Errore.menu();
			return false;
		}
		return true;

	}

// la quantità è un double che non può essere minore di 0
	public void setQuantita(double quantita) {
		if (quantita > 0.0)
			this.quantita = quantita;
		else {
			System.out.println("La quantita' e' minore di 0, prendo come valore: " + quantita * -1 + "\n\n\n\n\n");
			this.quantita = quantita * -1;
		}
	}

// il prezzo è un double che non può essere 0
	public void setPrezzo(double prezzo) {
		if (prezzo > 0.0) {
			this.prezzo = prezzo;
		} else {
			System.out.println("Il prezzo e' minore di 0, prendo come valore:" + prezzo * -1 + "\n\n\n\n\n");
			this.prezzo = prezzo * -1;
		}
	}

	public String getCodice_univoco() {

		return codice_univoco;
	}

// per il controllo del codice univoco richiameremo un altro metodo
	public void setCodice_univoco(String codice_univoco) {
		this.codice_univoco = codice_univoco;
	}

	// questo è il metodo che controlla il codice univoco che deve essere unico e di
	// 8 cifre
	public boolean ControlloCodiciUnivociUguali(String CodiceScanner) {
		if (CodiceScanner.length() != 8) {
			try {
				throw new ErroreCodiceUnivoco();
			} catch (ErroreCodiceUnivoco e) {
			}
		} else {
			for (int x = 0; x < ProgettoMain.Raccoglitore.size(); x++) {
				String CoDiCeEsistente = ProgettoMain.Raccoglitore.get(x);
				int InteroStringaCodiceUnivocoEsistente = Integer.parseInt(CoDiCeEsistente);

				String StringaScanner = CodiceScanner;
				int InteroStringaCodiceUnivocoNuovo = Integer.parseInt(StringaScanner);

				if (InteroStringaCodiceUnivocoEsistente == InteroStringaCodiceUnivocoNuovo) {
					try {
						throw new ErroreCodiceUnivoco();
					} catch (ErroreCodiceUnivoco e) {
						e.printStackTrace();
					}
				}

			}
			return true;
		}
		return false;

	}

// il nome non può essere una stringa vuota
	public void setNome(String nome) {
		this.nome = nome;
		if (nome == "") {
			System.out.println("Devi dare un nome all'articolo\n\n\n\n\n");
			Errore.menu();
		}
	}

// l'utente scriverà cio che vuole nelle caratteristiche
	public void setCaratteristiche(String caratteristiche) {
		this.caratteristiche = caratteristiche;
	}

	public String toString() {
		return "Magazzino [categoria=" + categoria + ", unita=" + unita + ", quantita=" + quantita + ", prezzo="
				+ prezzo + ", codice_univoco=" + codice_univoco + ", nome=" + nome + ", caratteristiche="
				+ caratteristiche + "]";
	}

// il metodo permette di creare un nuovo prodotto
	public void Creazione() {
		System.out.println("Di che categoria fa parte?\n\n(E = Elettricità,F = Ferramenta,L = Legno)");
		Scanner CategoriaScan = new Scanner(System.in);
		char InserimentoCategoria = CategoriaScan.next().charAt(0);
		categoria = InserimentoCategoria;
		if (setCategoria(InserimentoCategoria) == false) {
			return;
		}
		setCategoria(categoria);
		System.out.println("Qual'e' la sua unita'?\n\n(U = Unità,K = Kilo,L = Litro)");
		Scanner UnitaScan = new Scanner(System.in);
		char InserimentoUnita = UnitaScan.next().charAt(0);
		unita = InserimentoUnita;
		setUnita(unita);
		System.out.println("Quanto?(ricordati di inserire il punto se e' decimale)");
		Scanner QuantitaScan = new Scanner(System.in);
		String InserimentoQuantita = QuantitaScan.next();
		quantita = Double.parseDouble(InserimentoQuantita);
		;
		setQuantita(quantita);
		System.out.println("A che prezzo?\n\n(ricordati di inserire il punto se il prezzo e' decimale)");
		Scanner PrezzoScan = new Scanner(System.in);
		String InserimentoPrezzo = PrezzoScan.next();
		prezzo = Double.parseDouble(InserimentoPrezzo);
		setPrezzo(prezzo);
		System.out.println("Qual'e' il suo codice univoco?");
		Scanner CodiceUnivocoScan = new Scanner(System.in);
		String InsermentoCodiceUnivoco = CodiceUnivocoScan.next();
		codice_univoco = InsermentoCodiceUnivoco;
		if (ControlloCodiciUnivociUguali(InsermentoCodiceUnivoco) == false) {
			return;
		}
		setCodice_univoco(codice_univoco);
		System.out.println("Come si chiama?");
		Scanner NomeScan = new Scanner(System.in);
		String InserimentoNome = NomeScan.next();
		nome = InserimentoNome;
		setNome(nome);
		System.out.println("Che caratteristiche ha?");
		Scanner CaratteristicheScan = new Scanner(System.in);
		String InserimentoCaratteristiche = CaratteristicheScan.next();
		caratteristiche = InserimentoCaratteristiche;
		caratteristiche = caratteristiche;
		setCaratteristiche(caratteristiche);
		{
			System.out.println("Vuoi Salavare il seguente articolo?S/N?");
			System.out.println("-Categoria=" + categoria);
			System.out.println("-Unita=" + unita);
			System.out.println("-Quantita=" + quantita);
			System.out.println("-Prezzo=" + prezzo + " €");
			System.out.println("-Codice univoco=" + codice_univoco);
			System.out.println("-Nome=" + nome);
			System.out.println("-Caratteristiche=" + caratteristiche);
			Scanner ScannePerIlControllo = new Scanner(System.in);
			char ControlloScritturaFile = CaratteristicheScan.next().charAt(0);
			if (ControlloScritturaFile == 'S' || ControlloScritturaFile == 's') {
				try {
					AcquisizioneFile.scrivifile(categoria, unita, quantita, prezzo, codice_univoco, nome,
							caratteristiche);
					System.out.println("L'articolo e' stato aggiunto correttamente al database");
				} catch (IOException e) {
					System.out.println("C'e' stato un errore in scrittura: Hai controllato che tutti"
							+ " i campi sono compilati correttamente?");
					Errore.menu();
				}
			} else {
				System.out.println("L'articolo non e' stato aggiunto al database\n");
				Errore.menu();
			}
		}

	}

}
