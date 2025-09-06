package com.proyecto.vista;


import javax.swing.*;

import com.proyecto.utilidad.EstiloVentana;
import com.proyecto.utilidad.VentanaPersonalizada;

import java.awt.*;

public class ActualizarContact extends VentanaPersonalizada {

    private JTextField campoNombre, campoApellidos, campoTelefono, campoDireccion, campoCorreo;
    private JButton botonActualizar;

    public ActualizarContact() {
        super(); 
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(EstiloVentana.colorFondo);
        panelCentral.setLayout(new BorderLayout(10, 10));

        
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBackground(EstiloVentana.colorFondo);

   
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblApellidos = new JLabel("Apellidos:");
        JLabel lblTelefono = new JLabel("Teléfono:");
        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblCorreo = new JLabel("Correo:");

        
        campoNombre = new JTextField();
        campoApellidos = new JTextField();
        campoTelefono = new JTextField();
        campoDireccion = new JTextField();
        campoCorreo = new JTextField();

        
        EstiloVentana.aplicarEstiloEtiqueta(lblNombre);
        EstiloVentana.aplicarEstiloEtiqueta(lblApellidos);
        EstiloVentana.aplicarEstiloEtiqueta(lblTelefono);
        EstiloVentana.aplicarEstiloEtiqueta(lblDireccion);
        EstiloVentana.aplicarEstiloEtiqueta(lblCorreo);

        EstiloVentana.aplicarEstiloCampoTexto(campoNombre);
        EstiloVentana.aplicarEstiloCampoTexto(campoApellidos);
        EstiloVentana.aplicarEstiloCampoTexto(campoTelefono);
        EstiloVentana.aplicarEstiloCampoTexto(campoDireccion);
        EstiloVentana.aplicarEstiloCampoTexto(campoCorreo);

        
        panelFormulario.add(lblNombre); panelFormulario.add(campoNombre);
        panelFormulario.add(lblApellidos); panelFormulario.add(campoApellidos);
        panelFormulario.add(lblTelefono); panelFormulario.add(campoTelefono);
        panelFormulario.add(lblDireccion); panelFormulario.add(campoDireccion);
        panelFormulario.add(lblCorreo); panelFormulario.add(campoCorreo);

       
        botonActualizar = new JButton("Actualizar Contacto");
        EstiloVentana.aplicarEstiloBoton(botonActualizar);

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(EstiloVentana.colorFondo);
        panelBoton.add(botonActualizar);

        
        panelCentral.add(panelFormulario, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);

        
        botonActualizar.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            if(nombre.isEmpty()){
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            } else {
                JOptionPane.showMessageDialog(null, "Contacto actualizado:\n" +
                        "Nombre: " + campoNombre.getText() + "\n" +
                        "Apellidos: " + campoApellidos.getText() + "\n" +
                        "Teléfono: " + campoTelefono.getText() + "\n" +
                        "Dirección: " + campoDireccion.getText() + "\n" +
                        "Correo: " + campoCorreo.getText());
            }
        });
        this.setVisible(true);
    }
}
