package org.jefrienalvizures.androidchat.login;

/**
 * Created by Jefrien Alvizures on 11/06/2016.
 */
public interface LoginRepository {
    void singUp(String email,String password);
    void singIn(String email,String password);
    void checkAlreadyAuthenticated();
}
