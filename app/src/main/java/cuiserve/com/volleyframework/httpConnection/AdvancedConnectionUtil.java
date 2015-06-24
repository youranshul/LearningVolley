package cuiserve.com.volleyframework.httpConnection;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import cuiserve.com.volleyframework.requestData.AdvancedJacksonRequest;
import cuiserve.com.volleyframework.requestData.LoginRequest;

/**
 * Created by ansh on 21/6/15.
 */
public class AdvancedConnectionUtil<T> implements Response.Listener<T>, Response.ErrorListener {

    private int requestType;
    private final Class<T> type;
    private ServerListener listener;

    public AdvancedConnectionUtil(int requestType, ServerListener<T> listener, Class<T> type) {

        this.listener = listener;
        this.requestType = requestType;
        this.type = type;
    }

    public AdvancedJacksonRequest<T> getRequest() {

        switch (requestType) {
            case HttpRequestConstant.LOGIN_REQUEST:
                return new LoginRequest<T>(type, this, this);
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



