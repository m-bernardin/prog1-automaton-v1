import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
        reset();
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update()
    {
        // Build the new state in a separate array.
        int[] nextState = new int[state.length];
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        for(int i = 0; i < state.length; i++) {
            int left, center, right;
            //q30
            left = (i==0)?0:state[i-1];
            center = state[i];
            right = (i + 1 < state.length)?state[i+1]:0;
            nextState[i] = (left + center + right) % 2;
        }
        state = nextState;
    }
    
    /**
     * Update the automaton to its next state.
     */
    public void updateTest()
    {
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        for(int i = 0; i < state.length; i++) {
            int left, center, right;
            //q30
            left = (i==0)?0:state[i-1];
            center = state[i];
            right = (i + 1 < state.length)?state[i+1]:0;
            state[i] = (left + center + right) % 2;
        }
    }
    
    /**
     * Reset the automaton.
     * q29.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[(numberOfCells / 2) + 1] = 1;
        state[(numberOfCells / 2) - 1] = 1;
        state[(numberOfCells / 2) + 2] = 1;
        state[(numberOfCells / 2) - 2] = 1;
    }
}
