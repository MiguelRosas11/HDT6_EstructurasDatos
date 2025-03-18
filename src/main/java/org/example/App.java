package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione la implementación de Map para la Pokédex:");
        System.out.println("1) HashMap  2) TreeMap  3) LinkedHashMap");
        int choicePokedex = sc.nextInt();

        Mapa mapaPokedex;
        switch (choicePokedex) {
            case 1:
                mapaPokedex = new HashMapMapa();
                break;
            case 2:
                mapaPokedex = new TreeMapMapa();
                break;
            case 3:
                mapaPokedex = new LinkedHashMapMapa();
                break;
            default:
                System.out.println("Opción inválida, se usará HashMap por defecto.");
                mapaPokedex = new HashMapMapa();

        }
        int menu = 0;
        while(menu<1) {
            System.out.println("Bienvenido, ¿qué desea realizar? \n1. Agregar un pokemon a coleccion. \n2. Mostrar los datos de un pokemon ingresando su nombre. \n3. Mostrar el pokemones de la colección ordenados por tipo 1. \n4. Mostrar pokemones existentes ordenados por tipo 1. \n5. Buscar pokemones ingresando habilidad.");
            int opc = sc.nextInt(); sc.nextLine();
        }
    }
}
