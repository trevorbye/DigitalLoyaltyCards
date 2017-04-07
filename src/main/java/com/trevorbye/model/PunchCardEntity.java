package com.trevorbye.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class PunchCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cardId;

    @NotNull
    private long companyId;

    @NotEmpty
    private String company;

    @NotEmpty
    private String title;

    private String body;

    @NotNull
    @Max(10)
    private int numberOfPunches;

    @NotEmpty
    private String cssPositioning;

    @NotEmpty
    private String cssColorAndStyle;

    @NotNull
    private Date expirationDate;

    @NotNull
    private Boolean isExpirationDateInclusive;

    public PunchCardEntity() {
    }

    public static String asJsonString(PunchCardEntity entity) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entity);
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getNumberOfPunches() {
        return numberOfPunches;
    }

    public void setNumberOfPunches(int numberOfPunches) {
        this.numberOfPunches = numberOfPunches;
    }

    public String getCssPositioning() {
        return cssPositioning;
    }

    public void setCssPositioning(String cssPositioning) {
        this.cssPositioning = cssPositioning;
    }

    public String getCssColorAndStyle() {
        return cssColorAndStyle;
    }

    public void setCssColorAndStyle(String cssColorAndStyle) {
        this.cssColorAndStyle = cssColorAndStyle;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getExpirationDateInclusive() {
        return isExpirationDateInclusive;
    }

    public void setExpirationDateInclusive(Boolean expirationDateInclusive) {
        isExpirationDateInclusive = expirationDateInclusive;
    }
}