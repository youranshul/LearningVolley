package cuiserve.com.volleyframework.temp;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by upadhya on 29/05/2015.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Bitmap[] mis_fotos;
    int width;
    int height;

    // references to our images
    private Integer[] mThumbIds = {
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call,android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call,android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call,android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call,android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call,android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call, android.R.drawable.sym_action_call, android.R.drawable.sym_action_call,
            android.R.drawable.sym_action_call
    };

    public ImageAdapter(Context c) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        /*.getDefaultDisplay()
                .getMetrics(displaymetrics);
        */
        width = displaymetrics.widthPixels;
        height = displaymetrics.heightPixels;
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}