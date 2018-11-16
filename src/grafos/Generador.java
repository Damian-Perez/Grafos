package grafos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Generador {

	public static void generadorProbabilidadAdyacencia(int cantNodos, int probabilidadArista) throws IOException {
		double p = probabilidadArista / 100;
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		int cantMaxAristas = ((cantNodos * (cantNodos - 1)) / 2);
		int cantAristas = 0;

		for (int i = 0; i < cantNodos - 2; i++) {
			for (int j = i + 1; j < cantNodos - 1; j++) {
				if (Math.random() > p) {
					aristas.add(new Arista(i, j));
					cantAristas++;
				}
			}
		}

		double porcAdyacencia = (double) cantAristas / cantMaxAristas;
		Grado grado = calcularGrado(aristas, cantNodos);
		String miPath = "archivos/GrafoProbabilidadAdyacencia_" + cantNodos + "_" + probabilidadArista + ".in";
		
		
		escribirGrafoEnArchivo(cantNodos, cantAristas, porcAdyacencia, grado, aristas, miPath);
	}

	public static void generadorPorcentajeAdyacenteDeCadaArista(int cantNodos, double porcentaje) throws IOException {
		ArrayList<Arista> aristas_tmp = new ArrayList<Arista>();
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		int cantAristas = 0;
		
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				aristas_tmp.add(new Arista(i, j));
			}
		}

		Collections.shuffle(aristas);
		int p = (int) (aristas_tmp.size() * porcentaje) / 100;

		for (int i = 0; i < p; i++) {
			aristas.add(aristas_tmp.get(i));
			cantAristas++;
		}

		Grado grado = calcularGrado(aristas, cantNodos);
		String miPath = "archivos/GrafoPorcentajeAdyacente_" + cantNodos + "_" + (int) porcentaje + ".in";
		escribirGrafoEnArchivo(cantNodos, cantAristas, porcentaje, grado, aristas, miPath);
	}
	
	
	private static Grado calcularGrado(ArrayList<Arista> aristas, int cantNodos) {
		
		int[] gradosPorNodo = new int[cantNodos];
		
		int gradoMaximo = 0;
		int gradoMinimo = Integer.MAX_VALUE;
		
		for (int i = 0; i < gradosPorNodo.length; i++) {
			gradosPorNodo[i] = 0;
		}
		
		for (Arista a : aristas) {
			gradosPorNodo[a.getNodo1()] += 1;
			gradosPorNodo[a.getNodo2()] += 1;
		}
		
		for (int i = 0; i < gradosPorNodo.length; i++) {
			if(gradosPorNodo[i] > gradoMaximo)
				gradoMaximo = gradosPorNodo[i];
			if(gradosPorNodo[i] < gradoMinimo)
				gradoMinimo = gradosPorNodo[i];
		}
		
		return new Grado(gradoMinimo, gradoMaximo);
	}
	

	private static void escribirGrafoEnArchivo(int cantNodos, int cantAristas, double porcAdyacencia, Grado grado, ArrayList<Arista> arista, String miPath) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));

		salida.println(cantNodos + " " + cantAristas + " " + porcAdyacencia + " " + grado);
		
		for (Arista arista2 : arista) {
			salida.println(arista2);
		}

		salida.close();
	}

}
