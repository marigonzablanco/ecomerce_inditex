package com.ecomerce.prices.service;

import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;
import com.ecomerce.prices.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPrices() {
        Price price1 = new Price();
        Price price2 = new Price();
        when(priceRepository.findAll()).thenReturn(Arrays.asList(price1, price2));

        List<Price> prices = priceService.getAllPrices();

        assertEquals(2, prices.size());
        verify(priceRepository, times(1)).findAll();
    }

    @Test
    void testGetPriceById_Found() {
        Price price = new Price();
        when(priceRepository.getPriceById(1L)).thenReturn(price);

        Price result = priceService.getPriceById(1L);

        assertNotNull(result);
        verify(priceRepository, times(1)).getPriceById(1L);
    }

    @Test
    void testGetPriceById_NotFound() {
        when(priceRepository.findById(2L)).thenReturn(Optional.empty());

        Price result = priceService.getPriceById(2L);

        assertNull(result);
        verify(priceRepository, times(1)).getPriceById(2L);
    }

    @Test
    void testSavePrice() {
        Price price = new Price();
        when(priceRepository.save(price)).thenReturn(price);

        Price result = priceService.savePrice(price);

        assertEquals(price, result);
        verify(priceRepository, times(1)).save(price);
    }

    @Test
    void testDeletePrice() {
        priceService.deletePrice(3L);

        verify(priceRepository, times(1)).deletePrice(3L);
    }

    @Test
    void testGetPriceByDate() {
        PriceRequest request = mock(PriceRequest.class);
        Price price = new Price();
        when(priceRepository.getPriceByDate(request)).thenReturn(price);

        Price result = priceService.getPriceByDate(request);

        assertEquals(price, result);
        verify(priceRepository, times(1)).getPriceByDate(request);
    }
}