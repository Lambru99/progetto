import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Clsse2 {


	public boolean controllofile() throws IOException {
		try {
			FileReader InputFile = new FileReader("FileInventario.txt");
			BufferedReader righe = new BufferedReader(InputFile);
			righe.close();
			return false;
		} catch (FileNotFoundException E) {
			System.out.println("Errore 404: File non trovato");
			return true;
		}
	}

	public String[] leggifile() throws IOException {
		FileReader InputFile = new FileReader("FileInventario.txt");
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
	public boolean scrivifile (char cat,char unit,int quant,double pre, String codUn, String nom, String caratt) throws IOException{
		
		try {
			FileWriter OutputFile = new FileWriter("FileInventario.txt",true); 
			BufferedWriter A = new BufferedWriter(OutputFile);
			A.write("\r"+cat+";"+unit+";"+quant+";"+pre+";"+codUn+";"+nom+";"+caratt);
			A.flush(); 
			A.close();
			return false;
		} catch (FileNotFoundException E) {
			System.out.println("Errore 404: File non trovato");
			return true;
				
		
		}
		}
	public void Ricercatramite (String cosa, String scan) {
		switch (cosa) 
		{
//		case nome:for (int x=0;x<ProgettoMain.Raccoglitore.size();) 
//					{
//						String NomeEsistente =ProgettoMain.Nomi.get(x);
//						String Nomericerca =scan;
//						if 
//						
//					}
			//		case codice_univoco:; break;
//		case caratteristiche:; break;
//		
//
		}	
	}
	
		public void Vendeta (String CodiceDaCercare) throws IOException  
		{
			BufferedReader in = new BufferedReader(new FileReader("FileInventario.txt"));
			String RIcerca = in.readLine();
			if (RIcerca==CodiceDaCercare)
			{
				System.out.print(RIcerca);
			}
			
		}	
}

