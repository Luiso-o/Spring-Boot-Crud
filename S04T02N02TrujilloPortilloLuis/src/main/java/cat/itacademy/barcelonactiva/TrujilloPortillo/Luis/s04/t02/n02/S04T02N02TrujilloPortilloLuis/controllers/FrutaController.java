package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.entity.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.services.FrutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FrutaController {

    @Autowired
    private final FrutaService  frutaService;

    @PostMapping("/add")
    public ResponseEntity<String>addFruta(@RequestBody Fruta fruta){
        frutaService.addFruta(fruta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fruta ingresada con éxito!");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFruta(@RequestBody Fruta fruta){
        frutaService.updateFruta(fruta);
        return ResponseEntity.status(HttpStatus.OK).body("Fruta actualizada con éxito!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>eliminarFruta(@PathVariable int id){
        frutaService.deleteFruta(id);
        return ResponseEntity.ok("Fruta eliminada con éxito");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruta(@PathVariable int id) {
        Fruta fruta = frutaService.getFruta(id);
        if (fruta != null) {
            return ResponseEntity.ok(fruta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Indice no encontrado");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAllFrutas() {
        List<Fruta> frutas = frutaService.getAllFrutas();
        return ResponseEntity.ok(frutas);
    }


}
