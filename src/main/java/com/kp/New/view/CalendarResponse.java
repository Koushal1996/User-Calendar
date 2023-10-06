package com.kp.New.view;

public class CalendarResponse {

    private Long id;

    private String description;

    private String userName;

    private Long userId;


    public CalendarResponse(Long id, String description, String userName, Long userId) {
        this.id = id;
        this.description = description;
        this.userName = userName;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
