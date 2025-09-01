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
        this.setSize(520, 420); //TAMAÑO DE LA VENTANA
        this.setLocationRelativeTo(null); // HACE QUE LA PANTALLA SALGA EN EL CENTRO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        this.setResizable(false);

        panel= new JPanel(); //SE CREA EL PRINCIPAL PANEL
        panel.setBackground(Color.decode("#FFF8DC"));  //COLOR DEL FONDO DEL PANEL
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
        JLabel titulo = new Etiqueta("INICIAR SESIÓN", 105, 20, 300, 50, Color.BLACK, 32, "Arial Black").normal(); 
        panel.add(titulo);

        JLabel correo = new Etiqueta("Correo electrónico", 150, 90, 200, 30, Color.BLACK, 18, "Arial").normal();
        panel.add(correo);

        JLabel contraseña = new Etiqueta("Contraseña", 150, 170, 200, 30, Color.BLACK, 18, "Arial").normal();
        panel.add(contraseña);

        JLabel avatarUsuario= new Etiqueta(110, 120, 30, 30,"imagenes/usuario.png").conImagen();
        panel.add(avatarUsuario);

        JLabel avatarCandado= new Etiqueta(110, 200, 30, 30,"imagenes/candado.png").conImagen();
        panel.add(avatarCandado);
    }

    private void botones(){
        JButton entrar=new Boton("Entrar",150, 250, 200, 40, Color.decode("#00BFFF")).normal();
        entrar.setForeground(Color.WHITE);
        panel.add(entrar);

        entrar.addActionListener(e -> {
            this.setVisible(false);
            new Menu();
        });

        JButton crearCuenta=new Boton("<html><u>Crea una cuenta aqui</u></html>",170, 310, 160, 30, Color.white).normal();
        crearCuenta.setForeground(Color.BLUE);
        crearCuenta.setBorderPainted(false);
        crearCuenta.setFocusPainted(false);
        crearCuenta.setContentAreaFilled(false);
        panel.add(crearCuenta);

        crearCuenta.addActionListener(e -> {
            this.setVisible(false);
            new Registrarse();
        });
    }

    private void textField(){
        JTextField campoCorreo = new CampoTexto(150, 120, 200, 30, "Arial", 15).campo();
        campoCorreo=new CampoTexto(campoCorreo,"ejemplo@gmail.com").textoTemporal();
        panel.add(campoCorreo);

        JPasswordField campoContraseña = new CampoTexto(150, 200, 200, 30, "Arial", 15).campoContraseña();
        campoContraseña.setEchoChar('*');
        panel.add(campoContraseña);
    }

}