package TP.dao;

import TP.entity.ProductHousing;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProductHousingDao extends BaseDao<ProductHousing> {

    public ProductHousingDao() {
        super(ProductHousing.class);
    }

    @Override
    public List<ProductHousing> get() {
        TypedQuery<ProductHousing> query = em.createQuery("SELECT p FROM ProductHousing p", ProductHousing.class);
        return query.getResultList();
    }

    @Override
    public ProductHousing update(ProductHousing element, long id) {
        ProductHousing existing = get(id);
        if (existing == null) return null;

        try {
            em.getTransaction().begin();
            existing.setName(element.getName());
            existing.setPrice(element.getPrice());
            existing.setHeight(element.getHeight());
            existing.setWidth(element.getWidth());
            em.getTransaction().commit();
            return existing;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
}
