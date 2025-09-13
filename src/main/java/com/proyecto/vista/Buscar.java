package com.proyecto.vista;

import javax.swing.*;

import com.proyecto.controlador.BuscarContactos;

import java.awt.*;
import java.awt.event.*;
public class Buscar extends JFrame{
    
    // Campo de búsqueda
    private JTextField campoNombreBusqueda;
    private JButton botonBuscar;

    // Campos de resultado
    private JTextField campoNombre, campoApellidos, campoTelefono, campoDireccion, campoCorreo;
    
    // Componentes para la barra personalizada
    private JPanel barraSuperior;
    private JButton botonCerrar, botonMinimizar;
    private Point puntoClick;
    
    // Colores y estilos
    private static Color colorFondo = Color.white;
    private static Color colorBoton = Color.decode("#2B7FFF"); //
    private static Color colorBotonTexto = Color.BLACK;
    private static Color colorTexto = Color.black;
    private static Font fuenteEtiqueta = new Font("Arial", Font.PLAIN, 14);
    private static Font fuenteBoton = new Font("Arial", Font.BOLD, 14);
    private static Dimension tamañoBoton = new Dimension(100, 30);
    private static Dimension tamañoCampoTexto = new Dimension(150, 25);

    public Buscar() {
        // Configuración básica de la ventana
        setUndecorated(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Crear barra superior personalizada
        crearBarraSuperior();
        
        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(colorFondo);
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new FlowLayout());
        panelBusqueda.setBackground(colorFondo);

        JLabel etiquetaBusqueda = new JLabel("Nombre:");
        campoNombreBusqueda = new JTextField(15);

        // Botón de búsqueda
        botonBuscar = new JButton("Buscar");


        aplicarEstiloEtiqueta(etiquetaBusqueda);
        aplicarEstiloCampoTexto(campoNombreBusqueda);
        aplicarEstiloBoton(botonBuscar);

        panelBusqueda.add(etiquetaBusqueda);
        panelBusqueda.add(campoNombreBusqueda);
        panelBusqueda.add(botonBuscar);

        // Panel de resultados como mini formulario
        JPanel panelResultado = new JPanel(new GridLayout(5, 2, 10, 10));
        panelResultado.setBackground(colorFondo);
        panelResultado.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Labels
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblApellidos = new JLabel("Apellidos:");
        JLabel lblTelefono = new JLabel("Teléfono:");
        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblCorreo = new JLabel("Correo:");

        // Campos de resultado
        campoNombre = new JTextField(); campoNombre.setEditable(false);
        campoApellidos = new JTextField(); campoApellidos.setEditable(false);
        campoTelefono = new JTextField(); campoTelefono.setEditable(false);
        campoDireccion = new JTextField(); campoDireccion.setEditable(false);
        campoCorreo = new JTextField(); campoCorreo.setEditable(false);

        // Aplicar estilos
        aplicarEstiloEtiqueta(lblNombre);
        aplicarEstiloEtiqueta(lblApellidos);
        aplicarEstiloEtiqueta(lblTelefono);
        aplicarEstiloEtiqueta(lblDireccion);
        aplicarEstiloEtiqueta(lblCorreo);

        aplicarEstiloCampoTexto(campoNombre);
        aplicarEstiloCampoTexto(campoApellidos);
        aplicarEstiloCampoTexto(campoTelefono);
        aplicarEstiloCampoTexto(campoDireccion);
        aplicarEstiloCampoTexto(campoCorreo);

        // Agregar al panel
        panelResultado.add(lblNombre); panelResultado.add(campoNombre);
        panelResultado.add(lblApellidos); panelResultado.add(campoApellidos);
        panelResultado.add(lblTelefono); panelResultado.add(campoTelefono);
        panelResultado.add(lblDireccion); panelResultado.add(campoDireccion);
        panelResultado.add(lblCorreo); panelResultado.add(campoCorreo);

        // Agregar paneles al principal
        panelPrincipal.add(panelBusqueda, BorderLayout.NORTH);
        panelPrincipal.add(panelResultado, BorderLayout.CENTER);

        add(panelPrincipal, BorderLayout.CENTER);

        setVisible(true);

        new BuscarContactos(botonBuscar, this);
    }
    
    private void crearBarraSuperior() {
        // Panel de barra superior
        barraSuperior = new JPanel();
        barraSuperior.setBackground(new Color(33, 150, 243)); // Color del borde superior
        barraSuperior.setLayout(new FlowLayout(FlowLayout.RIGHT));
        barraSuperior.setPreferredSize(new Dimension(getWidth(), 30));

        // Botón minimizar
        botonMinimizar = new JButton("_");
        botonMinimizar.setFocusPainted(false);
        botonMinimizar.setBorderPainted(false);
        botonMinimizar.setBackground(new Color(33, 150, 243));
        botonMinimizar.setForeground(Color.WHITE);

        botonMinimizar.addActionListener(e -> setState(JFrame.ICONIFIED));

        // Botón cerrar
        botonCerrar = new JButton("X");
        botonCerrar.setFocusPainted(false);
        botonCerrar.setBorderPainted(false);
        botonCerrar.setBackground(new Color(33, 150, 243));
        botonCerrar.setForeground(Color.WHITE);

        botonCerrar.addActionListener(e -> dispose());

        barraSuperior.add(botonMinimizar);
        barraSuperior.add(botonCerrar);

        // Permitir mover la ventana arrastrando la barra superior
        barraSuperior.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                puntoClick = e.getPoint();
            }
        });

        barraSuperior.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - puntoClick.x, p.y + e.getY() - puntoClick.y);
            }
        });

        add(barraSuperior, BorderLayout.NORTH);
    }
    
    // Métodos de estilo (similares a los de EstiloVentana)
    public static void aplicarEstiloBoton(JButton boton) {
        boton.setBackground(colorBoton);
        boton.setForeground(colorBotonTexto);
        boton.setFont(fuenteBoton);
        boton.setPreferredSize(tamañoBoton);
        boton.setFocusPainted(false);
    }

    public static void aplicarEstiloEtiqueta(JLabel etiqueta) {
        etiqueta.setFont(fuenteEtiqueta);
        etiqueta.setForeground(colorTexto);
    }

    public static void aplicarEstiloCampoTexto(JTextField campo) {
        campo.setFont(fuenteEtiqueta);
        campo.setPreferredSize(tamañoCampoTexto);
    }

    // ====== GETTERS ======
    public String getNombre() {
        return campoNombre.getText();
    }

    public String getApellidos() {
        return campoApellidos.getText();
    }

    public String getTelefono() {
        return campoTelefono.getText();
    }

    public String getDireccion() {
        return campoDireccion.getText();
    }

    public String getCorreo() {
        return campoCorreo.getText();
    }

    public String getNombreBusqueda() {
        return campoNombreBusqueda.getText();
    }

    // ====== SETTERS ======
    public void setNombre(String nombre) {
        campoNombre.setText(nombre);
    }

    public void setApellidos(String apellidos) {
        campoApellidos.setText(apellidos);
    }

    public void setTelefono(String telefono) {
        campoTelefono.setText(telefono);
    }

    public void setDireccion(String direccion) {
        campoDireccion.setText(direccion);
    }

    public void setCorreo(String correo) {
        campoCorreo.setText(correo);
    }

    public void setNombreBusqueda(String texto) {
        campoNombreBusqueda.setText(texto);
    }

    // ====== LIMPIAR CAMPOS ======
    public void limpiarCamposResultado() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoTelefono.setText("");
        campoDireccion.setText("");
        campoCorreo.setText("");
    }
}