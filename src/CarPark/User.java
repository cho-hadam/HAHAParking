package CarPark;

public class User {
	private String name; //����� �̸�
	private int car_number; //�ڵ��� ��ȣ
	private String car_type; //�ڵ��� ����
	private int special = 0; //����� ���� ����, 1�� ��� ����� ������.
	
	//������ �޼���
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

	//��� ������ �˷��ش�
	@Override
	public String toString() {
		return "����� ���� [�̸�: " + name + ", ���� ��ȣ: " + car_number + ", ���� ����: " + car_type + "]";
	}
}
