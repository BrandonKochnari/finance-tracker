package use_case.graph;

import java.util.HashMap;

public interface GraphDataAccessInterface {

    /**
     * get all past entries
     * 
     * @return all past entries in a HASHMAP object -> {date:{type: String, amount:
     *         float, tags: {}, note: String}}
     */
    public HashMap getAllEntries();

    /**
     * save lineGraphRange data for next use
     * 
     * @param lineGraphRange the range data for line graph
     */
    public void saveLineRange(String lineGraphRange);

    /**
     * save pieGraphRange data for next use
     * 
     * @param pieGraphRange the range data for pie graph
     */
    public void savePieRange(String pieGraphRange);

    /**
     * get lineGraphRange data from database
     * 
     * @return the line graph range data in database, null if file not found
     */
    public String getLineRange();

    /**
     * get pieGraphRange data from database
     * 
     * @return the pie graph range data in database, null if file not found
     */
    public String getPieRange();

}
