package by.bsu.project.general.dao;

import by.bsu.project.general.model.AttributeCounting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by iason
 * on 11/17/2015.
 */
public interface AttributeCountingRepository extends JpaRepository<AttributeCounting, Long> {
}
