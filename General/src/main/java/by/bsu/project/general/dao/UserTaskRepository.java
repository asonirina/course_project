package by.bsu.project.general.dao;

import by.bsu.project.general.model.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by iason
 * on 11/17/2015.
 */
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {
   UserTask findByUserIdAndTaskId(Long userId, Long taskId);
}
