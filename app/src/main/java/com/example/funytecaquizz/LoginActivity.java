package com.example.funytecaquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView forgotPassB, cadastroB;
    private EditText email, pass;
    private Button loginB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        loginB = findViewById(R.id.loginB);
        forgotPassB = findViewById(R.id.forgot_pass);
        cadastroB = findViewById(R.id.cadastroB);

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateData())
                {
                    login();
                }

            }
        });

        cadastroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean validateData() {

        if (email.getText().toString().isEmpty())
        {
            email.setError("Insira o email");
            return false;
        }

        if (pass.getText().toString().isEmpty())
        {
            pass.setError("Insira a senha");
            return false;
        }

        return true;
    }

    private void login() {
    }

}