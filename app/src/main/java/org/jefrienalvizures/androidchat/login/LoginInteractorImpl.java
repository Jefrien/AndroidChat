package org.jefrienalvizures.androidchat.login;

/**
 * Created by Jefrien Alvizures on 11/06/2016.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkSession() {
        loginRepository.checkAlreadyAuthenticated();
    }

    @Override
    public void doSingUp(String email, String password) {
        loginRepository.singUp(email,password);
    }

    @Override
    public void doSingIn(String email, String password) {
        loginRepository.singIn(email,password);
    }
}
