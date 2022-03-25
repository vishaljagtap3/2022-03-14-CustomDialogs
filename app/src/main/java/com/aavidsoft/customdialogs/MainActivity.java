package com.aavidsoft.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                loginDialog.setMaxLoginAttempts(2);
                //loginDialog.setLoginActions(new LoginActions());
                loginDialog.setOnLoginListener(new MyLoginListener());
                loginDialog.show();
            }
        });
    }

    class MyLoginListener implements LoginDialog.OnLoginListener {

        @Override
        public void onSuccess() {
            mt("My Success Action");
        }

        @Override
        public void onFailure() {
            mt("My Failed Action");
        }

        @Override
        public void onMaxAttempts() {
            mt("My max attempts Action");
        }
    }

    class LoginActions {
        public void success() {
            mt("MainActivity success action");
        }

        public void failed() {
            mt("MainActivity failed action");
        }

        public void maxAttempts() {
            mt("Main Activity Max attempts action");
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}