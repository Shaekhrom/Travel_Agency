package com.curso.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.curso.inicio.TravelAgencyReservaApplication;
import com.curso.model.Reserva;
import com.curso.service.ReservaService;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de prueba para el controlador de reservas.
 * Utiliza Mockito para simular las dependencias y MockMvc para realizar las peticiones HTTP.
 * 
 * @author Alejandro Barbacil
 */
@SpringBootTest(classes = TravelAgencyReservaApplication.class)
@AutoConfigureMockMvc
public class ReservaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservaService reservaService;

    @MockBean
    private RestTemplate restTemplate;

    @InjectMocks
    private ReservaController reservaController;

    /**
     * Prueba el metodo insertarReserva del controlador.
     * Simula una excepcion al actualizar las plazas del vuelo y verifica que la respuesta sea un error 500.
     *
     * @throws Exception si ocurre un error durante la ejecucion de la prueba.
     */
    @Test
    public void testInsertarReserva() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setIdVuelo(5);
        reserva.setNumPersonas(2);

        // Simular la llamada a actualizarVuelo
        doThrow(new RuntimeException("Error al actualizar las plazas del vuelo con ID: 5"))
                .when(restTemplate).exchange(any(String.class), eq(HttpMethod.PUT), any(), eq(Void.class));

        MockHttpServletRequestBuilder request = post("/insertarReserva")
                .contentType("application/json")
                .content("{ \"nombreCliente\": \"Juan Perez\", \"dni\": \"12345678A\", \"idHotel\": 2, \"idVuelo\": 5, \"numPersonas\": 2 }");

        mockMvc.perform(request)
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error al crear la reserva: Error al actualizar las plazas del vuelo con ID: 5"));
    }

    /**
     * Prueba el metodo listarReservasPorNombreHotel del controlador.
     * Simula la llamada al microservicio de hotel y al servicio de reservas,
     * y verifica que la respuesta sea una lista de reservas en formato JSON.
     *
     * @throws Exception si ocurre un error durante la ejecucion de la prueba.
     */
    @Test
    public void testListarReservasPorNombreHotel() throws Exception {
        String nombreHotel = "Sunset Resort";

        Map<String, Object> hotelData = new HashMap<>();
        hotelData.put("idHotel", 1);

        List<Reserva> reservas = Arrays.asList(new Reserva(), new Reserva());

        // Simular la llamada al microservicio de hotel
        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(), eq(Map.class), eq(nombreHotel)))
                .thenReturn(new ResponseEntity<>(hotelData, HttpStatus.OK));

        // Simular la llamada al servicio para obtener la lista de reservas
        when(reservaService.listarReservasPorHotel(1)).thenReturn(reservas);

        mockMvc.perform(get("/reserva/{nombreHotel}", nombreHotel))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }
}
