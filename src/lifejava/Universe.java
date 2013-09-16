package lifejava;

/**
 *
 * @author Daniil
 */
public class Universe {

    int xU = 600;
    int yU = 400;

    int aliveNeighbour;
    boolean cells [][] = new boolean [xU] [yU];
    boolean bcells[][] = new boolean [xU] [yU];

    void setCellAlive(int x, int y) {
        if (normalizer(x, y))
        cells [x] [y] = true;
    }

    void setCellDead(int x, int y) {
        if (normalizer(x, y))
        cells [x] [y] = false;
    }

    boolean getAlive(int x, int y) {
        if (normalizer(x, y))
            return bcells [x] [y];
        return false;
    }

    int cardinality() {
        int cardinality = 0;
        for (int i = 0; i < xU; i++) {
            for (int j = 0; j < yU; j++) {
                if (cells[i][j]) ++cardinality;
            }
        }
        return cardinality;
    }

    void myClone(){
        for (int i = 0; i < xU; i++) {
            System.arraycopy(cells[i], 0, bcells[i], 0, yU);
        }
    }

    void makeStep(){
        myClone();
        for (int i = 0; i < xU; i++) {
            for (int j = 0; j < yU; j++) {
                makeStep (i, j);
            }
        }
    }

    void makeStep(int x, int y) {
        aliveNeighbour = 0;

        //calculate alive neighbour
        if (getAlive(x - 1, y - 1)) aliveNeighbour++;
        if (getAlive(x,     y - 1)) aliveNeighbour++;
        if (getAlive(x + 1, y - 1)) aliveNeighbour++;
        if (getAlive(x - 1, y)) aliveNeighbour++;
        if (getAlive(x + 1, y)) aliveNeighbour++;
        if (getAlive(x - 1, y + 1)) aliveNeighbour++;
        if (getAlive(x,     y + 1)) aliveNeighbour++;
        if (getAlive(x + 1, y + 1)) aliveNeighbour++;
        
        if (aliveNeighbour < 2 || aliveNeighbour > 3) {setCellDead(x, y);}
        if (aliveNeighbour == 3) {setCellAlive(x, y);}
    }

    boolean normalizer (int x, int y){
        if (x < xU && y < yU ){
            if (x >= 0 && y >= 0){
                return true;
            }
        }
        return false;
    }


    public class BitSet {

        private final int[] ints;

        public BitSet(int count) {
            ints = new int[(count >> 5) + ((count & 0x1f) != 0 ? 1 : 0)];
        }

        public boolean get(int number) {
            return (ints[(number >> 5)] & (1 << (number & 0x1f))) != 0;
        }

        public void set(int number) {
            ints[(number >> 5)] |= (1 << (number & 0x1f));
        }

        public void clear(int number) {
            ints[(number >> 5)] &= ~(1 << (number & 0x1f));
        }
    }
}