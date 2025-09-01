package com.proyecto.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import com.proyecto.utilidad.Boton;
import com.proyecto.utilidad.CampoTexto;
import com.proyecto.utilidad.CompoMeu;
import com.proyecto.utilidad.Etiqueta;

public class Menu extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelRegistro;

    public Menu() {
        this.setTitle("Menu"); // TITULO DE LA VENTANA
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // SE HABRA LA VENTANA COMPLETA
        this.setLocationRelativeTo(null); // HACE QUE LA PANTALLA SALGA EN EL CENTRO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        this.setResizable(false); //PARA QUE EL USUARIO NO REDUZCA LA PANTALLA

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        // Ajusta el tamaño preferido del panelPrincipal
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1200, 900)); // ancho, alto total

        // Creamos el JScrollPane que envuelve a panelPrincipal
        JScrollPane scroll = new JScrollPane(panelPrincipal);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Ajustamos el tamaño del scroll para que ocupe toda la ventana
        scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
        

        // Agregamos el scroll al JFrame en lugar de agregar panelPrincipal directamente
        this.getContentPane().add(scroll);

        componentes();
        this.setVisible(true); // PARA HACER VISIBLE LA PANTALLA
    }

    private void componentes() {
        crearPanelSecundario();
        menu();
        campoTexto();
        botones();
        etiquetas();
        checkBox();
    }

    private void menu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu logo = new CompoMeu("ContactApp", 40, 40, 0, 0, Color.BLACK, 20, "Arial", "imagenes/logo.png", 80, 60).menuEncabezado();
        logo.setEnabled(false);
        menuBar.add(logo);

        JMenu crearContacto = new CompoMeu("Crear Contacto", 40, 40, 20, 20, Color.BLACK, 20, "Arial","imagenes/Mas.png", 40, 40).menuEncabezado();
        menuBar.add(crearContacto);

        JMenu buscar = new CompoMeu("Buscar", 40, 40, 20, 20, Color.BLACK, 20, "Arial", "imagenes/lupa.png", 40, 40)
                .menuEncabezado();
        menuBar.add(buscar);

        JMenu lista = new CompoMeu("Lista", 40, 40, 20, 20, Color.BLACK, 20, "Arial", "imagenes/lista.png", 40, 40)
                .menuEncabezado();
        menuBar.add(lista);

        JMenu actualizar = new CompoMeu("Actualizar", 40, 40, 20, 20, Color.BLACK, 20, "Arial",
                "imagenes/actuzalizar.png", 40, 40).menuEncabezado();
        menuBar.add(actualizar);

        JMenu eliminar = new CompoMeu("Eliminar", 40, 40, 40, 40, Color.BLACK, 20, "Arial", "imagenes/eliminar.png", 40,
                40).menuEncabezado();
        menuBar.add(eliminar);

        JMenu cerrarSesion = new CompoMeu("Cerrar Sesión", 40, 40, 20, 20, Color.BLACK, 20, "Arial","imagenes/cerrar sesion.png", 40, 40).menuEncabezado();
        menuBar.add(cerrarSesion);

        cerrarSesion.addMouseListener(new MouseAdapter() {
            
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    dispose();
                    new Login();
                }
            }
        });

        this.setJMenuBar(menuBar);
    }

    private void etiquetas(){
        JLabel saludo=new Etiqueta(1100, 0, 130, 120, "imagenes/bienvenido2.png").conImagen();
        panelPrincipal.add(saludo);

        JLabel crearCuenta= new Etiqueta("+ Crea un nuevo contacto",100, 0, 400, 200, Color.magenta, 30, "Berlin Sans FB Demi").normal();
        panelPrincipal.add(crearCuenta);

        //APARTIR DE AQUI VA ETIQUETAS FORMULARIOS
        JLabel contexto=new Etiqueta("Informacion del contacto",50, 0, 300, 100, Color.magenta,25, "Berlin Sans FB Demi").normal();
        panelRegistro.add(contexto);

        JLabel linea= new Etiqueta(10, 40, 930, 90, "imagenes/linea.png").conImagen();
        panelRegistro.add(linea);

        //APARTIR DE AQUI FORMULARIO DE REGISTRO
        JLabel nombre= new Etiqueta("Nombre: ", 50,100, 100, 90, Color.black,15,"Arial Black").normal();
        panelRegistro.add(nombre);

        JLabel apellidos= new Etiqueta("Apellidos: ", 550, 100, 100, 90, Color.BLACK, 15, "Arial Black").normal();
        panelRegistro.add(apellidos);

        JLabel numeroTelefonico=new Etiqueta("Numero Telefonico: ", 50,210, 200, 90, Color.black,15,"Arial Black").normal();
        panelRegistro.add(numeroTelefonico);

        JLabel direccion=new Etiqueta("Dirección: ", 550,210, 200, 90, Color.black,15,"Arial Black").normal();
        panelRegistro.add(direccion);

        JLabel correo=new Etiqueta("Correo Electronico: ", 50,320, 200, 90, Color.black,15,"Arial Black").normal();
        panelRegistro.add(correo);

        JLabel categoria=new Etiqueta("Categoria: ", 550,320, 200, 90, Color.black,15,"Arial Black").normal();
        panelRegistro.add(categoria);

        JLabel nota=new Etiqueta("Agregar una nota (es opcional): ",340 , 400, 500, 90, Color.black, 15, "Arial Black").normal();
        panelRegistro.add(nota);
    }

    public void campoTexto(){
        JTextField campoNombre=new CampoTexto(50, 160, 350, 35, "Arial", 15).campo();
        campoNombre=new CampoTexto(campoNombre,"Juan pepito").textoTemporal();
        panelRegistro.add(campoNombre);

        JTextField campoApellidos=new CampoTexto(550, 160, 350, 35, "Arial", 15).campo();
        campoApellidos=new CampoTexto(campoApellidos,"Perez Gomez").textoTemporal();
        panelRegistro.add(campoApellidos);

        JTextField campoTelefono=new CampoTexto(50, 270, 350, 35, "Arial", 15).campo();
        campoTelefono=new CampoTexto(campoTelefono, "993388920").textoTemporal();
        panelRegistro.add(campoTelefono);

        JTextField campoDirreccion=new CampoTexto(550, 270, 350, 35, "Arial", 15).campo();
        campoDirreccion=new CampoTexto(campoDirreccion,"av. industrial etc").textoTemporal();
        panelRegistro.add(campoDirreccion);

        JTextField campoCorreo=new CampoTexto(50, 380, 350, 35, "Arial", 15).campo();
        campoCorreo=new CampoTexto(campoCorreo,"juanperez@gmail.com").textoTemporal();
        panelRegistro.add(campoCorreo);

        JTextField campoNota= new CampoTexto(230, 470, 500, 90, "Arial", 20).campo();
        campoNota=new CampoTexto(campoNota,"Este es el contacto de un compa del trabajo").textoTemporal();
        panelRegistro.add(campoNota);
    }

    private void checkBox(){
        String [] categorias={"Elige una categoria: ","Escuela","Trabajo","Amigo","Familia"};

        JComboBox<String> campoCategoria = new JComboBox<>(categorias);
        campoCategoria.setBounds(550, 380, 350, 35);
        panelRegistro.add(campoCategoria);
    }

    private void botones(){
        JButton fotoPerfil=new Boton("Subir foto perfil", 50, 600, 200, 50, Color.ORANGE).normal();
        fotoPerfil=new Boton(fotoPerfil, "imagenes/foto perfil.png", 50, 50).conImagen();
        panelRegistro.add(fotoPerfil);

        JButton guardar= new Boton("Guardar", 500, 600, 200, 50, Color.magenta).normal();
        guardar=new Boton(guardar, "imagenes/guardar.png", 50, 50).conImagen();
        panelRegistro.add(guardar);

        JButton limpiar= new Boton("Limpiar", 710, 600, 200, 50, Color.RED).normal();
        limpiar=new Boton(limpiar, "imagenes/limpiar.png", 50, 50).conImagen();
        panelRegistro.add(limpiar);
    }

    private void crearPanelSecundario(){
        //TODO ESTO HACE QUE HAGA REDONDO LOS BORDES
        panelRegistro = new JPanel() {
            private int radio = 30; // radio de las esquinas

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fondo normal del panel
                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Borde redondeado negro
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(3)); // grosor del borde
                g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radio, radio);

                g2.dispose();
            }
        };

        panelRegistro.setLayout(null); // QUITA LA CONFIGURACION DETERMINADA DEL PANEL
        panelRegistro.setBackground(Color.white);
        panelRegistro.setBounds(200, 150, 950, 700);
        panelPrincipal.add(panelRegistro);
    }

}