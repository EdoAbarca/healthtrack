
package com.ejemplo.servicio;

import com.ejemplo.modelo.Usuario;
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
