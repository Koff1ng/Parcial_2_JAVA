package PARCIAL2;
import java.util.Scanner; 
	public class Punto1 {
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingresa una frase: ");
	        String frase = scanner.nextLine();

	        char[] arrayCaracteres = frase.toCharArray();

	        for (char c : arrayCaracteres) {
	            System.out.println(c);
	        }
	        scanner.close();
	    }
		
	}
	
	
