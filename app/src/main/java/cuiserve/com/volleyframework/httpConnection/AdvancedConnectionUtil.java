package cuiserve.com.volleyframework.httpConnection;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import cuiserve.com.volleyframework.requestData.AdvancedJacksonRequest;
import cuiserve.com.volleyframework.requestData.CustomRequest;
import cuiserve.com.volleyframework.requestData.DataList;

/**
 * Created by ansh on 21/6/15.
 */
public class AdvancedConnectionUtil<T> implements Response.Listener<T>, Response.ErrorListener {

    private int requestType;
    private ServerListener listener;

    public AdvancedConnectionUtil(int requestType, ServerListener<T> listener) {

        this.listener = listener;
        this.requestType = requestType;
    }

    public AdvancedJacksonRequest<T> getRequest() {

        switch (requestType) {
            case HttpRequestConstant.LOGIN_REQUEST:
                //This gives compile error while while passing DataList.class in the argument
                return new CustomRequest<T>((Class<T>) DataList.class, this, this);
        }
        return null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        listener.onErrorReceived(error.getMessage());
    }

    @Override
    public void onResponse(T response) {
        listener.onDataReceived(response);
    }


    public interface ServerListener<T> {

        public void onDataReceived(T data);

        public void onErrorReceived(String errorMsg);

    }

}



