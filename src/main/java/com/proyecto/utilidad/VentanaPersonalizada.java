package com.proyecto.utilidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPersonalizada extends JFrame {

    private JPanel barraSuperior;
    private JButton botonCerrar, botonMinimizar;
    private Point puntoClick;

    public VentanaPersonalizada() {
        // Quitar los bordes por defecto
        setUndecorated(true);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de barra superior
        barraSuperior = new JPanel();
        barraSuperior.setBackground(new Color(33, 150, 243)); // Color del borde superior
        barraSuperior.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Botón minimizar
        botonMinimizar = new JButton("_");
        botonMinimizar.setFocusPainted(false);
        botonMinimizar.setBorderPainted(false);
        botonMinimizar.setBackground(new Color(33, 150, 243));
        botonMinimizar.setForeground(Color.WHITE);

        botonMinimizar.addActionListener(e -> setState(JFrame.ICONIFIED));

        // Botón cerrar
        botonCerrar = new JButton("X");
        botonCerrar.setFocusPainted(false);
        botonCerrar.setBorderPainted(false);
        botonCerrar.setBackground(new Color(33, 150, 243));
        botonCerrar.setForeground(Color.WHITE);

        botonCerrar.addActionListener(e -> dispose());

        barraSuperior.add(botonMinimizar);
        barraSuperior.add(botonCerrar);

        // Permitir mover la ventana arrastrando la barra superior
        barraSuperior.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                puntoClick = e.getPoint();
            }
        });

        barraSuperior.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - puntoClick.x, p.y + e.getY() - puntoClick.y);
            }
        });

        add(barraSuperior, BorderLayout.NORTH);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        add(panel, BorderLayout.CENTER);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPersonalizada().setVisible(true);
        });*/
}
