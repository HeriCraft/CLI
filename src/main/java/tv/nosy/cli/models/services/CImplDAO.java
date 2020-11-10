package tv.nosy.cli.models.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tv.nosy.cli.models.dao.Cd;

public class CImplDAO implements CDAO {

    private EntityManager em;
    
    private void createEm(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
        this.em = emf.createEntityManager();
    }

    @Override
    public Cd getCode(long ref) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        try{
            Cd c = em.find(Cd.class, ref);
            return c;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
        return null;
    }

    @Override
    public void addCode(Cd c) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.persist(c);
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
    public void update(Cd c) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.merge(c);
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
    public void delete(Cd c) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.remove(c);
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
    public void delete(long id) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.remove(em.find(Cd.class, id));
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
