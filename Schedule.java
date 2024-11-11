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
        tasks = new ArrayList<>();
        taskMap = new HashMap<>();
    }

    public void add(Task task) {
        tasks.add(task);
        taskMap.put(task.getName(), task);
    }

    public boolean remove(String taskName) {
        Task removeTask = taskMap.remove(taskName);
        if (removeTask != null) {
            tasks.remove(removeTask);
            return true;
        }
        return false;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void sortByPriority() {
        tasks.sort(Comparator.comparingInt(Task::getPriority).reversed());
    }

}
