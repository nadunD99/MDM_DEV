package com.virtusa.vtaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.virtusa.vtaf.Model.Device;
import com.virtusa.vtaf.Service.DeviceService;

@Controller
public class DeviceController {

	private DeviceService deviceService;

	@Autowired
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@GetMapping(value = "/device/", produces = "application/json")
	public ResponseEntity<List<Device>> listAllDevices() {
		List<Device> devices = deviceService.listAll();
		if (devices.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Device------------------------------------------

	@GetMapping(value = "/device/{id}", produces = "application/json")
	public ResponseEntity<?> getDevice(@PathVariable("id") Integer id) {

		Device device = deviceService.get(id);
		if (device == null) {

			return new ResponseEntity<>("Device with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}

	// -------------------Create a Device-------------------------------------------

	@PostMapping(value = "/device/save", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> createDevice(@RequestBody Device device) {

		if (deviceService.isAvalable(device)) {
			return new ResponseEntity<>("Unable to create. A Device with name " + device.getName() + " already exist.",
					HttpStatus.CONFLICT);
		}
		
		deviceService.save(device);
		return new ResponseEntity( HttpStatus.CREATED);
	}

	// ------------------- Update a Device
	// ------------------------------------------------

	@PutMapping(value = "/device/update/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> updateDevice(@PathVariable("id") Integer id, @RequestBody Device device) {

		Device currentDevice = deviceService.get(id);

		if (currentDevice == null) {

			return new ResponseEntity<>("Unable to upate. Device with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		currentDevice.setAlias(device.getAlias());
		currentDevice.setIs_out_of_order(device.isIs_out_of_order());

		deviceService.save(currentDevice);
		return new ResponseEntity<Device>(currentDevice, HttpStatus.OK);
	}

	// ------------------- Delete a Device-----------------------------------------

	@DeleteMapping(value = "/device/delete/{id}")
	public ResponseEntity<?> deleteDevice(@PathVariable("id") Integer id) {
		Device device = deviceService.get(id);
		if (device == null) {
			return new ResponseEntity<>("Unable to delete. Device with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}
		deviceService.delete(id);
		return new ResponseEntity<Device>(HttpStatus.NO_CONTENT);
	}

}
