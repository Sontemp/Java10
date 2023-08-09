import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadioTest {
    @Test
    public void testSetCurrentStationRegular(){
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        int actual = radio.getCurrentStation();
        int expected = 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationOver9(){
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.setCurrentStation(10);
        int actual = radio.getCurrentStation();
        int expected = 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationOverMaxLimit(){
        Radio radio = new Radio( 15);

        radio.setCurrentStation(5);
        radio.setCurrentStation(15);
        int actual = radio.getCurrentStation();
        int expected = 5;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationBellow0(){
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.setCurrentStation(-1);
        int actual = radio.getCurrentStation();
        int expected = 7;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testNextRegular(){
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testNextAfter9(){
        Radio radio = new Radio();

        radio.setCurrentStation(9);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextAfterMaxLimit(){
        Radio radio = new Radio(15);

        radio.setCurrentStation(14);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 0;


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevRegular(){
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 6;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevPrevious0(){
        Radio radio = new Radio();

        radio.setCurrentStation(0);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 9;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevPrevious0WithMaxLimit(){
        Radio radio = new Radio(15);

        radio.setCurrentStation(0);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 14;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetVolume(){
        Radio radio = new Radio();

        radio.setCurrentVolume(26);
        radio.prev();
        int actual = radio.getCurrentVolume();
        int expected = 26;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetVolumeOver100(){
        Radio radio = new Radio();

        radio.setCurrentVolume(26);
        radio.setCurrentVolume(101);
        int actual = radio.getCurrentVolume();
        int expected = 26;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetVolumeBellow0(){
        Radio radio = new Radio();

        radio.setCurrentVolume(26);
        radio.setCurrentVolume(-1);
        int actual = radio.getCurrentVolume();
        int expected = 26;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testIncreaseVolumeRegular(){
        Radio radio = new Radio();

        radio.setCurrentVolume(26);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 27;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDecreaseVolumeRegular(){
        Radio radio = new Radio();

        radio.setCurrentVolume(26);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 25;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolumeOver100(){
        Radio radio = new Radio();

        radio.setCurrentVolume(100);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 100;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDecreaseVolumeBellow0(){
        Radio radio = new Radio();

        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}