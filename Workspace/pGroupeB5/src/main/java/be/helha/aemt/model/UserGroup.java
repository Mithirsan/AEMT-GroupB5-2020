package be.helha.aemt.model;

public enum UserGroup {
	GRADUATE("graduate"),
	ADMIN("admin"), 
    TEACHER("teacher");
 
    private String groupName;
 
    UserGroup(String groupName) {
        this.groupName = groupName;
    }
 
    public String getGroupName() {
        return groupName;
    }
}
