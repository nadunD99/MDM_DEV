package com.virtusa.vtaf.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.vtaf.Model.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer>{
	

}
