package CarPark;

public class CarPark{
	private String location; //주차 위치
	private int time; //주차 시간
	private int price; //지불할 금액
	
	//생성자메서드
	public CarPark() {}
	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setTime(int time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}
	
	public int getTime() {
		return time;
	}
	
	//시간 추가
	public void plusTime(int plusTime) {
		this.time += plusTime;
	}
	
	//주차장을 빠져나갈 때 시간 오버 여부 체크
	public String leaveCarPark() {
		String over = "";
		if(time<0) {
			over = "over";
		}else {
			over = "notOver";
		}
		return over;
	}
	
	//벌금을 계산하는 메서드
	public int fine(User u) {
		int fine = 0;

		switch(u.getCar_type()) {
		//차의 종류에 따라 벌금을 달리함
		case "경형" : fine = calFine(1500); break;
		case "소형" : fine = calFine(2000); break;
		case "중형" : fine = calFine(2500); break;
		case "대형" : fine = calFine(3000); break;
		}

		return fine;
	}
	
	private int calFine(int basic) {
		//시간이 오버되면 무조건 벌금 시작
		int fine = basic;
		
		//계산하기 위해서 time을 양수로 바꿈
		if(time<0) {
			time *= -1;
		}
		fine += basic*(time/10);

		return fine;
	}
	
	//지불할 금액을 계산함
	public int price(User u, int time) {
		switch(u.getCar_type()) {
		//차의 종류에 따라 금액을 달리함
		case "경형" : price = 1000*(time/10); break; //10분당 1000원으로 계산한다.
		case "소형" : price = 1500*(time/10); break;
		case "중형" : price = 2000*(time/10); break;
		case "대형" : price = 2500*(time/10); break;
		}
		
		if(u.getSpecial()==1) {
			price *= 0.9; //장애인 차량일 경우 10% 할인한다.
		}
		
		return price;
	}
	
	
	@Override
	public String toString() {
		return "주차장 [위치: " + location + ", 주차 시간: " + time + "]";
	}
	
	
}