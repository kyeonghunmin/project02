package bitcamp.pms.domain;

import java.sql.Date;

public class Project {
  private int     pno;
  private int  inol;
  private int     inot;
  private String  title;
  private Date    startDate;
  private Date    endDate;
  private String  description;
  private int     state;
  private int     number;
  private String  slog;
  private Date    createdDate;
  private int     eno;
  
@Override
public String toString() {
	return "Project [pno=" + pno + ", inol=" + inol + ", inot=" + inot + ", title=" + title + ", startDate=" + startDate
			+ ", endDate=" + endDate + ", description=" + description + ", state=" + state + ", number=" + number
			+ ", slog=" + slog + ", createdDate=" + createdDate + ", eno=" + eno + "]";
}
public int getPno() {
	return pno;
}
public void setPno(int pno) {
	this.pno = pno;
}
public int getInol() {
	return inol;
}
public void setInol(int inol) {
	this.inol = inol;
}
public int getInot() {
	return inot;
}
public void setInot(int inot) {
	this.inot = inot;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getSlog() {
	return slog;
}
public void setSlog(String slog) {
	this.slog = slog;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public int getEno() {
	return eno;
}
public void setEno(int eno) {
	this.eno = eno;
}

 
}
