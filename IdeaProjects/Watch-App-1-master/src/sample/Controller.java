package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import sample.model.Alarm;
import sample.model.WatchTimer;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML
    private Label labelHours;
    @FXML
    private Label labelMinutes;
    @FXML
    private Timer timer;
    private String second = "00";
    private String minute = "00";
    private String hour = "00";
    private WatchTimer wt;
    private int hourChange = 1;
    private int minChange = 1;
    private int secChange = 1;
    private boolean timerOn;
    private boolean isTicking = true;
    private boolean hourIncClicked = false;
    private boolean hourDecClicked = false;
    private boolean minIncClicked = false;
    private boolean minDecClicked = false;
    private boolean secIncClicked = false;
    private boolean secDecClicked = false;
    private boolean runninng;


    public void setAlarm() {
        System.out.println("Alarm has been set to \"" + labelHours.getText() + " : " + labelMinutes.getText() + "\"");
        Thread t = new Thread() {
            public void run() {
                 runninng = true;
                while (runninng) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LocalTime theTimeIs = LocalTime.now();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String alarmHours = labelHours.getText();
                    int alarmHoursInt = Integer.parseInt(alarmHours);
                    //   System.out.println("HOURS = " + alarmHoursInt);

                    String alarmMinutes = labelMinutes.getText();
                    int alarmMinutesInt = Integer.parseInt(alarmMinutes);
                    // System.out.println("Minutes = " + alarmMinutesInt);


                    if (theTimeIs.getHour() == alarmHoursInt && theTimeIs.getMinute() == alarmMinutesInt)

                        playAudio(2);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();


    }

    public void alarmHourInc() {
        if (!hourIncClicked) {
            isTicking = true;
            hour = String.valueOf(hourChange);
            if (hour.length() < 2) {
                hour = "0" + (hourChange);
            }
            if (hourChange > 23) {
                hour = "00";
                hourChange = 1;
            } else {
                hourChange++;
            }
            labelHours.setText(hour);

        }
    }

    public void alarmHourDec() {
        if (!hourDecClicked) {
            isTicking = true;
            hour = String.valueOf(hourChange - 2);
            if (hour.length() < 2) {
                hour = "0" + (hourChange - 2);
            }

            if (hourChange <= 1) {
                hour = "23";
                hourChange = 24;
            } else {
                --hourChange;
            }
            labelHours.setText(hour);
        }
    }


    public void alarmMinInc() {
        if (!minIncClicked) {
            isTicking = true;
            minute = String.valueOf(minChange);
            if (minute.length() < 2) {
                minute = "0" + (minChange);
            }
            if (minChange > 59) {
                minute = "00";
                minChange = 1;
            } else {
                minChange++;
            }
            labelMinutes.setText(minute);
        }
    }

    public void alarmMinDec() {
        if (!minDecClicked) {
            isTicking = true;
            minute = String.valueOf(minChange - 2);
            if (minute.length() < 2) {
                minute = "0" + (minChange - 2);
            }
            if (minChange <= 1) {
                minute = "59";
                minChange = 60;
            } else {
                --minChange;
            }
            labelMinutes.setText(minute);
        }
    }

    public void AlarmReset() {
        hourIncClicked = false;
        hourDecClicked = false;
        minIncClicked = false;
        minDecClicked = false;

        isTicking = true;
        Platform.runLater(() -> labelHours.setText("00"));
        Platform.runLater(() -> labelMinutes.setText("00"));
        hour = "00";
        minute = "00";
        hourChange = 1;
        minChange = 1;
        runninng = false;
     //   Thread.interrupted();
        stop();
       // System.exit(1);

    }

    // BENJAMIN
    public void hourInc() {
        if (!hourIncClicked) {
            isTicking = true;
            hour = String.valueOf(hourChange);
            if (hour.length() < 2) {
                hour = "0" + (hourChange);
            }
            if (hourChange > 99) {
                hour = "00";
                hourChange = 1;
            } else {
                hourChange++;
            }
            labelHours.setText(hour + ":" + minute + ":" + second);
        }
    }


    public void hourDec() {
        if (!hourDecClicked) {
            isTicking = true;
            hour = String.valueOf(hourChange - 2);
            if (hour.length() < 2) {
                hour = "0" + (hourChange - 2);
            }
            if (hourChange <= 1) {
                hour = "99";
                hourChange = 100;
            } else {
                --hourChange;
            }
            labelHours.setText(hour + ":" + minute + ":" + second);
        }
    }

    public void minInc() {
        if (!minIncClicked) {
            isTicking = true;
            minute = String.valueOf(minChange);
            if (minute.length() < 2) {
                minute = "0" + (minChange);
            }
            if (minChange > 59) {
                minute = "00";
                minChange = 1;
            } else {
                minChange++;
            }
            labelHours.setText(hour + ":" + minute + ":" + second);
        }
    }

    public void minDec() {
        if (!minDecClicked) {
            isTicking = true;
            minute = String.valueOf(minChange - 2);
            if (minute.length() < 2) {
                minute = "0" + (minChange - 2);
            }
            if (minChange <= 1) {
                minute = "59";
                minChange = 60;
            } else {
                --minChange;
            }
            labelHours.setText(hour + ":" + minute + ":" + second);
        }
    }

    public void secInc() {
        if (!secIncClicked) {
            isTicking = true;
            second = String.valueOf(secChange);
            if (second.length() < 2) {
                second = "0" + (secChange);
            }
            if (secChange > 59) {
                second = "00";
                secChange = 1;
            } else {
                secChange++;
            }
            labelHours.setText(hour + ":" + minute + ":" + second);
        }
    }

    public void secDec() {
        if (!secDecClicked) {
            isTicking = true;
            second = String.valueOf(secChange - 2);
            if (second.length() < 2) {
                second = "0" + (secChange - 2);
            }
            if (secChange <= 1) {
                second = "59";
                secChange = 60;
            } else {
                --secChange;
            }
            labelHours.setText(hour + ":" + minute + ":" + second);
        }
    }

    public void setTimer() {
        if (isTicking) {
            wt = new WatchTimer(Long.parseLong(hour), Long.parseLong(minute), Long.parseLong(second));
            timer = new Timer();
            if (wt.getSec() > 0 || wt.getMin() > 0 || wt.getH() > 0) {
                timerOn = true;
                hourIncClicked = true;
                hourDecClicked = true;
                minIncClicked = true;
                minDecClicked = true;
                secIncClicked = true;
                secDecClicked = true;
                timer.scheduleAtFixedRate(new TimerTask() {
                    public void run() {
                        second = String.valueOf(wt.getSec());
                        minute = String.valueOf(wt.getMin());
                        hour = String.valueOf(wt.getH());
                        if (second.length() < 2) {
                            second = "0" + second;
                        }
                        if (minute.length() < 2) {
                            minute = "0" + minute;
                        }
                        if (hour.length() < 2) {
                            hour = "0" + hour;
                        }
                        if (wt.getH() < 1 && wt.getMin() < 1 && wt.getSec() < 1) {
                            reset();
                            playAudio(2);
                        } else {
                            if (wt.getSec() < 1 && wt.getMin() != 0) {
                                wt.setMin(wt.getMin() - 1);
                                wt.setSec(59);
                            } else if (wt.getSec() < 1 && wt.getMin() == 0 && wt.getH() != 0) {
                                wt.setH(wt.getH() - 1);
                                wt.setSec(59);
                                wt.setMin(59);
                            } else {
                                wt.setSec(wt.getSec() - 1);
                            }
                            Platform.runLater(() -> labelHours.setText(hour + ":" + minute + ":" + second));
                        }
                        isTicking = false;
                    }
                }, 100, 1000);
            }
        }
    }

    public void stop() {
        isTicking = true;
        if (timerOn) {
            Platform.runLater(() -> timer.cancel());
        }
        playAudio(1);
    }

    public void reset() {
        hourIncClicked = false;
        hourDecClicked = false;
        minIncClicked = false;
        minDecClicked = false;
        secIncClicked = false;
        secDecClicked = false;
        isTicking = true;
        Platform.runLater(() -> labelHours.setText("00" + ":" + "00" + ":" + "00"));
        hour = "00";
        minute = "00";
        second = "00";
        hourChange = 1;
        minChange = 1;
        secChange = 1;
        stop();
    }

    public void playAudio(int choice) {
        AudioClip alarm = new AudioClip(getClass().getResource("Alarm.mp3").toString());
        if (choice == 1) {
            alarm.stop();
        } else {
            alarm.play();
        }
    }

    @FXML
    public void timerScene(javafx.event.ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("timer.fxml"));
        Scene scene2 = new Scene(view2, 500, 375);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void stopwatchScene(javafx.event.ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("stopwatch.fxml"));
        Scene scene2 = new Scene(view2, 500, 375);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }


    @FXML
    public void alarmScene(javafx.event.ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("alarm.fxml"));
        Scene scene2 = new Scene(view2, 500, 375);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

}