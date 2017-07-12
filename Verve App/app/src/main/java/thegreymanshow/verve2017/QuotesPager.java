package thegreymanshow.verve2017;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by akshay dangare on 1/7/2017.
 */

public class QuotesPager extends PagerAdapter {

    private int images[]={R.drawable.quote1,R.drawable.quote13,R.drawable.quote4,R.drawable.quote5,R.drawable.quote14,R.drawable.quote3,R.drawable.quote6,R.drawable.quote11,R.drawable.quote2,R.drawable.quote8,R.drawable.quote9,R.drawable.quote7,R.drawable.quote10,R.drawable.quote12,R.drawable.quote15,R.drawable.quote16};
    private Context context;
    private LayoutInflater inflater;

    public QuotesPager(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = (View) inflater.inflate(R.layout.quotespager,container,false);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageResource(images[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}



