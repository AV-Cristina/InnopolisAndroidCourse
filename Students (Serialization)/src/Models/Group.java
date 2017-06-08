package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 08.06.2017.
 */
public class Group {
    private Long groupId;
    private String name;
    private List<Students> studentsList;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group (Long groupId, String name){
        this.groupId = groupId;
        this.name = name;
        this.studentsList = new ArrayList<>();
    }

}


