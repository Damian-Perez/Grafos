package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class GrafoNDNP {

	private MatrizSimetrica grafo;
	private int cantNodos;
	private int cantAristas; 
	private double porcAdyacencia; 
	private Grado grado;
	
	@SuppressWarnings("resource")
	public GrafoNDNP(String miPath) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(miPath)).useLocale(Locale.US);
		
		this.cantNodos = sc.nextInt();
		this.cantAristas = sc.nextInt(); 
		this.porcAdyacencia = sc.nextDouble();
		this.grado = new Grado(sc.nextInt(),sc.nextInt()); 
		this.grafo = new MatrizSimetrica(this.cantNodos);

		for (int i = 0; i < this.cantAristas; i++) {
			this.grafo.setValue(sc.nextInt(), sc.nextInt(), true);
		}

		sc.close();
		
	}

	public MatrizSimetrica getGrafo() {
		return grafo;
	}

	public double getPorcAdyacencia() {
		return porcAdyacencia;
	}

	public Grado getGrado() {
		return grado;
	}

}
