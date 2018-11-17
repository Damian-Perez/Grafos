package grafos;

import java.util.Arrays;

public class GrafoColoreado {

	public int cantColores;
	public Nodo[] nodos;
	
	public GrafoColoreado(int cantColores, Nodo[] nodos) {
		this.cantColores = cantColores;
		this.nodos = nodos;
	}

	public String toString() {
		return "GrafoColoreado [cantColores=" + cantColores + ", nodos=" + Arrays.toString(nodos) + "]";
	}

}
