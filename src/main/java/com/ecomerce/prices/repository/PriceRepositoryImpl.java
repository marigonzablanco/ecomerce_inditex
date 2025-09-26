package com.ecomerce.prices.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.transaction.annotation.Transactional;

import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class PriceRepositoryImpl implements PriceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Price getPriceByDate(PriceRequest request) {
        String jpql = "SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND :date BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC";
        List<Price> results = entityManager.createQuery(jpql, Price.class)
                .setParameter("productId", request.getProductId())
                .setParameter("brandId", request.getBrandId())
                .setParameter("date", request.getDate())
                .setMaxResults(1)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<Price> getAllPrices() {
        String jpql = "SELECT p FROM Price p ";
        TypedQuery<Price> results = entityManager.createQuery(jpql, Price.class);
        
        return  results.getResultList().isEmpty() ? null : results.getResultList();
    }

    @Override
    public Price getPriceById(Long id) {
        String jpql = "SELECT p FROM Price p WHERE p.id = :id ";
        TypedQuery<Price> results = entityManager.createQuery(jpql, Price.class)
                .setParameter("id", id);
        
        return  results.getResultList().isEmpty() ? null : results.getResultList().get(0);
    }

    @Override
    @Transactional
    public Price savePrice(Price price) {
        String jpql = "INSERT p INTO Price p ";
        entityManager.createQuery(jpql, Price.class);
        return price;
    }

    @Override
    @Transactional
    public void deletePrice(Long id) {
        String jpql = "DELETE p FROM Price p WHERE p.id = :id ";
        entityManager.createQuery(jpql, Price.class)
                .setParameter("id", id);
    }


    @SuppressWarnings("null")
    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAllInBatch(Iterable<Price> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

@SuppressWarnings("null")
    @Override
    public Price getById(Long arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

@SuppressWarnings("null")
    @Override
    public Price getOne(Long arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @SuppressWarnings("null")
    @Override
    public Price getReferenceById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Price> findAll() { 
        String jpql = "SELECT p FROM Price p ";
        TypedQuery<Price> results = entityManager.createQuery(jpql, Price.class);
        
        return  results.getResultList().isEmpty() ? null : results.getResultList();        
    }

    @SuppressWarnings("null")
    @Override
    public List<Price> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> S save(S entity) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Price> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @SuppressWarnings("null")
    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Price entity) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAll(Iterable<? extends Price> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Price> findAll(Sort sort) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public Page<Price> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> long count(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }
}
