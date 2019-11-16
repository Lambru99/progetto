//i metodi di questa interfaccia devono essere implementati nella classe menu e 
//sono i metodi a cui l'utente fa riferimento scrivendo un numero da 1 a 6 sulla tastiera
public interface MetodiDelMenu {

	public void Valore_Totale();

	public void Inserire_Prodotto();

	public void Ricerca();

	public void Vendita();

	public void ProdottiDelMagazzino();

	public boolean Chiusura();
}
