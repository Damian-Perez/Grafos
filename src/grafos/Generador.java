package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Generador {
	
	int n;
	int cantidadAristas;
	double porcentajeAdyacencia;
	int gradoMenor;
	int gradoMaximo;

	
	public static MatrizSimetrica escribirMatrizVector(int orden, int cantidad, String miPath) throws FileNotFoundException {
		
		MatrizSimetrica matriz = new MatrizSimetrica(orden);
		
		Scanner sc = new Scanner(new File(miPath));
		
		for(int i = 0; i < cantidad; i++) {
			matriz.setValue(sc.nextInt(), sc.nextInt(), true);
		}
		
		sc.close();
		return matriz;
	}
	
	public void generadorProbabilidadAdyacencia(int CantidadNodos, int probabilidadArista, String miPath) throws IOException {	
		
		double p = probabilidadArista/100;
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		
		for(int i = 0; i < CantidadNodos-2; i++) {
			for(int j = i+1; j < CantidadNodos-1; j++) {
				if(Math.random() > p) {
					salida.println(i + " " + j);
				}
			}
		}
		salida.close();
	}

	public static int generadorPorcentajeAdyacenteDeCadaArista(int CantidadNodos, int porcentaje, String miPath) throws IOException {	
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		
		ArrayList<Arista> Arista = new ArrayList<Arista>();
		
		for(int i = 0; i < CantidadNodos; i++) {
			for(int j = i+1; j < CantidadNodos; j++) {
				Arista.add(new Arista(i,j));
			}
		}
		
		Collections.shuffle(Arista);
		
		int p = (Arista.size() * porcentaje) / 100;
		
		System.out.println(p);
		int cant = 0;
		
		for (int i = 0; i < p; i++) {
			salida.println(Arista.get(i));
			cant++;
		}
		salida.close();
		return cant;
	}
	
	
	public static void main(String[] args) throws IOException {
		int cantidadElementos = generadorPorcentajeAdyacenteDeCadaArista(4,100,"archivos/pepe.txt");
		MatrizSimetrica matriz = escribirMatrizVector(4,cantidadElementos,"archivos/pepe.txt");		
	}
}
