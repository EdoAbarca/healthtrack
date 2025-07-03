package com.weight.healthtrack.model;
import com.weight.healthtrack.model.Usuario;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testActualizarPeso() {
        Usuario usuario = new Usuario("Eduardo", 75.0);
        usuario.actualizarPeso(80.0);
        assertEquals(80.0, usuario.getPeso());
    }

    @Test
    void testGetters() {
        Usuario usuario = new Usuario("Ana", 60.0);
        assertEquals("Ana", usuario.getNombre());
        assertEquals(60.0, usuario.getPeso());
    }
}
