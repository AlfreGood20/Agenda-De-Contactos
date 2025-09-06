package com.proyecto.controlador;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.proyecto.dao.ContactoDAO;
import com.proyecto.modelo.Contacto;
import com.proyecto.utilidad.Conexion;
import com.proyecto.utilidad.VentanaMensaje;
import com.proyecto.vista.Menu;

public class RegistrarContacto implements ActionListener {

    private JButton guardar;
    private JButton limpiar;
    private JButton subirFoto;
    private Menu menu;

    public RegistrarContacto(JButton guardar, JButton limpiar, JButton subirFoto, Menu menu) {
        this.guardar = guardar;
        this.limpiar = limpiar;
        this.subirFoto = subirFoto;
        this.menu = menu;
        
        this.guardar.addActionListener(this);
        this.limpiar.addActionListener(this);
        this.subirFoto.addActionListener(this);
    }


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        if(e.getSource()==guardar){

            Contacto nuevoContacto = Contacto.builder()
                    .nombre(menu.getCampoNombre().getText())
                    .apellidos(menu.getCampoApellidos().getText())
                    .numeroTelefono(menu.getCampoTelefono().getText())
                    .direccion(menu.getCampoDireccion().getText())
                    .correo(menu.getCampoCorreo().getText())
                    .categoria((String) menu.getCampoCategoria().getSelectedItem())
                    .fotoPerfil(null) //POR HAORA ES NULL PQ NO FUNCIONA LA SUBIDA DE FOTO
                    .build();

            if (nuevoContacto.getNombre().isEmpty() ||
                nuevoContacto.getApellidos().isEmpty() ||
                nuevoContacto.getNumeroTelefono().isEmpty() ||
                nuevoContacto.getDireccion().isEmpty() ||
                nuevoContacto.getCorreo().isEmpty() ||
                nuevoContacto.getCategoria().equals("Elige una categoria: ")) {

                new VentanaMensaje("Por favor, completa todos los campos son obligatorios.","imagenes/UNA X.png");
                return;
            }

            //AQUI FUNCIONA LA BASE DE DATOS CON LA LIBRERIA
            Connection conexion=Conexion.getInstancia().getConexion();

            try {
                new ContactoDAO().registrarContacto(conexion, nuevoContacto); //libreria usandose
                new VentanaMensaje("Contacto registrado exitosamente.","imagenes/CORRECTO.png");
            } catch (SQLException Error) {
                new VentanaMensaje("Error al registrar el contacto: " + Error.getMessage(),"imagenes/UNA X.png");
                return;
            }

            Conexion.getInstancia().cerrarConexion();
            //CERRAR BASE DE DATOS SI NO HABRA CONFLICTOS
        }

        if (e.getSource() == limpiar) {
            menu.getCampoNombre().setText("");
            menu.getCampoApellidos().setText("");
            menu.getCampoTelefono().setText("");
            menu.getCampoDireccion().setText("");
            menu.getCampoCorreo().setText("");
            menu.getCampoNota().setText("");
            menu.getCampoCategoria().setSelectedIndex(0);
        }


        if(e.getSource()==subirFoto){
            JOptionPane.showMessageDialog(null, "Proximamente" );
        }
    }

}
