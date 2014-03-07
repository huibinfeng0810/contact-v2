package snail.contact.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import snail.contact.R;
import snail.contact.ui.contact.ContactFragment;
import snail.contact.ui.dial.DialFragment;
import snail.contact.ui.setting.SettingFragment;
import snail.contact.ui.sms.SmsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenghb on 3/7/14.
 */
public class HomeActivity extends SlidingFragmentActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private List<Fragment> fragmentsList;
    private HomeSlidingMenuFragment mHomeSlidingMenuFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBehindContentView(R.layout.menu_frame);
        if (savedInstanceState == null) {
            FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
            mHomeSlidingMenuFragment = new HomeSlidingMenuFragment();
            t.replace(R.id.menu_frame, mHomeSlidingMenuFragment);
            t.commit();
        } else {
            mHomeSlidingMenuFragment = (HomeSlidingMenuFragment) this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
        }

        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidthRes(R.dimen.slidingmenu_shadow_width);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
        initViewPager();

    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentsList = new ArrayList<Fragment>();
        fragmentsList.add(new ContactFragment());
        fragmentsList.add(new DialFragment());
        fragmentsList.add(new SettingFragment());
        fragmentsList.add(new SmsFragment());
        viewPager.setAdapter(new HomeFragmentPagerAdapter(getSupportFragmentManager(), fragmentsList));
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {


    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
