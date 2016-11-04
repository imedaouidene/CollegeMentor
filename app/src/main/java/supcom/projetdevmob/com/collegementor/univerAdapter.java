package supcom.projetdevmob.com.collegementor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc on 30/10/2016.
 */

public class univerAdapter extends BaseAdapter{


    ArrayList<University> university ;
   LayoutInflater mInflater ;

    public univerAdapter(ArrayList<University> university, Context context) {
        this.university = university;
        mInflater=LayoutInflater.from(context) ;
    }

    @Override
    public int getCount() {
        return university.size();
    }

    @Override
    public Object getItem(int position) {
        return university.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;


        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_adapter,null);
            viewHolder =new ViewHolder();
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.universitytof);
            viewHolder.univname=(TextView)convertView.findViewById(R.id.univname);
            viewHolder.ratingBar=(RatingBar)convertView.findViewById(R.id.ratingBar);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder)convertView.getTag();
        }

        University uni = (University)getItem(position);

        viewHolder.univname.setText(uni.getNom());
        viewHolder.imageView.setImageResource(uni.getimage());
        viewHolder.ratingBar.setRating(uni.getRating());

        return  convertView ;
    }
    static class ViewHolder{
        ImageView imageView ;
        TextView univname;
        RatingBar ratingBar ;
    }








}
