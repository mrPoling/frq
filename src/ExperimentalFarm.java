
public class ExperimentalFarm {
    private Plot[][] farmPlots;

    public ExperimentalFarm(Plot[][] p) {
        farmPlots = p;
    }

    /**
     * Returns the Plot object with the highest yield among the plots in
     * farmPlots with the crop type specified by the parameter c. 
     * If more than one plot has the highest yield, any of these plots may be returned. 
     * If no plot exists containing the specified type of crop, the method returns null.
     */
    public Plot getHighestYield(String c) {
        return null;  //TODO replace with student solution
    }


    /**
     * Returns true if all plots in a given column in the twodimensional array
     * farmPlots
     * contain the same type of crop, or false otherwise, as described
     * in part (b).
     */
    public boolean sameCrop(int col) {
        return false;  //TODO replace with student solution
    }
}