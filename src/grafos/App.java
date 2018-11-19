package grafos;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		//Generador.generadorProbabilidadAdyacencia(5,70);
		Generador.generadorPorcentajeAdyacenteDeCadaArista(600,70);
		GrafoNDNP grafo = new GrafoNDNP("archivos/GrafoPorcentajeAdyacente_600_70.in");
		//System.out.println(grafo);
		//System.out.println(grafo.coloreoWelshPowell());
		//System.out.println(grafo.coloreoMatula());
		grafo.coloreoMatula("archivos/GrafoPorcentajeAdyacente_50_70.out");
		grafo.coloreoMatula("archivos/GrafoPorcentajeAdyacente_50_70_2.out");
		grafo.coloreoMatula("archivos/GrafoPorcentajeAdyacente_50_70_3.out");
		grafo.coloreoMatula("archivos/GrafoPorcentajeAdyacente_50_70_4.out");
		grafo.coloreoMatula("archivos/GrafoPorcentajeAdyacente_50_70_5.out");
		grafo.coloreoMatula("archivos/GrafoPorcentajeAdyacente_50_70_6.out");
		//ProgramaProbadorColoreo ppc = new ProgramaProbadorColoreo("archivos/GrafoPorcentajeAdyacente_5_70.in","archivos/GrafoPorcentajeAdyacente_5_70.out");
		//System.out.println(ppc.probador());
	}
}
