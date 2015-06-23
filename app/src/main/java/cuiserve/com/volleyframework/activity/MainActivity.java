package cuiserve.com.volleyframework.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import javax.net.ssl.SSLPeerUnverifiedException;

import cuiserve.com.volleyframework.R;
import cuiserve.com.volleyframework.httpConnection.AdvancedConnectionUtil;
import cuiserve.com.volleyframework.httpConnection.HttpRequestConstant;
import cuiserve.com.volleyframework.requestData.CustomRequest;
import cuiserve.com.volleyframework.requestData.DataList;

public class MainActivity extends SuperActivity {

    @Override
    public View getLayoutResource() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showProgressBar();
        CustomRequest<DataList> JacksonRequest  = (CustomRequest) new AdvancedConnectionUtil<DataList>(HttpRequestConstant.LOGIN_REQUEST, httpListener).getRequest();

        //This commented code works fine when i create a request this way
       /* JacksonRequest<DataList> jacksonRequest = new JacksonRequest<DataList>(Request.Method.GET, HttpRequestConstant.JACKSON_FETCH, null, DataList.class, new Response.Listener<DataList>() {
            @Override
            public void onResponse(DataList response) {
                hideProgressBar();
                Log.e("ANSH", "onResponse : " + response.getPicture());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideProgressBar();
                Log.e("ANSH", "onErrorResponse : " + error.getLocalizedMessage());
            }
        });*/

        onExecute(JacksonRequest);

    }

    private AdvancedConnectionUtil.ServerListener  httpListener = new AdvancedConnectionUtil.ServerListener<DataList>() {
        @Override
        public void onDataReceived(DataList data) {
            hideProgressBar();
            Log.e("ANSH", "onResponse : " + data.getPicture());
        }

        @Override
        public void onErrorReceived(String errorMsg) {
            hideProgressBar();
            Log.e("ANSH", "onResponse : " + errorMsg);
        }
    };

    @Override
    protected void internetAvailable() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
