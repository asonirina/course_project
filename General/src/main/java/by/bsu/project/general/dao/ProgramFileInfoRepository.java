package by.bsu.project.general.dao;

import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.ProgramFilesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by iason
 * on 11/17/2015.
 */
public interface ProgramFileInfoRepository extends JpaRepository<ProgramFilesEntity, Long> {
    List<ProgramFilesEntity> findByRunStatus(int runStatus);
    List<ProgramFilesEntity> findByUserId(Long id, Pageable pageable);
    List<ProgramFilesEntity> findByProgramNameAndUserIdNot(String programName, Long id);
}
