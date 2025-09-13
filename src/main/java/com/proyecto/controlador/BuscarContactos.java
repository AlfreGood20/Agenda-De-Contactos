package com.proyecto.controlador;

import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;

import com.proyecto.dao.ContactoDAO;
import com.proyecto.modelo.Contacto;
import com.proyecto.utilidad.Conexion;
import com.proyecto.utilidad.VentanaMensaje;
import com.proyecto.vista.Buscar;

public class BuscarContactos implements ActionListener {

    private JButton botonBuscar;
    private Buscar ventana;

    public BuscarContactos(JButton botonBuscar, Buscar ventana) {
        this.ventana = ventana;
        this.botonBuscar = botonBuscar;

        this.botonBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        
        String nombreBusqueda = ventana.getNombreBusqueda().trim();

        if(nombreBusqueda.isEmpty()) {
            new VentanaMensaje("Ingrese el nombre del contacto", "imagen/UNA X.png");
            return;
        }

        try{

            Connection conexion=Conexion.getInstancia().getConexion();

            Contacto contacto=new ContactoDAO().obtenerContactoPorNombre(conexion, nombreBusqueda);

            if(contacto==null){
                new VentanaMensaje("No se encontró ningún contacto con el nombre: " + nombreBusqueda, "imagen/UNA X.png");
                ventana.setNombre("");
                ventana.setApellidos("");
                ventana.setTelefono("");
                ventana.setDireccion("");
                ventana.setCorreo("");
                return;
            }

            ventana.setNombreBusqueda("");
            mostrarContacto(contacto);
        }catch(Exception ex) {
            new VentanaMensaje("Error al buscar el contacto: " + ex.getMessage(), "imagenes/UNA X.png");
            return;
        }finally{
            Conexion.getInstancia().cerrarConexion();
        }
    }

    private void mostrarContacto(Contacto contacto) {
        ventana.setNombre(contacto.getNombre());
        ventana.setApellidos(contacto.getApellidos());
        ventana.setTelefono(contacto.getNumeroTelefono());
        ventana.setDireccion(contacto.getDireccion());
        ventana.setCorreo(contacto.getCorreo());
    }

}
