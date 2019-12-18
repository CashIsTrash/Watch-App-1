package sample.model;

public class Alarm {

    private int hours = 0;
    private int minutes = 0;
//    private int seconds = 0;

    public Alarm(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;

    }

    public void setHours(int hours) {
        if (hours >24 || hours < 0)
            new Exception("Wrong!");
        else
            this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes <59 && minutes >=0)
            this.minutes = minutes;
        else
            System.out.println("WRONG!");
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

}
