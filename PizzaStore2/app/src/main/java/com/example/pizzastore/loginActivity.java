package com.example.pizzastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText username,pass;
    Button login;
    TextView signu;
    boolean allfield = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login1);
        signu=findViewById(R.id.signin);
        Intent i = getIntent();
        String a = " ";
        String b = " ";
        try {
            a = i.getStringExtra("number1");
            b = i.getStringExtra("number2");
        } catch (NumberFormatException e) {
            Log.d("error1", "user not give input");

        }
        username.setText(a);
        pass.setText(b);

        signu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 allfield = login();
                 if (allfield)
                 {
                     Intent i = new Intent(loginActivity.this,welcomeActivity.class);
                     startActivity(i);
                 }



             }
         });


    }

    private boolean login()
    {

        String eusername = username.getText().toString().trim();
        String epass = pass.getText().toString().trim();
        if(checkUsername(eusername)&& checkPassword(epass))
        {
            Toast.makeText(this,"You Have Login Successfully!",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    private boolean checkUsername(String eusername) {
        if (TextUtils.isEmpty(eusername)) {
            username.setError("Please Enter UserName");
            return false;
        }
        return true;
    }
    private  boolean checkPassword(String epass) {
        if (TextUtils.isEmpty(epass)) {
            pass.setError("Please Enter Password");
            return false;
        }
        else if (pass.length()<8 || pass.length()>10){
            pass.setError("Password Should be Atleast 8 to 10 characters");
            return false;
        }
        return true;
    }


}


