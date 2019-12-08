package com.bjsxt.model;

public class User {
	
	private int id ; 

	private String ksTime ; 
	private String kcName ; 
	private String className ; 
	private String classNum ; 
	private String similar ; 
	private String position ; 
	private String posi_num ;
	private String supervisor ; 
	private String jk1 ; 
	private String jk2 ;
	private String jk3 ; 
	private String jk4 ;
	private String tea_teacher ; 
	private String kh_Style ; 
	private String note ;
	
	public User() {
		super();
	}

	public User(int id, String ksTime, String kcName, String className, String classNum,
			String similar, String position, String posi_num, String supervisor,
			String jk1, String jk2,String jk3,String jk4,String tea_teacher,String kh_Style,String note) {
		super();
		this.id = id;
		this.ksTime = ksTime;
		this.kcName = kcName;
		this.className = className;
		this.classNum = classNum;
		this.similar = similar;
		this.position = position;
		this.posi_num = posi_num;
		this.supervisor = supervisor;
		this.jk1 = jk1;
		this.jk2 = jk2;
		this.jk3 = jk3;
		this.jk4 = jk4;
		this.tea_teacher = tea_teacher;
		this.kh_Style = kh_Style;
		this.note = note;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKsTime() {
		return ksTime;
	}

	public void setKsTime(String ksTime) {
		this.ksTime = ksTime;
	}

	public String getKcName() {
		return kcName;
	}

	public void setKcName(String kcName) {
		this.kcName = kcName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getSimilar() {
		return similar;
	}

	public void setSimilar(String similar) {
		this.similar = similar;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosi_num() {
		return posi_num;
	}

	public void setPosi_num(String posi_num) {
		this.posi_num = posi_num;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getJk1() {
		return jk1;
	}

	public void setJk1(String jk1) {
		this.jk1 = jk1;
	}

	public String getJk2() {
		return jk2;
	}

	public void setJk2(String jk2) {
		this.jk2 = jk2;
	}

	public String getJk3() {
		return jk3;
	}

	public void setJk3(String jk3) {
		this.jk3 = jk3;
	}

	public String getJk4() {
		return jk4;
	}

	public void setJk4(String jk4) {
		this.jk4 = jk4;
	}

	public String getTea_teacher() {
		return tea_teacher;
	}

	public void setTea_teacher(String tea_teacher) {
		this.tea_teacher = tea_teacher;
	}

	public String getKh_Style() {
		return kh_Style;
	}

	public void setKh_Style(String kh_Style) {
		this.kh_Style = kh_Style;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
}
