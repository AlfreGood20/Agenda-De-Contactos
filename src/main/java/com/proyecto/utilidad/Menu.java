package com.proyecto.utilidad;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class Menu {

    private String titulo;
    private int margenArriba;
    private int margenAbajo;
    private int margenIzquierda;
    private int margenDerecha;
    private Color colorLetras;
    private int tamañoLetra;
    private String tipografia;

    public Menu(String titulo, int margenArriba, int margenAbajo, int margenIzquierda, int margenDerecha, Color colorLetras,
            int tamañoLetra, String tipografia) {
        this.titulo = titulo;
        this.margenArriba = margenArriba;
        this.margenAbajo = margenAbajo;
        this.margenIzquierda = margenIzquierda;
        this.margenDerecha = margenDerecha;
        this.colorLetras = colorLetras;
        this.tamañoLetra = tamañoLetra;
        this.tipografia = tipografia;
    }

    public JMenu menuEncabezado() {
        JMenu menu = new JMenu(titulo);
        menu.setBorder(new EmptyBorder(margenArriba, margenIzquierda, margenAbajo, margenDerecha));
        menu.setFont(new Font(tipografia, Font.BOLD, tamañoLetra));
        menu.setForeground(colorLetras);
        return menu;
    }

    public  JMenuItem item() {
		JMenuItem item=new JMenuItem(titulo);
		item.setBorder(new EmptyBorder(margenArriba, margenIzquierda, margenAbajo, margenDerecha));
		item.setFont(new Font(tipografia, Font.BOLD, tamañoLetra));
		item.setForeground(colorLetras);
		return item;
	}
}