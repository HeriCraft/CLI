package tv.nosy.cli.models.services.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tv.nosy.cli.models.dao.custom.Subscription;
import tv.nosy.cli.models.services.util.EntityRepository;

@Repository
@Transactional
public class SubImpl implements EntityRepository<Subscription> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Subscription save(Subscription entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public List<Subscription> findAll() {
        Query query = em.createQuery("select s from Subscription s");
        return query.getResultList();
    }

    @Override
    public Subscription findOne(Long ref) {
        Subscription s = em.find(Subscription.class, ref);
        return s;
    }

    @Override
    public Subscription update(Subscription entity) {
        em.merge(entity);
        return entity;
    }

    @Override
    public void delete(Long ref) {
        Subscription s = this.findOne(ref);
        em.remove(s);
    }
    
}
