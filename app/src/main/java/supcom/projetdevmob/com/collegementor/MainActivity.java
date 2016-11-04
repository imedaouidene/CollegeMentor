package supcom.projetdevmob.com.collegementor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread mythred = new Thread(){


                @Override
                public void run(){
                    try {
                        synchronized(this){
                            wait(3000);

                            Intent i = new Intent(getApplicationContext(),LOGIN.class);
                            startActivity(i);
                            finish();

                        }} catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                        };
        mythred.start();

}



}
