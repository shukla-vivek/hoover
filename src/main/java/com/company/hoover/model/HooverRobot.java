package com.company.hoover.model;

import java.awt.Point;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HooverRobot {
	
	private final Logger LOGGER = LoggerFactory.getLogger(HooverRobot.class);
	
	private final Point initialHooverPosition;
	private final Room roomToClean;
	
	public Point getInitialPosition() {
        return initialHooverPosition;
    }

    public Point hooverPosition() {
        return this.roomToClean.getHooverPosition();
    }

	private void initHooverPosition(Point initPosition) {
        this.roomToClean.initHooverPosition(initPosition);
    }

    private void moveHooverPosition(Point nextPosition) {
        this.roomToClean.moveHooverPosition(nextPosition);
    }
    
    public HooverRobot(Point initPosition, Room roomToClean) {
        this.initialHooverPosition = initPosition;
        this.roomToClean = roomToClean;
        initHooverPosition(initialHooverPosition);
    }
    

    public void executeInstructionList(List<Character> instructions) {
    	instructions.stream().forEach(i -> {
            switch(Character.toUpperCase(i)) {
                case 'N':
                	moveHooverPosition(moveToNorth());
                    break;
                case 'E':
                	moveHooverPosition(moveToEast());
                    break;
                case 'S':
                	moveHooverPosition(moveToSouth());
                    break;
                case 'W':
                	moveHooverPosition(moveToWest());
                    break;
                default:
                	LOGGER.error("Unknown Instruction: {}", i);
            }
            
            if(roomToClean.isDirtyPatchCovered()) {
                roomToClean.incrementCountAndRemoveStainFromSet();
            }
        });
    }
 
    public Point moveToNorth() {
        Point currentPosition = hooverPosition();
        int upperRoomEdge = this.roomToClean.getRoomSize().y;
        if(currentPosition.y < upperRoomEdge) {
            return new Point(currentPosition.x, currentPosition.y+1);
        }
        return currentPosition;
    }
    
   
    public Point moveToSouth() {
        Point currentPosition = hooverPosition();
        if(currentPosition.y > 0) {
            return new Point(currentPosition.x, currentPosition.y-1);
        }
        return currentPosition;
    }

    public Point moveToWest() {
        Point currentPosition = hooverPosition();
        if(currentPosition.x > 0) {
            return new Point(currentPosition.x-1, currentPosition.y);
        }
        return currentPosition;
    }
    public Point moveToEast() {
        Point currentPosition = hooverPosition();
        int easternRoomEdge = this.roomToClean.getRoomSize().x;
        if(currentPosition.x < easternRoomEdge) {
            return new Point(currentPosition.x+1, currentPosition.y);
        }
        return currentPosition;
    }

}
