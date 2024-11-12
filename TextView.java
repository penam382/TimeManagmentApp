import java.util.Scanner;

public class TextView {
    private ScheduleController controller;
    private Scanner scanner;
    
    public TextView(ScheduleController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> controller.addTask();
                case 2 -> controller.viewTasks();
                case 3 -> controller.sortTasks();
                case 4 -> controller.deleteTask();
                case 5 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- Schedule Manager ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Sort Tasks by Priority");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }
}
