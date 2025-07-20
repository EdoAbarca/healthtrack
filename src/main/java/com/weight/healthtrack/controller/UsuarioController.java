package com.weight.healthtrack.service;

import com.weight.healthtrack.model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Map;

public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario")
    public String mostrarInformacion() {
        return usuarioService.obtenerUsuario();
    }

    @PatchMapping("/usuario/actualizar")
    public ResponseEntity<?> actualizarPeso(@RequestBody(required = false) Map<String, Object> body) {
        if (body == null || !body.containsKey("weight")) {
            return ResponseEntity.badRequest().body("Missing 'weight' field in request body.");
        }
        Object weightObj = body.get("weight");
        double peso;
        try {
            peso = Double.parseDouble(weightObj.toString());
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("'weight' must be a valid number.");
        }
        if (peso < 0) {
            return ResponseEntity.badRequest().body("'weight' must be zero or positive.");
        }
        usuarioService.actualizarPeso(peso);
        return ResponseEntity.ok(usuarioService.obtenerUsuario());
    }
}