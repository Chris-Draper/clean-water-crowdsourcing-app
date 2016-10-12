package model;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by nharper32 on 9/29/16.
 */
public class UserLog {

    private LinkedList<GenericUser> userLog;

    public UserLog() {
        this.userLog = new LinkedList<>();
        this.addDummy();
    }

    public void addUser(GenericUser user) {
        userLog.add(user);
    }

    public void addDummy() {
        addUser(new Manager("nharper32", "harper285"));
        addUser(new Worker("cdraper", "draper"));
        addUser(new User("s", "s"));
        addUser(new Administrator("cpolack", "polack"));
    }

    public boolean contains(GenericUser user) {
        return userLog.contains(user);
    }

    public GenericUser getCurrentUser(String userName) {
        GenericUser currentUser = null;
        for(int i = 0; i < userLog.size(); i++) {
            if(userLog.get(i).getUsername().equals(userName)) {
                currentUser = userLog.get(i);
            }
        }
        return currentUser;
    }

    public boolean hasAlreadyRegistered(String username) {
        ListIterator<GenericUser> iterator = userLog.listIterator();
        while (iterator.hasNext()) {
            //Checks usernames of all already in system against param
            if (iterator.next().getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
