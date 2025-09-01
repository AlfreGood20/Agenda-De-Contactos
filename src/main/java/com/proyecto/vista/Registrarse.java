package com.proyecto.vista;

import java.awt.Color;

import javax.swing.*;

import com.proyecto.utilidad.Boton;
import com.proyecto.utilidad.CampoTexto;
import com.proyecto.utilidad.Etiqueta;

public class Registrarse extends JFrame {
    private JPanel panel;

    public Registrarse() {
        this.setTitle("Primer ventana"); // TITULO DE LA VENTANA
        this.setSize(500, 550); // TAMAÑO DE LA VENTANA
        this.setLocationRelativeTo(null); // HACE QUE LA PANTALLA SALGA EN EL CENTRO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        this.setResizable(false);

        panel = new JPanel(); // SE CREA EL PRINCIPAL PANEL
        panel.setBackground(Color.decode("#FFF8DC")); // COLOR DEL FONDO DEL PANEL
        panel.setLayout(null); // QUITA LA CONFIGURACION DETERMINADA DEL PANEL
        this.getContentPane().add(panel); // AGREGAMOS EL PANEL AL JFRAME

        componentes();
        this.setVisible(true);
    }

    private void componentes() {
        etiquetas();
        botones();
        campos();
    }

    private void etiquetas() {
        JLabel contexto = new Etiqueta("Registrarse", 180, 0, 200, 100, Color.BLACK, 25, "Berlin Sans FB Demi").normal();
        panel.add(contexto);

        // Etiquetas del formulario
        JLabel nombre = new Etiqueta("Nombre:",50, 100, 150, 30,Color.BLACK,16,"Arial Black").normal();
        panel.add(nombre);

        JLabel apellidos = new Etiqueta("Apellidos:",50, 150, 150, 30,Color.BLACK,16,"Arial Black").normal();
        panel.add(apellidos);

        JLabel numero = new Etiqueta("Número:",50, 200, 150, 30,Color.BLACK,16,"Arial Black").normal();
        panel.add(numero);

        JLabel direccion = new Etiqueta("Dirección:",50, 250, 150, 30,Color.BLACK,16,"Arial Black").normal();
        panel.add(direccion);

        JLabel correo = new Etiqueta("Correo:",50, 300, 150, 30,Color.BLACK,16,"Arial Black").normal();
        panel.add(correo);

        JLabel contraseña = new Etiqueta("Contraseña:",50, 350, 150, 30,Color.BLACK,16, "Arial Black").normal();
        panel.add(contraseña);
    }

    private void botones() {
        JButton botonRegistrarse= new Boton("Registrarse", 180, 430, 180, 50, Color.ORANGE).normal();
        botonRegistrarse=new Boton(botonRegistrarse,"imagenes/registro.png", 50, 50).conImagen();
        botonRegistrarse.setForeground(Color.WHITE);
        panel.add(botonRegistrarse);

        JButton botonRegresar= new Boton("",0 , 430, 150, 50, Color.white).normal();
        botonRegresar=new Boton(botonRegresar, "imagenes/regresar2.png", 40, 40).conImagen();
        botonRegresar.setBorderPainted(false);
        botonRegresar.setFocusPainted(false);
        botonRegresar.setContentAreaFilled(false);
        panel.add(botonRegresar);

        botonRegresar.addActionListener(e ->{
            this.setVisible(false);
            new Login();
        });
    }

    private void campos() {

        // Nombre
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(200, 100, 200, 30);
        campoNombre = new CampoTexto(campoNombre, "Ej: Juan").textoTemporal();
        panel.add(campoNombre);

        // Apellidos
        JTextField campoApellidos = new JTextField();
        campoApellidos.setBounds(200, 150, 200, 30);
        campoApellidos = new CampoTexto(campoApellidos, "Ej: Pérez García").textoTemporal();
        panel.add(campoApellidos);

        // Número
        JTextField campoNumero = new JTextField();
        campoNumero.setBounds(200, 200, 200, 30);
        campoNumero = new CampoTexto(campoNumero, "Ej: 5512345678").textoTemporal();
        panel.add(campoNumero);

        // Dirección
        JTextField campoDireccion = new JTextField();
        campoDireccion.setBounds(200, 250, 200, 30);
        campoDireccion = new CampoTexto(campoDireccion, "Ej: Av. Reforma #123").textoTemporal();
        panel.add(campoDireccion);

        // Correo
        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(200, 300, 200, 30);
        campoCorreo = new CampoTexto(campoCorreo, "Ej: usuario@mail.com").textoTemporal();
        panel.add(campoCorreo);

        JPasswordField campoContraseña = new JPasswordField();
        campoContraseña.setBounds(200, 350, 200, 30);
        panel.add(campoContraseña);
    }
}
