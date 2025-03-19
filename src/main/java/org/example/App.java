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
        System.out.println("1. HashMap  \n2. TreeMap  \n3. LinkedHashMap");
        int choicePokedex = sc.nextInt();


        Usuario user;
        Mapa mapaPokedex;
        switch (choicePokedex) {
            case 1:
                mapaPokedex = new HashMapMapa();
                user = new Usuario(new HashMapMapa());
                break;
            case 2:
                mapaPokedex = new TreeMapMapa();
                user = new Usuario(new TreeMapMapa());
                break;
            case 3:
                mapaPokedex = new LinkedHashMapMapa();
                user = new Usuario(new LinkedHashMapMapa());
                break;
            default:
                System.out.println("Opción inválida, se usará HashMap por defecto.");
                mapaPokedex = new HashMapMapa();
                user = new Usuario(new HashMapMapa());

        }

        Pokedex pokedex = new Pokedex(mapaPokedex);

        int menu = 0;
        while(menu<1) {
            System.out.println("Bienvenido, ¿qué desea realizar? \n1. Agregar un pokemon a coleccion. \n2. Mostrar los datos de un pokemon ingresando su nombre. \n3. Mostrar el pokemones de la colección ordenados por tipo 1. \n4. Mostrar pokemones existentes ordenados por tipo 1. \n5. Buscar pokemones ingresando habilidad.");
            int opc = sc.nextInt(); sc.nextLine();
            if(opc == 1){
                System.out.println("Introduzca el nombre del pokemon");
                String name = sc.nextLine();
                user.AgregarPokemon(name, pokedex);

            }
            else if (opc == 2){
                System.out.println("Introduzca el nombre del pokemon del cual quiere información");
                String name = sc.nextLine();
                pokedex.buscarPorNombre(name);

            }

            else if (opc == 3){
                user.mostrarColeccionOrdenadaPorTipo();

            }

            else if (opc == 4){
                pokedex.mostrarTodosOrdenadosPorTipo();

            }

            else if (opc == 5){
                System.out.println("Ingrese la habilidad que desea encontrar");
                String habilidad = sc.nextLine();
                pokedex.buscarPorHabilidad(habilidad);

            }

            else if (opc == 6){
                System.out.println("Gracias por utilizar el programa");
                menu += 1;
            }
            else {
                System.out.println("Por favor introduzca una opción válida");
            }
        }
    }
}
