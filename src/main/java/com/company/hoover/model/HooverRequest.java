package com.company.hoover.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HooverRequest implements Serializable{

	private static final long serialVersionUID = 967522481387168673L;

	@JsonProperty("roomSize")
	private final int[] roomSize;

	@JsonProperty("coords")
	private final int[] initialPosition;

	@JsonProperty("patches")
	private final int[][] dirtPatches;

	@JsonProperty("instructions")
	private final String instructions;

	public HooverRequest(int[] roomSize, int[] initialPosition, int[][] patches, String instructions) {
		this.roomSize = roomSize;
		this.dirtPatches = patches;
		this.instructions = instructions;
		this.initialPosition = initialPosition;
	}

	public int[] getRoomSize() {
		return roomSize;
	}

	public int[] getInitialPosition() {
		return initialPosition;
	}

	public int[][] getDirtPatches() {
		return dirtPatches;
	}

	public String getInstructions() {
		return instructions;
	}

}
