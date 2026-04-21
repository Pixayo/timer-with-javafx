package github.com.pixayo.timer.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.Instant;

public class Timer extends AnimationTimer {

    private final Label label;
    private String timerText = "00:00";
    private String previousTimerText = "No previous timer";

    private Instant startTime;
    private boolean isRunning = false;

    public Timer(Label label) {
        this.label = label;
    }

    @Override
    public void start() {
        this.startTime = Instant.now();
        this.isRunning = true;
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        this.previousTimerText = this.timerText;
        this.isRunning = false;
    }

    @Override
    public void handle(long now) {
        Instant current = Instant.now();
        Duration elapsed = Duration.between(startTime, current);

        long totalMillis = elapsed.toMillis();
        long seconds = elapsed.toSeconds();
        long minutes = elapsed.toMinutes();
        long hours = elapsed.toHours();

        formatTime(totalMillis, seconds, minutes, hours);

        label.setText(timerText);
    }

    private void formatTime(long millis, long seconds, long minutes, long hours) {
        if (seconds < 60) {
            this.timerText = String.format("%02d:%02d",
                    seconds,
                    (millis % 1000) / 10);
        } else if (minutes < 60) {
            this.timerText = String.format("%02dm:%02ds",
                    minutes,
                    seconds % 60);
        } else {
            this.timerText = String.format("%02dh:%02dm:%02ds",
                    hours,
                    minutes % 60,
                    seconds % 60);
        }
    }

    public void reset() {
        timerText = "00:00";
        previousTimerText = "No previous timer";

        label.setText(timerText);
    }

    public String getPreviousTimerText() {
        return previousTimerText;
    }

    public boolean isRunning() {
        return isRunning;
    }
}