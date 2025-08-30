package com.proyecto.vista;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.proyecto.utilidad.Boton;
import com.proyecto.utilidad.CampoTexto;
import com.proyecto.utilidad.Etiqueta;


public class Login  extends JFrame{
    private JPanel panel;
    String Titulo_Ventana;
    String Titulo_Etiqueta;

   public Login(){

        this.setTitle("Login"); //TITULO DE LA VENTANA
        this.setSize(500, 500); //TAMAÑO DE LA VENTANA
        this.setLocationRelativeTo(null); // HACE QUE LA PANTALLA SALGA EN EL CENTRO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        this.setResizable(false);

        panel= new JPanel(); //SE CREA EL PRINCIPAL PANEL
        panel.setBackground(Color.WHITE);  //COLOR DEL FONDO DEL PANEL
        panel.setLayout(null);  //QUITA LA CONFIGURACION DETERMINADA DEL PANEL
        this.getContentPane().add(panel); //AGREGAMOS EL PANEL AL JFRAME

        componentes();
        this.setVisible(true); // PARA HACER VISIBLE LA PANTALLA
    }

    private void componentes(){
        etiqueta(); 
        botones();
        textField();
    }

    private void etiqueta(){
        JLabel etiquetaIniciarSesion=new Etiqueta("INICIAR SESIÓN",135, 10, 300,100 , Color.BLACK, 30, "Arial").normal(); 
        panel.add(etiquetaIniciarSesion); 

        JLabel correo= new Etiqueta("Correo Electronico",160,110,200,50,Color.black,20,"Arial").normal();
        panel.add(correo);

        JLabel contraseña= new Etiqueta("Contraseña", 190, 200,200, 50, Color.BLACK,20,"Arial").normal();
        panel.add(contraseña);
    }

    private void botones(){
        JButton entrar=new Boton("Entrar",150,300,200,50, Color.gray).normal();
        panel.add(entrar);

        JButton crearCuenta=new Boton("Crear cuenta",300,420,170,30, Color.gray).normal();
        crearCuenta=new Boton(crearCuenta, "imagenes/nuevo.png", 40,30).conImagen();
        panel.add(crearCuenta);
    }

    private void textField(){
        JTextField correo=new CampoTexto(150,150,200,30, "Arial", 15).campo();
        panel.add(correo);

        JPasswordField contraseña=new CampoTexto(150,240,200,30, "Arial", 15).campoContraseña();
        panel.add(contraseña);
    }
}