package com.example.project_management_tool.repositories;

import com.example.project_management_tool.domain.ProjectTask;
import com.example.project_management_tool.domain.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {

    List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

    ProjectTask findByProjectSequence(String sequence);
    
    @Query(value="select users from project_task_users where project_sequence=:p",nativeQuery=true)
    List<String> findAllusers(@Param("p") Long  pid);

}
