/**
 * 
 */
package com.virtusa.vtaf.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author nmadhushan
 *
 */

@Entity
public class Device {
	
	private Integer id;
	private String uuid;
	private String name;
	private String os;
	private String os_version;
	private String alias;
	private boolean is_out_of_order;
	
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOs_version() {
		return os_version;
	}

	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isIs_out_of_order() {
		return is_out_of_order;
	}

	public void setIs_out_of_order(boolean is_out_of_order) {
		this.is_out_of_order = is_out_of_order;
	}
		
}
