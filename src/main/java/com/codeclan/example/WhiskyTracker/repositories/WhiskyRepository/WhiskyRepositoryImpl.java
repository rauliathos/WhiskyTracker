package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    //TODO: Get all the whisky from a particular distillery that's a specific age

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesFromDistilleryThathaveAnAge(Long id, int age){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Whisky.class);

        cr.createAlias("distillery", "distilleryAlias");
        cr.add(Restrictions.eq("distilleryAlias.id", id));

        cr.add(Restrictions.eq("age", age));
        result = cr.list();

    return result;
    }



}
