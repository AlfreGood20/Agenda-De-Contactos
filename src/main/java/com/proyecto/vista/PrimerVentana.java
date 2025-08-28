package com.proyecto.vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.proyecto.utilidad.Boton;
import com.proyecto.utilidad.Etiqueta;

public class PrimerVentana extends JFrame{

    private JPanel panel;

    public PrimerVentana(){
        this.setTitle("Primer ventana"); //TITULO DE LA VENTANA
        this.setSize(500, 500); //TAMAÑO DE LA VENTANA
        this.setLocationRelativeTo(null); // HACE QUE LA PANTALLA SALGA EN EL CENTRO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA

        panel= new JPanel(); //SE CREA EL PRINCIPAL PANEL
        panel.setBackground(Color.WHITE);  //COLOR DEL FONDO DEL PANEL
        panel.setLayout(null);  //QUITA LA CONFIGURACION DETERMINADA DEL PANEL
        this.getContentPane().add(panel); //AGREGAMOS EL PANEL AL JFRAME

        componentes();
        this.setVisible(true); // PARA HACER VISIBLE LA PANTALLA
    }

    private void componentes(){
        etiquetas();
        boton();
    }

    private void etiquetas(){
        JLabel etiqueta=new Etiqueta("Mi primera ventana", 100, 50, 300,100 , Color.BLACK, 30, "Arial").normal();
        panel.add(etiqueta); //AGREGAR ETIQUETA AL PANEL
    }

    private void boton(){
        JButton boton=new Boton("Da click aqui",130, 200, 100, 50, Color.GREEN).normal();
        panel.add(boton);
    }
}
