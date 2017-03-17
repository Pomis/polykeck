package pomis.app.wineglass;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dd.processbutton.FlatButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fb_dial)
    void dial() {
        Log.d("kek", "lek");
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+79153234801", null)));

    }
}
