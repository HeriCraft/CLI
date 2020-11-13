package tv.nosy.cli.models.services.custom;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tv.nosy.cli.models.dao.custom.Box;
import tv.nosy.cli.models.services.util.EntityRepository;

@Repository
@Transactional
public class BoxImp implements EntityRepository<Box> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Box save(Box entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public List<Box> findAll() {
        Query req = em.createQuery("select b from Box b");
        return req.getResultList();
    }

    @Override
    public Box findOne(Long ref) {
        Box res = em.find(Box.class, ref);
        return res;
    }

    @Override
    public Box update(Box entity) {
        em.merge(entity);
        return entity;
    }

    @Override
    public void delete(Long ref) {
        Box cible = em.find(Box.class, ref);
        em.remove(cible);
    }
    
}
