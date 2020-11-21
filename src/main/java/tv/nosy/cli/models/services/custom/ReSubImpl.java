package tv.nosy.cli.models.services.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tv.nosy.cli.models.dao.custom.ReSubscription;
import tv.nosy.cli.models.services.util.EntityRepository;

@Transactional
@Repository
public class ReSubImpl implements EntityRepository<ReSubscription> {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public ReSubscription save(ReSubscription entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public List<ReSubscription> findAll() {
        Query q = em.createQuery("Select r from ReSubscription r");
        return q.getResultList();
    }

    @Override
    public ReSubscription findOne(Long ref) {
        ReSubscription res = em.find(ReSubscription.class, ref);
        return res;
    }

    @Override
    public ReSubscription update(ReSubscription entity) {
        em.merge(entity);
        return entity;
    }

    @Override
    public void delete(Long ref) {
        ReSubscription cible = em.find(ReSubscription.class, ref);
        em.remove(cible);
    }
    
}
