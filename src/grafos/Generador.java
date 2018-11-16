package grafos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Generador {

	public static void generadorProbabilidadAdyacencia(int cantNodos, int probabilidadArista, String miPath) throws IOException {
		double p = probabilidadArista / 100;
		ArrayList<Arista> arista = new ArrayList<Arista>();
		int cantMaxAristas = ((cantNodos * (cantNodos - 1)) / 2);
		int cantAristas = 0;

		for (int i = 0; i < cantNodos - 2; i++) {
			for (int j = i + 1; j < cantNodos - 1; j++) {
				if (Math.random() > p) {
					arista.add(new Arista(i, j));
					cantAristas++;
				}
			}
		}

		double porcAdyacencia = (double) cantAristas / cantMaxAristas;
		
		escribirGrafoEnArchivo(cantNodos, cantAristas, porcAdyacencia, arista, miPath);
	}

	public static void generadorPorcentajeAdyacenteDeCadaArista(int cantNodos, double porcentaje, String miPath) throws IOException {
		ArrayList<Arista> arista_tmp = new ArrayList<Arista>();
		ArrayList<Arista> arista = new ArrayList<Arista>();
		int cantAristas = 0;
		
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				arista_tmp.add(new Arista(i, j));
			}
		}

		Collections.shuffle(arista);
		int p = (int) (arista_tmp.size() * porcentaje) / 100;

		for (int i = 0; i < p; i++) {
			arista.add(arista_tmp.get(i));
			cantAristas++;
		}

		escribirGrafoEnArchivo(cantNodos, cantAristas, porcentaje, arista, miPath);

	}

	public static void escribirGrafoEnArchivo(int cantNodos, int cantAristas, double porcAdyacencia, ArrayList<Arista> arista, String miPath) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));

		salida.println(cantNodos + " " + cantAristas + " " + porcAdyacencia);
		
		for (Arista arista2 : arista) {
			salida.println(arista2);
		}

		salida.close();
	}

}
