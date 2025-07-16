package TP.service;

import TP.dao.BaseDao;
import TP.entity.Product;

import java.util.List;

public class ProductService<T extends Product> {

    private final BaseDao<T> dao;

    public ProductService(BaseDao<T> dao) {
        this.dao = dao;
    }

    public T create(T product) {
        return dao.save(product);
    }

    public T getById(long id) {
        return dao.get(id);
    }

    public List<T> getAll() {
        return dao.get();
    }

    public boolean delete(long id) {
        return dao.delete(id);
    }

    public T update(T updatedProduct, long id) {
        return dao.update(updatedProduct, id);
    }
}

