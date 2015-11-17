package by.bsu.project.general.dao;

import by.bsu.project.general.model.UserInfoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by iason
 * on 11/17/2015.
 */

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
    UserInfoEntity findOneByLogin(String login);
    List<UserInfoEntity> findByForm(String form);
    List<UserInfoEntity> findByForm(String form, Pageable pageable);
    long countByForm(String form);
    long countByFormNot(String form);
    List<UserInfoEntity> findByFormNot(String form);
    List<UserInfoEntity> findByFormNot(String form, Pageable pageable);
}
