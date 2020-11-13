package tv.nosy.cli.models.services.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tv.nosy.cli.models.dao.custom.Client;
import tv.nosy.cli.models.services.util.EntityRepository;

@Repository
@Transactional
public class ClientImpl implements EntityRepository<Client> {

    @PersistenceContext
    EntityManager em;

    @Override
    public Client save(Client entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public List<Client> findAll() {
        Query q = em.createQuery("Select c from Client c");
        return q.getResultList();
    }

    @Override
    public Client findOne(Long ref) {
        Client c = em.find(Client.class, ref);
        return c;
    }

    @Override
    public Client update(Client entity) {
        em.merge(entity);
        return entity;
    }

    @Override
    public void delete(Long ref) {
        Client cible = this.findOne(ref);
        em.remove(cible);
    }
    
}
