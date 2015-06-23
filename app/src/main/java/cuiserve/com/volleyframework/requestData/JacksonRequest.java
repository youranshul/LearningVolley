package cuiserve.com.volleyframework.requestData;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import java.util.Map;

/**
 * Created by ansh on 7/4/15.
 */
public class JacksonRequest<T> extends JsonRequest<T> {

    private Class<T> responseType;

    /**
     * Creates a new request.
     * @param method        the HTTP method to use
     * @param url           URL to fetch the JSON from
     * @param requestData   A {@link Object} to post and convert into json as the request. Null is allowed and indicates no parameters will be posted along with request.
     * @param listener      Listener to receive the JSON response
     * @param errorListener Error listener, or null to ignore errors.
     */
    public JacksonRequest(int method, String url, Object requestData, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, (requestData == null) ? null : Mapper.string(requestData), listener, errorListener);
    }

    public void setResponseType(T type){
            this.responseType = (Class<T>) type;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(Mapper.objectOrThrow(json, responseType), HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }
}
