/*
 * Author: Marco Pena
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Schedule {
    
    private List<Task> tasks;
    private HashMap<String, Task> taskMap;

    public Schedule() {
        tasks = new ArrayList<Task>();
        taskMap = new HashMap<String, Task>();
    }

    public void add(Task task) {
        tasks.add(task);
        taskMap.put(task.getName(), task);
    }

    public void sortByPriority() {
        tasks.sort(Comparator.comparingInt(Task::getPriority).reversed());
    }

}
