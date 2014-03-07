package snail.contact.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import snail.contact.R;

/**
 * Created by fenghb on 3/7/14.
 */
public class HomeSlidingMenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_homeslidingmenu, null);
        return mView;
    }
}
