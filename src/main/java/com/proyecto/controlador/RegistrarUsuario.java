package com.proyecto.controlador;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import com.proyecto.dao.UsuarioDAO;
import com.proyecto.modelo.Usuario;
import com.proyecto.utilidad.Conexion;
import com.proyecto.utilidad.VentanaMensaje;
import com.proyecto.vista.Registrarse;

public class RegistrarUsuario implements ActionListener {

    private JButton registrar;
    private Registrarse ventana;

    public RegistrarUsuario(JButton registrar, Registrarse ventana) {

        this.registrar = registrar;
        this.ventana = ventana;

        this.registrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        Usuario usuario = Usuario.builder()
                .nombre(ventana.getNombre())
                .apellidos(ventana.getApellidos())
                .direccion(ventana.getDireccion())
                .numeroTelefono(ventana.getNumero())
                .correo(ventana.getCorreo())
                .contrasena(ventana.getContraseña())
                .build();

        if (!validarCampos(usuario)) {
            new VentanaMensaje("Por favor, completa todos los campos son obligatorios.","imagenes/UNA X.png");
            return;
        }

        if (!validarContrasena(usuario.getContrasena())) {
            new VentanaMensaje("La contraseña debe tener al menos 8 <br>caracteres.","imagenes/UNA X.png");
            return;
        }


        try {
            Connection conexion = Conexion.getInstancia().getConexion();

            boolean guardado = new UsuarioDAO().registrarUsuario(conexion, usuario);

            if (!guardado) {
                new VentanaMensaje("Error al registrar el usuario", "imagenes/UNA X.png");
                return;
            }

            ventana.limpiarCampos();
            new VentanaMensaje("Registro Exitoso", "imagenes/CORRECTO.png");

        } catch (SQLException ex) {
            System.out.print("error" + ex.getMessage());
        } finally {
            Conexion.getInstancia().cerrarConexion();
        }
    }

    private boolean validarCampos(Usuario usuario) {
        if (usuario.getNombre().isEmpty() ||
            usuario.getApellidos().isEmpty() ||
            usuario.getDireccion().isEmpty() ||
            usuario.getNumeroTelefono().isEmpty() ||
            usuario.getCorreo().isEmpty() ||
            usuario.getContrasena().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean validarContrasena(String contrasena) {
        return contrasena.length() >= 8;
    }



}
