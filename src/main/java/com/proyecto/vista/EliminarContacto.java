package com.proyecto.vista;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.proyecto.dao.ContactoDAO;
import com.proyecto.modelo.Contacto;
import com.proyecto.utilidad.Conexion;

public class EliminarContacto extends JFrame{

    private JTextField txtBuscar, txtNombre, txtApellidos, txtTelefono, txtCorreo, txtDireccion, txtCategoria;
    private JButton btnBuscar, btnEliminar;

    public EliminarContacto() {
        setTitle("Eliminar Contacto");
        setSize(450, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        this.setResizable(false);
        setLayout(null);

        // Campo de búsqueda
        JLabel lblBuscar = new JLabel("Buscar por Nombre:");
        lblBuscar.setBounds(30, 10, 150, 30);
        add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(180, 10, 150, 30);
        add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(340, 10, 80, 30);
        add(btnBuscar);

        btnBuscar.addActionListener(e -> {
            try (Connection conexion = Conexion.getInstancia().getConexion()) {

                ContactoDAO dao = new ContactoDAO();
                Contacto contacto = dao.obtenerContactoPorNombre(conexion, txtBuscar.getText());

                if (contacto != null) {
                    txtBuscar.setText("");
                    txtNombre.setText(contacto.getNombre());
                    txtApellidos.setText(contacto.getApellidos());
                    txtTelefono.setText(contacto.getNumeroTelefono());
                    txtCorreo.setText(contacto.getCorreo());
                    txtDireccion.setText(contacto.getDireccion());
                    txtCategoria.setText(contacto.getCategoria());
                } else {
                    JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al buscar: " + ex.getMessage());
            }

        });

        // Campos de contacto
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 50, 100, 30);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 50, 200, 30);
        txtNombre.setEditable(false);
        add(txtNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(30, 90, 100, 30);
        add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(150, 90, 200, 30);
        txtApellidos.setEditable(false);
        add(txtApellidos);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 130, 100, 30);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 130, 200, 30);
        txtTelefono.setEditable(false);
        add(txtTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(30, 170, 100, 30);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(150, 170, 200, 30);
        txtCorreo.setEditable(false);
        add(txtCorreo);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 210, 100, 30);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 210, 200, 30);
        txtDireccion.setEditable(false);
        add(txtDireccion);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(30, 250, 100, 30);
        add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(150, 250, 200, 30);
        txtCategoria.setEditable(false);
        add(txtCategoria);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(150, 300, 120, 40);
        add(btnEliminar);

        btnEliminar.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminarlo?", "",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                try (Connection conexion = Conexion.getInstancia().getConexion()) {

                    ContactoDAO dao = new ContactoDAO();
                    boolean eliminado = dao.eliminarContacto(conexion, txtNombre.getText());
                    if (eliminado) {
                        txtNombre.setText("");
                        txtApellidos.setText("");
                        txtDireccion.setText("");
                        txtCorreo.setText("");
                        txtTelefono.setText("");
                        txtCategoria.setText("");
                        JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el contacto.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
                }finally{
                    Conexion.getInstancia().cerrarConexion();
                }

            }

        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}