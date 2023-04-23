package com.example.restapitask;

import lombok.Data;

@Data
public class HouseToBuy {
    int numberOfFloors;
    String quality;
    boolean seaView;

    public HouseToBuy(int numberOfFloors, String quality, boolean seaView) {
        this.numberOfFloors = numberOfFloors;
        this.quality = quality;
        this.seaView = seaView;
    }

    @Override
    public String toString() {
        return "HouseToBuy - >" +
                "numberOfFloors=" + numberOfFloors +
                ", quality='" + quality + '\'' +
                ", seaView=" + seaView ;
    }
}
