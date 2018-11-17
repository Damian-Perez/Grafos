package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class GrafoNDNP {

	private MatrizSimetrica grafo;
	private int cantNodos;
	private int cantAristas; 
	private double porcAdyacencia; 
	private int gradoMaximo;
	private int gradoMinimo;
	private Nodo[] nodo;
	private int cantidadColores;
	
	@SuppressWarnings("resource")
	public GrafoNDNP(String miPath) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(miPath)).useLocale(Locale.US);
		
		this.cantNodos = sc.nextInt();
		this.cantAristas = sc.nextInt(); 
		this.porcAdyacencia = sc.nextDouble();
		this.gradoMaximo = sc.nextInt();
		this.gradoMinimo = sc.nextInt(); 
		this.grafo = new MatrizSimetrica(this.cantNodos);
		this.nodo = new Nodo[this.cantNodos];
		this.cantidadColores = 0;
		
		for (int i = 0; i < nodo.length; i++) {
			nodo[i] = new Nodo(i,0,0);
		}

		for (int i = 0; i < this.cantAristas; i++) {
			Arista a = new Arista(sc.nextInt(), sc.nextInt());
			this.grafo.setValue(a.getNodo1(), a.getNodo2(), true);
			this.nodo[a.getNodo1()].sumarGrado();
			this.nodo[a.getNodo2()].sumarGrado();
		}

		sc.close();
		
	}

	public MatrizSimetrica getGrafo() {
		return grafo;
	}

	public double getPorcAdyacencia() {
		return porcAdyacencia;
	}

	public int getGradoMaximo() {
		return gradoMaximo;
	}

	public void setGradoMaximo(int gradoMaximo) {
		this.gradoMaximo = gradoMaximo;
	}

	@Override
	public String toString() {
		return "GrafoNDNP [grafo=" + grafo + ", cantNodos=" + cantNodos + ", cantAristas=" + cantAristas
				+ ", porcAdyacencia=" + porcAdyacencia + ", gradoMaximo=" + gradoMaximo
				+ ", gradoMinimo=" + gradoMinimo + ", nodo=" + Arrays.toString(nodo) + "]";
	}
	
	public GrafoColoreado colorear() {
		int i, color;
		this.cantidadColores = 0;
		
		for (i = 0; i < cantNodos; i++) {
			color = 1;
			
			while (!sePuedeColorear(i, color)) {
				color++;
			}
			
			nodo[i].setColor(color);
			
			if (color > this.cantidadColores) {
				this.cantidadColores = color;
			}
		}
		
		return new GrafoColoreado(this.cantidadColores, nodo);
		
	}
	
	public boolean sePuedeColorear(int posicion, int color) {
		int i = 0;
		
		while(i < this.cantNodos) {
			if(this.nodo[i].getColor() == color) {
				if(esAdyacente(this.nodo[posicion].getId(), this.nodo[i].getId())) {
					return false;
				}
			}
			i++;
		}
		
		return true;
	}
	
	public boolean esAdyacente(int nodo1, int nodo2) {
		return this.grafo.getValue(nodo1, nodo2);
	}
	
	
}
