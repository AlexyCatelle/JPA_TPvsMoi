package TP.dao;

import TP.entity.ProductElectronic;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProductElectronicDao extends BaseDao<ProductElectronic> {

    public ProductElectronicDao() {
        super(ProductElectronic.class);
    }

    @Override
    public List<ProductElectronic> get() {
        TypedQuery<ProductElectronic> query = em.createQuery("SELECT p FROM ProductElectronic p", ProductElectronic.class);
        return query.getResultList();
    }

    @Override
    public ProductElectronic update(ProductElectronic element, long id) {
        ProductElectronic existing = get(id);
        if (existing == null) return null;

        try {
            em.getTransaction().begin();
            existing.setName(element.getName());
            existing.setPrice(element.getPrice());
            existing.setBatteryDuration(element.getBatteryDuration());
            em.getTransaction().commit();
            return existing;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
}
