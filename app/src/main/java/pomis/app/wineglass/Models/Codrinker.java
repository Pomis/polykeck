package pomis.app.wineglass.Models;

import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;

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
    public int photo;


    public Codrinker(String name, int age, Gender gender, double lat, double lon, @DrawableRes int photo) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.lat = lat;
        this.lon = lon;
        this.photo = photo;
    }
}
