package model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DBResturant {

    public static void insert(Resturant resturant) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(resturant);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
public static void insert(Customer customer) {
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
    EntityTransaction trans = em.getTransaction();
    try {
        trans.begin();
        em.persist(customer);
        trans.commit();
    } catch (Exception e) {
        trans.rollback();
    } finally {
        em.close();
    }
		
	}

    public static void update(Resturant resturant) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(resturant);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Resturant resturant) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(resturant));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static List<Resturant> getAllPost(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select b from Resturant b";
        
        List<Resturant> posts = null;
        try{
            TypedQuery<Resturant> query = em.createQuery(qString,Resturant.class);
            posts = query.getResultList();
         // System.out.println(posts.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
	
    public static List<Resturant> resturantofresturantID (long resturantid){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select b from Resturant b where b.resturantid = :resturantid";
       List<Resturant> resturant =null;
        
        try{    
            TypedQuery<Resturant> query = em.createQuery(qString,Resturant.class);
            query.setParameter("resturantid", resturantid);
            resturant = query.getResultList();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return resturant;
        
    }
    public static List<Resturant> reviewofresturantID (String resturantid){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select r from Review r where r.resturant.resturantid = :resturantid";
       List<Resturant> resturant =null;
        
        try{    
            TypedQuery<Resturant> query = em.createQuery(qString,Resturant.class);
            query.setParameter("resturantid", resturantid);
            resturant = query.getResultList();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return resturant;
        
    }
    public static List<Resturant> postsofUser(long resturantid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Resturant> userposts = null;
        String qString = "select b from Resturant b where b.resturantid = :resturantid";
        
        try{
            TypedQuery<Resturant> query = em.createQuery(qString,Resturant.class);
            query.setParameter("resturantid", resturantid);
            userposts = query.getResultList();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return userposts;    
    }
  
   
    
}
	
    
   
    
    
