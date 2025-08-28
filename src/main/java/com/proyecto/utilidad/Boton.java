package com.proyecto.utilidad;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton {

    private String titulo;
    private int x;
    private int y;
    private int ancho;
    private int altura;
    private Color colorBoton;
    private JButton boton;
    private String url;

    public Boton(String titulo, int x, int y, int ancho, int altura, Color colorBoton) {
        this.titulo = titulo;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        this.colorBoton = colorBoton;
    }

    public Boton(String titulo, int x, int y, int ancho, int altura, Color colorBoton, JButton boton, String url) {
        this.titulo = titulo;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        this.colorBoton = colorBoton;
        this.boton = boton;
        this.url = url;
    }

    public JButton normal(){
        JButton boton=new JButton(titulo);
		boton.setBounds(x, y, ancho, altura);
		boton.setBackground(colorBoton);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //PONE EL LA MANITO DEL PUNTERO DEL MAUSE
		return boton;
    }

    public JButton conImagen(){
        ImageIcon imagen=new ImageIcon(url); // AGREGAMOS LA IMAGEN
		boton.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ancho,altura,Image.SCALE_FAST)));
		return boton;
    }
}