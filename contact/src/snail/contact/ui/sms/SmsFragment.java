package snail.contact.ui.sms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import snail.contact.R;
import snail.contact.sync.sms.TelephonyBackUpTask;

import java.util.concurrent.Future;

/**
 * Created by fenghb on 3/7/14.
 */
public class SmsFragment extends Fragment implements TelephonyBackUpTask.onCompleteListener {

    private static final String TAG = "SmsFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TelephonyBackUpTask smsBackUpTask = new TelephonyBackUpTask(getActivity());
        smsBackUpTask.setonCompleteListener(this);
        smsBackUpTask.execute(null);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_sms, null);

        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onComplete(Future<Object> result) {
        Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_LONG).show();
    }
}
