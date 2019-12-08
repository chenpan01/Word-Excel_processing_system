package com.bjsxt.dto;

import java.util.HashMap;
import java.util.Map;

public class TreeDTO {
		
		private int id ;
		private String text ;
		private String iconCls ;
		private int checked ;
		private int parent_id ;
		private Map<String, Object> attributes = new HashMap<String, Object>();
		private String state ;
		
		
		public TreeDTO(int id, String text, String iconCls, int checked,
				int parentId, Map<String, Object> attributes, String state) {
			super();
			this.id = id;
			this.text = text;
			this.iconCls = iconCls;
			this.checked = checked;
			parent_id = parentId;
			this.attributes = attributes;
			this.state = state;
		}
		public TreeDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getIconCls() {
			return iconCls;
		}
		public void setIconCls(String iconCls) {
			this.iconCls = iconCls;
		}
		public int getChecked() {
			return checked;
		}
		public void setChecked(int checked) {
			this.checked = checked;
		}
		public int getParent_id() {
			return parent_id;
		}
		public void setParent_id(int parentId) {
			parent_id = parentId;
		}
		public Map<String, Object> getAttributes() {
			return attributes;
		}
		public void setAttributes(Map<String, Object> attributes) {
			this.attributes = attributes;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		
		
}
