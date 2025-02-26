package com.anthony.server;

import com.anthony.server.ManejadorCliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServidorDNITest {
    @Test
    void testCalcularLetraDNI() {
        ManejadorCliente handler = new ManejadorCliente(null);

        assertEquals('Z', handler.calcularLetraDNI("12345678"));
        assertEquals('X', handler.calcularLetraDNI("98765432"));
        assertEquals('R', handler.calcularLetraDNI("12312312"));
    }

    @Test
    void testValidarFormatoDNI() {
        ManejadorCliente handler = new ManejadorCliente(null);

        assertTrue(handler.validarFormatoDNI("12345678Z"));
        assertFalse(handler.validarFormatoDNI("1234567Z"));
        assertFalse(handler.validarFormatoDNI("ABCDEFGHZ"));
    }

}
