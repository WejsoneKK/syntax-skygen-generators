package eu.wejsonekk.syntaxstudio.skygengenerator.generator.genboost;

import org.bukkit.Material;

import java.time.Duration;

public class GeneratorBooster {
    public Duration getBoosterTime() {
        return boosterTime;
    }

    public void setBoosterTime(Duration boosterTime) {
        this.boosterTime = boosterTime;
    }

    public Material getGenBoostIcon() {
        return genBoostIcon;
    }

    public void setGenBoostIcon(Material genBoostIcon) {
        this.genBoostIcon = genBoostIcon;
    }

    public String getGenBoostId() {
        return genBoostId;
    }

    public void setGenBoostId(String genBoostId) {
        this.genBoostId = genBoostId;
    }

    public GeneratorBoostType getGenBoostType() {
        return genBoostType;
    }

    public void setGenBoostType(GeneratorBoostType genBoostType) {
        this.genBoostType = genBoostType;
    }

    public GeneratorBooster(Duration boosterTime, Material genBoostIcon, String genBoostId, GeneratorBoostType genBoostType) {
        this.boosterTime = boosterTime;
        this.genBoostIcon = genBoostIcon;
        this.genBoostId = genBoostId;
        this.genBoostType = genBoostType;
    }

    private String genBoostId;
    private Material genBoostIcon;
    private GeneratorBoostType genBoostType;
    private Duration boosterTime;

}
