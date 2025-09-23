package com.ecomerce.prices.Controller;

import com.ecomerce.prices.entities.Price;
import com.ecomerce.prices.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;




class PricesControllerTest {

    @Mock
    private PriceService priceService;

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

        PriceResponse response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(expectedResponse, response);
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }

    @Test
    void getPriceByDate_ThrowsException_WhenPriceNotFound() {
        PriceRequest request = new PriceRequest();

        when(priceService.getPriceByDate(request)).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            pricesController.getPriceByDate(request);
        });

        assertTrue(exception.getMessage().contains("No price found for the given date"));
        verify(priceService).getPriceByDate(request);
    }

    @Test
    void getPriceByDate_ThrowsException_WhenServiceThrows() {
        PriceRequest request = new PriceRequest();

        when(priceService.getPriceByDate(request)).thenThrow(new RuntimeException("DB error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            pricesController.getPriceByDate(request);
        });

        assertTrue(exception.getMessage().contains("Error retrieving price: DB error"));
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

        PriceResponse response = pricesController.getPriceByDate(request);

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

        PriceResponse response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(expectedResponse, response);
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

        PriceResponse response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(expectedResponse, response);
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

        PriceResponse response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(expectedResponse, response);
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

        PriceResponse response = pricesController.getPriceByDate(request);

        assertNotNull(response);
        assertEquals(expectedResponse, response);
        verify(priceService).getPriceByDate(request);
        verify(mapper).mapToResponse(price);
    }
}