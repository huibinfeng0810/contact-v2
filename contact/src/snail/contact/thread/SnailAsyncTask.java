package snail.contact.thread;

import android.content.Context;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by fenghb on 3/12/14.
 */
public abstract class SnailAsyncTask {
    private static final int THREAD_COUNT = 10;


    public abstract Object doTask(Object inputParameters);

    ExecutorService exec = Executors.newFixedThreadPool(THREAD_COUNT);

    /**
     * context
     */

    private Context context;

    /**
     * construct method
     */
    protected SnailAsyncTask(Context context) {
        this.context = context;
    }

    public interface onCompleteListener {
        /**
         * return the result of thread
         */
        public void onComplete(Future<Object> result);
    }

    private onCompleteListener mOnCompleteListener;

    public void setonCompleteListener(onCompleteListener listener) {
        this.mOnCompleteListener = listener;
    }


    public void execute(final Object inputParameters) {
        Future<Object> result = exec.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return doTask(inputParameters);
            }
        });
        mOnCompleteListener.onComplete(result);
        exec.shutdown();
    }
}
