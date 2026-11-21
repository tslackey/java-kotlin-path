
package path.junior.testing.j;

public final class LeapYear {
    private LeapYear() {}

    public static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }
}
