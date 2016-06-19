package org.jefrienalvizures.androidchat.login;

/**
 * Created by Jefrien Alvizures on 11/06/2016.
 */
public interface LoginInteractor {
    void checkSession();
    void doSingUp(String email,String password);
    void doSingIn(String email,String password);
}
