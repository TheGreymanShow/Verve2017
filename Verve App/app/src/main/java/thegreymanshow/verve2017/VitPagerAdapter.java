package thegreymanshow.verve2017;

/**
 * Created by akshay dangare on 1/14/2017.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;



public class VitPagerAdapter extends PagerAdapter {

    private int images[]={R.drawable.about4,R.drawable.about5,R.drawable.about1,R.drawable.about2,R.drawable.about3,R.drawable.about6,R.drawable.about7,R.drawable.about8,R.drawable.about9,R.drawable.about10,R.drawable.about11,R.drawable.about12,R.drawable.about13,R.drawable.about14};
    private Context context;
    private LayoutInflater inflater;

    public VitPagerAdapter(Context context) {
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
        View view = (View) inflater.inflate(R.layout.vitpager,container,false);

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


