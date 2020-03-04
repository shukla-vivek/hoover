package com.company.hoover.controller;

import static com.company.hoover.constants.HooverConstants.INTERNAL_REQUEST_FAILED;
import static com.company.hoover.constants.HooverConstants.INVALID_INPUT_REQUEST;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.hoover.exception.ErrorResponse;
import com.company.hoover.exception.ServiceException;
import com.company.hoover.model.Hoover;
import com.company.hoover.model.HooverRequest;
import com.company.hoover.model.HooverResponse;
import com.company.hoover.service.HooverService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/1.0/int/hooverRobot")
public class HooverController {

	private final Logger LOGGER = LoggerFactory.getLogger(HooverController.class);

	@Autowired
	private HooverService robotHooverService;

	@ApiOperation(value = "cleanRoom", nickname = "CleanRoom", notes = "CleanRoom TODO", response = HooverResponse.class,
			      tags = {"Hoover" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = HooverResponse.class),
			                @ApiResponse(code = 500, message = "Problem occured while serving the request") })
	@PostMapping(value = "/cleanRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hoover> cleanRoom(@NotNull @RequestBody HooverRequest hooverRequest) {
		LOGGER.debug("Inside cleanRoom {}",hooverRequest);
		HooverResponse hooverControllerResponse = new HooverResponse();;
		try {
			hooverControllerResponse = robotHooverService.cleanRoom(hooverRequest);
		} catch (ServiceException e) {
			LOGGER.error("HooverController|cleanRoom|ServiceException Occured: {}",e);
			return new ResponseEntity<>(new ErrorResponse(INVALID_INPUT_REQUEST),HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error("HooverController|cleanRoom|Exception Occured: {}",e);
			return new ResponseEntity<>(new ErrorResponse(INTERNAL_REQUEST_FAILED),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(hooverControllerResponse, HttpStatus.OK);
	}
}
