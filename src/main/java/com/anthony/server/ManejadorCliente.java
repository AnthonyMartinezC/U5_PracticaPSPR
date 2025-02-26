package com.anthony.server;

import java.io.*;
import java.net.Socket;

public class ManejadorCliente extends Thread {
    private final Socket socket;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            salida.println("Ingrese un DNI (Ejemplo: 12345678Z): ");
            String dni = entrada.readLine();

            boolean esValido = validarFormatoDNI(dni) && comprobarLetraDNI(dni);
            salida.println(esValido);

            System.out.println("📩 DNI recibido: " + dni + " | Estado: " + (esValido ? "✅ Válido" : "❌ Inválido"));
        } catch (IOException e) {
            System.err.println("❌ Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("❌ Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public boolean validarFormatoDNI(String dni) {
        return dni != null && dni.matches("\\d{8}[A-Za-z]");
    }

    private boolean comprobarLetraDNI(String dni) {
        String numeros = dni.substring(0, 8);
        char letraCalculada = calcularLetraDNI(numeros);
        char letraIngresada = Character.toUpperCase(dni.charAt(8));
        return letraCalculada == letraIngresada;
    }

    // Cambiar de protected a public
    public char calcularLetraDNI(String subCadenaNumeros) {
        int miDNI = Integer.parseInt(subCadenaNumeros);
        String asignarLetra = "TRWAGMYFPDXBNJZSQVHLCKE";
        return asignarLetra.charAt(miDNI % 23);
    }

}
