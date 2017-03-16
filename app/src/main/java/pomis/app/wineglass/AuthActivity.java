package pomis.app.wineglass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dd.processbutton.FlatButton;
import com.dd.processbutton.iml.ActionProcessButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends AppCompatActivity {
    @BindView(R.id.vk_auth_butt)
    FlatButton vkButt;

    @BindView(R.id.fb_auth_butt)
    FlatButton fbButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.vk_auth_butt) void auth(){
        startActivity(new Intent(this, SearchActivity.class));
    }
}
