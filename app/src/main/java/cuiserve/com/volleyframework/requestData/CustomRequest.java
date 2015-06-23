package cuiserve.com.volleyframework.requestData;

import com.android.volley.Response;

import cuiserve.com.volleyframework.httpConnection.HttpRequestConstant;


/**
 * Created by ansh on 23/6/15.
 */
public class CustomRequest<T> extends AdvancedJacksonRequest<T>{

    /**
     * Creates a new request
     * @param responseType
     * @param listener      Listener to receive the JSON response
     * @param errorListener Error listener, or null to ignore errors.
     */
    public CustomRequest(Class<T> responseType, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(Method.GET,responseType, HttpRequestConstant.JACKSON_FETCH,null,listener,errorListener);
    }

    @Override
    public <MODEL> MODEL getRequestBody() {
        //It is null for this request as we dont need to send body or any params
        return null;
    }
}
