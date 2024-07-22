public class Scoreboard {
        private int numEntries = 0; // number of actual entries
        private GameEntry[] board; // array of game entries (names & scores)

        /** Constructs an empty scoreboard with the given capacity for storing entries. */
        public Scoreboard(int capacity) {
            board = new GameEntry[capacity];
        }

        /** Attempt to add a new score to the collection (if it is high enough) */
        public void add(GameEntry e) {
            int newScore = e.getScore();
            // is the new entry e really a high score?
            if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
                if (numEntries < board.length) { // no score drops from the board
                    numEntries++; // so overall number increases
                }
                // shift any lower scores rightward to make room for the new entry
                int j = numEntries - 1;
                while (j > 0 && board[j - 1].getScore() < newScore) {
                    board[j] = board[j - 1];
                    j--;
                }
                board[j] = e;
            }
        }

        /** Remove and return the high score at index i. */
        public GameEntry remove(int i) throws IndexOutOfBoundsException {
            if (i < 0 || i >= numEntries) {
                throw new IndexOutOfBoundsException("Invalid index: " + i);
            }
            GameEntry temp = board[i];
            for (int j = i; j < numEntries - 1; j++) {
                board[j] = board[j + 1];
            }
            board[numEntries - 1] = null;
            numEntries--;
            return temp;
        }

        /** Returns a string representation of the high scores list. */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < numEntries; i++) {
                sb.append(board[i]);
                if (i < numEntries - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }




    }

