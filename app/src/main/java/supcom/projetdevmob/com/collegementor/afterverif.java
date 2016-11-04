package supcom.projetdevmob.com.collegementor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class afterverif extends AppCompatActivity {

    TextView name , email, dateofbirth ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterverif);


        //getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        name = (TextView)findViewById(R.id.name_after);
        email = (TextView)findViewById(R.id.email_after);
        dateofbirth=(TextView)findViewById(R.id.dateofbirth_after) ;


        Intent i = getIntent()  ;
        USER user = (USER)i.getSerializableExtra("user");
        name.setText("WELCOME "+user.getFirstname()+"   "+user.getLastname());
            name.setTextSize(25);
        email.setText(user.getEmail());
        email.setTextSize(25);
        dateofbirth.setText(user.getDateofbirth());
        dateofbirth.setTextSize(25);







    }
}
