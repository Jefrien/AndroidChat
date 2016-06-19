package org.jefrienalvizures.androidchat.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.jefrienalvizures.androidchat.R;
import org.jefrienalvizures.androidchat.contactList.ContactListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @Bind(R.id.editTxtEmail) EditText inputEmail;
    @Bind(R.id.editTxtPassword) EditText inputPassword;
    @Bind(R.id.btnSingin) Button btnSingIn;
    @Bind(R.id.btnSingup) Button btnSingUp;
    @Bind(R.id.layoutMainContainer) RelativeLayout layoutMainContainer;
    @Bind(R.id.progressBar) ProgressBar progressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();
    }


    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.btnSingup)
    @Override
    public void handleSingUp() {
        loginPresenter.registerNewUser(
                inputEmail.getText().toString(),
                inputPassword.getText().toString());
    }

    @OnClick(R.id.btnSingin)
    @Override
    public void handlerSingIn() {
        loginPresenter.validateLogin(
                inputEmail.getText().toString(),
                inputPassword.getText().toString()
        );
    }

    @Override
    public void navidateToMainScreen() {
        startActivity(new Intent(this, ContactListActivity.class));
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_singin),error);
        inputPassword.setError(msgError);
    }

    @Override
    public void newUserSucces() {
        Snackbar.make(layoutMainContainer,R.string.login_notice_message_singup,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void newUserError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_singup),error);
        inputPassword.setError(msgError);
    }

    private void setInputs(boolean enable){
        inputEmail.setEnabled(enable);
        inputPassword.setEnabled(enable);
        btnSingIn.setEnabled(enable);
        btnSingUp.setEnabled(enable);
    }
}
