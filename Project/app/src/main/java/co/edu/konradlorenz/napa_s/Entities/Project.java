package co.edu.konradlorenz.napa_s.Entities;


import android.content.res.TypedArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {

    private int placeHolder;
    private String projectName;
    private String percentageComplete;

    public Project(int placeHolder, String projectName, String percentageComplete) {
        this.placeHolder = placeHolder;
        this.projectName = projectName;
        this.percentageComplete = percentageComplete;
    }

    public static List<Project> prepareProjects(TypedArray placeHolders, String[] projectsName, String[] percentageComplete){

        List<Project> projects = new ArrayList<>(projectsName.length);

        for(int i = 0; i < projectsName.length; i++){
            Project project = new Project(placeHolders.getResourceId(i, -1), projectsName[i], percentageComplete[i]);
            projects.add(project);
        }

        return projects;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(String percentageComplete) {
        this.percentageComplete = percentageComplete;
    }
}
