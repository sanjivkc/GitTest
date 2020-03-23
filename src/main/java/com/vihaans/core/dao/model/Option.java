package com.vihaans.core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mt_option")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Option extends BaseModelObject {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name = "id")
	private Long id;

	@Size(min = 0, max = 50)
	@Column(name = "module_group")
	private String mgroup;
	
	
	@Size(min = 0, max = 100)
	@Column(name = "description")
	private String description;
	
	
	@Size(min = 0, max = 50)
	@Column(name = "link")
	private String link;
	
	@Size(min = 0, max = 50)
	@Column(name = "type")
	private String type;
	
	@Size(min = 0, max = 50)
	@Column(name = "menu_group")
	private String menuGroup;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMgroup(){
		return mgroup;	
	}
	
	public void setMgroup(String mgroup){
		this.mgroup = mgroup;	
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getMenuGroup(){
		return menuGroup;	
	}
	
	public void setMenuGroup(String menuGroup){
		this.menuGroup = menuGroup;	
	}
	
	
	    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id + "; ");
		sb.append("mgroup: " + mgroup + "; ");
		sb.append("description: " + description + "; ");
		sb.append("link: " + link + "; ");
		sb.append("type: " + type + "; ");
		sb.append("menuGroup: " + menuGroup + "; ");
		
		return sb.toString();
	}

}

