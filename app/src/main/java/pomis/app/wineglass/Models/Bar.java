package pomis.app.wineglass.Models;

/**
 * Created by romanismagilov on 17.03.17.
 */

public class Bar {
    public String name;
    public double lat;
    public double lon;

    public Bar(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }
}
