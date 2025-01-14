package ru.netology.smarthome;

public class Radio {

    private int radioStation = 0;
    private int volumeValue = 10;

    public void setRadioStation(int radioStation) {

        if ((radioStation < 0) || (radioStation > 9)) {

            return;
        }
        this.radioStation = radioStation;
    }

    public void nextRadioStation() {

        if (radioStation == 9) {

            radioStation = 0;
            return;
        }
        radioStation += 1;
    }

    public void prevRadioStation() {

        if (radioStation == 0) {

            radioStation = 9;
            return;
        }
        radioStation -= 1;
    }

    public void increaseVolume() {

        if (volumeValue == 100) {

            return;
        }
        volumeValue += 1;
    }

    public void decreaseVolume() {

        if (volumeValue == 0) {

            return;
        }
        volumeValue -= 1;
    }

    public int getRadioStation() {
        return radioStation;
    }

    public int getVolumeValue() {
        return volumeValue;
    }
}
