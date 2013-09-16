/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lifejava;

/**
 *
 * @author Daniil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Universe uni = new Universe();

//http://www.conwaylife.com/wiki/index.php?title=R-pentomino
        uni.setCellAlive(20, 20);
        uni.setCellAlive(21, 20);
        uni.setCellAlive(20, 21);
        uni.setCellAlive(20, 22);
        uni.setCellAlive(19, 21);

        System.out.println("Alive: "+uni.cardinality());


        for (int i = 0; i < 101; i++) {
            uni.makeStep();
        }

        System.out.println("Alive: "+uni.cardinality());

//        System.out.println("Alive cell: "+ uni.cardinality());
        // TODO code application logic here
    }

}
