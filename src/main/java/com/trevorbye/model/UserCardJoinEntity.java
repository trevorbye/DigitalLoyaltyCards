package com.trevorbye.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
public class UserCardJoinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private long cardId;

    @NotEmpty
    private long userId;

    @NotEmpty
    private String username;

    @NotEmpty
    @Max(10)
    private int userPunchCount;

    @NotEmpty
    private Boolean isCardComplete;
}
