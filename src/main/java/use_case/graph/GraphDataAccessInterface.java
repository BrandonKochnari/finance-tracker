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
    public void saveGraphRange(String lineGraphRange);

    /**
     * save the type of entry to graph
     * 
     * @param type the type of entry
     */
    public void saveGraphType(String type);

    /**
     * get range data from database
     * 
     * @return the graph range data in database, null if file not found
     */
    public String getRange();

    /**
     * get type data from database
     * 
     * @return the pie graph range data in database, null if file not found
     */
    public String getType();

}
