package com.proyecto.utilidad;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

public class Tabla {

    private String [] columnas;
    private Object [][] datos;
    private Color colorLetras;
    private Color colorFondo;
    private int tamañoLetra;
    private String tipografiaEncabezado;
    private int alturaFilas;
    private String tipografiaDatos;

    public Tabla(String[] columnas, Object[][] datos, Color colorLetras, Color colorFondo, int tamañoLetra,
            String tipografiaEncabezado, int alturaFilas, String tipografiaDatos) {
        this.columnas = columnas;
        this.datos = datos;
        this.colorLetras = colorLetras;
        this.colorFondo = colorFondo;
        this.tamañoLetra = tamañoLetra;
        this.tipografiaEncabezado = tipografiaEncabezado;
        this.alturaFilas = alturaFilas;
        this.tipografiaDatos = tipografiaDatos;
    }

    public JTable tabla(){
        JTable tabla = new JTable(datos, columnas);

        // Encabezados de la tabla
        tabla.getTableHeader().setFont(new Font(tipografiaEncabezado, Font.BOLD, tamañoLetra));
        tabla.getTableHeader().setBackground(colorFondo);
        tabla.getTableHeader().setForeground(colorLetras);

        // Datos de la tabla
        tabla.setFont(new Font(tipografiaDatos, Font.BOLD, tamañoLetra));
        tabla.setRowHeight(alturaFilas);

        return tabla;
    }

    
}
