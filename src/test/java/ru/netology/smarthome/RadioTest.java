package ru.netology.smarthome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/setRadioStation.csv")
    public void setRadioStationTest(int setValue, int expected) {

        Radio radio = new Radio();

        if ((setValue < 0) || (setValue > 9)) {

            expected = radio.getRadioStation();
        }
        radio.setRadioStation(setValue);

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextRadioStationTest() {

        Radio radio = new Radio();

        radio.setRadioStation(3);
        radio.nextRadioStation();

        int expected = 4;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextRadioStationAboveMax() {

        Radio radio = new Radio();

        radio.setRadioStation(9);
        radio.nextRadioStation();

        int expected = 0;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevRadioStationTest() {

        Radio radio = new Radio();

        radio.setRadioStation(5);
        radio.prevRadioStation();

        int expected = 4;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevRadioStationBelowMin() {

        Radio radio = new Radio();

        radio.setRadioStation(0);
        radio.prevRadioStation();

        int expected = 9;

        int actual = radio.getRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeTest() {

        Radio radio = new Radio();

        int expected = radio.getVolumeValue();
        radio.increaseVolume();

        expected += 1;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeAboveMax() {

        Radio radio = new Radio();

        do {
            radio.increaseVolume();

        } while (radio.getVolumeValue() != 100);

        radio.increaseVolume();

        int expected = 100;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeTest() {

        Radio radio = new Radio();

        int expected = radio.getVolumeValue();
        radio.decreaseVolume();

        expected -= 1;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeBelowMin() {

        Radio radio = new Radio();

        while (radio.getVolumeValue() != 0) {

            radio.decreaseVolume();
        }

        radio.decreaseVolume();

        int expected = 0;

        int actual = radio.getVolumeValue();

        Assertions.assertEquals(expected, actual);
    }
}
