package com.proyecto.utilidad;

import javax.swing.*;
import java.awt.*;


public class VentanaMensaje extends JFrame{

    public VentanaMensaje(String mensaje, String url) {
        setTitle("Mensaje");
        setSize(400, 250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); //PARA QUE EL USUARIO NO REDUZCA LA PANTALLA
        setLayout(null);
        setType(JFrame.Type.UTILITY);

        // Crear un ImageIcon desde la URL
        JLabel icon=new Etiqueta(140, 20, 100, 100, url).conImagen();
        add(icon);

        JLabel mandarMensaje=new Etiqueta("<html>"+mensaje+"</html>", 0, 110, 380, 100, Color.BLACK, 20, "Arial").normal();
        add(mandarMensaje);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar, BorderLayout.SOUTH);

        setVisible(true);
    }
}