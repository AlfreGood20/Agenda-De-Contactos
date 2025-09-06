package com.proyecto.vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.proyecto.controlador.ListadoContactos;
import com.proyecto.utilidad.Etiqueta;
import com.proyecto.utilidad.Tabla;

public class MostrarLista extends JFrame {

    private JPanel panel;

    public MostrarLista() {
        setTitle("Lista de contactos");
        setSize(1020, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // PARA QUE EL USUARIO NO REDUZCA LA PANTALLA

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        add(panel);

        componentes();
        setVisible(true);
    }

    private void componentes() {
        tabla();
        etiqueta();
    }

    private void etiqueta() {
        // Etiqueta superior
        JLabel etiqueta = new Etiqueta("Lista De Contactos", 10, 0, 200, 100, Color.BLACK,20, "Cooper Black").normal();
        panel.add(etiqueta);
    }

    private void tabla() {
        // Columnas
        String[] columnas = { "Nombre", "Apellidos", "Número teléfono", "Dirección", "Correo electrónico",
                "Categoría" };

        // Datos desde el controlador
        Object[][] datos = new ListadoContactos().datosContactos();

        // Crear JTable con los datos reales
        JTable tabla = new Tabla(columnas, datos, Color.BLACK, Color.WHITE, 16, "Cooper Black", 35, "Arial").tabla();

        // ScrollPane para la tabla
        JScrollPane scroll = new JScrollPane(tabla);

        // Ajustar tamaño y posición (ocupa todo el panel)
        scroll.setBounds(53, 80, 900, 500);

        panel.add(scroll);
    }

}