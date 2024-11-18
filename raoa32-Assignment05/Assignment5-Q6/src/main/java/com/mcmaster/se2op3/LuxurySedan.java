package com.mcmaster.se2op3;

public class LuxurySedan extends LuxuryCar {
    private String mediaPlayed;

    public LuxurySedan() {
    }

    public LuxurySedan(String make, String model, float fuelTankCapacity, float milesPerGallon, float temperature,
            String mediaPlayed) {
        super(make, model, fuelTankCapacity, milesPerGallon, temperature);
        this.mediaPlayed = mediaPlayed;
    }

    public String getMediaPlayed() {
        return mediaPlayed;
    }

    public void setMediaPlayed(String mediaPlayed) {
        this.mediaPlayed = mediaPlayed;
    }

    @Override
    public void playMedia(String song) {
        setMediaPlayed(song);
    }

}
