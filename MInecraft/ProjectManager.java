import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    private List<Project> projects;
    private String fileName = "projects.dat";

    public ProjectManager() {
        projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void saveProjects() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(projects);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProjects() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            projects = (List<Project>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
