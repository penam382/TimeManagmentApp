import java.util.List;
import java.util.Scanner;

public class ScheduleController {
    private Schedule schedule;
    private Scanner scanner;

    public ScheduleController(Schedule schedule) {
        this.schedule = schedule;
        this.scanner = new Scanner(System.in);
    }

    public void newTask(String name, int priority, int estimatedTime) {
        Task task = new Task(name, priority, estimatedTime);
        schedule.add(task);
    }

    public boolean deleteTask(String taskName) {
        return schedule.remove(taskName);
    }

    public List<Task> getTasks() {
        return schedule.getTasks();
    }

    public void sortTasksByPriority() {
        schedule.sortByPriority();
    }

    public void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter priority (1-10): ");
        int priority = scanner.nextInt();
        System.out.print("Enter estimated time in minutes: ");
        int estimatedTime = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        newTask(name, priority, estimatedTime);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        List<Task> tasks = getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (Task task : tasks) {
                System.out.println(task); // Override `toString` in Task to show formatted details
            }
        }
    }

    public void sortTasks() {
        sortTasksByPriority();
        System.out.println("Tasks sorted by priority.");
    }

    public void deleteTask() {
        System.out.print("Enter task name to delete: ");
        String name = scanner.nextLine();
        boolean removed = deleteTask(name);
        System.out.println(removed ? "Task removed successfully." : "Task not found.");
    }


}
