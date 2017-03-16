package pomis.app.wineglass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

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


    boolean beerSet = true;
    boolean wineSet = false;
    boolean cocktailSet = false;
    boolean vodkaSet = false;

    boolean maleSet = false;
    boolean femaleSet = false;

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
        setAlpha();
    }

    @OnClick(R.id.rl_beer)
    void switchBeer() {
        beerSet = !beerSet;
        setAlpha();
    }

    @OnClick(R.id.rl_cocktail)
    void switchCocktail() {
        cocktailSet = !cocktailSet;
        setAlpha();
    }

    @OnClick(R.id.rl_wine)
    void switchWine() {
        wineSet = !wineSet;
        setAlpha();
    }

    @OnClick(R.id.rl_male)
    void switchMale() {
        maleSet = !maleSet;
        setAlpha();
    }

    @OnClick(R.id.rl_female)
    void switchFemale() {
        femaleSet = !femaleSet;
        setAlpha();
    }

    void setAlpha() {
        rlVodka.setAlpha(vodkaSet ? 1f : 0.2f);
        rlBeer.setAlpha(beerSet ? 1f : 0.2f);
        rlCocktail.setAlpha(cocktailSet ? 1f : 0.2f);
        rlWine.setAlpha(wineSet ? 1f : 0.2f);
        rlMale.setAlpha(maleSet ? 1f : 0.2f);
        rlFemale.setAlpha(femaleSet ? 1f : 0.2f);
    }
}
