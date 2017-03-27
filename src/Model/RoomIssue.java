package src.Model;

/*
    Created by Peter on 3/26/17
*/

import java.util.Date;

public class RoomIssue {

    private Date reportDate;
    private Date resolvedDate;
    private String description;
    private boolean ongoing;

    public RoomIssue(Date d, String desc) {
        reportDate = d;
        resolvedDate = null;
        description = desc;
        ongoing = true;
    }
    
    public void resolve(Date d) {
        resolvedDate = d;
        ongoing = false;
    }
}
