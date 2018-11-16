package grafos;

import java.io.IOException;

public class GeneradorTest {

	public static void main(String[] args) throws IOException {
		Generador.generadorProbabilidadAdyacencia(5,70,"archivos/GrafoProbabilidadAdyacencia.in");
		Generador.generadorPorcentajeAdyacenteDeCadaArista(5,70,"archivos/GrafoPorcentajeAdyacente.in");
	}

}
