package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtLoginEmail, edtLoginPassword;
    private Button btnLoginActivity, btnSignUpLoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Log In");

        edtLoginEmail=findViewById(R.id.edtLoginMail);
        edtLoginPassword=findViewById(R.id.edtLoginPasswor);
        btnLoginActivity=findViewById(R.id.btnLogInLogInActivity);
        btnSignUpLoginActivity=findViewById(R.id.btnSignUpLogInActivity);
        btnLoginActivity.setOnClickListener(this);
        btnSignUpLoginActivity.setOnClickListener(this);

        if (ParseUser.getCurrentUser()!=null) {
            ParseUser.getCurrentUser().logOut();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

           case R.id.btnLogInLogInActivity:

               ParseUser.logInInBackground(edtLoginEmail.getText().toString(),
                       edtLoginPassword.getText().toString(),
                       new LogInCallback() {
                           @Override
                           public void done(ParseUser user, ParseException e) {

                               if (user != null && e == null) {

                                   FancyToast.makeText(LoginActivity.this,
                                           user.getUsername() + " is logged in!", Toast.LENGTH_LONG, FancyToast.SUCCESS,
                                           true).show();
                                   transitionToSocialMediaActivity();

                               }

                           }
                       });

            break;
            case R.id.btnSignUpLogInActivity:

                break;
        }

    }
    private void transitionToSocialMediaActivity(){

        Intent intent=new Intent(LoginActivity.this,SocialMediaActivity.class);
        startActivity(intent);

    }
}