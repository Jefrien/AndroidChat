package org.jefrienalvizures.androidchat.login;

import org.jefrienalvizures.androidchat.login.events.LoginEvent;

/**
 * Created by Jefrien Alvizures on 11/06/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email,String password);
    void registerNewUser(String email,String password);
    void onEventMainThread(LoginEvent event);
}
