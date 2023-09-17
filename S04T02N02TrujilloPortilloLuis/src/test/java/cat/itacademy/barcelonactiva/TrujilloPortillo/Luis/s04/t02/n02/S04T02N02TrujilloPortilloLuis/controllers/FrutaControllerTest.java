package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.entity.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.repository.FrutaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FrutaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FrutaRepository frutaRepository;

    @BeforeEach
    public void setUp() {
        frutaRepository.save(Fruta.builder()
                .nombre("Manzana")
                .cantidadKilos(5)
                .build());

        frutaRepository.save(Fruta.builder()
                .nombre("Plátano")
                .cantidadKilos(7)
                .build());

    }

    @Test
    public void test_Al_agregar_una_fruta_esta_el_resultado_sera_created() throws Exception {
        Fruta nuevaFruta = new Fruta(3, "Sandia",6);

        String nuevaFrutaJson = objectMapper.writeValueAsString(nuevaFruta);

        mockMvc.perform(post("/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(nuevaFrutaJson))
                .andExpect(status().isCreated())
                .andExpect(content().string(is("Fruta ingresada con éxito!")));
    }

    @Test
    public void test_ActualizarLosDatosDeUnaFrutaSeleccionadaPorSuId_Resultado_OK() throws Exception {
        Fruta frutaActualizada = new Fruta(1, "Melón",3);

        String frutaActualizadaJson = objectMapper.writeValueAsString(frutaActualizada);

        mockMvc.perform(put("/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(frutaActualizadaJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Fruta actualizada con éxito!"));

    }

    @Test
    public void test_EliminarUnaFrutaPorId_Resultado_OK() throws Exception {
        mockMvc.perform(delete("/delete/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fruta eliminada con éxito"));
    }

    @Test
    public void test_ObtenerUnaFrutaExistentePorId_Resultado_OK() throws Exception {
        mockMvc.perform(get("/getOne/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value("Plátano"))
                .andExpect(jsonPath("$.cantidadKilos").value(7));
    }

    @Test
    public void test_ObtenerUnaFrutaQueNoExistePorId_Resultado_NotFound() throws Exception {
        mockMvc.perform(get("/getOne/90"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_GetAllFrutas_ReturnsOk() throws Exception {
        mockMvc.perform(get("/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }


}