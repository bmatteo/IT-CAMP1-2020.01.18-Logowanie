package pl.camp.it;


import pl.camp.it.gui.GUI;
import pl.camp.it.repository.UserRepository;

public class App {
    public static void main(String[] args) {
        while (UserRepository.getUserRepository().runFlag) {
            GUI.showMenu();
        }
    }
}
