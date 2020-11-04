package tv.nosy.cli.models.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tv.nosy.cli.models.dao.Admin;

public class AdminImplDAO implements AdminDAO {

    private EntityManager em;

    public AdminImplDAO(){
        this.createEm();
    }
    private void createEm(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
        this.em = emf.createEntityManager();
    }

    @Override
    public void update(Admin a) {
        if(!em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.merge(a);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    @Override
    public List<Admin> getAllAdmin() {
        return null;
    }

    @Override
    public Admin getAdmin(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void addAdmin(Admin a) {
        if(!em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.persist(a);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }        
    }
}
