package org.jefrienalvizures.androidchat.login;

import android.util.Log;

import org.greenrobot.eventbus.Subscribe;
import org.jefrienalvizures.androidchat.lib.EventBus;
import org.jefrienalvizures.androidchat.lib.GreenRobotEventBus;
import org.jefrienalvizures.androidchat.login.events.LoginEvent;

/**
 * Created by Jefrien Alvizures on 11/06/2016.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private EventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.untegister(this);
    }

    @Override
    public void checkForAuthenticatedUser() {
        if(loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if(loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSingIn(email,password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if(loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSingUp(email,password);
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent event) {
        switch(event.getEventType()){
            case LoginEvent.onSingInSuccess:
                onSingInSucces();
                break;
            case LoginEvent.onSingUpSuccess:
                onSingUpSucces();
                break;
            case LoginEvent.onSingUpError:
                onSingUpError(event.getErrorMessage());
                break;
            case LoginEvent.onSngInError:
                onSingInError(event.getErrorMessage());
                break;
            case LoginEvent.onFailedToRecoverySession:
                onFailedToRecoverySession();
                break;
        }
    }

    private void onFailedToRecoverySession() {
        if(loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
        }
        Log.e("LoginPresenterImpl","onFailedToRecoverySession");
    }

    private void onSingInSucces(){
        if(loginView != null){
            loginView.navidateToMainScreen();
        }
    }
    private void onSingUpSucces(){
        if(loginView != null){
            loginView.newUserSucces();
        }
    }
    private void onSingInError(String error){
        if(loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }
    private void onSingUpError(String error){
        if(loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}
