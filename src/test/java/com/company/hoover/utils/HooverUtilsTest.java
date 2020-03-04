package com.company.hoover.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.hoover.model.HooverRequest;

public class HooverUtilsTest {

	private HooverRequest request;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		request = null;
	}

	@Test()
	public void testNullRoomSize() {
		request = new HooverRequest(null, null, null, null);
		assertFalse(HooverUtils.validateHooverRequest(request));
		
	}

	@Test
	public void testRoomSize_CorrectValues() throws Exception {
		request = new HooverRequest(new int[] {5, 5}, null, null, null);
		assertFalse(HooverUtils.validateHooverRequest(request));
	}

	@Test
	public void testRoomSize_IncorrectCoordinate() throws Exception {
		request = new HooverRequest(new int[] {-1, 2}, null, null, null);
		assertFalse(HooverUtils.validateHooverRequest(request));
	}

	@Test
	public void testRoomSizeWithRectangleDimn() throws Exception {
		request = new HooverRequest(new int[] {5, 10}, new int[] {1, 2},new int[][] {{1, 0},{2, 2},{2, 3}},"NNESEESWNWW");
		assertTrue(HooverUtils.validateHooverRequest(request));
	}

	

	@Test
	public void testInitialPositionOutOfRoom() throws Exception {
		request = new HooverRequest(new int[] {5, 5}, new int[] {7, 2},new int[][] {{1, 0},{2, 2},{2, 3}},"NNESEESWNWW");
		assertFalse(HooverUtils.validateHooverRequest(request));
	}

	@Test
	public void testWithNullInstructions() throws Exception {
		request = new HooverRequest(new int[] {5, 5}, new int[] {7, 2},new int[][] {{1, 0},{2, 2},{2, 3}},null);
		assertFalse(HooverUtils.validateHooverRequest(request));
	}

	@Test
	public void testInstructionsWithUnknownCharacters() throws Exception {
		request = new HooverRequest(new int[] {5, 5}, new int[] {7, 2},new int[][] {{1, 0},{2, 2},{2, 3}},"NNESEESWNWW123");
		assertFalse(HooverUtils.validateHooverRequest(request));
	}

	

}
