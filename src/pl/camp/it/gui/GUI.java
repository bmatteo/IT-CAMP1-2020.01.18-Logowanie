package pl.camp.it.gui;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.exceptions.DuplicateUserException;
import pl.camp.it.model.User;
import pl.camp.it.repository.UserRepository;

import java.util.Scanner;

public class GUI {

    private static Scanner scanner = new Scanner(System.in);
    public static void showMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        String choose = GUI.scanner.nextLine();

        switch (choose) {
            case "1":
                showRegisterScreen();
                break;
            case "2":
                showLoginScreen();
                break;
            case "3":
                UserRepository.getUserRepository().runFlag = false;
                break;
            case "god":
                UserRepository.getUserRepository().printUsers();
                break;
                default:
                    System.out.println("Nieprawidłowa wartość !!");
                    break;
        }
    }

    public static void showRegisterScreen() {
        System.out.println("Podaj login:");
        String login = GUI.scanner.nextLine();
        boolean flag = true;
        int counter = 0;
        do {
            System.out.println("Podaj hasło:");
            String pass = GUI.scanner.nextLine();

            System.out.println("Powtorz hasło:");
            String pass2 = GUI.scanner.nextLine();

            if(pass.equals(pass2)) {
                UserRepository ur = UserRepository.getUserRepository();
                User user = new User(login, DigestUtils.md5Hex(pass + UserRepository.bean));
                try {
                    ur.addUser(user);
                } catch (DuplicateUserException e) {
                    System.out.println(e.getErrorInfo());

                }
                flag = false;
            } else {
                System.out.println("Nieprawidłowe hasła");
                counter++;
                if(counter == 3) {
                    System.out.println("Za dużo prób !!");
                }
            }
        } while (flag && counter < 3);
    }

    public static void showLoginScreen() {
        System.out.println("Podaj login:");
        String login = GUI.scanner.nextLine();

        System.out.println("Podaj hasło:");
        String pass = GUI.scanner.nextLine();

        User userFromDb = UserRepository
                .getUserRepository()
                .getUserByLogin(login);

        String hashedPass = DigestUtils.md5Hex(pass + UserRepository.bean);

        if(userFromDb != null && userFromDb.getPass().equals(hashedPass)) {
            System.out.println("Zalogowano !!");
        } else {
            System.out.println("Brak dostępu !!");
        }
    }
}
