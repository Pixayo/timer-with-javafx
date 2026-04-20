package github.com.pixayo.timer;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.Instant;

public class Timer extends AnimationTimer {

    private final Label label;
    private String timeText;
    private String previousTimeText;

    private Instant startTime;
    private boolean isRunning = false;

    Timer(Label label) {
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
        this.previousTimeText = this.timeText;
        this.isRunning = false;
    }

    @Override
    public void handle(long now) {
        try {
            Instant current = Instant.now();
            Duration elapsed = Duration.between(startTime, current);

            long totalMillis = elapsed.toMillis();
            long seconds = elapsed.toSeconds();
            long minutes = elapsed.toMinutes();
            long hours = elapsed.toHours();

            formatTime(totalMillis, seconds, minutes, hours);

            label.setText(timeText);
        } catch (ArithmeticException e) {
            // POPUP
        }
    }

    private void formatTime(long millis, long seconds, long minutes, long hours) {
        if (seconds < 60) {
            this.timeText = String.format("%02d:%02d",
                    seconds,
                    (millis % 1000) / 10);
        } else if (minutes < 60) {
            this.timeText = String.format("%02dm:%02ds",
                    minutes,
                    seconds % 60);
        } else {
            this.timeText = String.format("%02dh:%02dm:%02ds",
                    hours,
                    minutes % 60,
                    seconds % 60);
        }
    }

    public String getPreviousTimeText() {
        if (previousTimeText != null) {
            return previousTimeText;
        }
        return "no previous time";
    }

    public boolean isRunning() {
        return isRunning;
    }
}