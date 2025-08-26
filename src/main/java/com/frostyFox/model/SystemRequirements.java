package com.frostyFox.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class SystemRequirements {
    private int minRam;
    private int minStorage;
    private boolean multiplayerSupported;
    private String OSRequirement;
    private String graphicsRequirement;

    public SystemRequirements(String OSRequirement, boolean multiplayerSupported, int minStorage, int minRam, String graphicsRequirement) {
        this.OSRequirement = OSRequirement;
        this.multiplayerSupported = multiplayerSupported;
        this.minStorage = minStorage;
        this.minRam = minRam;
        this.graphicsRequirement = graphicsRequirement;
    }

    public SystemRequirements() {
    }

    public String getGraphicsRequirement() {
        return graphicsRequirement;
    }

    public void setGraphicsRequirement(String graphicsRequirement) {
        this.graphicsRequirement = graphicsRequirement;
    }

    public int getMinRam() {
        return minRam;
    }

    public void setMinRam(int minRam) {
        this.minRam = minRam;
    }

    public int getMinStorage() {
        return minStorage;
    }

    public void setMinStorage(int minStorage) {
        this.minStorage = minStorage;
    }

    public boolean isMultiplayerSupported() {
        return multiplayerSupported;
    }

    public void setMultiplayerSupported(boolean multiplayerSupported) {
        this.multiplayerSupported = multiplayerSupported;
    }

    public String getOSRequirement() {
        return OSRequirement;
    }

    public void setOSRequirement(String OSRequirement) {
        this.OSRequirement = OSRequirement;
    }

    @Override
    public String toString() {
        return "SystemRequirements{" +
                "graphicsRequirement='" + graphicsRequirement + '\'' +
                ", minRam=" + minRam +
                ", minStorage=" + minStorage +
                ", multiplayerSupported=" + multiplayerSupported +
                ", OSRequirement='" + OSRequirement + '\'' +
                '}';
    }
}
