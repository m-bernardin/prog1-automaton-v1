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
        state = new int[numberOfCells+1];
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
     * q33. 
     */
    public void updateV2()
    {
        int[] nextState = new int[state.length];
        int left = 0;
        int centre = state[0];
        for(int i=0; i<numberOfCells; ++i){
            int right = state[i+1];     
            nextState[i]=calculateNextState(left, centre, right);
            left=centre;
            centre=right;
        }
        state=nextState;
    }
    
    /**
     * q31, 32
     * Update the automaton to its next state.
     */
    public void updateWithoutNextState()
    {
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        int[] adjCells = new int[3];
        adjCells[0]=0;
        adjCells[1]=1;
        adjCells[2]=1;
        for(int i = 0; i < state.length;) {
            int left, center, right;
            left = (i==0)?0:adjCells[0];
            center = state[1];
            right = (i + 1 < state.length)?state[2]:0;
            state[i] = (left + center + right) % 2;
            ++i;
            adjCells[0] = state[i-1];
            adjCells[1] = state[i];
            adjCells[2] = (state[+1]<state.length)?state[i+1]:state[i];
        }
    }
    
    /**
     * q34
     */
    public int calculateNextState(int left, int centre, int right)
    {
        return (centre + right*left + 1 + centre*right + left*centre*right)%2;
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
