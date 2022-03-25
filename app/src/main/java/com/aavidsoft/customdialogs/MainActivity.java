package com.aavidsoft.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLoginWithGoogle, btnLoginWithBitCode;

    private LoginDialog loginDialogGoogle, loginDialogBitCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoginWithGoogle = findViewById(R.id.btnLoginWithGoogle);
        btnLoginWithBitCode = findViewById(R.id.btnLoginWithBitCode);

        btnLoginWithBitCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialogBitCode = new LoginDialog(MainActivity.this);
                loginDialogBitCode.setOnLoginListener(new MyLoginListener());
                loginDialogBitCode.show();
            }
        });

        btnLoginWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialogGoogle = new LoginDialog(MainActivity.this);
                loginDialogGoogle.setMaxLoginAttempts(2);
                //loginDialog.setLoginActions(new LoginActions());
                loginDialogGoogle.setOnLoginListener(new MyLoginListener());
                loginDialogGoogle.show();
            }
        });
    }

    class MyLoginListener implements LoginDialog.OnLoginListener {

        @Override
        public void onSuccess(LoginDialog loginDialog) {

            loginDialog.dismiss();

            if(loginDialog == loginDialogGoogle) {
                mt("Google: My Success Action");
            }
            if(loginDialog == loginDialogBitCode) {
                mt("BitCode: My Success Action");
            }

        }

        @Override
        public void onFailure(LoginDialog loginDialog) {
            mt("My Failed Action");
        }

        @Override
        public void onMaxAttempts(LoginDialog loginDialog) {
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