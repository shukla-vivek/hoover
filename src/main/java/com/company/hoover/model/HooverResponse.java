package com.company.hoover.model;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HooverResponse implements Serializable,Hoover{

	private static final long serialVersionUID = 281591072711438656L;

	@JsonProperty("patches")
	private  int cleanedPatchesCount;

	@JsonProperty("coords")
	private  int[] finalHooverPosition;

	public HooverResponse() {
		
	}
	public HooverResponse(int[] finalHooverPosition, int cleanedPatchesCount) {
		this.cleanedPatchesCount = cleanedPatchesCount;
		this.finalHooverPosition = finalHooverPosition;
	}
	
	public int getCleanedPatchesCount() {
		return cleanedPatchesCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cleanedPatchesCount;
		result = prime * result + Arrays.hashCode(finalHooverPosition);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HooverResponse other = (HooverResponse) obj;
		if (cleanedPatchesCount != other.cleanedPatchesCount)
			return false;
		if (!Arrays.equals(finalHooverPosition, other.finalHooverPosition))
			return false;
		return true;
	}
	
	

}
