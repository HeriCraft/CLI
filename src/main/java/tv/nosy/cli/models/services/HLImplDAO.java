package tv.nosy.cli.models.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.Cd;
import tv.nosy.cli.models.dao.HL;
import tv.nosy.cli.models.utilities.Generater;

public class HLImplDAO implements HLDAO {

    private EntityManager em;

    private void createEm(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
        this.em = emf.createEntityManager();
    }

    @Override
    public void addHL(HL hl) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.persist(hl);
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
    public void addHL(Admin a, Cd c) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            Date dt = Date.valueOf(LocalDate.now());
            HL hl = new HL(a, c, dt, Generater.generateKeyValue());
            em.persist(hl);
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
    public void remove(HL hl) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            em.remove(hl);
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
    public HL getHLByAdmin(long id) {
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        try{
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("Creatting query");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            Query q = em.createQuery("Select h from HL h where h.admin = "+id);
            System.out.println("Setting parameter");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("Creatting query");
            // System.out.println(q.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            // q.setParameter(1, id);
            System.out.println();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("Returnning result");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            return (HL) q.getSingleResult();
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
    public HL getHLByCd(long ref) {
        
        if(em == null || !em.isOpen()){
            this.createEm();
        }
        try{
            Query q = em.createQuery("Select h from HL h where h.c = :rf");
            q.setParameter("rf", ref);
            return (HL) q.getSingleResult();
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
    public List<HL> getAllHL() {
        if(em == null || em.isOpen() == false){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
            em = emf.createEntityManager();
        }
        
        try{
            Query query = em.createQuery("Select h from HL h");
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
    
}
