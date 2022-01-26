package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SessionJpaRepository jpaRepositoy;

    public Session create(Session session) {
        return jpaRepositoy.saveAndFlush(session);
    }

    public Session update(Session session) {
        return jpaRepositoy.saveAndFlush(session);
    }

    public void delete(Long id) {
        jpaRepositoy.deleteById(id);
    }

    public Session find(Long id) {
        return jpaRepositoy.getOne(id);
    }

    public List<Session> list() {
        return jpaRepositoy.findAll();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        return jpaRepositoy.findBySessionNameContains(name);
    }
}
