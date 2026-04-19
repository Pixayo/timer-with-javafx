package github.com.pixayo.timer;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.Instant;

public class Timer extends AnimationTimer {

    private String timeText;
    private final Label label;

    private String previusTimeText;

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
        previusTimeText = timeText;
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

        label.setText(timeText);
    }

    private void formatTime(long millis, long seconds, long minutes, long hours) {

        if (seconds < 60) {
            this.timeText = String.format("%02d:%02d",
                    seconds,
                    (millis % 1000) / 10);
        } else if (minutes < 60) {
            this.timeText = String.format("%02d:%02d",
                    minutes,
                    seconds % 60);
        } else {
            this.timeText = String.format("%02d:%02d:%02d",
                    hours,
                    minutes % 60,
                    seconds % 60);
        }
    }

    public String getPreviusTimeText() {
        if (previusTimeText != null) {
            return previusTimeText;
        }
        return "no previus time";
    }

    public boolean isRunning() {
        return isRunning;
    }
}