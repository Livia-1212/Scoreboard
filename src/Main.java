public class Main {

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard(5);
        scoreboard.add(new GameEntry("Alice", 100));
        scoreboard.add(new GameEntry("Bob", 120));
        scoreboard.add(new GameEntry("Charlie", 110));
        scoreboard.add(new GameEntry("Diana", 90));
        scoreboard.add(new GameEntry("Eve", 130));

        System.out.println(scoreboard); // Expected output: [Eve, Bob, Charlie, Alice, Diana]

    }
}
    class GameEntry {
        private String name;
        private int score;

        public GameEntry(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + ": " + score;
        }
    }
