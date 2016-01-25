package pl.edu.uksw.irc.executor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sok_pomaranczowy on 08.01.16.
 */
public class UserRepository {
    Set<User> userDB;

    public UserRepository() {
        userDB = new HashSet<>();
    }

    public boolean isUserInRepository(User user){
        return userDB.contains(user);
    }

    public boolean addUser(User user){
        return userDB.add(user);
    }

    public boolean removeUser(User user){
        return userDB.remove(user);
    }

    public int getSize(){
        return userDB.size();
    }

}
