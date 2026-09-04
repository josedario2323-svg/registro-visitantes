package co.edu.unicordoba.registro_visitantes.controlador;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicordoba.registro_visitantes.modelo.Visitante;
import co.edu.unicordoba.registro_visitantes.servicio.VisitanteService;
import co.edu.unicordoba.registro_visitantes.util.TextoUtil;


@RestController
@RequestMapping("/api/visitantes")
public class VisitanteController {
    private final VisitanteService servicio;

    public VisitanteController(VisitanteService servicio){
        this.servicio = servicio;
    }

    @PostMapping
    public Visitante registrar(@RequestParam String nombre, @RequestParam int edad){
        return servicio.registrar(nombre, edad);
    }

    @GetMapping
    public List<Visitante> listar(){
        return servicio.listar();
    }
    @GetMapping("/conteos")
    public Map<String, Object> conteos() {
        Map<String, Object> r = new LinkedHashMap<>();
        r.put("registradosEnElServicio", servicio.contarRegistrados());
        r.put("creadosEnLaClase", servicio.contarCreadoEnLaClase());
        r.put("edadMinima", Visitante.EDAD_MINIMA);
        return r;
    }
    @GetMapping("/normalizar")
    public Map<String, String> normalizar(@RequestParam String texto) {
        Map<String, String> r = new LinkedHashMap<>();
        return Map.of("normalizado", TextoUtil.normalizarNombre(texto));
    }
}
