package com.virtusa.vtaf.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.vtaf.Model.Device;
import com.virtusa.vtaf.Repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository repo;

	public List<Device> listAll() {
		return repo.findAll();
	}

	public void save(Device device) {
		repo.save(device);
	}

	public Device get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}	

	public boolean isAvalable(Device device) {
		boolean max=false;
		//Device D1=new Device();
		List<Device> devices= new ArrayList<Device>();
		devices = repo.findAll();
		
		//Set<Device> D=new HashSet<>();
		
		
		
		for (Device one: devices) {
			if(one.getUuid().equals(device.getUuid())) {
				max=true;
				break;
			}
		}
		
		
		return max;
		}
		

}
