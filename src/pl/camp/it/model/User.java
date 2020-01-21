package pl.camp.it.model;

public class User {
    private String login;
    private String pass;

    public User() {

    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public void jakasMetoda(String a, int ... liczby) {
        liczby[3] = 8;
    }

    public void jakasMetoda2() {
        //jakasMetoda(6, 8, 34);
    }
}
