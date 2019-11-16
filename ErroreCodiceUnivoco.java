import java.io.IOException;

public class ErroreCodiceUnivoco extends IOException {
	ErroreCodiceUnivoco() {
		super();
		System.out.println("Errore Codice Univoco, Controlla che non sia più \n "
				+ "grande di 8 caratteri e che non ce ne sia un altro uguale");
		Menu Ricorsione = new Menu();
		Ricorsione.menu();
	}
}
