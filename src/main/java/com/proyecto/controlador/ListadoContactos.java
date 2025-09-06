package com.proyecto.controlador;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.dao.ContactoDAO;
import com.proyecto.modelo.Contacto;
import com.proyecto.utilidad.Conexion;

public class ListadoContactos {

    public Object[][] datosContactos() {
        List<Contacto> listaContactos = new ArrayList<>();

        Connection conexion = Conexion.getInstancia().getConexion();

        try {
            listaContactos = new ContactoDAO().obtenerTodosLosContactos(conexion);
        } catch (Exception e) {
            System.out.println("Error al obtener los contactos: " + e.getMessage());
        }
        
        Conexion.getInstancia().cerrarConexion();

        // 🔹 Crear Object[][] con el tamaño de la lista
        Object[][] datos = new Object[listaContactos.size()][];

        // 🔹 Llenar el array con los datos de cada contacto
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto c = listaContactos.get(i);
            datos[i] = new Object[] {
                    c.getNombre(),
                    c.getApellidos(),
                    c.getNumeroTelefono(),
                    c.getDireccion(),
                    c.getCorreo(),
                    c.getCategoria(),
                    c.getFotoPerfil() // si quieres mostrar la ruta o null
            };
        }

        return datos;
    }
}