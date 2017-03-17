package pomis.app.wineglass.Models;

/**
 * Created by romanismagilov on 17.03.17.
 */

public class Codrinker {
    public String name;
    public int age;
    public double lat, lon;

    public Codrinker(String name, int age, double lat, double lon) {
        this.name = name;
        this.age = age;
        this.lat = lat;
        this.lon = lon;
    }
}
