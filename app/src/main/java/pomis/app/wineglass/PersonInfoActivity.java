package pomis.app.wineglass;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.zagum.switchicon.SwitchIconView;

import at.markushi.ui.CircleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.blurry.Blurry;

public class PersonInfoActivity extends AppCompatActivity {
    @BindView(R.id.like_cb) CircleButton likeCB;
    @BindView(R.id.dislike_cb) CircleButton dislikeCB;
    @BindView(R.id.profile_image_back) ImageView backPhoto;
    @BindView(R.id.profile_image) ImageView profilePhoto;
    @BindView(R.id.name_tv) TextView nameTV;
    @BindView(R.id.preference_tv) TextView preferenceTV;
    @BindView(R.id.siv_vodka) SwitchIconView sivVodka;
    @BindView(R.id.siv_beer) SwitchIconView sivBeer;
    @BindView(R.id.siv_wine) SwitchIconView sivWine;
    @BindView(R.id.siv_cocktail) SwitchIconView sivCocktail;
    @BindView(R.id.rl_vodka) RelativeLayout rlVodka;
    @BindView(R.id.rl_beer) RelativeLayout rlBeer;
    @BindView(R.id.rl_wine) RelativeLayout rlWine;
    @BindView(R.id.rl_cocktail) RelativeLayout rlCocktail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Bitmap backPhotoBmp = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.profile_photo);
        Blurry.with(this)
                .radius(10)
                .sampling(8)
                .from(backPhotoBmp)
                .into(backPhoto);
        backPhoto.setColorFilter(new LightingColorFilter(0xFF7F7F7F, 0x00000000)); //затемняем фото
        sivCocktail.setIconEnabled(false);
        sivWine.setIconEnabled(false);
        rlCocktail.setAlpha(0.2f);
        rlWine.setAlpha(0.2f);

    }

    @OnClick(R.id.profile_image) void viewPhotos(){
        Intent intent = new Intent(PersonInfoActivity.this, PhotoViewActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.like_cb) void likeEvent(){
        Toast likeToast = Toast.makeText(this, "Ждите отклика!", Toast.LENGTH_SHORT);
        likeToast.show();
    }
    @OnClick(R.id.dislike_cb) void dislikeEvent(){
        Intent intent = new Intent(PersonInfoActivity.this, LocatorActivity.class);
        startActivity(intent);
    }
}
