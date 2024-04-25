/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 1066839260
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;





public class Principal {
    private static ArrayList<Contacto> listaContactos = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println( "Zona Virtual S.A");
      
            System.out.println("1. Agregar un Nuevo Contacto");
            System.out.println("2. Mostrar Lista de Contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por Burbuja   los nombres");
            System.out.println("5. Ordenar por Inserción  números Telefónicos");
            System.out.println("6. Salir");
            System.out.println("Ingrese su opción:");

            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarListaContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    ordenarPorNombre();
                    break;
                case 5:
                    ordenarPorTelefono();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 6.");
            }
        } while (opcion != 6);
    }

    private static void agregarContacto() {
        System.out.println("Ingrese el nombre del contacto:");
        String nombre = scan.nextLine();
        System.out.println("Ingrese el número de teléfono del contacto:");
        int telefono = scan.nextInt();
        scan.nextLine(); 

        Contacto nuevoContacto = new Contacto(nombre, telefono);
        listaContactos.add(nuevoContacto);
        System.out.println("Contacto agregado correctamente.");
    }

    private static void mostrarListaContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía.");
        } else {
            System.out.println("Lista de Contactos:");
            for (int i = 0; i < listaContactos.size(); i++) {
                Contacto contacto = listaContactos.get(i);
                System.out.println((i + 1) + ". " + contacto.getNombre() + " - " + contacto.getNumeroTelefono());
            }
        }
    }

    private static void buscarContacto() {
        System.out.println("Ingrese el nombre del contacto a buscar:");
        String nombreBuscar = scan.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("Contacto encontrado:");
                System.out.println(contacto.getNombre() + " - " + contacto.getNumeroTelefono());
                encontrado = true;
                
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se encuentra en la lista.");
        }
    }

    private static void ordenarPorNombre() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos para ordenar.");
            return;
        }

        Collections.sort(listaContactos, (c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));

        System.out.println("Lista de Contactos ordenada por nombre:");
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            System.out.println((i + 1) + ". " + contacto.getNombre() + " - " + contacto.getNumeroTelefono());
        }
    }

    private static void ordenarPorTelefono() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos para ordenar.");
            return;
        }

        Collections.sort(listaContactos, (c1, c2) -> Integer.compare(c1.getNumeroTelefono(), c2.getNumeroTelefono()));

        System.out.println("Lista de telefonos ordenada por nombres:");
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            System.out.println((i + 1) + ". " + contacto.getNombre() + " - " + contacto.getNumeroTelefono());
        }
    }
}

