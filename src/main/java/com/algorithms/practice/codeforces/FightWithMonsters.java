package main.java.com.algorithms.practice.codeforces;

import java.util.*;
import static java.lang.System.in;
public final class FightWithMonsters {
    static class Monster implements Comparable<Monster>{
        private  int health;
        private final int a;
        private final int b;
        public int getHealth() {
            return health;
        }

        public Monster(int health, int a, int b){
            this.health = health;
            this.a = a;
            this.b = b;
        }

        private int hasToUseTechnique(){
            int remaining;
            int res = -1;
            boolean solved = false;
            if(a >= health){
                solved = true;
                res = 0;
            }
            remaining = ((health / (a + b)) * (a +b));
            if(!solved) {
                if (remaining == health) {
                    remaining = b;
                } else{
                    remaining = health - (remaining + a);
                }
//            System.out.println("DATA >>>> " + a + " "+b+" "+ remaining + " " +health);
                if ((remaining > 0) && (remaining <= a)) {
                    res = 1;
                }
                int techniques = (int) Math.ceil((double) remaining / (double) a);
                if(res == -1)
                res = techniques;
            }
//            System.out.println("DATA >>>> " + a + " "+b+" "+ remaining +" "+res + " " +health);
            return res;
        }

        @Override
        public int compareTo(Monster o) {
            return this.hasToUseTechnique() - o.hasToUseTechnique();
        }
        @Override
        public boolean equals(Object obj) {
            assert obj.getClass() == Monster.class;
            Monster monster = (Monster) obj;
            return this.hasToUseTechnique() == monster.hasToUseTechnique();
        }
    }

    static class Fight{
        private Monster[] monsters;
        private final int a;
        private final int b;
        private int tricks;
        private int n;

        public Fight(int n, int a, int b, int tricks, int[] healths) {
            this.a = a;
            this.b = b;
            this.n = n;
            this.tricks = tricks;
            monsters = new Monster[healths.length];
            for(int i = 0; i < monsters.length; i++){
                monsters[i] = new Monster(healths[i], this.a, this.b);
            }
            Arrays.sort(this.monsters);
        }

        public int findWins(){
            int gain = 0;
/*            for(Monster monster: this.monsters){
                System.out.println(monster.hasToUseTechnique() + " "+ monster.getHealth());
            }
            System.out.println("\n");*/
            for(int i = 0; i < n; i++){
                int techniques = monsters[i].hasToUseTechnique();
                if((techniques > 0) && (techniques <= tricks)){
//                    System.out.println(monsters[i].getHealth() + " "+techniques);
                    gain++;
                    tricks -= techniques;
                } else if(techniques == 0){
//                    System.out.println("No use "+ monsters[i].getHealth());
                    gain++;
                }
            }
            return gain;
        }
    }

    private static int solution(){
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int tricks = scanner.nextInt();
        int[] healths = new int[n];
        for(int i = 0; i < n; i++){
            healths[i] = scanner.nextInt();
        }
        Fight fight = new Fight(n, a, b, tricks, healths);
        return fight.findWins();
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
