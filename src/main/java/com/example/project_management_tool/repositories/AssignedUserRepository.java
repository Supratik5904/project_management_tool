package com.example.project_management_tool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project_management_tool.domain.AssignedUsers;

@Repository
public interface AssignedUserRepository extends JpaRepository<AssignedUsers, Long> {

}
