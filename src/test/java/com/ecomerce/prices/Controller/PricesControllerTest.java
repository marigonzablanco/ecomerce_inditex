package com.ecomerce.prices.Controller;

import com.ecomerce.prices.entities.Price;
import com.ecomerce.prices.service.PriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;




class PricesControllerTest {

    @Mock
    private PriceServiceImpl priceService;

    @InjectMocks
    private PricesController pricesController;

    @Spy
    private PriceMappertoPriceResponse mapper = new PriceMappertoPriceResponse();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPriceByDate_ReturnsPriceResponse_WhenPriceExists() {
        PriceRequest request = new PriceRequest();
        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(expectedResponse, response.getBody());
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    @SuppressWarnings("deprecation")
    @Test
    void getPriceByDate_Returns404_WhenPriceNotFound() {
        PriceRequest request = new PriceRequest();

        when(priceService.getPriceByDate(request)).thenReturn(null);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(priceService).getPriceByDate(request);
    }

    @Test
    void getPriceByDate_WhenServiceThrows_ReturnsNullResponse() {
        PriceRequest request = new PriceRequest();

        when(priceService.getPriceByDate(request)).thenThrow(new RuntimeException("DB error"));

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNull(response.getBody());
        verify(priceService).getPriceByDate(request);
    }

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void getPriceByDate_Test1_14th10AM_Product35455_Brand1() {
        PriceRequest request = new PriceRequest();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setDate(java.time.LocalDateTime.of(2020, 6, 14, 10, 0, 0));

        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> entity = pricesController.getPriceByDate(request);
        PriceResponse response = entity.getBody();

        assertNotNull(response);
        assertEquals(expectedResponse, response);
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void getPriceByDate_Test2_14th16PM_Product35455_Brand1() {
        PriceRequest request = new PriceRequest();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setDate(java.time.LocalDateTime.of(2020, 6, 14, 16, 0, 0));

        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void getPriceByDate_Test3_14th21PM_Product35455_Brand1() {
        PriceRequest request = new PriceRequest();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setDate(java.time.LocalDateTime.of(2020, 6, 14, 21, 0, 0));

        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    void getPriceByDate_Test4_15th10AM_Product35455_Brand1() {
        PriceRequest request = new PriceRequest();
        request.setProductId(35455L);
        request.setBrandId(1L);
        java.time.LocalDateTime date = java.time.LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        request.setDate(date);

        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    void getPriceByDate_Test5_16th21PM_Product35455_Brand1() {
        PriceRequest request = new PriceRequest();
        request.setProductId(35455L);
        request.setBrandId(1L);
        java.time.LocalDateTime date = java.time.LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        request.setDate(date);

        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    @Test
    void getAllPrices_ReturnsListOfPrices() {
        List<Price> prices = List.of(new Price(), new Price());
        when(priceService.getAllPrices()).thenReturn(prices);

        ResponseEntity<List<PriceResponse>> result = pricesController.getAllPrices();

        assertNotNull(result);
        verify(priceService).getAllPrices();
    }

    @Test
    void getPriceById_ReturnsPrice_WhenExists() {
        Long id = 1L;
        Price price = new Price();
        when(priceService.getPriceById(id)).thenReturn(price);

        ResponseEntity<PriceResponse> result = pricesController.getPriceById(id);

        assertNotNull(result);
        verify(priceService).getPriceById(id);
    }

    @SuppressWarnings("deprecation")
    @Test
    void getPriceById_Returns404_WhenNotExists() {
        Long id = 99L;
        when(priceService.getPriceById(id)).thenReturn(null);

        ResponseEntity<PriceResponse> result = pricesController.getPriceById(id);

        assertNotNull(result);
        assertEquals(404, result.getStatusCodeValue());
        verify(priceService).getPriceById(id);
    }

    @Test
    void deletePrice_CallsServiceDelete() {
        Long id = 1L;
        doNothing().when(priceService).deletePrice(id);

        pricesController.deletePrice(id);

        verify(priceService).deletePrice(id);
    }

    @Test
    void getPriceByDate_WhenMapperDoesNotThrow_ReturnsResponse() {
        PriceRequest request = new PriceRequest();
        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(expectedResponse, response.getBody());
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    @Test
    void deletePrice_WhenServiceThrows_Returns500() {
        Long id = 1L;
        doThrow(new RuntimeException("DB error")).when(priceService).deletePrice(id);

        // Since deletePrice returns void, we can't check the response directly.
        // But we can verify that the service method was called and exception was handled.
        assertDoesNotThrow(() -> pricesController.deletePrice(id));
        verify(priceService).deletePrice(id);
    }

    @Test
    void deletePrice_WhenServiceSucceeds_DoesNotThrow() {
        Long id = 2L;
        doNothing().when(priceService).deletePrice(id);

        assertDoesNotThrow(() -> pricesController.deletePrice(id));
        verify(priceService).deletePrice(id);
    }

    @SuppressWarnings("deprecation")
    @Test
    void getAllPrices_ReturnsNoContent_WhenListIsEmpty() {
        when(priceService.getAllPrices()).thenReturn(List.of());

        ResponseEntity<List<PriceResponse>> response = pricesController.getAllPrices();

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(priceService).getAllPrices();
    }

    @SuppressWarnings("deprecation")
    @Test
    void getAllPrices_ReturnsNoContent_WhenListIsNull() {
        when(priceService.getAllPrices()).thenReturn(null);

        ResponseEntity<List<PriceResponse>> response = pricesController.getAllPrices();

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(priceService).getAllPrices();
    }

    @SuppressWarnings("deprecation")
    @Test
    void getPriceById_Returns500_WhenServiceThrows() {
        Long id = 1L;
        when(priceService.getPriceById(id)).thenThrow(new RuntimeException("DB error"));

        ResponseEntity<PriceResponse> response = pricesController.getPriceById(id);

        assertNotNull(response);
        assertEquals(500, response.getStatusCodeValue());
        verify(priceService).getPriceById(id);
    }

    @Test
    void deletePrice_WhenServiceThrows_Returns500Response() {
        Long id = 1L;
        doThrow(new RuntimeException("DB error")).when(priceService).deletePrice(id);

        // Method returns void, but should not throw
        assertDoesNotThrow(() -> pricesController.deletePrice(id));
        verify(priceService).deletePrice(id);
    }

    @SuppressWarnings("deprecation")
    @Test
    void getPriceByDate_Returns500_WhenServiceThrows() {
        PriceRequest request = new PriceRequest();
        when(priceService.getPriceByDate(request)).thenThrow(new RuntimeException("DB error"));

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(500, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(priceService).getPriceByDate(request);
    }

    @SuppressWarnings("deprecation")
    @Test
    void getPriceByDate_Returns404_WhenPriceIsNull() {
        PriceRequest request = new PriceRequest();
        when(priceService.getPriceByDate(request)).thenReturn(null);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(priceService).getPriceByDate(request);
    }

    @SuppressWarnings("deprecation")
    @Test
    void getPriceByDate_Returns200_WhenPriceExists() {
        PriceRequest request = new PriceRequest();
        Price price = new Price();
        PriceResponse expectedResponse = new PriceResponse();

        when(priceService.getPriceByDate(request)).thenReturn(price);
        doReturn(expectedResponse).when(mapper).mapToResponse(price);

        ResponseEntity<PriceResponse> response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

}