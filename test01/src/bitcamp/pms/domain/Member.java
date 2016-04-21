package bitcamp.pms.domain;

public class Member {
  protected int    ino;
  protected String name;
  protected int age;
  protected boolean gender;
  protected String tel;
  protected String step;
  protected String password;
  protected String email;
  

  
public Member(int ino, String name, int age, boolean gender, String tel, String step, String password, String email) {
	super();
	this.ino = ino;
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.tel = tel;
	this.step = step;
	this.password = password;
	this.email = email;
}

@Override
public String toString() {
	return "Member [ino=" + ino + ", name=" + name + ", age=" + age + ", gender=" + gender + ", tel=" + tel + ", step="
			+ step + ", password=" + password + ", email=" + email + "]";
}

public int getIno() {
	return ino;
}
public void setIno(int ino) {
	this.ino = ino;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public boolean isGender() {
	return gender;
}
public void setGender(boolean gender) {
	this.gender = gender;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getStep() {
	return step;
}
public void setStep(String step) {
	this.step = step;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

  
}
