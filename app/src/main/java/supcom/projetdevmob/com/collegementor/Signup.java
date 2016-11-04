package supcom.projetdevmob.com.collegementor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    database mydatabase ;
    EditText firstname , lastname,email,password,dateofbirth ,password2;
    Button signup ;
    RadioGroup gender ;
    RadioButton male ;
    public boolean verif=false,verif_password=false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*************************************************************************************/

/*
        */














        /*************************************************************************************/








       /* WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(getWindow().getAttributes());
        lp.width = 350;
        lp.height = 600;;
        getWindow().setAttributes(lp);*/


        firstname = (EditText)findViewById(R.id.firstname);
        lastname = (EditText)findViewById(R.id.lastname);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password) ;
        dateofbirth= (EditText)findViewById(R.id.dateofbirth) ;
        signup=(Button)findViewById(R.id.signupbotton) ;
        password2=(EditText)findViewById(R.id.password2);
        gender=(RadioGroup)findViewById(R.id.gendergroup);
        mydatabase= new database(this);


        gender.check(R.id.malebutton);
/*********************************/







        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getfirstname = firstname.getText().toString();
                String getlastname = lastname.getText().toString() ;
                String getemail = email.getText().toString();
                String getpassword = password.getText().toString() ;
                String getpassword2 = password2.getText().toString() ;
                String getdateofbirth = dateofbirth.getText().toString() ;

                firstname.setError(null);
                lastname.setError(null);
                email.setError(null);
                password2.setError(null);
                dateofbirth.setError(null);


                verif=true ;

                if (!password2.getText().toString().equals(password.getText().toString())){
                    password2.setError("Password does not match ");
                    verif=false ;} else{

                    if (password.getText().toString().trim().equals("")){
                        password.setError("Empty password");
                        verif=false ;
                    }
                }


                    if(!email.getText().toString().contains("@") ){
                        email.setError("Invalid email");
                        verif=false;
                    }
                    else if(mydatabase.searchname(email.getText().toString())){
                        email.setError("Email already exists");
                        verif=false;


                    }
                if(dateofbirth.getText().toString().trim().equalsIgnoreCase("")){
                    dateofbirth.setError("Invalid date");
                    verif=false;}
                    if(firstname.getText().toString().trim().equalsIgnoreCase("")){
                        firstname.setError("Invalid name");
                        verif=false;}
                    if(lastname.getText().toString().trim().equalsIgnoreCase("")){
                        lastname.setError("Invalid name");
                        verif=false;
                    }




                if(verif){
                    USER myuser = new USER();
                    myuser.setFirstname(getdateofbirth);
                    myuser.setLastname(getlastname);
                    myuser.setDateofbirth(getdateofbirth);
                    myuser.setPassword(getpassword);
                    myuser.setEmail(getemail);
                    myuser.setFirstname(getfirstname);
                    mydatabase.insertuser(myuser);
                    Toast.makeText(getApplicationContext(),"DONE",Toast.LENGTH_SHORT).show();
                    finish();

                }


            }
        });

checkerrors();
    }
    public void showalert(String s,final boolean b,String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s)
                .setTitle(title)
                .setPositiveButton("OK" ,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(b){finish();}
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void checkerrors(){


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                email.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(!email.getText().toString().contains("@") ){
                    email.setError("Invalid email");
                verif=false;
                }
                        else if(mydatabase.searchname(email.getText().toString())){
                        email.setError("Email already exists");
                        verif=false;

                    }else {


                        email.setError(null);
                        verif=true;

                    }




            }
        });
        lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lastname.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lastname.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(lastname.getText().toString().trim().equalsIgnoreCase("")){
                    lastname.setError("Invalid name");
                    verif=false;
                }else{
                    lastname.setError(null);
                    verif=true;
                }

            }
        });
        firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                firstname.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    firstname.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(firstname.getText().toString().trim().equalsIgnoreCase("")){
                    firstname.setError("Invalid name");
                    verif=false;
                }else{
                    firstname.setError(null);
                    verif=true;
                }
            }
        });
        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                password2.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password2.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!password2.getText().toString().equals(password.getText().toString())){
                    password2.setError("Password does not match ");
                    verif_password=false ;
                }else{
                    password2.setError(null);
                    verif_password=true ;
                }
            }
        });


    }
}
