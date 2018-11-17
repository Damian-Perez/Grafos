package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaProbadorColoreo {

	private GrafoColoreado grafoColoreado;
	private GrafoNDNP grafo;

	public ProgramaProbadorColoreo(String pathInGrafo, String pathInGrafoColoreado) throws FileNotFoundException {

		this.grafo = new GrafoNDNP(pathInGrafo);

		/* Leemos y cargamos el grafo ya coloreado */

		Scanner grafoColoreadoIn = new Scanner(new File(pathInGrafoColoreado));

		int cantidadNodos = grafoColoreadoIn.nextInt(); // Cantidad de nodos.
		int cantidadColores = grafoColoreadoIn.nextInt();
		ArrayList<Nodo> nodoscoloreados = new ArrayList<Nodo>();

		for (int i = 0; i < cantidadNodos; i++) {
			nodoscoloreados.add(new Nodo(grafoColoreadoIn.nextInt(), 0, grafoColoreadoIn.nextInt()));
		}

		this.grafoColoreado = new GrafoColoreado(cantidadColores, nodoscoloreados);

		grafoColoreadoIn.close();
	}

	public boolean probador() {

		for (int i = 0; i < grafo.getCantNodos(); i++) {
			for (int j = 0; j < grafo.getCantNodos(); j++) {
				if (i != j) {
					if (grafo.esAdyacente(grafoColoreado.getNodos().get(i).id, grafoColoreado.getNodos().get(j).id)
							&& grafoColoreado.getNodos().get(i).color == grafoColoreado.getNodos().get(j).color) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
