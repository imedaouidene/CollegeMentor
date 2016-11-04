package supcom.projetdevmob.com.collegementor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class trier extends Activity {
    TextView close ;
    RadioGroup radioGroup ;
    Button alphabical,distance,rating,apply;
    int choice ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trier);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);





        DisplayMetrics dm = new DisplayMetrics() ;
        getWindowManager().getDefaultDisplay().getMetrics(dm) ;
        int with =dm.widthPixels ;
        int hight = dm.heightPixels ;
        getWindow().setLayout((int)(with*0.8),(int)(hight*0.6));



        close = (TextView)findViewById(R.id.closetrie) ;
        radioGroup =(RadioGroup)findViewById(R.id.groupetrie);
        alphabical=(Button)findViewById(R.id.alphabatical);
        distance=(Button)findViewById(R.id.distance);
        rating=(Button)findViewById(R.id.rating) ;


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.alphabatical){
                    alphabical.setAlpha((float)0.5);
                    distance.setAlpha(1);
                    rating.setAlpha(1);
                    choice = 1 ;
                }
                if (checkedId==R.id.distance){

                        alphabical.setAlpha(1);
                        distance.setAlpha((float)0.5);
                        rating.setAlpha(1);
                    choice= 3 ;
                    }
                if (checkedId==R.id.rating){

                    alphabical.setAlpha(1);
                    distance.setAlpha(1);
                    rating.setAlpha((float)0.5);
                    choice= 2 ;


                }


            }
        });

        apply= (Button) findViewById(R.id.applytrie);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Search.class);
                i.putExtra("Trievalue",choice);
                finish();
            }
        });



    }
}
