package pl.camp.it.repository;

import pl.camp.it.exceptions.DuplicateUserException;
import pl.camp.it.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userList = new ArrayList<>();
    private static final UserRepository userRepository = new UserRepository();
    public boolean runFlag = true;
    public static String bean = "mkG0x42RLcPIuaw";

    private UserRepository() {

    }

    public static UserRepository getUserRepository() {
        return UserRepository.userRepository;
    }

    public void addUser(User user) throws DuplicateUserException {
        User userFromDb = getUserByLogin(user.getLogin());
        if(userFromDb == null) {
            this.userList.add(user);
        } else {
            throw new DuplicateUserException("Już jest taki login !!");
        }
    }

    public void printUsers() {
        for (User user : this.userList) {
            System.out.println(user);
        }
    }

    public User getUserByLogin(String login) {
        for(User user : this.userList) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }
}
