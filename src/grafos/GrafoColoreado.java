package grafos;

import java.util.ArrayList;

public class GrafoColoreado {

	public int cantColores;
	public ArrayList<Nodo> nodos;
	
	public GrafoColoreado(int cantColores, ArrayList<Nodo> nodos) {
		this.cantColores = cantColores;
		this.nodos = nodos;
	}

	public String toString() {
		return "GrafoColoreado [cantColores=" + cantColores + ", nodos=" + nodos + "]";
	}

}
