package TP.dao;

import TP.entity.ProductFood;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProductFoodDao extends BaseDao<ProductFood> {

    public ProductFoodDao() {
        super(ProductFood.class);
    }

    @Override
    public List<ProductFood> get() {
        TypedQuery<ProductFood> query = em.createQuery("SELECT p FROM ProductFood p", ProductFood.class);
        return query.getResultList();
    }

    @Override
    public ProductFood update(ProductFood element, long id) {
        ProductFood existing = get(id);
        if (existing == null) return null;

        try {
            em.getTransaction().begin();
            existing.setName(element.getName());
            existing.setPrice(element.getPrice());
            existing.setExpiryDate(element.getExpiryDate());
            em.getTransaction().commit();
            return existing;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
}
