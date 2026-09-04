package co.edu.unicordoba.registro_visitantes.modelo;

import co.edu.unicordoba.registro_visitantes.util.TextoUtil;

public class Visitante {

    private final int id;
    public final String nombre;
    public final int edad;

    private static int totalCreados;
    public static final int EDAD_MINIMA=18;
    static{
        totalCreados = 0;
    }

    public Visitante(String nombre, int edad){
        totalCreados++;
        this.id = totalCreados;

        this.nombre = TextoUtil.normalizarNombre(nombre);
        this.edad = edad;
    }

    public boolean esMayorDeEdad(){
        return this.edad>= EDAD_MINIMA;
    }

    public static int getTotalCreados(){
        return totalCreados;
    }
    
}