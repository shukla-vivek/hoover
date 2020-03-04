package com.company.hoover.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.company.hoover.model.Hoover;
import com.company.hoover.model.HooverRequest;
import com.company.hoover.model.HooverResponse;
import com.company.hoover.service.impl.HooverServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HooverControllerTest {


	@Mock
	private HooverServiceImpl hooverService;
	
	@InjectMocks
	private  HooverController  hooverController;
	
	@Mock
	HooverRequest hooverRequest;
	
	@Mock
	HooverResponse hooverResponse;

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void testCleanRoom_StatusOK() throws Exception {	
		when(hooverService.cleanRoom(hooverRequest)).thenReturn(hooverResponse);
		final ResponseEntity<Hoover> rsp = (ResponseEntity<Hoover>) hooverController.cleanRoom(hooverRequest);
		assertNotNull(rsp);
		assertEquals(HttpStatus.OK, rsp.getStatusCode());
	}
	
	/*
	 * @Test public void testCleanRoom_withNullRequest() throws Exception {
	 * when(hooverService.cleanRoom(null)).thenThrow(Exception.class); final
	 * ResponseEntity<Hoover> rsp = (ResponseEntity<Hoover>)
	 * hooverController.cleanRoom(null); assertNotNull(rsp);
	 * assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, rsp.getStatusCode()); }
	 */
}
