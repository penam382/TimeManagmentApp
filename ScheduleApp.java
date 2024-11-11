public class ScheduleApp {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        ScheduleController controller = new ScheduleController(schedule);
        TextView view = new TextView(controller);
        view.start();
    }
}
