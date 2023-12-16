public class RelacionaisLogicos {

	public static void main(String[] args) {
		// Operadores Relacionais
		// > < <= >= !=  ==
		
		int num1, num2;
		
		// testando uma igualdade
		num1 = 10;
		num2 = 10;
		if (num1 == num2) {
			System.out.println("n�mero 1 e n�mero s�o iguais");
		}

		// testando uma desigualdade
		num1 = 10;
		num2 = 30;
		if (num1 != num2) {
			System.out.println("n�mero 1 e n�mero s�o diferentes");
		}
		// testando maior
		num1 = 10;
		num2 = 5;
		if (num1 > num2) {
			System.out.println("n�mero 1 � maior que n�mero 2");	
		} else {
			System.out.println("n�mero 2 � maior que n�mero 1");
		}
		
		// operadores l�gicos
		// && = e / AND  || = ou / OR
		num1 = 10;
		num2 = 5;
		int num3 = 20, num4 = 5;
		if ((num1 > num3) && (num2 == num4)) {
			System.out.println("Primeira op��o satisfeita");
		} else {
			System.out.println("Segunda op��o satisfeita");
		}
		
		num2 = 10;
		if ((num1 > num3) || (num2 == num4)) {
			System.out.println("Primeira op��o satisfeita");
		} else {
			System.out.println("Segunda op��o satisfeita");
		}
	}
}
