import java.util.List;
import java.util.Scanner;

public class ScheduleController {
    private Schedule schedule;
    private Task task;
    private Scanner scanner;

    public ScheduleController(Schedule schedule) {
        this.schedule = schedule;
        // task = new Task(null, 0, 0);
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
        String startTime = "";
        int estimatedTime = 0;

        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter priority (1-10): ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Do you have a set time for this? 'y/n': ");
        String setTime = scanner.nextLine();

        if (setTime.equals("y")) {
            
            System.out.print("Enter start time. Ex.'10:00pm': ");
            startTime = scanner.nextLine();

            System.out.print("Enter end time. Ex.'8:00am': ");
            String endTime = scanner.nextLine();

            estimatedTime = task.calculateEstimatedTime(startTime, endTime);
        } else {
            System.out.print("Enter estimated time in minutes: ");
            estimatedTime = scanner.nextInt();
            scanner.nextLine();
        }
        
        newTask(name, priority, estimatedTime);
        
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        List<Task> tasks = getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (Task task : tasks) {
                System.out.println(task); 
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

    public void createSchedule() {
        if (task.getSpecificTime()) {
            
            
        }
    }


}
