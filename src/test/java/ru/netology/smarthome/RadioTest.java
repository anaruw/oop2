package ru.netology.smarthome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {

    private int radioStationCount = 10;

    private int minRadioStationNumber = 0;
    private int maxRadiostationNumber = minRadioStationNumber + radioStationCount - 1;

    private int minVolumeValue = 0;
    private int maxVolumeValue = 100;

    Radio radio = new Radio(radioStationCount);

    private int currentVolumeValue = radio.getVolumeValue();

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/setRadioStation.csv")
    public void setRadioStationTest(int setValue, int expected) {

        if ((setValue < minRadioStationNumber) || (setValue > maxRadiostationNumber)) {

            expected = radio.getRadioStation();
        }
        radio.setRadioStation(setValue);

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextRadioStationTest() {

        radio.setRadioStation(3);
        radio.nextRadioStation();

        int expected = 4;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextRadioStationAboveMax() {

        radio.setRadioStation(maxRadiostationNumber);
        radio.nextRadioStation();

        int expected = minRadioStationNumber;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevRadioStationTest() {

        radio.setRadioStation(5);
        radio.prevRadioStation();

        int expected = 4;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevRadioStationBelowMin() {

        radio.setRadioStation(minRadioStationNumber);
        radio.prevRadioStation();

        int expected = maxRadiostationNumber;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeTest() {

        int expected = radio.getVolumeValue();
        radio.increaseVolume();

        expected += 1;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeAboveMax() {

        for (int i = currentVolumeValue; i <= maxVolumeValue; i++) {

            radio.increaseVolume();
        }

        radio.increaseVolume();

        int expected = maxVolumeValue;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeTest() {

        int expected = radio.getVolumeValue();
        radio.decreaseVolume();

        expected -= 1;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeBelowMin() {

        for (int i = currentVolumeValue; i >= minVolumeValue; i--) {

            radio.decreaseVolume();
        }
        radio.decreaseVolume();

        int expected = minVolumeValue;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }
}
