package pomis.app.wineglass;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import pomis.app.wineglass.Models.Bar;
import pomis.app.wineglass.Models.Codrinker;

public class LocatorActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Bar> barList;
    private ArrayList<Codrinker> codrinkerList;

    private static final String BAR = "bar";
    private static final String CODRINKER = "codrinker";


    private boolean maleSet;
    private boolean femaleSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        readIntent();
    }

    private void readIntent() {
        maleSet = getIntent().getBooleanExtra("male", false);
        femaleSet = getIntent().getBooleanExtra("female", false);
    }


    void initBars() {
        barList = new ArrayList<>();

        barList.add(new Bar(
                "Killfish bar",
                55.688728, 37.572061
        ));

        barList.add(new Bar(
                "Beertime Bar",
                55.68282, 37.58053
        ));

        barList.add(new Bar(
                "Crazy bar",
                55.68774, 37.57042
        ));
    }

    void initCodrinkers() {
        codrinkerList = new ArrayList<>();

        codrinkerList.add(new Codrinker(
                "Марина", 20, Codrinker.Gender.FEMALE,
                55.684, 37.56542,
                R.drawable.marina
        ));

        codrinkerList.add(new Codrinker(
                "Михаил", 21, Codrinker.Gender.MALE,
                55.681, 37.57542,
                R.drawable.profile_photo
        ));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        initBars();
        initCodrinkers();
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(55.6887287, 37.5728061), 15));

        drawBarMarkers();
        drawCodrinkerMarkers();


        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker.getSnippet() != null) {
                    startActivity(new Intent(getApplicationContext(), BarInfoActivity.class).putExtra("name", marker.getTitle()));
                } else {
                    startActivity(new Intent(getApplicationContext(), PersonInfoActivity.class).putExtra("name", marker.getTitle()));
                }
            }
        });

    }

    private void drawCodrinkerMarkers() {
        for (Codrinker codrinker : codrinkerList)
            if (maleSet && codrinker.gender == Codrinker.Gender.MALE ||
                    femaleSet && codrinker.gender == Codrinker.Gender.FEMALE)
                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(codrinker.lat, codrinker.lon))
                        .title(codrinker.name + ", " + codrinker.age)
                        .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(codrinker.photo))));
    }

    private void drawBarMarkers() {
        for (Bar bar : barList)
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(bar.lat, bar.lon))
                    .title(bar.name)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bar))
                    .snippet(BAR));

    }

    private Bitmap getMarkerBitmapFromView(@DrawableRes int resId) {

        View customMarkerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.marker_codrinker, null);
        ImageView markerImageView = (ImageView) customMarkerView.findViewById(R.id.profile_image);
        markerImageView.setImageResource(resId);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }
}
