package com.company.hoover.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.hoover.exception.ServiceException;
import com.company.hoover.model.HooverRequest;
import com.company.hoover.model.HooverResponse;
import com.company.hoover.service.impl.HooverServiceImpl;
@RunWith(MockitoJUnitRunner.class) 
public class HooverServiceImplTest {

	@InjectMocks
	private HooverServiceImpl hooverService; 
	
	
	private HooverRequest robotRequest;
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected = Exception.class)
    public void testCleanRoomWithNullRequest() throws Exception {
        hooverService.cleanRoom(null);
    }
	
	@Test(expected = ServiceException.class)
    public void testCleanRoomWithIncorrectRoomSize() throws ServiceException {
		robotRequest = new HooverRequest(
                new int[] {0, 0},
                new int[] {1, 2},
                new int[][] {{1, 0},{2, 2},{2, 3}},
                "NNESEESWNWW");
        	hooverService.cleanRoom(robotRequest);
      
    }
	
	@Test(expected = ServiceException.class)
    public void testCleanRoomWithWithIncorrectInitialPosition() throws ServiceException  {
		robotRequest = new HooverRequest(
                new int[] {5, 5},
                new int[] {10, 2},
                new int[][] {{1, 0},{2, 2},{2, 3}},
                "NNESEESWNWW");
       hooverService.cleanRoom(robotRequest);
    }
	
	@Test
    public void testCleanRoomWithoutDirtPatches() throws Exception {
		robotRequest = new HooverRequest(
                new int[] {5, 5},
                new int[] {3, 3},
                new int[][] {{1, 0},{2, 2},{2, 3}},
                "NNESNS");
        final HooverResponse robotResponse = hooverService.cleanRoom(robotRequest);
        assertEquals(new HooverResponse(new int[] {4, 4}, 0), robotResponse);
    }

    @Test
    public void testCleanRoomWith_1_DirtPatchRemoved() throws Exception {
    	robotRequest = new HooverRequest(
                new int[] {5, 5},
                new int[] {1, 2},
                new int[][] {{1, 0},{2, 2},{2, 3}},
                "NNESEESWNWW");
        final HooverResponse robotResponse = hooverService.cleanRoom(robotRequest);
        assertEquals(new HooverResponse(new int[] {1, 3}, 1), robotResponse);
    }

}
