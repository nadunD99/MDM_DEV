package com.virtusa.vtaf.Service;

import java.util.List;

import com.virtusa.vtaf.Model.Device;

public interface DeviceService {
	List<Device> listAll();
	
	public void save(Device device);
	
	public Device get(Integer id);
	
	public void delete(Integer id);
	
	public boolean isAvalable(Device device);

}
