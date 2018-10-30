package cn.crscube.portal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cn.crscube.portal.model.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppRoleDAO {
    @Autowired
    private EntityManager entityManager;

    /**
     * Role Name 조회
     * @param userId
     * @return user Role List
     */
    public List<String> getRoleNames(Long userId) {
        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
                + " where ur.appUser.userId = :userId ";

        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
