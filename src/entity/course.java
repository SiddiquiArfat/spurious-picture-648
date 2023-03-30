package entity;

import java.io.Serializable;

public class course implements Serializable{
	int id;
	int durationMonth;
	String name;
	double fee;
	String description; 
	public course(int id, int duration,String name,double fee,String descrip){
		super();
		this.id = id;
		this.durationMonth = duration;
		this.name = name;
		this.fee = fee;
		this.description = descrip;
	}
	public int id() {
		return id;
	}
	public int getDurationMonth() {
		return durationMonth;
	}
	public void setDurationMonth(int durationMonth) {
		this.durationMonth = durationMonth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "course [id=" + id + ", durationMonth=" + durationMonth + ", name=" + name + ", fee=" + fee
				+ ", description=" + description + "]";
	}

	
	
	
	
	
	
}