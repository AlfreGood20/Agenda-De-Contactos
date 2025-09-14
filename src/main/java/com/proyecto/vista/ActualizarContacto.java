package com.proyecto.vista;

import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.proyecto.dao.ContactoDAO;
import com.proyecto.modelo.Contacto;
import com.proyecto.utilidad.Conexion;

public class ActualizarContacto extends JFrame{

    private JTextField txtBuscar, txtNombre, txtApellidos, txtTelefono, txtCorreo, txtDireccion, txtCategoria;
    private JButton btnBuscar, btnActualizar;

    public ActualizarContacto() {
        setTitle("Actualizar Contacto");
        setSize(450, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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
        add(txtApellidos);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 130, 100, 30);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 130, 200, 30);
        add(txtTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(30, 170, 100, 30);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(150, 170, 200, 30);
        add(txtCorreo);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 210, 100, 30);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 210, 200, 30);
        add(txtDireccion);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(30, 250, 100, 30);
        add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(150, 250, 200, 30);
        add(txtCategoria);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(150, 300, 120, 40);
        add(btnActualizar);

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
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al buscar: " + ex.getMessage());
            }

        });

        // Evento del botón
        btnActualizar.addActionListener(e -> {
            try (Connection conexion = Conexion.getInstancia().getConexion()) {

                Contacto contacto = new Contacto();
                contacto.setNombre(txtNombre.getText());
                contacto.setApellidos(txtApellidos.getText());
                contacto.setNumeroTelefono(txtTelefono.getText());
                contacto.setCorreo(txtCorreo.getText());
                contacto.setDireccion(txtDireccion.getText());
                contacto.setCategoria(txtCategoria.getText());

                boolean actualizado = new ContactoDAO().actualizarContacto(conexion, contacto);

                if (actualizado) {
                    txtNombre.setText("");
                    txtApellidos.setText("");
                    txtDireccion.setText("");
                    txtCorreo.setText("");
                    txtTelefono.setText("");
                    txtCategoria.setText("");
                    JOptionPane.showMessageDialog(null, "Contacto actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el contacto.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}