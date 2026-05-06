package eu.wejsonekk.syntaxstudio.skygengenerator.generator;

import org.bukkit.Location;

import java.time.Duration;

public class SkyGenerator {

    private Duration regenerationTime;
    private boolean enabled;
    private Generator generator;
    private Location location;

    public SkyGenerator(Generator generator, Location location, Duration regenerationTime) {
        this.generator = generator;
        this.location = location;
        this.regenerationTime = regenerationTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Duration getRegenerationTime() {
        return regenerationTime;
    }

    public void setRegenerationTime(Duration regenerationTime) {
        this.regenerationTime = regenerationTime;
    }

    public SkyGenerator(boolean enabled, Generator generator, Location location, Duration regenerationTime) {
        this.enabled = enabled;
        this.generator = generator;
        this.location = location;
        this.regenerationTime = regenerationTime;
    }
}
