package snail.contact.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by fenghb on 3/7/14.
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentsList;


    public HomeFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentsList) {
        super(fm);
        this.fragmentsList = fragmentsList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
