package start;
import game.Graid;
import java.util.Scanner;

public class StartGame extends Graid {
    public static void main(String[] args){
        Graid g= new Graid();
        int score=0,r1,r2,c1,c2;
        Scanner in = new Scanner(System.in);

        g.GenField();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(g.canvas[i][j]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }

        System.out.println(score);
        while(score<30000) {
            System.out.println("Enter the coordinates of the two chips");
            r1 = in.nextInt();
            c1 = in.nextInt();
            r2 = in.nextInt();
            c2 = in.nextInt();
            if (((c1>7)||(c1<1))||((c2>7)||(c2<1))||((r1>7)||(r1<1))||((r2>7)||(r2<1))){
                System.out.println("Wrong coordinates! Please, try again.");
                r1 = in.nextInt();
                c1 = in.nextInt();
                r2 = in.nextInt();
                c2 = in.nextInt();
            }
            g.Move(r1, c1, r2, c2);
            System.out.println("\n \n \n");
            if (g.lookForMatches(r2, c2) != 0) {
                        score += g.Del(r2, c2,g.lookForMatches(r2, c2));
                    }
                /*    for (int i=1;i<8;i++) {
                        for(int j=1;j<8;j++) {
                            if (g.lookForMatches(i, j) != 0) {
                                score += g.Del(i, j, g.lookForMatches(i, j));
                            }
                        }
                   }*/


            System.out.println("\n \n \n \n");
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    System.out.print(g.canvas[i][j]);
                    System.out.print(" ");
                }
                System.out.println("\n");
            }
            System.out.println(score);
        }
        System.out.println("You win!");
    }
}

