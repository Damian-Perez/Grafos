package grafos;

import java.io.IOException;

public class GeneradorTest {
	public static void main(String[] args) throws IOException {
		//Generador.generadorProbabilidadAdyacencia(5,70);
		//Generador.generadorPorcentajeAdyacenteDeCadaArista(5,70);
		GrafoNDNP grafo = new GrafoNDNP("archivos/GrafoPorcentajeAdyacente_5_70.in");
		System.out.println(grafo);
		//System.out.println(grafo.coloreoWelshPowell());
		System.out.println(grafo.coloreoMatula());
	}
}
