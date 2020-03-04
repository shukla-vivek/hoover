package com.company.hoover.service.impl;

import java.awt.Point;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.company.hoover.exception.ServiceException;
import com.company.hoover.model.HooverRobot;
import com.company.hoover.model.HooverRequest;
import com.company.hoover.model.HooverResponse;
import com.company.hoover.model.Room;
import com.company.hoover.service.HooverService;
import com.company.hoover.utils.HooverUtils;

@Service
public class HooverServiceImpl implements HooverService {

	@Override
	public HooverResponse cleanRoom(HooverRequest hooverRobotRequest) throws ServiceException {
		if(!HooverUtils.validateHooverRequest(hooverRobotRequest))
			 throw new ServiceException();
		Set<Point> dirtPatchSet = HooverUtils.collectDirtPatches(hooverRobotRequest.getDirtPatches());
		List<Character> instructionsList = HooverUtils.collectInstructions(hooverRobotRequest.getInstructions());

		Point roomSize = new Point(hooverRobotRequest.getRoomSize()[0], hooverRobotRequest.getRoomSize()[1]);

		Room room = new Room(roomSize, dirtPatchSet);

		Point initialPosition = new Point(hooverRobotRequest.getInitialPosition()[0],hooverRobotRequest.getInitialPosition()[1]);

		HooverRobot hoover = new HooverRobot(initialPosition, room);
		
		hoover.executeInstructionList(instructionsList);

		final Point finalHooverPosition = hoover.hooverPosition();
		return new HooverResponse(new int[] { finalHooverPosition.x, finalHooverPosition.y },
				room.getPatchRemovalCount());

	}

}
