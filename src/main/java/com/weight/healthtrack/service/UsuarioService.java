package com.weight.healthtrack.service;

import com.weight.healthtrack.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private Usuario usuario = new Usuario("Eduardo", 75.0);

    public Usuario obtenerUsuario() {
        return usuario;
    }

    public void actualizarPeso(double nuevoPeso) {
        usuario.actualizarPeso(nuevoPeso);
    }
}
