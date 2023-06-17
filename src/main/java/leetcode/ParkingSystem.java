package leetcode;

public class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && big >= 1) {
            --big;
            return true;
        } else if (carType == 2 && medium >= 1) {
            --medium;
            return true;
        } else if (carType == 3 && small >= 1) {
            --small;
            return true;
        } else {
            return false;
        }
    }
}
//https://leetcode.com/problems/design-parking-system/?envType=featured-list&envId=top-amazon-questions