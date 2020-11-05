package tv.nosy.cli.models.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
        if(!em.isOpen()){
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

    }

    @Override
    public void update(Cd c) {


    }

    @Override
    public void remove(Cd c) {

    }    
}
