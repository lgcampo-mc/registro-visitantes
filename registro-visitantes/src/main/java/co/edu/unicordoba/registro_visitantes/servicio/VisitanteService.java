package co.edu.unicordoba.registro_visitantes.servicio;
import co.edu.unicordoba.registro_visitantes.modelo.Visitante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VisitanteService {
    private final List<Visitante> reg = new ArrayList<>();

    public Visitante registrar(String n, int e) {
        Visitante v = new Visitante(n, e);
        reg.add(v);
        return v;
    }

    public List<Visitante> listar() {
        return List.copyOf(reg); // Copia inmutable
    }

    public int contarRegistrados() {
        return reg.size();
    }

    public int contarCreadosEnLaClase() {
        return Visitante.getTotalCreados(); // Invocación a un método static
    }
}
