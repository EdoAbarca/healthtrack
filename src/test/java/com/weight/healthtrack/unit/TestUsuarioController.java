package com.weight.healthtrack.controller;

import com.weight.healthtrack.model.Usuario;
import com.weight.healthtrack.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestUsuarioController {

    private UsuarioService usuarioService;
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        usuarioService = mock(UsuarioService.class);
        usuarioController = new UsuarioController(usuarioService);
    }

    @Test
    void testMostrarInformacion() {
        when(usuarioService.obtenerUsuario()).thenReturn(new Usuario("Eduardo", 75.0));
        ResponseEntity<?> response = usuarioController.mostrarInformacion();
        assertEquals(200, response.getStatusCodeValue());
        verify(usuarioService, times(1)).obtenerUsuario();
    }

    @Test
    void testActualizarPesoSuccess() {
        Map<String, Object> body = new HashMap<>();
        body.put("weight", 70.5);
        Usuario usuarioMock = new Usuario("Eduardo", 70.5);
        when(usuarioService.obtenerUsuario()).thenReturn(usuarioMock);

        ResponseEntity<?> response = usuarioController.actualizarPeso(body);

        assertEquals(200, response.getStatusCodeValue());

        Usuario usuario = (Usuario) response.getBody();
        assertEquals("Eduardo", usuario.getNombre());
        assertEquals(70.5, usuario.getPeso());

        verify(usuarioService, times(1)).actualizarPeso(70.5);
        verify(usuarioService, times(1)).obtenerUsuario();
    }


    @Test
    void testActualizarPesoMissingWeight() {
        Map<String, Object> body = new HashMap<>();
        ResponseEntity<?> response = usuarioController.actualizarPeso(body);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Missing 'weight' field in request body.", response.getBody());
    }

    @Test
    void testActualizarPesoInvalidWeight() {
        Map<String, Object> body = new HashMap<>();
        body.put("weight", "invalid");
        ResponseEntity<?> response = usuarioController.actualizarPeso(body);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("'weight' must be a valid number.", response.getBody());
    }

    @Test
    void testActualizarPesoNegativeWeight() {
        Map<String, Object> body = new HashMap<>();
        body.put("weight", -5);
        ResponseEntity<?> response = usuarioController.actualizarPeso(body);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("'weight' must be zero or positive.", response.getBody());
    }

    @Test
    void testActualizarPesoNullBody() {
        ResponseEntity<?> response = usuarioController.actualizarPeso(null);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Missing 'weight' field in request body.", response.getBody());
    }
}