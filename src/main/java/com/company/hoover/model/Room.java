package com.company.hoover.model;

import java.awt.Point;
import java.util.Set;

public class Room {

	private final Point roomSize;
	private final Set<Point> dirtPatchesSet;
	private Point hooverPosition;
	private int patchRemovalCount = 0;

	public Room(Point roomSizeIn, Set<Point> dirtPatchesSetIn) {
		this.roomSize = roomSizeIn;
		this.dirtPatchesSet = dirtPatchesSetIn;
	}

	public void initHooverPosition(Point initialPosition) {
		this.hooverPosition = initialPosition;
	}

	public void moveHooverPosition(Point newPosition) {
		this.hooverPosition = newPosition;
	}


	public void incrementCountAndRemoveStainFromSet() {
		patchRemovalCount += 1;		
		dirtPatchesSet.remove(hooverPosition);
	}

	
	public Point getRoomSize() {
		return roomSize;
	}

	
	public Set<Point> getDirtPatchesSet() {
		return dirtPatchesSet;
	}
	
	public Point getHooverPosition() {
		return hooverPosition;
    }
	public int getPatchRemovalCount() {
		return patchRemovalCount;
	}
	
	
	public boolean isDirtyPatchCovered() {
      return dirtPatchesSet.stream().anyMatch(dirt -> dirt.equals(hooverPosition));
  }

}
