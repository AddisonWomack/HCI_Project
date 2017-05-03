package Model;

/*
    Created by Peter on 3/26/17
*/

import java.util.Date;

public class RoomIssue {

    private Date reportDate;
    private Date resolvedDate;
    private String description;
    public boolean isOngoing;

    public RoomIssue(Date d, String desc) {
        reportDate = d;
        resolvedDate = null;
        description = desc;
        isOngoing = true;
    }
    
    public void resolve(Date d) {
        resolvedDate = d;
        isOngoing = false;
    }
    
    public String toString(){
    	StringBuilder sb = new StringBuilder("Date of issue: " + reportDate.getMonth() + "/" + reportDate.getDay() + "/" + reportDate.getYear() + "\n");
    	if(isOngoing) sb.append("Issue not resolved\n");
    	else sb.append("Resolved: " + resolvedDate.getMonth() + "/" + resolvedDate.getDay() + "/" + resolvedDate.getYear() + "\n");
    	sb.append("Description: " + description + "\n\n");
    	return sb.toString();
    }
}
