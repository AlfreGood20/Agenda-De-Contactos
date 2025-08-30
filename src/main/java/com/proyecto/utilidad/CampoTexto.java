package com.proyecto.utilidad;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CampoTexto {

    private int x;
    private int y;
    private int ancho;
    private int altura;
    private String tipoLetra;
    private int tamañoLetra;

    public CampoTexto(int x, int y, int ancho, int altura, String tipoLetra, int tamañoLetra) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        this.tipoLetra = tipoLetra;
        this.tamañoLetra = tamañoLetra;
    }

    public JTextField campo(){
        JTextField campo = new JTextField();
		campo.setBounds(x, y, ancho, altura);
		campo.setFont(new Font(tipoLetra, Font.BOLD, tamañoLetra));
		return campo;
    }

    public JPasswordField campoContraseña() {
        JPasswordField campo = new JPasswordField();
        campo.setBounds(x, y, ancho, altura);
        campo.setFont(new java.awt.Font(tipoLetra, java.awt.Font.PLAIN, tamañoLetra));
        return campo;
    }
}