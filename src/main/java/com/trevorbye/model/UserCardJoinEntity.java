package com.trevorbye.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
public class UserCardJoinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long cardId;

    @NotNull
    private long userId;

    @NotNull
    private String username;

    @NotNull
    @Max(10)
    private int userPunchCount;

    @NotNull
    private Boolean isCardComplete;

    public UserCardJoinEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserPunchCount() {
        return userPunchCount;
    }

    public void setUserPunchCount(int userPunchCount) {
        this.userPunchCount = userPunchCount;
    }

    public Boolean getCardComplete() {
        return isCardComplete;
    }

    public void setCardComplete(Boolean cardComplete) {
        isCardComplete = cardComplete;
    }
}
