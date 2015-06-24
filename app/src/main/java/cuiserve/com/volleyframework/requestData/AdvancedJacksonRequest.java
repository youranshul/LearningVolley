package cuiserve.com.volleyframework.requestData;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by ansh on 7/4/15.
 */
public abstract class AdvancedJacksonRequest<T> extends JsonRequest<T> {

    private Class<T> responseType;

    public abstract  <MODEL> MODEL getRequestBody() ;

    /**
     * Creates a new request.
     * @param method        the HTTP method to use
     * @param url           URL to fetch the JSON from
     * @param requestData   A {@link Object} to post and convert into json as the request. Null is allowed and indicates no parameters will be posted along with request.
     * @param listener      Listener to receive the JSON response
     * @param errorListener Error listener, or null to ignore errors.
     */
    public AdvancedJacksonRequest(int method, Class<T> responseType, String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, null, listener, errorListener);
        this.responseType = responseType;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

  // we are handling this method as we have to separate the LoginRequestData
    @Override
    public byte[] getBody() {

      String requestBody =  (getRequestBody() == null) ? null : Mapper.string(getRequestBody());
        try {
            return requestBody == null ? null : requestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException uee) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                    requestBody, PROTOCOL_CHARSET);
            return null;
        }
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
