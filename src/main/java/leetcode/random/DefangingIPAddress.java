package leetcode.random;

public class DefangingIPAddress {

    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char character : chars) {
            if (String.valueOf(character).equals(".")) {
                result.append("[.]");
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public String defangIPaddr2(String address) {
        return address.replace(".", "[.]");
    }
}
//https://leetcode.com/problems/defanging-an-ip-address/