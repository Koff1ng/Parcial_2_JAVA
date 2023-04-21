package PARCIAL2; 
import java.util.Random;
public class Persona {
    private String nombre;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;
    private int dni;
    
    private static final char SEXO_POR_DEFECTO = 'H';
    private static final int PESO_IDEAL_BAJO = -1;
    private static final int PESO_IDEAL_NORMAL = 0;
    private static final int PESO_IDEAL_ALTO = 1;
    
    public Persona() {
        this("", 0, SEXO_POR_DEFECTO, 0, 0);
        generaDNI();
    }
    
    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
        generaDNI();
    }
    
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        generaDNI();
    }
    
    private char comprobarSexo(char sexo) {
        return sexo == 'M' || sexo == 'H' ? sexo : SEXO_POR_DEFECTO;
    }
    
    private void generaDNI() {
        Random rnd = new Random();
        this.dni = rnd.nextInt(90000000) + 10000000;
        this.dni = this.dni * 10 + letraDNI(this.dni);
    }
    
    private int letraDNI(int dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = dni % 23;
        return letras.charAt(indice);
    }
    
    public int calcularIMC() {
        double imc = peso / (altura * altura);
        if (imc < 20) {
            return PESO_IDEAL_BAJO;
        } else if (imc <= 25) {
            return PESO_IDEAL_NORMAL;
        } else {
            return PESO_IDEAL_ALTO;
        }
    }
    
    public boolean esMayorDeEdad() {
    	 return edad >= 18;
    }
   
    


   
    public String toString() {
        String estadoPeso;
        int estado = calcularIMC();
        switch (estado) {
            case PESO_IDEAL_BAJO:
                estadoPeso = "por debajo de su peso ideal";
                break;
            case PESO_IDEAL_NORMAL:
                estadoPeso = "en su peso ideal";
                break;
            case PESO_IDEAL_ALTO:
                estadoPeso = "con sobrepeso";
                break;
            default:
                estadoPeso = "con un estado de peso desconocido";
                break;
        }
        String estadoEdad = esMayorDeEdad() ? "mayor de edad" : "menor de edad";
        return "Nombre: " + nombre + "\n" +
               "Edad: " + edad + "\n" +
               "Sexo: " + sexo + "\n" +
               "Peso: " + peso + " kg\n" +
               "Altura: " + altura + " m\n" +
               "DNI: " + dni + "\n" +
               "Estado de peso: " + estadoPeso + "\n" +
               "Estado de edad: " + estadoEdad + "\n "
               	 ;}
}




