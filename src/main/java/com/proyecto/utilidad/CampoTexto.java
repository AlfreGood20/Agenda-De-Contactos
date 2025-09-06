package com.proyecto.utilidad;

import java.awt.Color;
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

    private JTextField campo;
    private String texto;

    public CampoTexto(int x, int y, int ancho, int altura, String tipoLetra, int tamañoLetra) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        this.tipoLetra = tipoLetra;
        this.tamañoLetra = tamañoLetra;
    }

    

    public CampoTexto(JTextField campo, String texto) {
        this.campo = campo;
        this.texto = texto;
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

    public JTextField textoTemporal() {
    campo.setText(texto);
    campo.setForeground(Color.GRAY);

    campo.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (campo.getText().equals(texto)) {
                campo.setText("");
                campo.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (campo.getText().isEmpty()) {
                campo.setText(texto);
                campo.setForeground(Color.GRAY);
            }
        }
    });
    return campo;
}

}