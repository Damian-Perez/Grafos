package grafos;

import java.io.FileNotFoundException;

public class ProgramaProbadorColoreo {

	private GrafoColoreado grafoColoreado;
	private GrafoNDNP grafo;

	public ProgramaProbadorColoreo(String pathInGrafo, String pathInGrafoColoreado) throws FileNotFoundException {
		this.grafo = new GrafoNDNP(pathInGrafo);
		this.grafoColoreado = new GrafoColoreado(pathInGrafoColoreado);
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
