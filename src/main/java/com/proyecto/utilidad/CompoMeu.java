package com.proyecto.utilidad;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class CompoMeu {

    private String titulo;
    private int margenArriba;
    private int margenAbajo;
    private int margenIzquierda;
    private int margenDerecha;
    private Color colorLetras;
    private int tamañoLetra;
    private String tipografia;
    private String urlIcono; // nueva propiedad opcional para icono
    private int anchoIcono;
    private int altoIcono;

    //SIN ICONO
    public CompoMeu(String titulo, int margenArriba, int margenAbajo, int margenIzquierda, int margenDerecha,
            Color colorLetras, int tamañoLetra, String tipografia) {
        this.titulo = titulo;
        this.margenArriba = margenArriba;
        this.margenAbajo = margenAbajo;
        this.margenIzquierda = margenIzquierda;
        this.margenDerecha = margenDerecha;
        this.colorLetras = colorLetras;
        this.tamañoLetra = tamañoLetra;
        this.tipografia = tipografia;
    }

    public CompoMeu(String titulo, int margenArriba, int margenAbajo, int margenIzquierda, int margenDerecha,
            Color colorLetras, int tamañoLetra, String tipografia, String urlIcono, int anchoIcono, int altoIcono) {
        this(titulo, margenArriba, margenAbajo, margenIzquierda, margenDerecha, colorLetras, tamañoLetra, tipografia);
        this.urlIcono = urlIcono;
        this.anchoIcono = anchoIcono;
        this.altoIcono = altoIcono;
    }

    private ImageIcon getIcono() {
        if (urlIcono == null) return null;
        ImageIcon icono = new ImageIcon(urlIcono);
        Image img = icono.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public JMenu menuEncabezado() {
        JMenu menu = new JMenu(titulo);
        menu.setBorder(new EmptyBorder(margenArriba, margenIzquierda, margenAbajo, margenDerecha));
        menu.setFont(new Font(tipografia, Font.BOLD, tamañoLetra));
        menu.setForeground(colorLetras);

        if (urlIcono != null) {
            menu.setIcon(getIcono());
        }

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
