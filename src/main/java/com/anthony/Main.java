package com.anthony;

import com.anthony.server.ServidorDNI;
import com.anthony.client.ClienteDNI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar Servidor");
        System.out.println("2. Iniciar Cliente");
        System.out.print("➡️ Opción: ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("🟢 Iniciando el servidor...");
                ServidorDNI.main(new String[]{}); // Llamar al servidor
                break;
            case 2:
                System.out.println("🟢 Iniciando el cliente...");
                ClienteDNI.main(new String[]{}); // Llamar al cliente
                break;
            default:
                System.out.println("❌ Opción no válida. Reinicie el programa.");
        }

        scanner.close();
    }
}
