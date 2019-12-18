package com.eliseev.app.repository.custom.impl;

import com.eliseev.app.models.Role;
import com.eliseev.app.models.UserRoleEnum;
import com.eliseev.app.repository.AbstractDAO;
import com.eliseev.app.repository.custom.RoleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class RoleDAOImpl extends AbstractDAO<Role>
        implements RoleDAO {

    private Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

    public RoleDAOImpl() {
        super(Role.class);
    }

    @Override
    public Role findByName(UserRoleEnum name) {
        try {
            return super.entityManager.createQuery("select r from Role r where r.name = :roleName", Role.class)
                    .setParameter("roleName", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        entityManager.createNativeQuery("delete from user_role where role_id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.remove(entityManager.getReference(Role.class, id));
    }
}
