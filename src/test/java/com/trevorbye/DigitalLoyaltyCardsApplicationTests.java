package com.trevorbye;

import com.trevorbye.POJO.PunchCardEntityBuilder;
import com.trevorbye.model.PunchCardEntity;
import com.trevorbye.service.PunchCardService;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DigitalLoyaltyCardsApplicationTests {

    @Autowired
    private PunchCardService service;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {

        //build test object to persist
        PunchCardEntity entity = new PunchCardEntityBuilder().body("testBody").company("Darigold").companyId(555)
                .CssColorAndStyle(".test {color: black}").CssPositioning(".test {position: relative}")
                .title("Hello World.").numberOfPunches(7).inclusiveDate(true).date(new Date(new Date().getTime()))
                .build();

        service.deleteAll();
        service.createOrUpdate(entity);
        RestAssured.port = port;
    }

    @Test
    public void canRequestCardsForCompany() throws Exception {
        RestAssured.given()
                .params("companyId", 555)
                .when()
                    .get("/getCardsByCompanyId")
                .then()
                    .statusCode(200)
                    .body("body[0]", equalTo("testBody"))
                    .body("title[0]", equalTo("Hello World."));
    }
}
