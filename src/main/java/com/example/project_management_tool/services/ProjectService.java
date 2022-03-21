package com.example.project_management_tool.services;

import com.example.project_management_tool.domain.Backlog;
import com.example.project_management_tool.domain.Project;
import com.example.project_management_tool.domain.User;
import com.example.project_management_tool.exceptions.ProjectIdException;
import com.example.project_management_tool.exceptions.ProjectNotFoundException;
import com.example.project_management_tool.exceptions.UserNotFoundException;
import com.example.project_management_tool.repositories.BacklogRepository;
import com.example.project_management_tool.repositories.ProjectRepository;
import com.example.project_management_tool.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//ProjectService class to perform CRUD operations through Repository
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private UserRepository userRepository;


    //saveOrUpdate project
    public Project saveOrUpdateProject(Project project, String username){

		/*
		 * if(project.getId() != null){ Project existingProject =
		 * projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
		 * 
		 * if(existingProject == null){ throw new
		 * ProjectNotFoundException("Project with ID: '"+project.getProjectIdentifier()
		 * +"' cannot be updated because it doesn't exist"); } }
		 */

        //checking if project already exists
        try{

            //User user = userRepository.findByUsername(username);
            //project.setUser(user);
           // project.setProjectLeader(user.getUsername());
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
    
            
            if(project.getId()==null){
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if(project.getId()!=null){
                project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            return projectRepository.save(project);
        }catch (ProjectIdException e){
            throw new ProjectIdException("ProjectID " + project.getProjectIdentifier().toUpperCase() + " already exists");
		} 
			 
    }

    //finding project by projectId
    public Project findProjectByIdentifier(String projectId, String username){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        //if no project with projectID was found
        if(project==null){
            throw new ProjectIdException("ProjectID " + projectId + " doesn't exists");
        }

		/*
		 * if(!project.getProjectLeader().equals(username)){ throw new
		 * ProjectNotFoundException("Project not found in your account"); }
		 * 
		 */
        return project;
    }

    //finding all projects
    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    //deleting project by projectId
    public void deleteProjectByIdentifier(Long projectId){

        //checking is project exists in the database
        projectRepository.deleteById(projectId);
    }
}
