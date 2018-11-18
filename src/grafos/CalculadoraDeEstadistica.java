package grafos;

public class CalculadoraDeEstadistica {
	public void calcularEstadisticaGrafosAleatorios(int cantidadNodos, double porcentajeAdyacencia, int cantidadCorridas, String nombreSalida){
		// Inicializo las estadísticas
		Estadistica [] estadisticas = new Estadistica[3];
		estadisticas[0] = new Estadistica("Secuencial Aleatorio", cantidadNodos);
		estadisticas[1] = new Estadistica("Wellsh Powell", cantidadNodos);
		estadisticas[2] = new Estadistica("Matula", cantidadNodos);
		// Genero un grafo con esas caracteristicas
		GrafoNPND grafo = GeneradoraDeGrafos.generarGrafoPorcentajeDeAdyacencia(cantidadNodos, porcentajeAdyacencia);
		// Creo 'cantidadCorridas' grafos, los coloreo y obtengo sus estadisticas
		for(int i=0; i<cantidadCorridas; i++){
			if(i%100 == 0)
				System.out.println("Recoriendo " + i);
			// Coloreo el grafo
			grafo.colorearSecuencialAleatorio();
			// Actualizo las estadisticas
			actualizarEstadistica(estadisticas, 0, i+1, grafo.getCantidadDeColores());
			// Coloreo el grafo
			grafo.colorearWellshPowell();
			// Actualizo las estadisticas
			actualizarEstadistica(estadisticas, 1, i+1, grafo.getCantidadDeColores());
			// Coloreo el grafo
			grafo.colorearMatula();
			// Actualizo las estadisticas
			actualizarEstadistica(estadisticas, 2, i+1, grafo.getCantidadDeColores());
		}
		// Almaceno las estadisticas en un archivo
		try {
			FileWriter [] fw = new FileWriter[3];
			fw[0] = new FileWriter(nombreSalida+"SA.out");
			fw[1] = new FileWriter(nombreSalida+"WP.out");
			fw[2] = new FileWriter(nombreSalida+"MA.out");
			for(int i=0; i<3; i++){
				fw[i].write(estadisticas[i].getAlgoritmo() + "\r\n");
				fw[i].write(cantidadNodos + " " + String.format("%.2f", porcentajeAdyacencia) + " " + cantidadCorridas + "\r\n");
				for(int j=0; j<estadisticas[i].getFrecuencia().length; j++){
					if(estadisticas[i].getFrecuencia()[j]>0){
						fw[i].write(j + " " + estadisticas[i].getFrecuencia()[j] + " " + estadisticas[i].getPrimeraAparicion()[j] + "\r\n");
					}
				}
				fw[i].close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void calcularEstadisticaGrafosRegulares(int cantidadNodos, double porcentajeAdyacencia, int cantidadCorridas, String nombreSalida){
		// Inicializo las estadísticas
		Estadistica estadisticas = new Estadistica("Secuencial Aleatorio", cantidadNodos);
		// Genero un grafo con esas caracteristicas
		GrafoNPND grafo = GeneradoraDeGrafos.generarGrafoPorcentajeDeAdyacencia(cantidadNodos, porcentajeAdyacencia);
		// Creo 'cantidadCorridas' grafos, los coloreo y obtengo sus estadisticas
		for(int i=0; i<cantidadCorridas; i++){
			if(i%100 == 0)
				System.out.println("Recoriendo " + i);
			// Coloreo el grafo
			grafo.colorearSecuencialAleatorio();
			// Actualizo las estadisticas
			if(estadisticas.esLaPrimerAparicion(grafo.getCantidadDeColores()))
				estadisticas.setPrimeraApiricion(grafo.getCantidadDeColores(), i+1);
			estadisticas.aumentarFrecuencia(grafo.getCantidadDeColores());
		}
		// Almaceno las estadisticas en un archivo
		try {
			FileWriter fw = new FileWriter(nombreSalida+"SA.out");
			fw.write(estadisticas.getAlgoritmo() + "\r\n");
			fw.write(cantidadNodos + " " + String.format("%.2f", porcentajeAdyacencia) + " " + cantidadCorridas + "\r\n");
			for(int j=0; j<estadisticas.getFrecuencia().length; j++){
				if(estadisticas.getFrecuencia()[j]>0){
					fw.write(j + " " + estadisticas.getFrecuencia()[j] + " " + estadisticas.getPrimeraAparicion()[j] + "\r\n");
				}
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void actualizarEstadistica(Estadistica [] estadisticas, int algoritmo, int nroCorrida, int cantidadColoresObtenidos){
		if(estadisticas[algoritmo].esLaPrimerAparicion(cantidadColoresObtenidos))
			estadisticas[algoritmo].setPrimeraApiricion(cantidadColoresObtenidos, nroCorrida);
		estadisticas[algoritmo].aumentarFrecuencia(cantidadColoresObtenidos);
	}
	
//	public static void main(String[] args) {
//		CalculadoraDeEstadistica cde = new CalculadoraDeEstadistica();
//		System.out.println("aleatorio40");
//		cde.calcularEstadisticaGrafosAleatorios(600, 0.4, 10000, "aleatorio40");
//		System.out.println("aleatorio60");
//		cde.calcularEstadisticaGrafosAleatorios(600, 0.6, 10000, "aleatorio60");
//		System.out.println("aleatorio90");
//		cde.calcularEstadisticaGrafosAleatorios(600, 0.9, 10000, "aleatorio90");
//		System.out.println("regular50");
//		cde.calcularEstadisticaGrafosRegulares(1000, 0.5, 10000, "regular50");
//		System.out.println("regular75");
//		cde.calcularEstadisticaGrafosRegulares(1000, 0.75, 10000, "regular75");
//	}

}

class Estadistica{
	
	String algoritmo;
	int [] frecuencia;
	int [] primeraAparicion;
	
	public Estadistica(String algoritmo, int cantidadNodos){
		this.algoritmo = algoritmo;
		frecuencia = new int[cantidadNodos];
		primeraAparicion = new int[cantidadNodos];
	}
	
	public void aumentarFrecuencia(int cantidadColores){
		frecuencia[cantidadColores]++;
	}
	
	public boolean esLaPrimerAparicion(int cantidadColores){
		if(frecuencia[cantidadColores]==0)
			return true;
		return false;
	}
	
	public void setPrimeraApiricion(int cantidadColores, int nroCorrida){
		primeraAparicion[cantidadColores]=nroCorrida;
	}
	
	public String getAlgoritmo(){
		return algoritmo;
	}
	
	public int [] getFrecuencia(){
		return frecuencia;
	}
	
	public int [] getPrimeraAparicion(){
		return primeraAparicion;
	}
}