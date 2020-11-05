package tv.nosy.cli.models.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tv.nosy.cli.models.dao.HL;

public class HLImplDAO implements HLDAO {

    private EntityManager em;

    private void createEm(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_MN");
        this.em = emf.createEntityManager();
    }

    @Override
    public void addHL(HL hl) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(HL hl) {
        // TODO Auto-generated method stub

    }

    @Override
    public HL getHLByAdmin(long ref) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HL getHLByCd(long ref) {
        
        if(!em.isOpen()){
            this.createEm();
        }
        try{
            
            
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
        if(em.isOpen() == false){
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
