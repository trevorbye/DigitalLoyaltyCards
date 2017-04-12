package com.trevorbye.web;

import com.trevorbye.POJO.ErrorResponseObj;
import com.trevorbye.model.PunchCardEntity;
import com.trevorbye.service.PunchCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VendorCardRESTController {
    /*
    Primary controller for vendor operations. Creating new cards, fetching all cards for profile page,
    and deleting cards.
    * */

    @Autowired
    private PunchCardService cardService;

    @RequestMapping(method = RequestMethod.POST, path = "/createCard")
    public ResponseEntity<?> createCard(@Valid @RequestBody PunchCardEntity entity) {
        return new ResponseEntity<>(cardService.createOrUpdate(entity), HttpStatus.OK);
    }

    @RequestMapping("/getCardsByCompanyId")
    public ResponseEntity<?> getCard(@RequestParam long companyId) {
        List<PunchCardEntity> entities = cardService.selectAllByCompanyId(companyId);

        if (entities.isEmpty()) {
            return new ResponseEntity<>(new ErrorResponseObj("No cards for this companyId."), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(entities, HttpStatus.OK);
        }
    }

    @RequestMapping("/deleteCardById")
    public ResponseEntity<?> deleteCard(@RequestParam long cardId) {
        PunchCardEntity entity = cardService.selectById(cardId);

        if (entity == null) {
            return new ResponseEntity<>(new ErrorResponseObj("Card does not exist."), HttpStatus.BAD_REQUEST);
        } else {
            cardService.deleteEntity(entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }

    //TODO add logic to increment punch count and mark a UserCardJoinEntity as "complete", but restrict these operations


}
