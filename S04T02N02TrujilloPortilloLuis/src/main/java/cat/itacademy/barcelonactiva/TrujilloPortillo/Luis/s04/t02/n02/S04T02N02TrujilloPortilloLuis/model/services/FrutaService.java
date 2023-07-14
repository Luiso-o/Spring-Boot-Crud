package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.services;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.domain.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrutaService {

    private final FrutaRepository frutaRepository;

    @Autowired
    public FrutaService(FrutaRepository frutaRepository){
        this.frutaRepository = frutaRepository;
    }

    public void addFruta(Fruta fruta) {
        frutaRepository.save(fruta);
    }

    public void updateFruta(Fruta fruta) {
        frutaRepository.save(fruta);
    }

    public void deleteFruta(int id) {
        frutaRepository.deleteById(id);
    }

    public Fruta getFruta(int id) {
        return frutaRepository.findById(id).orElse(null);
    }

    public List<Fruta> getAllFrutas() {
        return frutaRepository.findAll();
    }


}
