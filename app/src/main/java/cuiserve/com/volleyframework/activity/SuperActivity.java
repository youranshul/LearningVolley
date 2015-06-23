package cuiserve.com.volleyframework.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cuiserve.com.volleyframework.R;
import cuiserve.com.volleyframework.dialogs.SimpleAlertDialog;
import cuiserve.com.volleyframework.httpConnection.RequestQueueSingleton;

/**
 * Created by ansh on 3/4/15.
 */
public abstract class SuperActivity extends FragmentActivity {

    // Instantiate the RequestQueue.
    private RequestQueue queue;


    @InjectView(R.id.progressBar)
    ProgressBar progressBar;

    private ProgressDialog progressDialog;

    public abstract View getLayoutResource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_xml);
        ButterKnife.inject(this);
    }

    BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnected();
            if (isConnected) {
                internetAvailable();
            } else {
                showNoInternetPopup();
            }
        }
    };

    protected abstract void internetAvailable();

    protected void showNoInternetPopup() {
        SimpleAlertDialog alertDialog = new SimpleAlertDialog();
        alertDialog.show(getSupportFragmentManager(), "1001");
    }


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkStateReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkStateReceiver);
    }

    protected <T> void onExecute(T request) {
        // Add the request to the RequestQueue.
        RequestQueueSingleton.getInstance(this.getApplicationContext()).addToRequestQueue((Request<T>) request);

    }

    protected void cancelVolleyRequests(String requestTag) {

        RequestQueueSingleton.getInstance(this).CancelRequest(requestTag);


    }

    protected void hideProgressBar() {
        if (progressBar != null && progressBar.isShown()) {
            progressBar.setVisibility(View.GONE);
        }
    }

    protected void showProgressBar() {
        if (progressBar != null && !progressBar.isShown()) {
            progressBar.setVisibility(View.VISIBLE);

        }
    }

}
