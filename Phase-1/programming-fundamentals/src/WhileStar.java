public class WhileStar {
    public static void main(String[] args) {
//        int x = 0;
//        while (x < 6){
//            int y = 0;
//            while (y <= x){
//                System.out.print(" * ");
//                y++;
//            }
//            System.out.println();
//            x++;
//        }

//        int a = 0;
//        while (a < 6){
//            int b = 0;
//            while (b < (6-a)){
//                System.out.print(" * ");
//                b++;
//            }
//            System.out.println();
//            a++;
//        }

//        int i = 0;
//        while (i < 6){
//            int j = 0;
//            while (j < 6){
//                System.out.print(" * ");
//                j++;
//            }
//            System.out.println();
//            i++;
//        }

        int p = 0;
        while (p <= 12){
            int q = 0;
            while (q <= (p < 6 ? p : (12 - p))){
                System.out.print(" * ");
                q++;
            }
            System.out.println();
            p++;
        }
    }
}
