package com.aavidsoft.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog extends Dialog {

    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    private Context context;

    private int maxLoginAttempts = 3;
    private int attemptsCount = 0;

    public void setMaxLoginAttempts(int maxLoginAttempts) {
        if(maxLoginAttempts > 0) {
            this.maxLoginAttempts = maxLoginAttempts;
        }
    }

    LoginDialog(Context context) {
        super(context);
        this.context = context;
        setContentView(R.layout.login_dialog);

        init();

        btnSignIn.setOnClickListener(new BtnSignInClickListener());
    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            //validate credentials
            if(edtUsername.getText().toString().equals("bitcode")) {
                mt("Success");
                dismiss();
            }
            else {
                attemptsCount++;
                if(attemptsCount >= maxLoginAttempts) {
                    mt("Account blocked");
                    dismiss();
                    return;
                }
                mt("Failed");
            }
        }
    }

    private void mt(String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    private void init() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
    }
}
