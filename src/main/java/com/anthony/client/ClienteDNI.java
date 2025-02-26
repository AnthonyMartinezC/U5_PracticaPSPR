package com.anthony.client;

import java.io.*;
import java.net.Socket;

public class ClienteDNI {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("🔵 Conectado al servidor");
            System.out.println("📩 " + entrada.readLine()); // Mensaje de bienvenida

            System.out.print("➡️ Ingrese su DNI (Ejemplo: 12345678Z): ");
            String dni = teclado.readLine();
            salida.println(dni); // Enviar DNI al servidor

            boolean esValido = Boolean.parseBoolean(entrada.readLine()); // Recibir "true" o "false"
            System.out.println(esValido ? "✅ DNI válido" : "❌ DNI inválido");

        } catch (IOException e) {
            System.err.println("❌ Error en la conexión con el servidor: " + e.getMessage());
        }
    }
}
