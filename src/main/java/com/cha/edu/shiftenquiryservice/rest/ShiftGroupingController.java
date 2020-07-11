package com.cha.edu.shiftenquiryservice.rest;


import com.cha.edu.shiftenquiryservice.service.ShiftGroupingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Rest API for Shift Grouping entity
 */
@RestController
@Validated
@RequestMapping("/shift-grouping")
@Api(value = "ShiftGroupingController")
public class ShiftGroupingController {

    private static final Logger logger = LoggerFactory.getLogger(ShiftGroupingController.class);

    @Autowired
    private ShiftGroupingService shiftGroupingService;


    @ApiOperation(value = "Check group code and shift code is exists", response = Boolean.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Group code and shift code are available"),
            @ApiResponse(code = 400, message = "Arguments are not valid (min length is 5 characters)"),
            @ApiResponse(code = 404, message = "Group code and shift code are not available")
    }
    )
    @GetMapping("/group/{group}/shift/{shift}")
    public ResponseEntity shifyBelogToTheGroup(@PathVariable("group") @NotNull @NotBlank @Size(min = 5) String group,
                                               @PathVariable("shift") @NotNull @NotBlank @Size(min = 5) String shift) {
        logger.info("Enquiring the group {} , shift {} ", group, shift);
        ResponseEntity responseEntity;
        boolean exists = shiftGroupingService.doesShiftBelongToGroup(shift, group);
        logger.info("Result for enquiry the group {} , shift {} exists {} ", group, shift, exists);
        if (exists) {
            responseEntity = ResponseEntity.ok().body(true);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }


}
