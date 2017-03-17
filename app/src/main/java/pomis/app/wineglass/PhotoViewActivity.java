package pomis.app.wineglass;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoViewActivity extends AppCompatActivity {
    @BindView(R.id.vp_profile_images) ViewPager vpProfilePhoto;
    static int NUM_ITEMS = 3;
    ImageFragmentPagerAdapter imageFragmentPagerAdapter;
    public static String name;
    public static final String[] IMAGESMIXOIL = {"profile_photo", "profile_photo1", "profile_photo2"};
    public static final String[] IMAGESMARINA = {"marina"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        ButterKnife.bind(this);

        name = getIntent().getStringExtra("name");
        if(name.contains("Марина")){
            NUM_ITEMS = 1;
        }else {
            NUM_ITEMS = 3;
        }
        imageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());
        vpProfilePhoto.setAdapter(imageFragmentPagerAdapter);
    }

    public static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {
        public ImageFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            SwipeFragment fragment = new SwipeFragment();
            return SwipeFragment.newInstance(position);
        }
    }

    public static class SwipeFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View swipeView = inflater.inflate(R.layout.swipe_item, container, false);
            ImageView imageView = (ImageView) swipeView.findViewById(R.id.imageView);
            Bundle bundle = getArguments();
            int position = bundle.getInt("position");
            String imageFileName;
            if(name.contains("Марина")){
                imageFileName = IMAGESMARINA[position];
            }else {
                imageFileName = IMAGESMIXOIL[position];
            }
            int imgResId = getResources().getIdentifier(imageFileName, "drawable", "pomis.app.wineglass");
            imageView.setImageResource(imgResId);
            return swipeView;
        }

        static SwipeFragment newInstance(int position) {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            swipeFragment.setArguments(bundle);
            return swipeFragment;
        }
    }
}
