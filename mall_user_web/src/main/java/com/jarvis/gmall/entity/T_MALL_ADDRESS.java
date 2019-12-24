package com.jarvis.gmall.entity;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class T_MALL_ADDRESS implements Serializable {

	@FormParam("id")
	private int id;
	@FormParam("dz_mch")
	private String dz_mch;
	@FormParam("dzzt")
	private String dzzt;
	@FormParam("yh_id")
	private int yh_id;
	@FormParam("shjr")
	private String shjr;
	@FormParam("lxfsh")
	private String lxfsh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDz_mch() {
		return dz_mch;
	}

	public void setDz_mch(String dz_mch) {
		this.dz_mch = dz_mch;
	}

	public String getDzzt() {
		return dzzt;
	}

	public void setDzzt(String dzzt) {
		this.dzzt = dzzt;
	}

	public int getYh_id() {
		return yh_id;
	}

	public void setYh_id(int yh_id) {
		this.yh_id = yh_id;
	}

	public String getShjr() {
		return shjr;
	}

	public void setShjr(String shjr) {
		this.shjr = shjr;
	}

	public String getLxfsh() {
		return lxfsh;
	}

	public void setLxfsh(String lxfsh) {
		this.lxfsh = lxfsh;
	}

}
