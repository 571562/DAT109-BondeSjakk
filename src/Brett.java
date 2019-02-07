public class Brett {

    private char[][] brett;

    public Brett() {
        this.brett = new char[3][3];
    }


    public void skrivBrett(Brett brett){
        System.out.println("-----------");

        for (int i = 0; i < 3; i++) {
            System.out.println("|");
            for (int j = 0; j < 3; j++) {
                System.out.println(brett[i][j] + "|");
            }
        }
    }
}
