package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.config.Constants;
import com.example.demo.entity2.Advertiser;

//@Repository là singleton => annotation của Springboot dùng cho DAO object
@Repository
public class AdvertiserDAO {
  
 
    @Autowired
    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME_2)  // annotation của JPA để xác định DataSource
    private EntityManager entityManager;
 
    public List<Advertiser> listAdvertisers() {
        String sql = "Select e from " + Advertiser.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, Advertiser.class);
        return query.getResultList();
    }
 
    public Advertiser findById(Long id) {
        return this.entityManager.find(Advertiser.class, id);
    }
     
}
