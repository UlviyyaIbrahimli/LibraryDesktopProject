package project.library.desktop.model.employee;

import project.library.desktop.model.AbstractClass;

public class TimeType extends AbstractClass {
    private Long id;
    private String timeTypeName;
    private String  timeInterval;
    private String pauseInterval;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeTypeName() {
        return timeTypeName;
    }

    public void setTimeTypeName(String timeTypeName) {
        this.timeTypeName = timeTypeName;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getPauseInterval() {
        return pauseInterval;
    }

    public void setPauseInterval(String pauseInterval) {
        this.pauseInterval = pauseInterval;
    }

    @Override
    public String toString() {
        return "TimeType{" +
                "id=" + id +
                ", timeTypeName='" + timeTypeName + '\'' +
                ", timeInterval='" + timeInterval + '\'' +
                ", pauseInterval='" + pauseInterval + '\'' +
                '}';
    }
}
