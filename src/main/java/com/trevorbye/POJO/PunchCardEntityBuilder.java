package com.trevorbye.POJO;

import com.trevorbye.model.PunchCardEntity;

import java.util.Date;

public class PunchCardEntityBuilder {
    private PunchCardEntity entity = new PunchCardEntity();

    public PunchCardEntityBuilder companyId(long companyId) {
        entity.setCompanyId(companyId);
        return this;
    }

    public PunchCardEntityBuilder company(String company) {
        entity.setCompany(company);
        return this;
    }

    public PunchCardEntityBuilder title(String title) {
        entity.setTitle(title);
        return this;
    }

    public PunchCardEntityBuilder body(String body) {
        entity.setBody(body);
        return this;
    }

    public PunchCardEntityBuilder numberOfPunches(int punches) {
        entity.setNumberOfPunches(punches);
        return this;
    }

    public PunchCardEntityBuilder CssPositioning(String cssPositioning) {
        entity.setCssPositioning(cssPositioning);
        return this;
    }

    public PunchCardEntityBuilder CssColorAndStyle(String cssColorAndStyle) {
        entity.setCssColorAndStyle(cssColorAndStyle);
        return this;
    }

    public PunchCardEntityBuilder date(Date date) {
        entity.setExpirationDate(date);
        return this;
    }

    public PunchCardEntityBuilder inclusiveDate(Boolean inclusive) {
        entity.setExpirationDateInclusive(inclusive);
        return this;
    }

    public PunchCardEntity build() {
        return entity;
    }
}
