package com.proyecto.utilidad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EstiloVentana {

   public static Color colorFondo;
   public static Color colorBoton;
   public static Color colorBotonTexto;
   public static Color colorTexto;
   public static Font fuenteTitulo;
   public static Font fuenteEtiqueta;
   public static Font fuenteBoton;
   public static Font fuenteAreaTexto;
   public static Dimension tamanoBoton;         
   public static Dimension tamanoCampoTexto;    
   static {
      colorFondo = Color.white;
      colorBoton = Color.GRAY;
      colorBotonTexto = Color.BLACK;
      colorTexto = Color.black;
      fuenteTitulo = new Font("Arial", 2, 18);
      fuenteEtiqueta = new Font("Arial", 0, 14);
      fuenteBoton = new Font("Arial", 1, 14);
      fuenteAreaTexto = new Font("Consolas", 0, 12);
      tamanoBoton = new Dimension(100, 30);         
      tamanoCampoTexto = new Dimension(150, 25);  
   }

   public EstiloVentana() {
   }

   public static void aplicarEstiloBoton(JButton boton) {
      boton.setBackground(colorBoton);
      boton.setForeground(colorBotonTexto);
      boton.setFont(fuenteBoton);
      boton.setPreferredSize(tamanoBoton);   
      boton.setFocusPainted(false);
   }

   public static void aplicarEstiloEtiqueta(JLabel etiqueta) {
      etiqueta.setFont(fuenteEtiqueta);
      etiqueta.setForeground(colorTexto);
   }

   public static void aplicarEstiloCampoTexto(JTextField campo) {
      campo.setFont(fuenteEtiqueta);
      campo.setPreferredSize(tamanoCampoTexto);    
   }

   public static void aplicarEstiloAreaTexto(JTextArea area) {
      area.setFont(fuenteAreaTexto);
      area.setForeground(colorTexto);
      area.setBackground(Color.DARK_GRAY);
      area.setLineWrap(true);
      area.setWrapStyleWord(true);
   }

   public static void aplicarEstiloVentana(JFrame ventana) {
      ventana.getContentPane().setBackground(colorFondo);
   }

   public static void setColores(Color fondo, Color boton, Color botonTexto, Color texto) {
      colorFondo = fondo;
      colorBoton = boton;
      colorBotonTexto = botonTexto;
      colorTexto = texto;
   }

   public static void setFuentes(Font titulo, Font etiqueta, Font boton, Font areaTexto) {
      fuenteTitulo = titulo;
      fuenteEtiqueta = etiqueta;
      fuenteBoton = boton;
      fuenteAreaTexto = areaTexto;
   }
}
