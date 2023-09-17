package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.repository;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.entity.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutaRepository extends JpaRepository<Fruta,Integer> {
}
