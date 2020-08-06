package CarPark;

public class CarPark{
	private String location; //���� ��ġ
	private int time; //���� �ð�
	private int price; //������ �ݾ�
	
	//�����ڸ޼���
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
	
	//�ð� �߰�
	public void plusTime(int plusTime) {
		this.time += plusTime;
	}
	
	//�������� �������� �� �ð� ���� ���� üũ
	public String leaveCarPark() {
		String over = "";
		if(time<0) {
			over = "over";
		}else {
			over = "notOver";
		}
		return over;
	}
	
	//������ ����ϴ� �޼���
	public int fine(User u) {
		int fine = 0;

		switch(u.getCar_type()) {
		//���� ������ ���� ������ �޸���
		case "����" : fine = calFine(1500); break;
		case "����" : fine = calFine(2000); break;
		case "����" : fine = calFine(2500); break;
		case "����" : fine = calFine(3000); break;
		}

		return fine;
	}
	
	private int calFine(int basic) {
		//�ð��� �����Ǹ� ������ ���� ����
		int fine = basic;
		
		//����ϱ� ���ؼ� time�� ����� �ٲ�
		if(time<0) {
			time *= -1;
		}
		fine += basic*(time/10);

		return fine;
	}
	
	//������ �ݾ��� �����
	public int price(User u, int time) {
		switch(u.getCar_type()) {
		//���� ������ ���� �ݾ��� �޸���
		case "����" : price = 1000*(time/10); break; //10�д� 1000������ ����Ѵ�.
		case "����" : price = 1500*(time/10); break;
		case "����" : price = 2000*(time/10); break;
		case "����" : price = 2500*(time/10); break;
		}
		
		if(u.getSpecial()==1) {
			price *= 0.9; //����� ������ ��� 10% �����Ѵ�.
		}
		
		return price;
	}
	
	
	@Override
	public String toString() {
		return "������ [��ġ: " + location + ", ���� �ð�: " + time + "]";
	}
	
	
}