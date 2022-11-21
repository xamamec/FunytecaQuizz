package com.example.funytecaquizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends AppCompatActivity {

    private EditText name, email, pass, confirmSenha;
    private Button cadastroB;
    private ImageView backB;
    private FirebaseAuth mAuth;
    private String emailStr, senhaStr, confirmSenhaStr, nameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        name = findViewById(R.id.username);
        email = findViewById(R.id.emailID);
        pass = findViewById(R.id.password);
        confirmSenha = findViewById(R.id.confirm_senha);
        cadastroB = findViewById(R.id.cadastroB);
        backB = findViewById(R.id.backB);

        mAuth = FirebaseAuth.getInstance();


        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cadastroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    cadastroNewUser();
                }
            }
        });

    }

    private boolean validate()
    {
        nameStr = name.getText().toString().trim();
        senhaStr = pass.getText().toString().trim();
        emailStr = email.getText().toString().trim();
        confirmSenhaStr = confirmSenha.getText().toString().trim();

        if (nameStr.isEmpty()){
            name.setError("Insira seu Nome");
            return false;
        }

        if (emailStr.isEmpty()){
            email.setError("Insira seu Email");
            return false;
        }

        if (senhaStr.isEmpty()){
            pass.setError("Insira sua senha");
            return false;
        }

        if (confirmSenhaStr.isEmpty()){
            confirmSenha.setError("Insira sua senha");
            return false;
        }

        if (senhaStr.compareTo(confirmSenhaStr) != 0){
            Toast.makeText(CadastroActivity.this, "Os campos Senha e Confirmar senha tem que ser iguais!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void cadastroNewUser() {

        mAuth.createUserWithEmailAndPassword(emailStr, senhaStr)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso !", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(CadastroActivity.this,MainActivity.class);
                            startActivity(intent);
                            CadastroActivity.this.finish();


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(CadastroActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}