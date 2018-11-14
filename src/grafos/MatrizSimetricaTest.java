package grafos;

public class MatrizSimetricaTest {

	public static void main(String[] args) {
		
		MatrizSimetrica matriz = new MatrizSimetrica(4);
		
		System.out.println(matriz);

		matriz.setValue(2,0, true);
		
		System.out.println(matriz);
		
		System.out.println(matriz.getValue(3, 0));
		
		//System.out.println(matriz.getValorMatrizTi(2, 0));
		
		

	}

}
