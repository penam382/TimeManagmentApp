/*
 * Author: Marco Pena
 */
public class Task {  

    private String name;
    private int priority;
    private String startTimeStr;
    private String endTimeStr;
    private int estimatedTime; // minutes
    private boolean specificTime;

    public Task(String name, int priority, int estimatedTime) {
        this.name = name;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
        this.specificTime = false;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int startEndTimesToMinutes(String timeStr) {
        int hour = 0;
        int minutes = 0; 
        String amPm = "";

        // Get the hour and minutes part
        String[] timeParts = timeStr.split(":"); // Split at the colon
        hour = Integer.parseInt(timeParts[0].replaceAll("^0", "")); // Remove leading zero if present and convert to int
        minutes = Integer.parseInt(timeParts[1].substring(0, 2)); // Get minutes part (ignore the AM/PM for now)

        // Get the AM/PM part
        amPm = timeStr.substring(timeStr.length() - 2); // Get the last 2 characters (AM/PM)

        // Adjust the hour based on AM/PM
        if (amPm.equals("pm") && hour != 12) {
            hour += 12; // Convert PM hour to 24-hour format, except 12 PM (no change)
        } else if (amPm.equals("am") && hour == 12) {
            hour = 0; // 12 AM is 0 hour in 24-hour format
        }

        // Combine hour and minutes into total minutes
        return hour * 60 + minutes; // Convert total time to minutes
    }

    public int calculateEstimatedTime(String startTimeStr, String endTimeStr) {
        specificTime = true;
        // Calculate start and end times in minutes
        int startMinutes = startEndTimesToMinutes(startTimeStr);
        int endMinutes = startEndTimesToMinutes(endTimeStr);
    
        // Calculate difference, and handle cases where end time is the next day
        int duration = endMinutes - startMinutes;
        if (duration < 0) {
            duration += 24 * 60; // Add 24 hours if end time is on the next day
        }
        return duration;
    }
    

    public double estimatedTimeInHours() {
        return (double) calculateEstimatedTime(startTimeStr, endTimeStr) / 60;
    }

    public boolean isStartTime() {
        return startTimeStr == null || startTimeStr.isEmpty();
    }

    public boolean getSpecificTime() {
        return specificTime;
    }

    @Override
    public String toString() {
        return "Task [Name=" + name + ", Priority=" + priority + ", Estimated Time=" + estimatedTime + " mins]";
    }

}
