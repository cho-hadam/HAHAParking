package CarPark;

public class User {
	private String name; //사용자 이름
	private int car_number; //자동차 번호
	private String car_type; //자동차 종류
	private int special = 0; //장애인 차량 여부, 1일 경우 장애인 차량임.
	
	//생성자 메서드
	public User() {}
	

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public int getCar_number() {
		return car_number;
	}

	public void setCar_number(int car_number) {
		this.car_number = car_number;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//모든 정보를 알려준다
	@Override
	public String toString() {
		return "사용자 정보 [이름: " + name + ", 차량 번호: " + car_number + ", 차량 종류: " + car_type + "]";
	}
}
