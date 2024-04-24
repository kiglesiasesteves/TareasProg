import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project implements Serializable {
    private String name;
    private Map<String, Integer> materialsNeeded;

    public Project(String name) {
        this.name = name;
        this.materialsNeeded = new HashMap<>();
    }

    public void addMaterial(String material, int quantity) {
        materialsNeeded.put(material, quantity);
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getMaterialsNeeded() {
        return materialsNeeded;
    }
}
