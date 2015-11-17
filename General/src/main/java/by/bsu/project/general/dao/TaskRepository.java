package by.bsu.project.general.dao;

import by.bsu.project.general.model.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by iason
 * on 11/17/2015.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByForm(String form);
    List<Task> findByForm(String form, Pageable pageable);
    Task findOneByFormAndProgramName(String form, String programName);
    long countByForm(String form);
}
