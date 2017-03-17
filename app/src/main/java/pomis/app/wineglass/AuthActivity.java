package pomis.app.wineglass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dd.processbutton.iml.ActionProcessButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {
    @BindView(R.id.vk_auth_butt)
    ActionProcessButton vkButt;

    @BindView(R.id.fb_auth_butt)
    ActionProcessButton fbButt;
    private ProgressGenerator progressGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        progressGenerator =new ProgressGenerator(this);
    }


    @OnClick(R.id.vk_auth_butt) void authVk() {
        progressGenerator.start(vkButt);
    }
    @OnClick(R.id.fb_auth_butt) void authFb() {
        progressGenerator.start(fbButt);
    }

    @Override
    public void onComplete() {
        if(vkButt.getProgress()==100){
            Intent intent = new Intent(AuthActivity.this, SearchActivity.class);
            startActivity(intent);
            finish();
        }
        if(fbButt.getProgress()==100){
            Intent intent = new Intent(AuthActivity.this, SearchActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
