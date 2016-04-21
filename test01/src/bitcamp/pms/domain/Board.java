package bitcamp.pms.domain;

import java.sql.Date;

public class Board {
  private int     bno;
  private String  title;
  private String  content;
  private int     views;
  private String  password;
  private Date    createdDate;
  private String  auth;
  private int     ino;
  
  @Override
  public String toString() {
	return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", views=" + views + ", password="
			+ password + ", createdDate=" + createdDate + ", auth=" + auth + ", ino=" + ino + "]";
}



  public int getBno() {
	return bno;
}



public void setBno(int bno) {
	this.bno = bno;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public String getContent() {
	return content;
}



public void setContent(String content) {
	this.content = content;
}



public int getViews() {
	return views;
}



public void setViews(int views) {
	this.views = views;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getAuth() {
	return auth;
}



public void setAuth(String auth) {
	this.auth = auth;
}



public int getIno() {
	return ino;
}



public void setIno(int ino) {
	this.ino = ino;
}



public Date getCreatedDate() {
	return createdDate;
}



public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  
  
}
