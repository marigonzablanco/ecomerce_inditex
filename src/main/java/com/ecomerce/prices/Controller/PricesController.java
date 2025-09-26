package com.ecomerce.prices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.prices.entities.Price;
import com.ecomerce.prices.service.PriceService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/prices")
public class PricesController {

    private  PriceMappertoPriceResponse mapper = new PriceMappertoPriceResponse();
    
    @Autowired
    private PriceService priceService;

    @GetMapping("/all")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK. Operacion realizada con exito" ),
        @ApiResponse(responseCode = "400", description = "Bad Request."),
        @ApiResponse(responseCode = "404", description = "No encontrado."),
        @ApiResponse(responseCode = "500", description = "Error inesperado del sistema") })
    public ResponseEntity<List<PriceResponse>> getAllPrices() {
        List<Price> prices = priceService.getAllPrices();
        if (prices == null || prices.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List <PriceResponse> responses = mapper.mapToResponseList(prices);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK. Operacion realizada con exito" ),
        @ApiResponse(responseCode = "400", description = "Bad Request."),
        @ApiResponse(responseCode = "404", description = "No encontrado."),
        @ApiResponse(responseCode = "500", description = "Error inesperado del sistema") })
    public ResponseEntity<PriceResponse> getPriceById(@PathVariable Long id) {
        try {
            Price price = priceService.getPriceById(id);
            if (price == null) {
                return ResponseEntity.notFound().build();
            }
            PriceResponse response = mapper.mapToResponse(price);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
        
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK. Borrado realizado con exito" ),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "404", description = "No encontrado."),
            @ApiResponse(responseCode = "500", description = "Error inesperado del sistema") })
    public void deletePrice(@PathVariable Long id) {
        try {
            priceService.deletePrice(id);
        } catch (Exception e) {
            ResponseEntity.status(500).build();
        }
    }

    @PostMapping("getByDate")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK. Operacion realizada con exito" ),
        @ApiResponse(responseCode = "400", description = "Bad Request."),
        @ApiResponse(responseCode = "404", description = "No encontrado."),
        @ApiResponse(responseCode = "500", description = "Error inesperado del sistema") })
    public ResponseEntity<PriceResponse> getPriceByDate(@RequestBody PriceRequest request) {
        try {
                Price price = priceService.getPriceByDate(request);
            if (price == null) {
                return ResponseEntity.notFound().build();
            }
            PriceResponse response = mapper.mapToResponse(price);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
}
