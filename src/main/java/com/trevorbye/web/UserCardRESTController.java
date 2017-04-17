package com.trevorbye.web;

import com.trevorbye.POJO.ErrorResponseObj;
import com.trevorbye.model.CustomerCardJoinEntity;
import com.trevorbye.service.CustomerCardJoinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserCardRESTController {
    //TODO add logic to match "Principal" to username in payload

    /*
    Primary controller for user operations.
    * */

    @Autowired
    private CustomerCardJoinServiceImpl service;

    @RequestMapping(method = RequestMethod.POST, path = "/subscribeToCard")
    public ResponseEntity<?> subscribeToCard(@Valid @RequestBody CustomerCardJoinEntity payload) {

        //prevent user from creating the same card from the same company more than once
        if (service.getUserAndCardSubscription(payload.getUserId(), payload.getCardId()) == null) {
            payload.setUserPunchCount(0);
            payload.setCardComplete(false);
            return new ResponseEntity<>(service.createOrUpdate(payload), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponseObj("Card already exists for user."), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/deleteCardSubscription")
    public ResponseEntity<?> deleteCard(@RequestParam long userId, @RequestParam long cardId) {
        CustomerCardJoinEntity entity = service.deleteUserAndCardSubscriptionCombination(userId, cardId);

        if (entity == null) {
            return new ResponseEntity<>(new ErrorResponseObj("Card/User combination does not exist."), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }

    @RequestMapping("/getAllSubscriptionsForUser")
    public ResponseEntity<?> getAllSubscriptionsForUser(@RequestParam long userId) {
        List<CustomerCardJoinEntity> entities = service.getAllSubscriptionsForUser(userId);

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
