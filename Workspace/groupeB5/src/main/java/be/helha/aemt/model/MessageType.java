package be.helha.aemt.model;

public enum MessageType {
	TECH_ISSUE("Technical issue"),
	EVENT_PROMOTE("Event to promote"),
	NEWS_PROMOTE("News to promote"),
	IDEA("I have an idea");
 
    private String type;
 
    MessageType(String type) {
        this.type = type;
    }
 
    public String getMessageType() {
        return type;
    }
}
