package pomis.app.wineglass.Models;

/**
 * Created by romanismagilov on 17.03.17.
 */

public class Codrinker {
    public enum Gender {
        MALE, FEMALE
    }

    public String name;
    public int age;
    public double lat, lon;
    public Gender gender;

    public Codrinker(String name, int age, Gender gender, double lat, double lon) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.lat = lat;
        this.lon = lon;
    }
}
