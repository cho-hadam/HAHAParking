package CarPark;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class GUI {

	private JFrame frame;
	private JTextField nameField;
	private JTextField carNumField;
	private JTextField paymentField;

	private JTextField paymentField2;
	private JTextField findNameField;
	private JTextField findCarNumField;
	
	private boolean flag = false;

	// 객체 생성
	User u1 = new User();
	CarPark c1 = new CarPark();

	// 타이머
	private Timer t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 350, 500);
		// 창 사이즈 변경 불가능
		frame.setResizable(false);
		// 실행 시 가운데에 창이 뜸
		frame.setLocationRelativeTo(null);
		// 프로그램 제목
		frame.setTitle("HAHA PARKING");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 프로그램 아이콘 설정
		ImageIcon img = new ImageIcon("image/car.png");
		frame.setIconImage(img.getImage());

		// 버튼 디자인 (윤곽선 없음)
		EmptyBorder b1 = new EmptyBorder(5, 3, 5, 3);

		// 첫 화면
		JPanel startPanel = new JPanel();
		startPanel.setBackground(new Color(255, 250, 240));
		startPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(startPanel);
		startPanel.setLayout(null);

		// 첫 화면 자동차 이미지(배경)
		JLabel carImg = new JLabel("");
		carImg.setIcon(new ImageIcon("image/carBg.png"));
		carImg.setBounds(38, 41, 256, 200);
		startPanel.add(carImg);

		// 첫 화면 START 버튼
		JButton btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon("image/btnStart.png"));
		btnStart.setBackground(new Color(255, 250, 240));
		btnStart.setBounds(101, 358, 140, 50);
		btnStart.setBorder(b1);
		startPanel.add(btnStart);

		// HAHA PARKING
		JLabel hahaLabel = new JLabel("HAHA PARKING");
		hahaLabel.setForeground(Color.DARK_GRAY);
		hahaLabel.setFont(new Font("Agency FB", Font.BOLD, 30));
		hahaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hahaLabel.setBounds(91, 230, 161, 50);
		startPanel.add(hahaLabel);

		// 예매, 찾기, 종료 중 원하는 기능 선택
		JPanel choicePanel = new JPanel();
		choicePanel.setBackground(new Color(255, 250, 240));
		choicePanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(choicePanel);
		choicePanel.setLayout(null);

		// 예매 버튼
		JButton btnBook = new JButton("\uC608\uB9E4");
		btnBook.setForeground(new Color(255, 255, 255));
		btnBook.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		btnBook.setBackground(Color.PINK);
		btnBook.setBounds(108, 166, 128, 39);
		btnBook.setBorder(b1);
		choicePanel.add(btnBook);

		// 종료 버튼
		JButton btnEnd = new JButton("\uC885\uB8CC");
		btnEnd.setForeground(new Color(255, 255, 255));
		btnEnd.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		btnEnd.setBackground(new Color(192, 192, 192));
		btnEnd.setBounds(108, 249, 128, 39);
		btnEnd.setBorder(b1);
		choicePanel.add(btnEnd);

		// 사용자의 정보를 입력받는 화면
		JPanel userPanel = new JPanel();
		userPanel.setBackground(new Color(255, 250, 240));
		userPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(userPanel);
		userPanel.setLayout(null);

		// 이름 :
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.DARK_GRAY);
		nameLabel.setBounds(100, 97, 28, 19);
		userPanel.add(nameLabel);
		nameLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

		// 이름 입력
		nameField = new JTextField();
		nameField.setBackground(Color.WHITE);
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setBounds(163, 88, 120, 36);
		userPanel.add(nameField);
		nameField.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		nameField.setColumns(10);

		// 차량 번호 입력
		carNumField = new JTextField();
		carNumField.setBackground(Color.WHITE);
		carNumField.setHorizontalAlignment(SwingConstants.CENTER);
		carNumField.setBounds(163, 147, 120, 36);
		userPanel.add(carNumField);
		carNumField.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		carNumField.setColumns(10);

		// 차량 번호:
		JLabel carNumLabel = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		carNumLabel.setForeground(Color.DARK_GRAY);
		carNumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		carNumLabel.setBounds(60, 156, 68, 19);
		userPanel.add(carNumLabel);
		carNumLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

		// 차량 종류:
		JLabel carTypeLabel = new JLabel("\uCC28\uB7C9 \uC885\uB958");
		carTypeLabel.setForeground(Color.DARK_GRAY);
		carTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		carTypeLabel.setBounds(60, 219, 68, 19);
		userPanel.add(carTypeLabel);
		carTypeLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

		// 차량 종류 선택 (경형, 소형, 중형, 대형)
		JComboBox carTypeCheck = new JComboBox();
		carTypeCheck.setForeground(new Color(255, 255, 255));
		carTypeCheck.setBounds(163, 209, 120, 36);
		userPanel.add(carTypeCheck);
		carTypeCheck.setMaximumRowCount(4);
		carTypeCheck.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		carTypeCheck.setModel(new DefaultComboBoxModel(new String[] { "경형", "소형", "중형", "대형" }));
		carTypeCheck.setBackground(new Color(255, 204, 102));
		carTypeCheck.setEditable(false);

		// 장애인 차량 여부:
		JLabel specialLabel = new JLabel("\uC7A5\uC560\uC778 \uCC28\uB7C9");
		specialLabel.setForeground(Color.DARK_GRAY);
		specialLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		specialLabel.setBounds(46, 277, 82, 19);
		userPanel.add(specialLabel);
		specialLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

		// 장애인 차량 여부 선택(체크박스)
		JCheckBox specialCheck = new JCheckBox("");
		specialCheck.setBounds(217, 277, 21, 21);
		userPanel.add(specialCheck);
		specialCheck.setBackground(new Color(255, 250, 240));

		// 다음으로 넘어가는 버튼
		JButton btnNextUser = new JButton("NEXT");
		btnNextUser.setForeground(new Color(255, 255, 255));
		btnNextUser.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnNextUser.setBackground(new Color(255, 160, 122));
		btnNextUser.setBounds(123, 348, 97, 31);
		btnNextUser.setBorder(b1);
		userPanel.add(btnNextUser);

		// 주차 위치를 선택하는 화면
		JPanel locationPanel = new JPanel();
		locationPanel.setBackground(new Color(255, 250, 240));
		locationPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(locationPanel);
		locationPanel.setLayout(null);

		// A구역
		JLabel A = new JLabel("A");
		A.setHorizontalAlignment(SwingConstants.CENTER);
		A.setForeground(Color.DARK_GRAY);
		A.setFont(new Font("휴먼모음T", Font.BOLD, 16));
		A.setBounds(164, 10, 16, 19);
		locationPanel.add(A);

		JButton A_1 = new JButton("A-1");
		A_1.setVerticalAlignment(SwingConstants.TOP);
		A_1.setHorizontalAlignment(SwingConstants.LEFT);
		A_1.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		A_1.setBackground(new Color(255, 228, 225));
		A_1.setBounds(23, 48, 137, 65);
		locationPanel.add(A_1);

		JButton A_2 = new JButton("A-2");
		A_2.setVerticalAlignment(SwingConstants.TOP);
		A_2.setHorizontalAlignment(SwingConstants.LEFT);
		A_2.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		A_2.setBackground(new Color(255, 228, 225));
		A_2.setBounds(177, 47, 137, 65);
		locationPanel.add(A_2);

		JButton A_3 = new JButton("A-4");
		A_3.setVerticalAlignment(SwingConstants.TOP);
		A_3.setHorizontalAlignment(SwingConstants.LEFT);
		A_3.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		A_3.setBackground(new Color(255, 228, 225));
		A_3.setBounds(177, 128, 137, 65);
		locationPanel.add(A_3);

		JButton A_4 = new JButton("A-3");
		A_4.setVerticalAlignment(SwingConstants.TOP);
		A_4.setHorizontalAlignment(SwingConstants.LEFT);
		A_4.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		A_4.setBackground(new Color(255, 228, 225));
		A_4.setBounds(23, 129, 137, 65);
		locationPanel.add(A_4);

		// B구역
		JLabel B = new JLabel("B");
		B.setHorizontalAlignment(SwingConstants.CENTER);
		B.setForeground(Color.DARK_GRAY);
		B.setFont(new Font("휴먼모음T", Font.BOLD, 16));
		B.setBounds(164, 262, 16, 19);
		locationPanel.add(B);

		JButton B_1 = new JButton("B-1");
		B_1.setVerticalAlignment(SwingConstants.TOP);
		B_1.setHorizontalAlignment(SwingConstants.LEFT);
		B_1.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		B_1.setBackground(new Color(255, 235, 205));
		B_1.setBounds(23, 300, 137, 65);
		locationPanel.add(B_1);

		JButton B_2 = new JButton("B-2");
		B_2.setVerticalAlignment(SwingConstants.TOP);
		B_2.setHorizontalAlignment(SwingConstants.LEFT);
		B_2.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		B_2.setBackground(new Color(255, 235, 205));
		B_2.setBounds(177, 299, 137, 65);
		locationPanel.add(B_2);

		JButton B_3 = new JButton("B-3");
		B_3.setVerticalAlignment(SwingConstants.TOP);
		B_3.setHorizontalAlignment(SwingConstants.LEFT);
		B_3.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		B_3.setBackground(new Color(255, 235, 205));
		B_3.setBounds(23, 381, 137, 65);
		locationPanel.add(B_3);

		JButton B_4 = new JButton("B-4");
		B_4.setVerticalAlignment(SwingConstants.TOP);
		B_4.setHorizontalAlignment(SwingConstants.LEFT);
		B_4.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		B_4.setBackground(new Color(255, 235, 205));
		B_4.setBounds(177, 380, 137, 65);
		locationPanel.add(B_4);

		// 계산 화면
		JPanel paymentPanel = new JPanel();
		paymentPanel.setBackground(new Color(255, 250, 240));
		paymentPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(paymentPanel);
		paymentPanel.setLayout(null);

		// 시간 선택 :
		JLabel timeLabel = new JLabel("\uC8FC\uCC28 \uC2DC\uAC04");
		timeLabel.setForeground(Color.DARK_GRAY);
		timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		timeLabel.setBounds(33, 86, 91, 19);
		paymentPanel.add(timeLabel);

		// 시간 선택 (30분, 1시간, 1시간 30분, 2시간)
		JComboBox timeCheck = new JComboBox();
		timeCheck.setForeground(Color.WHITE);
		timeCheck.setModel(new DefaultComboBoxModel(new String[] { "시간 선택", "30분", "1시간", "1시간 30분", "2시간" }));
		timeCheck.setMaximumRowCount(4);
		timeCheck.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		timeCheck.setBackground(new Color(255, 204, 102));
		timeCheck.setBounds(163, 77, 120, 36);
		paymentPanel.add(timeCheck);

		// 금액:
		JLabel moneyLabel = new JLabel("\uACB0\uC81C \uAE08\uC561");
		moneyLabel.setForeground(Color.DARK_GRAY);
		moneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		moneyLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		moneyLabel.setBounds(83, 136, 68, 19);
		paymentPanel.add(moneyLabel);

		// 지불할 금액 출력
		JLabel printMoney = new JLabel("");
		printMoney.setForeground(Color.DARK_GRAY);
		printMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		printMoney.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		printMoney.setBounds(163, 136, 60, 19);
		paymentPanel.add(printMoney);

		// ~원
		JLabel wonLabel = new JLabel("\uC6D0");
		wonLabel.setForeground(Color.DARK_GRAY);
		wonLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		wonLabel.setBounds(224, 136, 14, 19);
		paymentPanel.add(wonLabel);

		// 낼 금액 입력:
		JLabel paymentLabel = new JLabel("\uC9C0\uBD88 \uAE08\uC561");
		paymentLabel.setForeground(Color.DARK_GRAY);
		paymentLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		paymentLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		paymentLabel.setBounds(33, 241, 91, 19);
		paymentPanel.add(paymentLabel);

		// 거스름돈:
		JLabel changeLabel = new JLabel("\uAC70\uC2A4\uB984\uB3C8");
		changeLabel.setForeground(Color.DARK_GRAY);
		changeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		changeLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		changeLabel.setBounds(87, 295, 64, 19);
		paymentPanel.add(changeLabel);

		// 거스름돈 출력
		JLabel printChange = new JLabel("");
		printChange.setForeground(Color.DARK_GRAY);
		printChange.setHorizontalAlignment(SwingConstants.RIGHT);
		printChange.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		printChange.setBounds(163, 295, 60, 19);
		paymentPanel.add(printChange);

		// ~원
		JLabel changeWonLabel = new JLabel("\uC6D0");
		changeWonLabel.setForeground(Color.DARK_GRAY);
		changeWonLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		changeWonLabel.setBounds(224, 295, 14, 19);
		paymentPanel.add(changeWonLabel);

		// 낼 금액 입력
		paymentField = new JTextField();
		paymentField.setHorizontalAlignment(SwingConstants.CENTER);
		paymentField.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		paymentField.setColumns(10);
		paymentField.setBounds(163, 233, 120, 36);
		paymentPanel.add(paymentField);

		// 다음으로 가는 버튼
		JButton btnNextPay = new JButton("NEXT");
		btnNextPay.setForeground(new Color(255, 255, 255));
		btnNextPay.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnNextPay.setBackground(new Color(255, 160, 122));
		btnNextPay.setBounds(123, 372, 97, 31);
		btnNextPay.setBorder(b1);
		paymentPanel.add(btnNextPay);

		// 결제 후 화면
		JPanel afterPanel = new JPanel();
		afterPanel.setBackground(new Color(255, 250, 240));
		afterPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(afterPanel);
		afterPanel.setLayout(null);

		// 결제가 완료되었다고 안내
		JLabel afterBookLabel = new JLabel("\uC608\uB9E4\uAC00 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		afterBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		afterBookLabel.setForeground(Color.DARK_GRAY);
		afterBookLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		afterBookLabel.setBounds(97, 41, 149, 33);
		afterPanel.add(afterBookLabel);

		JLabel afterBookLabel2 = new JLabel("\uBC8C\uAE08\uC774 \uBD80\uACFC\uB420 \uC218 \uC788\uC73C\uB2C8");
		afterBookLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		afterBookLabel2.setForeground(Color.DARK_GRAY);
		afterBookLabel2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		afterBookLabel2.setBounds(77, 87, 189, 33);
		afterPanel.add(afterBookLabel2);

		JLabel afterBookLabel3 = new JLabel(
				"\uC2DC\uAC04 \uB0B4\uC5D0 \uB3CC\uC544\uC640\uC8FC\uC2DC\uAE30 \uBC14\uB78D\uB2C8\uB2E4.");
		afterBookLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		afterBookLabel3.setForeground(Color.DARK_GRAY);
		afterBookLabel3.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		afterBookLabel3.setBounds(62, 110, 220, 33);
		afterPanel.add(afterBookLabel3);

		// 이용 종료 버튼
		JButton btnAfterEnd = new JButton("\uC774\uC6A9 \uC885\uB8CC");
		btnAfterEnd.setForeground(Color.WHITE);
		btnAfterEnd.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		btnAfterEnd.setBackground(new Color(255, 204, 102));
		btnAfterEnd.setBounds(108, 384, 128, 39);
		btnAfterEnd.setBorder(b1);
		afterPanel.add(btnAfterEnd);

		JButton btnPlusTime = new JButton("\uC2DC\uAC04 \uCD94\uAC00");
		btnPlusTime.setForeground(Color.WHITE);
		btnPlusTime.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		btnPlusTime.setBackground(new Color(255, 160, 122));
		btnPlusTime.setBounds(108, 334, 128, 39);
		btnPlusTime.setBorder(b1);
		afterPanel.add(btnPlusTime);

		// 찾기 버튼
		JButton btnFind = new JButton("\uC704\uCE58 \uCC3E\uAE30");
		btnFind.setBounds(108, 282, 128, 39);
		afterPanel.add(btnFind);
		btnFind.setForeground(new Color(255, 255, 255));
		btnFind.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		btnFind.setBackground(Color.PINK);
		btnFind.setBorder(b1);

		JLabel timerLabel = new JLabel("");
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerLabel.setForeground(Color.BLACK);
		timerLabel.setFont(new Font("휴먼모음T", Font.BOLD, 19));
		timerLabel.setBounds(108, 162, 127, 89);
		afterPanel.add(timerLabel);
		afterPanel.setVisible(false);

		// 주차 시간 초과 화면
		JPanel overPanel = new JPanel();
		overPanel.setBackground(new Color(255, 250, 240));
		overPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(overPanel);
		overPanel.setLayout(null);

		// 주차 시간이 초과되었습니다. 공지
		JLabel notice = new JLabel(
				"\uC608\uB9E4\uD55C \uC8FC\uCC28 \uC2DC\uAC04\uC744 \uACBD\uACFC\uD558\uC168\uC2B5\uB2C8\uB2E4.");
		notice.setForeground(Color.DARK_GRAY);
		notice.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		notice.setBounds(57, 71, 235, 33);
		overPanel.add(notice);

		JLabel fineNotice = new JLabel("\uBC8C\uAE08\uC740");
		fineNotice.setForeground(Color.DARK_GRAY);
		fineNotice.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		fineNotice.setBounds(82, 102, 42, 19);
		overPanel.add(fineNotice);

		// 벌금 출력
		JLabel printFine = new JLabel("");
		printFine.setForeground(Color.DARK_GRAY);
		printFine.setHorizontalAlignment(SwingConstants.RIGHT);
		printFine.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		printFine.setBounds(136, 102, 60, 19);
		overPanel.add(printFine);

		JLabel fineNotice2 = new JLabel("\uC6D0\uC785\uB2C8\uB2E4.");
		fineNotice2.setForeground(Color.DARK_GRAY);
		fineNotice2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		fineNotice2.setBounds(200, 102, 60, 19);
		overPanel.add(fineNotice2);

		// 지불할 금액:
		JLabel paymentLabel2 = new JLabel("\uC9C0\uBD88 \uAE08\uC561");
		paymentLabel2.setForeground(Color.DARK_GRAY);
		paymentLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		paymentLabel2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		paymentLabel2.setBounds(57, 210, 68, 19);
		overPanel.add(paymentLabel2);

		// 잔돈:
		JLabel changeLabel2 = new JLabel("\uAC70\uC2A4\uB984\uB3C8");
		changeLabel2.setForeground(Color.DARK_GRAY);
		changeLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		changeLabel2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		changeLabel2.setBounds(82, 259, 65, 19);
		overPanel.add(changeLabel2);

		// 잔돈 출력
		JLabel printChange2 = new JLabel("");
		printChange2.setForeground(Color.DARK_GRAY);
		printChange2.setHorizontalAlignment(SwingConstants.RIGHT);
		printChange2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		printChange2.setBounds(159, 259, 60, 19);
		overPanel.add(printChange2);

		// ~원
		JLabel changeWonLabel2 = new JLabel("\uC6D0");
		changeWonLabel2.setForeground(Color.DARK_GRAY);
		changeWonLabel2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		changeWonLabel2.setBounds(220, 259, 14, 19);
		overPanel.add(changeWonLabel2);

		// 벌금 낼 금액 입력
		paymentField2 = new JTextField();
		paymentField2.setHorizontalAlignment(SwingConstants.CENTER);
		paymentField2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		paymentField2.setColumns(10);
		paymentField2.setBounds(160, 201, 120, 36);
		overPanel.add(paymentField2);

		// 확인 버튼
		JButton fineOk = new JButton("\uD655\uC778");
		fineOk.setForeground(Color.WHITE);
		fineOk.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		fineOk.setBackground(Color.PINK);
		fineOk.setBounds(123, 371, 97, 31);
		fineOk.setBorder(b1);
		overPanel.add(fineOk);

		// 찾기 화면
		JPanel findPanel = new JPanel();
		findPanel.setBackground(new Color(255, 250, 240));
		findPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(findPanel);
		findPanel.setLayout(null);

		// 위치를 알고 싶은 사용자 이름:
		JLabel findName = new JLabel("\uC774\uB984");
		findName.setHorizontalAlignment(SwingConstants.RIGHT);
		findName.setForeground(Color.DARK_GRAY);
		findName.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		findName.setBounds(96, 151, 28, 19);
		findPanel.add(findName);

		// 사용자 이름 입력
		findNameField = new JTextField();
		findNameField.setHorizontalAlignment(SwingConstants.CENTER);
		findNameField.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		findNameField.setColumns(10);
		findNameField.setBounds(159, 142, 120, 36);
		findPanel.add(findNameField);

		// 차량 번호 입력
		findCarNumField = new JTextField();
		findCarNumField.setHorizontalAlignment(SwingConstants.CENTER);
		findCarNumField.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		findCarNumField.setColumns(10);
		findCarNumField.setBounds(159, 201, 120, 36);
		findPanel.add(findCarNumField);

		// 위치를 알고 싶은 차량 번호:
		JLabel findCarNum = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		findCarNum.setHorizontalAlignment(SwingConstants.RIGHT);
		findCarNum.setForeground(Color.DARK_GRAY);
		findCarNum.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		findCarNum.setBounds(50, 210, 74, 19);
		findPanel.add(findCarNum);

		// 찾고 싶은 ~ 공지
		JLabel findNotice = new JLabel(
				"\uC704\uCE58\uB97C \uC54C\uACE0 \uC2F6\uC740 \uCC28\uB7C9\uC758 \uBC88\uD638\uC640");
		findNotice.setHorizontalAlignment(SwingConstants.CENTER);
		findNotice.setForeground(Color.DARK_GRAY);
		findNotice.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		findNotice.setBounds(54, 51, 236, 33);
		findPanel.add(findNotice);

		JLabel findNotice2 = new JLabel(
				"\uC608\uB9E4\uD558\uC2E0 \uC0AC\uC6A9\uC790\uC758 \uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		findNotice2.setHorizontalAlignment(SwingConstants.CENTER);
		findNotice2.setForeground(Color.DARK_GRAY);
		findNotice2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		findNotice2.setBounds(40, 73, 263, 33);
		findPanel.add(findNotice2);

		// 위치:
		JLabel locationNotice = new JLabel("\uB2D8\uC758 \uCC28\uB7C9 \uC704\uCE58\uB294");
		locationNotice.setForeground(Color.DARK_GRAY);
		locationNotice.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		locationNotice.setBounds(141, 297, 114, 19);
		findPanel.add(locationNotice);

		// 위치 출력
		JLabel printLocation = new JLabel("");
		printLocation.setForeground(new Color(255, 99, 71));
		printLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		printLocation.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		printLocation.setBounds(113, 319, 60, 19);
		findPanel.add(printLocation);

		// ~입니다
		JLabel locationNotice2 = new JLabel("\uC785\uB2C8\uB2E4.");
		locationNotice2.setForeground(Color.DARK_GRAY);
		locationNotice2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		locationNotice2.setBounds(178, 319, 46, 19);
		findPanel.add(locationNotice2);

		// 이름 출력
		JLabel printFindName = new JLabel("");
		printFindName.setForeground(new Color(255, 99, 71));
		printFindName.setHorizontalAlignment(SwingConstants.RIGHT);
		printFindName.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		printFindName.setBounds(76, 297, 60, 19);
		findPanel.add(printFindName);

		// 되돌아가는 버튼
		JButton btnHome = new JButton("BACK");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnHome.setBackground(new Color(255, 182, 193));
		btnHome.setBounds(122, 396, 97, 31);
		btnHome.setBorder(b1);
		findPanel.add(btnHome);

		////////////////////////////////////
		// 첫 화면 제외 보이지 않도록 처리
		startPanel.setVisible(true);
		choicePanel.setVisible(false);
		userPanel.setVisible(false);
		locationPanel.setVisible(false);
		paymentPanel.setVisible(false);
		overPanel.setVisible(false);
		findPanel.setVisible(false);

		// 첫 시작 화면 액션
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startPanel.setVisible(false);
				choicePanel.setVisible(true);
			}
		});

		// 홈 화면 액션
		// 예매 버튼을 눌렀을 경우
		btnBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choicePanel.setVisible(false);
				// 사용자 정보를 받는 화면으로 이동
				userPanel.setVisible(true);
			}
		});
		// 찾기 버튼을 눌렀을 경우
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 화면 초기화
				findNameField.setText("");
				findCarNumField.setText("");
				printFindName.setText("");
				printLocation.setText("");

				afterPanel.setVisible(false);
				// 찾기 화면으로 이동
				findPanel.setVisible(true);
			}
		});
		// 종료 버튼을 눌렀을 경우
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프로그램 종료
				System.exit(0);
			}
		});

		// 정보 입력 창 액션
		// 사용자 정보 입력 창에서 NEXT 버튼을 눌렀을 경우
		btnNextUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 이름, 번호 비어있으면
				if ((nameField.getText().equals("")) && (carNumField.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "정보를 입력해주세요.");
				} // 차량 번호 비어있으면
				else if (carNumField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "차량 번호를 입력해주세요.");
				} // 이름 비어있으면
				else if (nameField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
				} // 정상 입력하면
				else {
					// 확인 창 띄우기
					int result = JOptionPane.showConfirmDialog(null,
							"    " + nameField.getText() + " 님, " + carNumField.getText() + " 번 "
									+ carTypeCheck.getSelectedItem().toString() + " 차량 맞으신가요?",
							"사용자 정보 확인", JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION) {
						// 입력한 정보 저장
						u1.setName(nameField.getText());
						u1.setCar_number(Integer.parseInt(carNumField.getText()));
						u1.setCar_type(carTypeCheck.getSelectedItem().toString());

						userPanel.setVisible(false);
						// 위치 선택 화면으로 이동
						locationPanel.setVisible(true);
					}

				}
			}
		});
		// 체크박스(장애인 차량 여부)
		specialCheck.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {// 이벤트 발생 시 호출
				if (e.getStateChange() == ItemEvent.SELECTED) {// 체크박스 선택시
					// 장애인 차량임
					u1.setSpecial(1);
				} else {// 선택 안 할시
					// 장애인 차량이 아님
					u1.setSpecial(0);
				}
			}
		});

		// 위치 선택 창 액션
		// 원하는 위치 버튼 클릭시 해당 위치 저장
		A_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "A-1");
			}
		});
		A_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "A-2");
			}
		});
		A_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "A-3");
			}
		});
		A_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "A-4");
			}
		});
		B_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "B-1");
			}
		});
		B_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "B-2");
			}
		});
		B_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "B-3");
			}
		});
		B_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locationAc(locationPanel, paymentPanel, "B-4");
			}
		});

		// 계산 창 액션
		// 원하는 시간 선택시
		timeCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int time = 0;
				if ((timeCheck.getSelectedItem()).equals("시간 선택")) {
					JOptionPane.showMessageDialog(null, "시간을 선택하세요.");
				} else if ((timeCheck.getSelectedItem()).equals("30분")) {
					// 금액 계산을 위함
					time = 30;
				} else if ((timeCheck.getSelectedItem()).equals("1시간")) {
					time = 60;
				} else if ((timeCheck.getSelectedItem()).equals("1시간 30분")) {
					time = 90;
				} else {
					time = 120;
				}
				// 금액 출력
				printMoney.setText(Integer.toString(c1.price(u1, time)));
			}
		});
		// 낼 금액 입력
		paymentField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 잔돈 출력
				paymentAc(c1.getPrice(), printChange, paymentField);
			}
		});
		// 결제 화면에서 NEXT 버튼을 누르면
		btnNextPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택 안 하고 넘어가려 하면
				if ((timeCheck.getSelectedItem()).equals("시간 선택")) {
					JOptionPane.showMessageDialog(null, "시간을 선택하세요.");

					// 금액 입력 창이 비어있는데 넘어가려 한다면
				} else if (paymentField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "금액을 입력하세요.");

					// 가격이 지불 금액보다 많을 경우(돈 부족)
				} else if (c1.getPrice() > Integer.parseInt(paymentField.getText())) {
					JOptionPane.showMessageDialog(null, "금액이 부족합니다. 다시 입력해주세요.");

					// 금액 입력을 정상적으로 했다면
				} else {
					if ((timeCheck.getSelectedItem()).equals("시간 선택")) {
						JOptionPane.showMessageDialog(null, "시간을 선택하세요.");
					} else if ((timeCheck.getSelectedItem()).equals("30분")) {
						// 선택한 시간이 30분일 때 CarPark time에 30 추가
						c1.plusTime(30);
					} else if ((timeCheck.getSelectedItem()).equals("1시간")) {
						c1.plusTime(60);
					} else if ((timeCheck.getSelectedItem()).equals("1시간 30분")) {
						c1.plusTime(90);
					} else {
						c1.plusTime(120);
					}

					paymentPanel.setVisible(false);
					// 예매 후 화면으로 이동
					afterPanel.setVisible(true);

					// 시간 추가 위해서 정리(화면 초기 상태로)
					paymentField.setText("");
					printMoney.setText("");
					printChange.setText("");
					timeCheck.setModel(
							new DefaultComboBoxModel(new String[] { "시간 선택", "30분", "1시간", "1시간 30분", "2시간" }));

					SwingUtilities.invokeLater(new Runnable() {// 후에 실행
						public void run() {
							// 타이머 생성, 딜레이 0.5초(원래는 1분, 60000)
							t = new Timer(500, new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e2) {
									// timerLabel에 남은 시간 출력
									timerLabel.setText(Integer.toString(c1.getTime()));
									// 카운팅
									c1.plusTime(-1);
								}
							});
							
							// 타이머 시작
							if(flag == true) {
								t.restart();
							}else {
								t.start();
							}
							
						}// end of run()
					});

				} // end of else
			}// end of actionPerformed
		});

		// 예매 후 창 액션
		// 시간 추가 버튼 클릭시
		btnPlusTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 타이머 생성, 딜레이 0.5초(원래는 1분, 60000)
				t = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e2) {
						// timerLabel에 남은 시간 출력
						timerLabel.setText(Integer.toString(c1.getTime()));
						// 카운팅
						c1.plusTime(-1);
					}
				});
				t.start();
				afterPanel.setVisible(false);
				// 결제 창으로 이동
				paymentPanel.setVisible(true);
			}
		});
		// 예매 후 화면에서의 이용 종료
		btnAfterEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 타이머 정지
				t.stop();

				if (c1.leaveCarPark().equals("over")) { // 주차 시간 오버됐을 경우
					afterPanel.setVisible(false);
					// 벌금 창 띄우기
					overPanel.setVisible(true);
					// 벌금 바로 출력
					printFine.setText(Integer.toString(c1.fine(u1)));
				} else {// 시간 내에 나갔을 경우
					//정보 초기화
					set(timerLabel);
					
					afterPanel.setVisible(false);
					// 홈 화면으로 이동
					choicePanel.setVisible(true);
				}
			}
		});

		// 벌금 창 액션
		paymentField2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 잔돈 출력
				paymentAc(c1.fine(u1), printChange2, paymentField2);
			}
		});
		// 벌금 지불 후 확인 버튼
		fineOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 금액 입력 안 했을 경우
				if (paymentField2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "금액을 입력하세요.");

				// 금액을 부족하게 입력 했을 경우
				} else if (Integer.parseInt(paymentField2.getText()) < c1.fine(u1)) {
					JOptionPane.showMessageDialog(null, "금액이 부족합니다. 다시 입력해주세요.");

				// 정상적으로 금액 지불
				} else {
					//정보 초기화
					set(timerLabel);
					
					paymentField2.setText("");
					printChange2.setText("");

					overPanel.setVisible(false);
					// 홈 화면으로 이동
					choicePanel.setVisible(true);
				}
			}
		});

		// 찾기 창 액션
		// 차량 번호 입력 후 엔터
		findCarNumField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.stop();
				// 찾을 사용자 정보를 저장하는 변수
				String name = findNameField.getText();
				int carNum = Integer.parseInt(findCarNumField.getText());

				// 이름과 차량 번호가 예매 사용자 정보와 동일하다면
				if (name.equals(u1.getName()) && carNum == u1.getCar_number()) {
					// 위치 출력
					printFindName.setText(findNameField.getText());
					printLocation.setText(c1.getLocation());
				} else { // 이름이나 차량 번호 중 하나라도 예매 사용자 정보와 불일치
					// 위치 출력 X
					JOptionPane.showMessageDialog(null, "사용자를 찾을 수 없습니다.");
					printFindName.setText("");
					printLocation.setText("");
				}
			}
		});
		// 찾기 화면에서 시간 화면으로 이동
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.restart();
				findPanel.setVisible(false);
				// 예매 후 화면으로 이동
				afterPanel.setVisible(true);
			}
		});
	}// end of initialize

	// 메서드
	// 위치 저장하는 메서드
	public void locationAc(JPanel locationPanel, JPanel paymentPanel, String location) {
		locationPanel.setVisible(false);
		paymentPanel.setVisible(true);
		c1.setLocation(location);
	}

	// 잔돈 계산 메서드
	public void paymentAc(int pay, JLabel print, JTextField payment) {
		// textField이므로 int 타입으로 변환해 money에 저장
		int money = Integer.parseInt(payment.getText());
		if (money >= pay) {
			// label에는 text만 가능하므로 잔돈을 String 타입으로 변환
			String change = Integer.toString(money - pay);
			// 잔돈 출력
			print.setText(change);
		} else {
			// 입력한 금액이 지불해야 할 금액보다 적을 경우 메세지 출력
			JOptionPane.showMessageDialog(null, "금액이 부족합니다. 다시 입력해주세요.");
		}
	}
	
	public void set(JLabel timerLabel) {
		// 초기화
		c1.setLocation("");
		c1.setPrice(0);
		c1.setTime(0);
		timerLabel.setText("");

		u1.setCar_number(0);
		u1.setName("");
		u1.setSpecial(0);

		nameField.setText("");
		carNumField.setText("");
	}
}// end of GUI