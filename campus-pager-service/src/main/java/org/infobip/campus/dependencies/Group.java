package org.infobip.campus.dependencies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hbusic on 10.8.2016.
 */
public class Group {

    private String groupID;
    private List<Member> members;

    public Group(String groupID) {
        if(groupID == null) {
            throw new IllegalArgumentException();
        }
        this.groupID = groupID;
        members = new ArrayList<>();
    }

    public String getGroupID() {
        return groupID;
    }

    public void addMember(Member member) {
        if(member == null) {
            throw new IllegalArgumentException();
        }
        if(!members.contains(member)) {
            members.add(member);
        }
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupID != null ? groupID.equals(group.groupID) : group.groupID == null;

    }

    @Override
    public int hashCode() {
        return groupID != null ? groupID.hashCode() : 0;
    }
}
