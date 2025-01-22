package ru.netology.smarthome;

public class Radio {

    private int minVolumeValue = 0;
    private int maxVolumeValue = 100;
    private int currentvolumeValue = 10;

    private int minRadioStationNumber = 0;
    private int maxRadioStationNumber;
    private int defaultRadioStationCount = 10;
    private int currentRadioStationNumber = minRadioStationNumber;

    public Radio() {

        maxRadioStationNumber = defaultRadioStationCount - 1;
    }

    public Radio(int radioStationCount) {

        maxRadioStationNumber = radioStationCount - 1;
    }

    public void setRadioStation(int currentRadioStationNumber) {

        if ((currentRadioStationNumber < minRadioStationNumber) || (currentRadioStationNumber > maxRadioStationNumber)) {

            return;
        }
        this.currentRadioStationNumber = currentRadioStationNumber;
    }

    public void nextRadioStation() {

        if (currentRadioStationNumber == maxRadioStationNumber) {

            currentRadioStationNumber = minRadioStationNumber;
            return;
        }
        currentRadioStationNumber += 1;
    }

    public void prevRadioStation() {

        if (currentRadioStationNumber == minRadioStationNumber) {

            currentRadioStationNumber = maxRadioStationNumber;
            return;
        }
        currentRadioStationNumber -= 1;
    }

    public void increaseVolume() {

        if (currentvolumeValue == maxVolumeValue) {

            return;
        }
        currentvolumeValue += 1;
    }

    public void decreaseVolume() {

        if (currentvolumeValue == minVolumeValue) {

            return;
        }
        currentvolumeValue -= 1;
    }

    public int getRadioStation() {
        return currentRadioStationNumber;
    }

    public int getVolumeValue() {
        return currentvolumeValue;
    }
}
