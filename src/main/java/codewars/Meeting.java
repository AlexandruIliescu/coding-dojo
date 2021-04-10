package codewars;

import codewars.User.UserComparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Meeting {

    public static String meeting(String s) {
        List<User> users = new ArrayList<>();
        String[] stringList = s.toUpperCase().split(";");
        for (String name : stringList) {
            String firstName = name.substring(0, name.indexOf(":"));
            String lastName = name.substring(name.indexOf(":") + 1);
            users.add(new User(firstName, lastName));
        }
        UserComparator userComparator = new UserComparator();
        users.sort(userComparator);
        StringBuilder result = new StringBuilder();
        for (User user : users) {
            result.append(user.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"));
    }

}

class User {

    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "(" + lastName + ", " + firstName + ")";
    }

    static class UserComparator implements Comparator<User> {

        @Override
        public int compare(User user1, User user2) {
            if (user1.getLastName().equals(user2.getLastName())) {
                return user1.getFirstName().compareTo(user2.getFirstName());
            }
            return user1.getLastName().compareTo(user2.getLastName());
        }
    }
}
//https://www.codewars.com/kata/59df2f8f08c6cec835000012/train/java
