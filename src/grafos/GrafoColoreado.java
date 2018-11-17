package grafos;

import java.util.ArrayList;

public class GrafoColoreado {

	private int cantColores;
	private ArrayList<Nodo> nodos;
	
	public GrafoColoreado(int cantColores, ArrayList<Nodo> nodos) {
		this.cantColores = cantColores;
		this.nodos = nodos;
	}

	public String toString() {
		return "GrafoColoreado [cantColores=" + cantColores + ", nodos=" + nodos + "]";
	}

	public int getCantColores() {
		return cantColores;
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

}
