package com.anthony.client;

import com.anthony.client.ClienteDNI;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static org.mockito.Mockito.*;


public class ClienteDNITest {
    @Test
    void testConexionClienteServidor() throws IOException {
        Socket mockSocket = mock(Socket.class);
        BufferedReader mockEntrada = mock(BufferedReader.class);
        PrintWriter mockSalida = mock(PrintWriter.class);

        when(mockEntrada.readLine()).thenReturn("Ingrese un DNI:", "true");

        ClienteDNI.main(null); // Simulación de ejecución del cliente

        verify(mockSalida, times(1)).println(anyString());
    }
}
