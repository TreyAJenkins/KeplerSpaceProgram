

public class KSP {

    private final static String STARLINK_TLE = "STARLINK-1294\n" +
            "1 71294C 20025B   20120.55156569 -.01221895  00000-0 -34216-2 0  1203\n" +
            "2 71294  53.0067   6.2430 0067945  73.9622 137.6889 15.89995808    16";

    public static void main(String[] args) {
        TLE starLink = new TLE(STARLINK_TLE);
        System.out.println(starLink);
    }

}
