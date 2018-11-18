package grafos;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		//Generador.generadorProbabilidadAdyacencia(5,70);
		Generador.generadorPorcentajeAdyacenteDeCadaArista(5,70);
		GrafoNDNP grafo = new GrafoNDNP("archivos/GrafoPorcentajeAdyacente_5_70.in");
		//System.out.println(grafo);
		//System.out.println(grafo.coloreoWelshPowell());
		//System.out.println(grafo.coloreoMatula());
		grafo.coloreoMatula("archivos/GrafoPorcentajeAdyacente_5_70.out");
		ProgramaProbadorColoreo ppc = new ProgramaProbadorColoreo("archivos/GrafoPorcentajeAdyacente_5_70.in","archivos/GrafoPorcentajeAdyacente_5_70.out");
		System.out.println(ppc.probador());
	}
}
