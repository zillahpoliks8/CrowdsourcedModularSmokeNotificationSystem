package com.app.uic.crowdsourcedmodularsmokenotificationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class frmLogin extends AppCompatActivity {

    private EditText editText_email,editText2_pass;
    private Button button_login;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_login);

        editText_email = (EditText) findViewById(R.id.editText_email);
        editText2_pass = (EditText) findViewById(R.id.editText2_pass);
        button_login = (Button) findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(frmLogin.this, MainActivity.class);

                // currentContext.startActivity(activityChangeIntent);

                frmLogin.this.startActivity(activityChangeIntent);
            }
        });

        FirebaseApp.initializeApp(frmLogin.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText_email.getText().toString().isEmpty() || editText2_pass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Name or Email is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    UserModel user = new UserModel();
                    user.setId(UUID.randomUUID().toString());
                    user.setEmail(editText_email.getText().toString().trim());
                    user.setPass(editText2_pass.getText().toString().trim());
                    databaseReference.child("users").child(user.getId()).setValue(user);

                    Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                    editText_email.setText("");
                    editText2_pass.setText("");
                }
            }
        });

    }
}
