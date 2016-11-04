package supcom.projetdevmob.com.collegementor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

public class LOGIN extends AppCompatActivity {

    CallbackManager callbackManager;
    TextView tosignup,forgot ;
    EditText userpassword,useremail ;
    Button login,loginwithemail;
    LoginButton loginwithfacebook ;

    database db ;
    public boolean verif = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        //callbackManager= CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        tosignup=(TextView)findViewById(R.id.newaccount);
        useremail = (EditText)findViewById(R.id.useremail) ;
        userpassword= (EditText)findViewById(R.id.userpassword) ;
        login=(Button)findViewById(R.id.LoginButton);
        forgot =(TextView)findViewById(R.id.forgotyouprass);




        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/ChantillySerial.ttf");

       // login.setTypeface(type);


        db = new database(this) ;

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),collegeMentor.class);
                startActivity(i);
            }
        });
        //login.setBackgroundColor(Color.TRANSPARENT);
        //login.setTextColor(Color.parseColor("#DAA520"));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typedemail= useremail.getText().toString() ;
                String typedpassword = userpassword.getText().toString() ;


                        Boolean b= db.searchname(typedemail) ;

                        if (useremail.getText().toString().equals("")||!useremail.getText().toString().contains("@")){
                            useremail.setError("Invalid Email");

                        }else if (b) {

                    Boolean passverif = db.searchpass(typedemail,typedpassword) ;
                            if (passverif) {

                                Intent toverif = new Intent(getApplicationContext(),afterverif.class) ;
                                USER user= db.getuser(typedemail);
                                toverif.putExtra("user",user);
                                startActivity(toverif);

                            }
                    else{
                                userpassword.setError("Wrong password");
                                verif=false;

                            }

                }else {
                                  useremail.setError("Email does not exist");
                                        verif=false;
                }

            }
        });





        tosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = new Intent(getApplicationContext(),Signup.class);
                startActivity(i);
            }
        });
    }



    public void showalert(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sorry ! "+s)
                .setTitle("Error")
        .setPositiveButton("OK" ,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();






    }
    public void check1(){

        userpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                userpassword.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (userpassword.getText().toString().equals("")){
                    userpassword.setError("Password empty");
                    verif=false;
                }else{
                    userpassword.setError(null);
                    verif=false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        useremail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                useremail.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            useremail.setError(null);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
