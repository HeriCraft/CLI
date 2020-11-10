package tv.nosy.cli.models.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tv.nosy.cli.models.dao.Admin;

public class AdminImplDAO implements AdminDAO {

    private EntityManager em;

    public AdminImplDAO(){
        
    }
    private void createEm(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
        this.em = emf.createEntityManager();
    }

    @Override
    public void update(Admin a) {
        if(em == null || !em.isOpen()){
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
        if(em == null || em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }
        
        try{
            Query query = em.createQuery("Select a from Admin a");
            return query.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(em.isOpen()){
                em.close();
            }
        }
        return null;
    }

    @Override
    public Admin getAdmin(long id) {
        Admin a = null;
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        try{
            a = em.find(Admin.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
        return a;
    }

    @Override
    public void delete(long id) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.remove(em.find(Admin.class, id));
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
    public void addAdmin(Admin a) {
        if(em == null || !em.isOpen()){
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
