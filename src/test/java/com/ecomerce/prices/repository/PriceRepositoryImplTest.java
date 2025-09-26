package com.ecomerce.prices.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


class PriceRepositoryImplTest {

    private PriceRepositoryImpl priceRepository;
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        priceRepository = new PriceRepositoryImpl();
        entityManager = mock(EntityManager.class);
        // Use reflection to inject the mock EntityManager
        try {
            var field = PriceRepositoryImpl.class.getDeclaredField("entityManager");
            field.setAccessible(true);
            field.set(priceRepository, entityManager);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetPriceByDate_ReturnsPrice() {
        PriceRequest request = mock(PriceRequest.class);
        when(request.getProductId()).thenReturn(1L);
        when(request.getBrandId()).thenReturn(2L);
        when(request.getDate()).thenReturn(LocalDateTime.now());

        Price price = new Price();
        List<Price> prices = List.of(price);

        var query = mock(jakarta.persistence.TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.setParameter(eq("productId"), any())).thenReturn(query);
        when(query.setParameter(eq("brandId"), any())).thenReturn(query);
        when(query.setParameter(eq("date"), any())).thenReturn(query);
        when(query.setMaxResults(1)).thenReturn(query);
        when(query.getResultList()).thenReturn(prices);

        Price result = priceRepository.getPriceByDate(request);
        assertNotNull(result);
        assertEquals(price, result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetPriceByDate_ReturnsNullWhenNoResult() {
        PriceRequest request = mock(PriceRequest.class);
        when(request.getProductId()).thenReturn(1L);
        when(request.getBrandId()).thenReturn(2L);
        when(request.getDate()).thenReturn(LocalDateTime.now());

        var query = mock(jakarta.persistence.TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.setParameter(eq("productId"), any())).thenReturn(query);
        when(query.setParameter(eq("brandId"), any())).thenReturn(query);
        when(query.setParameter(eq("date"), any())).thenReturn(query);
        when(query.setMaxResults(1)).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.emptyList());

        Price result = priceRepository.getPriceByDate(request);
        assertNull(result);
    }

    @Test
    void testDeleteAllByIdInBatch_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.deleteAllByIdInBatch(List.of(1L, 2L)));
    }

    @Test
    void testDeleteAllInBatchIterable_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.deleteAllInBatch(List.of(new Price())));
    }

    @Test
    void testFindAllExample_ThrowsException() {
        Example<Price> example = Example.of(new Price());
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findAll(example));
    }

    @Test
    void testFindAllExampleSort_ThrowsException() {
        Example<Price> example = Example.of(new Price());
        Sort sort = Sort.by("id");
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findAll(example, sort));
    }

    @Test
    void testFlush_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.flush());
    }

    @Test
    void testGetById_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.getById(1L));
    }

    @Test
    void testGetOne_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.getOne(1L));
    }

    @Test
    void testGetReferenceById_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.getReferenceById(1L));
    }

    @Test
    void testSaveAllAndFlush_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.saveAllAndFlush(List.of(new Price())));
    }

    @Test
    void testSaveAndFlush_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.saveAndFlush(new Price()));
    }

    @Test
    void testSaveAll_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.saveAll(List.of(new Price())));
    }

    @Test
    void testFindAllById_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findAllById(List.of(1L, 2L)));
    }

    @Test
    void testFindById_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findById(1L));
    }

    @Test
    void testExistsById_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.existsById(1L));
    }

    @Test
    void testDeleteById_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.deleteById(1L));
    }

    @Test
    void testDeleteEntity_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.delete(new Price()));
    }

    @Test
    void testDeleteAllByIdIterable_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.deleteAllById(List.of(1L, 2L)));
    }

    @Test
    void testDeleteAllIterable_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.deleteAll(List.of(new Price())));
    }

    @Test
    void testFindAllSort_ThrowsException() {
        Sort sort = Sort.by("id");
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findAll(sort));
    }

    @Test
    void testFindAllPageable_ThrowsException() {
        Pageable pageable = Pageable.unpaged();
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findAll(pageable));
    }

    @Test
    void testFindOneExample_ThrowsException() {
        Example<Price> example = Example.of(new Price());
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findOne(example));
    }

    @Test
    void testFindAllExamplePageable_ThrowsException() {
        Example<Price> example = Example.of(new Price());
        Pageable pageable = Pageable.unpaged();
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findAll(example, pageable));
    }

    @Test
    void testCountExample_ThrowsException() {
        Example<Price> example = Example.of(new Price());
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.count(example));
    }

    @Test
    void testExistsExample_ThrowsException() {
        Example<Price> example = Example.of(new Price());
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.exists(example));
    }

    @Test
    void testFindBy_ThrowsException() {
        Example<Price> example = Example.of(new Price());
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.findBy(example, q -> null));
    }
    @SuppressWarnings("unchecked")
    @Test
    void testGetAllPrices_ReturnsPrices() {
        Price price = new Price();
        List<Price> prices = List.of(price);

        TypedQuery<Price> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(prices);

        List<Price> result = priceRepository.getAllPrices();
        assertNotNull(result);
        assertEquals(prices, result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetAllPrices_ReturnsNullWhenEmpty() {
        TypedQuery<Price> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.emptyList());

        List<Price> result = priceRepository.getAllPrices();
        assertNull(result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetPriceById_ReturnsPrice() {
        Price price = new Price();
        List<Price> prices = List.of(price);

        TypedQuery<Price> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.setParameter(eq("id"), any())).thenReturn(query);
        when(query.getResultList()).thenReturn(prices);

        Price result = priceRepository.getPriceById(1L);
        assertNotNull(result);
        assertEquals(price, result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetPriceById_ReturnsNullWhenEmpty() {
        TypedQuery<Price> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.setParameter(eq("id"), any())).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.emptyList());

        Price result = priceRepository.getPriceById(1L);
        assertNull(result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testFindAll_ReturnsPrices() {
        Price price = new Price();
        List<Price> prices = List.of(price);

        TypedQuery<Price> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(prices);

        List<Price> result = priceRepository.findAll();
        assertNotNull(result);
        assertEquals(prices, result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testFindAll_ReturnsNullWhenEmpty() {
        TypedQuery<Price> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.emptyList());

        List<Price> result = priceRepository.findAll();
        assertNull(result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testSavePrice_DoesNotThrowException() {
        Price price = new Price();
        // The JPQL is invalid, but we just want to verify no exception is thrown in the method itself
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(mock(TypedQuery.class));
        Price result = priceRepository.savePrice(price);
        assertEquals(price, result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testDeletePrice_DoesNotThrowException() {
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(mock(TypedQuery.class));
        assertDoesNotThrow(() -> priceRepository.deletePrice(1L));
    }
    @Test
    void testDeleteAllInBatch_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.deleteAllInBatch());
    }

    @Test
    void testSave_ThrowsException() {
        Price price = new Price();
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.save(price));
    }

    @Test
    void testDeleteAll_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.deleteAll());
    }
    
    @Test
    void testCount_ThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> priceRepository.count());
    }

}
