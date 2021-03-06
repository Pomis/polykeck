package pomis.app.wineglass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.zagum.switchicon.SwitchIconView;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.rl_vodka)
    RelativeLayout rlVodka;

    @BindView(R.id.rl_beer)
    RelativeLayout rlBeer;

    @BindView(R.id.rl_wine)
    RelativeLayout rlWine;

    @BindView(R.id.rl_cocktail)
    RelativeLayout rlCocktail;

    @BindView(R.id.rl_male)
    RelativeLayout rlMale;

    @BindView(R.id.rl_female)
    RelativeLayout rlFemale;

    @BindView(R.id.siv_vodka)
    SwitchIconView sivVodka;

    @BindView(R.id.siv_beer)
    SwitchIconView sivBeer;

    @BindView(R.id.siv_wine)
    SwitchIconView sivWine;

    @BindView(R.id.siv_cocktail)
    SwitchIconView sivCocktail;

    @BindView(R.id.siv_male)
    SwitchIconView sivMale;

    @BindView(R.id.siv_female)
    SwitchIconView sivFemale;

    @BindView(R.id.ll_when)
    LinearLayout llWhen;

    @BindView(R.id.tv_time)
    TextView tvTime;

    boolean beerSet = true;
    boolean wineSet = true;
    boolean cocktailSet = true;
    boolean vodkaSet = true;

    boolean maleSet = true;
    boolean femaleSet = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setAlpha();
    }

    @OnClick(R.id.rl_vodka)
    void switchVodka() {
        vodkaSet = !vodkaSet;
        sivVodka.switchState();
        setAlpha();
    }

    @OnClick(R.id.rl_beer)
    void switchBeer() {
        beerSet = !beerSet;
        sivBeer.switchState();
        setAlpha();
    }

    @OnClick(R.id.rl_cocktail)
    void switchCocktail() {
        cocktailSet = !cocktailSet;
        sivCocktail.switchState();
        setAlpha();
    }

    @OnClick(R.id.rl_wine)
    void switchWine() {
        wineSet = !wineSet;
        sivWine.switchState();
        setAlpha();
    }

    @OnClick(R.id.rl_male)
    void switchMale() {
        maleSet = !maleSet;
        sivMale.switchState();
        setAlpha();
    }

    @OnClick(R.id.rl_female)
    void switchFemale() {
        femaleSet = !femaleSet;
        sivFemale.switchState();
        setAlpha();
    }

    @OnClick(R.id.fb_drink)
    void drink() {
        startActivity(new Intent(this, LocatorActivity.class).putExtra("male", maleSet).putExtra("female", femaleSet));
    }

    void setAlpha() {
        rlVodka.setAlpha(vodkaSet ? 1f : 0.2f);
        rlBeer.setAlpha(beerSet ? 1f : 0.2f);
        rlCocktail.setAlpha(cocktailSet ? 1f : 0.2f);
        rlWine.setAlpha(wineSet ? 1f : 0.2f);
        rlMale.setAlpha(maleSet ? 1f : 0.2f);
        rlFemale.setAlpha(femaleSet ? 1f : 0.2f);
    }

    @OnClick(R.id.ll_when)
    void setTime() {
        Calendar now = Calendar.getInstance();
        TimePickerDialog dpd = TimePickerDialog.newInstance(
                SearchActivity.this,
                now.get(Calendar.HOUR),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                true
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        tvTime.setText("Сегодня в " + hourOfDay + ":" + minute);
    }
}
