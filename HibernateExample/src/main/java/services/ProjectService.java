package services;

import dao.GenericDao;
import model.Project;

public class ProjectService {

    GenericDao<Project> projectGenericDao = new GenericDao<>();

    public void addProject(Project project)
    {
        projectGenericDao.add(project);
    }
}
