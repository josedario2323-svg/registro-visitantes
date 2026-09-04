package co.edu.unicordoba.registro_visitantes.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicordoba.registro_visitantes.modelo.Visitante;

@Service
public class VisitanteService {
    private final List<Visitante> reg = new ArrayList<>();
    public Visitante registrar(String nombre, int edad){
        Visitante v = new Visitante(nombre, edad);
        reg.add(v);
        return v;
    }

    public List<Visitante> listar(){
        return List.copyOf(reg);
    }

    public int contarRegistrados(){
        return reg.size();
    }

    public int contarCreadoEnLaClase(){
        return Visitante.getTotalCreados();
    }
}