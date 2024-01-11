package Experimental;

public class WatchFaceAngle {

    // Method to return the angle between the hour hand and second hand on a clock, given a specific time
    public static int getAngleBetweenHands(int hours, int minutes) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59)
            return -1;

        int normalisedHours = hours > 11 ? hours-12 : hours;

        int hoursAngle = (360/12)*normalisedHours;
        int minutesAngle = (360/60)*minutes;

        return Math.abs(hoursAngle-minutesAngle);
    }
}
