package org.jefrienalvizures.androidchat.login;

/**
 * Created by Jefrien Alvizures on 11/06/2016.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSingUp();
    void handlerSingIn();

    void navidateToMainScreen();
    void loginError(String error);

    void newUserSucces();
    void newUserError(String error);

}
