package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.domain.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/misfrutas")
public class FrutaController {
    private final FrutaService  frutaService;

    @Autowired
    public FrutaController(FrutaService frutaService){
        this.frutaService = frutaService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruta>addFruta(@RequestBody Fruta fruta){
        frutaService.addFruta(fruta);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Fruta> updateFruta(@RequestBody Fruta fruta){
        frutaService.updateFruta(fruta);
        return ResponseEntity.status(HttpStatus.OK).body(fruta);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>eliminarFruta(@PathVariable int id){
        frutaService.deleteFruta(id);
        return ResponseEntity.ok("Fruta eliminada");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruta(@PathVariable int id) {
        Fruta fruta = frutaService.getFruta(id);
        if (fruta != null) {
            return ResponseEntity.ok(fruta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAllFrutas() {
        List<Fruta> frutas = frutaService.getAllFrutas();
        return ResponseEntity.ok(frutas);
    }


}
