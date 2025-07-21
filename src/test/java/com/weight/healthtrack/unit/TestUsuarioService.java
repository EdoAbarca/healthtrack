package com.weight.healthtrack;

import com.weight.healthtrack.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioService();
    }

    @Test
    void testObtenerUsuario() {
        Usuario usuario = usuarioService.obtenerUsuario();
        assertNotNull(usuario);
        assertEquals("Eduardo", usuario.getNombre());
        assertEquals(75.0, usuario.getPeso());
    }

    @Test
    void testActualizarPeso() {
        usuarioService.actualizarPeso(85.0);
        assertEquals(85.0, usuarioService.obtenerUsuario().getPeso());
    }
}
