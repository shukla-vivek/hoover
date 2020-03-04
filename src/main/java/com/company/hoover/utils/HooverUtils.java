package com.company.hoover.utils;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.company.hoover.model.HooverRequest;

public class HooverUtils {

	private HooverUtils() {
	}
	
	public static boolean validateHooverRequest(HooverRequest hooverRobotRequest){
		return validateRoomSize(hooverRobotRequest.getRoomSize()) 
				&& validateInitialHooverPosition(hooverRobotRequest.getInitialPosition(),hooverRobotRequest.getRoomSize())
				&& hooverRobotRequest.getDirtPatches() != null
				&& isDirtPatchesFallsInsideRoom(hooverRobotRequest.getDirtPatches(), hooverRobotRequest.getRoomSize())
				&& isValidInstructions(hooverRobotRequest.getInstructions());
	}

	/**
	 * 
	 * RoomSize should not be null and should be having exactly 2 elements Both x &
	 * y coordinates of room should be more than 0
	 * 
	 */
	private static boolean validateRoomSize(int[] roomSize) {
		return (roomSize != null && roomSize.length == 2 && roomSize[0] >= 1 && roomSize[1] >=1) ;
	}

	/**
	 * 
	 * initPosition of Hoover can't be null and can onlyhave 2 elements Both
	 * elements of Roomsize has to be greater than 0 Hoover initial position should
	 * be inside the room
	 * 
	 */
	private static boolean validateInitialHooverPosition(int[] initPosition, int[] roomSize) {
		return (initPosition != null && initPosition.length == 2 && initPosition[0] <= roomSize[0]
				&& initPosition[1] <= roomSize[1] && initPosition[0] >= 0 && initPosition[1] >= 0) ;
	}

	private static boolean isDirtPatchesFallsInsideRoom(int[][] patches, int[] roomSize){
		boolean isValid = false;
		for (int i = 0; i < patches.length; i++) {
			if (patches[i].length == 2) {
				if (patches[i][0] < roomSize[0] && patches[i][1] < roomSize[1]) {
					isValid = true;
				} else {
					isValid = false;
					break;
				}
			} else {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	
	

	/**
	 * 
	 * Dirt Patches should be inside the room
	 */
	private static boolean isValidInstructions(String instructions) {
		if (null != instructions && !instructions.isEmpty()) {
			instructions = instructions.replaceAll("\\s+", "");
			Pattern pt = Pattern.compile("[NESW]+");
			Matcher match = pt.matcher(instructions);
			return match.matches();
		}
		return false;
	}

	/**
	 * 
	 * Validates if the correct direction is passed N,S,E,W
	 */
	public static List<Character> collectInstructions(String instructions) {
		List<Character> list = new LinkedList<>();
		instructions = instructions.replaceAll("\\s+", "");

		final char[] chars = instructions.toUpperCase().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			list.add(chars[i]);
		}
		return list;

	}
	
	public static Set<Point> collectDirtPatches(int[][] patches) {
		Set<Point> patchesSet = new HashSet<>();
		for (int i = 0; i < patches.length; i++) {
				patchesSet.add(new Point(patches[i][0], patches[i][1]));			
		}
		return patchesSet;
	}

}
