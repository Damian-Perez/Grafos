package grafos;

import java.util.Arrays;

public class MatrizSimetrica {
	
	private boolean matSimetrica[];
	private int cantElementos;
	private int orden;
	
	// Crea una matriz simetrica de cantidad de elementos 
	public MatrizSimetrica(int orden){
		this.orden = orden;		
		this.cantElementos = (orden*(orden-1))/2;
		matSimetrica = new boolean[this.cantElementos];
		
		for(int i = 0; i < this.cantElementos; i++) {
			matSimetrica[i] = false;
		}
		/*
		for(int i = 0; i < this.orden; i++) {
			for(int j = 0; j < this.orden; j++) {
				
			}
		}*/
		
	}
	
	// Establece un valor en la matriz en la fila i columna j
	public void setValue(int i, int j, boolean value){
		if(i==j)
			return;
		
		if(i > j) {
			int aux = j;
			j = i;
			i = aux;
		}
		
		int posicion_vector = i * this.orden + j - ( (i*i) + 3 * i +2 ) / 2;
			
		matSimetrica[posicion_vector] = value;
		
		
		
		System.out.println(posicion_vector);
		System.out.println(i*(2*4-i-3)/2+j-1);
	}
	
	// Retorna el valor de la matrz en la fila i columna j
	public boolean getValue(int i, int j){
		if(i==j)
			return false;

		if(i > j) {
			int aux = j;
			j = i;
			i = aux;
		}
		
		int posicion_vector = i * this.orden + j - ( (i*i) + 3 * i +2 ) / 2;
		
		System.out.println(posicion_vector);
		
		return matSimetrica[posicion_vector];
	}

	@Override
	public String toString() {
		return "MatrizSimetrica [matSimetrica=" + Arrays.toString(matSimetrica) + ", cantElementos=" + cantElementos
				+ "]";
	}
	
//	// Devuelve la cantidad de elementos
//	public int getCantidadElementos(){
//		return cantElementos;
//	}
//	
//	// Devuelve la cantidad de 0 de la matriz
//	public int getVacios(){
//		int cantVacios = 0;
//		for(int i=0; i<matSimetrica.length; i++){
//			if(!matSimetrica[i])
//				cantVacios++;
//		}
//		return cantVacios;
//	}
//	
//	// Devuelve la cantidad de ocupados (distinto de 0) de la matriz
//	public int getOcupados(){
//		return matSimetrica.length-getVacios();
//	}
//	
//	// Devuelve el porcentaje de ocupados de la matriz
//	public double getPorcentajeOcupados(){
//		return getOcupados()/(double)matSimetrica.length;
//	}
	
	
}
