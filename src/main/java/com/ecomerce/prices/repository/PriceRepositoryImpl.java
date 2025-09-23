package com.ecomerce.prices.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.ecomerce.prices.Controller.PriceRequest;
import com.ecomerce.prices.entities.Price;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PriceRepositoryImpl implements PriceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Price getPriceByDate(PriceRequest request) throws RuntimeException {
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

    @SuppressWarnings("null")
    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAllInBatch(Iterable<Price> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public void flush() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

@SuppressWarnings("null")
    @Override
    public Price getById(Long arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

@SuppressWarnings("null")
    @Override
    public Price getOne(Long arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @SuppressWarnings("null")
    @Override
    public Price getReferenceById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Price> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Price> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> S save(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Price> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @SuppressWarnings("null")
    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @SuppressWarnings("null")
    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Price entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAll(Iterable<? extends Price> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @SuppressWarnings("null")
    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @SuppressWarnings("null")
    @Override
    public List<Price> findAll(Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public Page<Price> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends Price, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

}
