package co.edu.unicordoba.registro_visitantes.controlador;
import co.edu.unicordoba.registro_visitantes.modelo.Visitante;
import co.edu.unicordoba.registro_visitantes.servicio.VisitanteService;
import co.edu.unicordoba.registro_visitantes.util.TextoUtil;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/visitantes")
public class VisitanteController {
    private final VisitanteService servicio;

    // Inyección por constructor
    public VisitanteController(VisitanteService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public Visitante registrar(@RequestBody Map<String, Object> body) {
        String nombre = (String) body.get("nombre");
        int edad = Integer.parseInt(body.get("edad").toString());
        return servicio.registrar(nombre, edad);
    }

    @GetMapping
    public List<Visitante> listar() {
        return servicio.listar();
    }

    @GetMapping("/conteos")
    public Map<String, Object> conteos() {
        Map<String, Object> r = new LinkedHashMap<>();
        r.put("registradosEnElServicio", servicio.contarRegistrados());
        r.put("creadosEnLaClase", servicio.contarCreadosEnLaClase());
        r.put("edadMinima", Visitante.EDAD_MINIMA);
        return r;
    }

    @GetMapping("/normalizar")
    public Map<String, String> normalizar(@RequestParam String texto) {
        return Map.of("normalizado", TextoUtil.normalizarNombre(texto));
    }

    // Paso 6: Endpoint Fantasma requerido
    @PostMapping("/fantasma")
    public Map<String, Object> fantasma() {
        new Visitante("objeto fantasma", 30);
        return Map.of(
                "registradosEnElServicio", servicio.contarRegistrados(),
                "creadosEnLaClase", Visitante.getTotalCreados()
        );
    }
}
