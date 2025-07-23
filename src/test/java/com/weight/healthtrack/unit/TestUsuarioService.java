package com.weight.healthtrack.unit;

import com.weight.healthtrack.service.UsuarioService;
import com.weight.healthtrack.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
public class TestUsuarioService {

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
