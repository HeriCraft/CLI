package tv.nosy.cli.models.services.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tv.nosy.cli.models.dao.custom.Achat;
import tv.nosy.cli.models.services.util.EntityRepository;

@Repository
@Transactional
public class AchatImpl implements EntityRepository<Achat> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Achat save(Achat entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public List<Achat> findAll() {
        Query q = em.createQuery("select a from Achat a");
        return q.getResultList();
    }

    @Override
    public Achat findOne(Long ref) {
        Achat a = em.find(Achat.class, ref);
        return a;
    }

    @Override
    public Achat update(Achat entity) {
        em.merge(entity);
        return null;
    }

    @Override
    public void delete(Long ref) {
        Achat cible = em.find(Achat.class, ref);
        em.remove(cible);
    }    
}
