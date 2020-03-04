package com.company.hoover.service;

import com.company.hoover.exception.ServiceException;
import com.company.hoover.model.HooverRequest;
import com.company.hoover.model.HooverResponse;


public interface HooverService {
	
	 HooverResponse cleanRoom(HooverRequest hooverRobotRequest) throws ServiceException ;

}
