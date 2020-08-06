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

	// ��ü ����
	User u1 = new User();
	CarPark c1 = new CarPark();

	// Ÿ�̸�
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
		// â ������ ���� �Ұ���
		frame.setResizable(false);
		// ���� �� ����� â�� ��
		frame.setLocationRelativeTo(null);
		// ���α׷� ����
		frame.setTitle("HAHA PARKING");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// ���α׷� ������ ����
		ImageIcon img = new ImageIcon("image/car.png");
		frame.setIconImage(img.getImage());

		// ��ư ������ (������ ����)
		EmptyBorder b1 = new EmptyBorder(5, 3, 5, 3);

		// ù ȭ��
		JPanel startPanel = new JPanel();
		startPanel.setBackground(new Color(255, 250, 240));
		startPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(startPanel);
		startPanel.setLayout(null);

		// ù ȭ�� �ڵ��� �̹���(���)
		JLabel carImg = new JLabel("");
		carImg.setIcon(new ImageIcon("image/carBg.png"));
		carImg.setBounds(38, 41, 256, 200);
		startPanel.add(carImg);

		// ù ȭ�� START ��ư
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

		// ����, ã��, ���� �� ���ϴ� ��� ����
		JPanel choicePanel = new JPanel();
		choicePanel.setBackground(new Color(255, 250, 240));
		choicePanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(choicePanel);
		choicePanel.setLayout(null);

		// ���� ��ư
		JButton btnBook = new JButton("\uC608\uB9E4");
		btnBook.setForeground(new Color(255, 255, 255));
		btnBook.setFont(new Font("�޸ո���T", Font.PLAIN, 17));
		btnBook.setBackground(Color.PINK);
		btnBook.setBounds(108, 166, 128, 39);
		btnBook.setBorder(b1);
		choicePanel.add(btnBook);

		// ���� ��ư
		JButton btnEnd = new JButton("\uC885\uB8CC");
		btnEnd.setForeground(new Color(255, 255, 255));
		btnEnd.setFont(new Font("�޸ո���T", Font.PLAIN, 17));
		btnEnd.setBackground(new Color(192, 192, 192));
		btnEnd.setBounds(108, 249, 128, 39);
		btnEnd.setBorder(b1);
		choicePanel.add(btnEnd);

		// ������� ������ �Է¹޴� ȭ��
		JPanel userPanel = new JPanel();
		userPanel.setBackground(new Color(255, 250, 240));
		userPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(userPanel);
		userPanel.setLayout(null);

		// �̸� :
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.DARK_GRAY);
		nameLabel.setBounds(100, 97, 28, 19);
		userPanel.add(nameLabel);
		nameLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));

		// �̸� �Է�
		nameField = new JTextField();
		nameField.setBackground(Color.WHITE);
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setBounds(163, 88, 120, 36);
		userPanel.add(nameField);
		nameField.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		nameField.setColumns(10);

		// ���� ��ȣ �Է�
		carNumField = new JTextField();
		carNumField.setBackground(Color.WHITE);
		carNumField.setHorizontalAlignment(SwingConstants.CENTER);
		carNumField.setBounds(163, 147, 120, 36);
		userPanel.add(carNumField);
		carNumField.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		carNumField.setColumns(10);

		// ���� ��ȣ:
		JLabel carNumLabel = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		carNumLabel.setForeground(Color.DARK_GRAY);
		carNumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		carNumLabel.setBounds(60, 156, 68, 19);
		userPanel.add(carNumLabel);
		carNumLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));

		// ���� ����:
		JLabel carTypeLabel = new JLabel("\uCC28\uB7C9 \uC885\uB958");
		carTypeLabel.setForeground(Color.DARK_GRAY);
		carTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		carTypeLabel.setBounds(60, 219, 68, 19);
		userPanel.add(carTypeLabel);
		carTypeLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));

		// ���� ���� ���� (����, ����, ����, ����)
		JComboBox carTypeCheck = new JComboBox();
		carTypeCheck.setForeground(new Color(255, 255, 255));
		carTypeCheck.setBounds(163, 209, 120, 36);
		userPanel.add(carTypeCheck);
		carTypeCheck.setMaximumRowCount(4);
		carTypeCheck.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		carTypeCheck.setModel(new DefaultComboBoxModel(new String[] { "����", "����", "����", "����" }));
		carTypeCheck.setBackground(new Color(255, 204, 102));
		carTypeCheck.setEditable(false);

		// ����� ���� ����:
		JLabel specialLabel = new JLabel("\uC7A5\uC560\uC778 \uCC28\uB7C9");
		specialLabel.setForeground(Color.DARK_GRAY);
		specialLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		specialLabel.setBounds(46, 277, 82, 19);
		userPanel.add(specialLabel);
		specialLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));

		// ����� ���� ���� ����(üũ�ڽ�)
		JCheckBox specialCheck = new JCheckBox("");
		specialCheck.setBounds(217, 277, 21, 21);
		userPanel.add(specialCheck);
		specialCheck.setBackground(new Color(255, 250, 240));

		// �������� �Ѿ�� ��ư
		JButton btnNextUser = new JButton("NEXT");
		btnNextUser.setForeground(new Color(255, 255, 255));
		btnNextUser.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnNextUser.setBackground(new Color(255, 160, 122));
		btnNextUser.setBounds(123, 348, 97, 31);
		btnNextUser.setBorder(b1);
		userPanel.add(btnNextUser);

		// ���� ��ġ�� �����ϴ� ȭ��
		JPanel locationPanel = new JPanel();
		locationPanel.setBackground(new Color(255, 250, 240));
		locationPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(locationPanel);
		locationPanel.setLayout(null);

		// A����
		JLabel A = new JLabel("A");
		A.setHorizontalAlignment(SwingConstants.CENTER);
		A.setForeground(Color.DARK_GRAY);
		A.setFont(new Font("�޸ո���T", Font.BOLD, 16));
		A.setBounds(164, 10, 16, 19);
		locationPanel.add(A);

		JButton A_1 = new JButton("A-1");
		A_1.setVerticalAlignment(SwingConstants.TOP);
		A_1.setHorizontalAlignment(SwingConstants.LEFT);
		A_1.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		A_1.setBackground(new Color(255, 228, 225));
		A_1.setBounds(23, 48, 137, 65);
		locationPanel.add(A_1);

		JButton A_2 = new JButton("A-2");
		A_2.setVerticalAlignment(SwingConstants.TOP);
		A_2.setHorizontalAlignment(SwingConstants.LEFT);
		A_2.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		A_2.setBackground(new Color(255, 228, 225));
		A_2.setBounds(177, 47, 137, 65);
		locationPanel.add(A_2);

		JButton A_3 = new JButton("A-4");
		A_3.setVerticalAlignment(SwingConstants.TOP);
		A_3.setHorizontalAlignment(SwingConstants.LEFT);
		A_3.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		A_3.setBackground(new Color(255, 228, 225));
		A_3.setBounds(177, 128, 137, 65);
		locationPanel.add(A_3);

		JButton A_4 = new JButton("A-3");
		A_4.setVerticalAlignment(SwingConstants.TOP);
		A_4.setHorizontalAlignment(SwingConstants.LEFT);
		A_4.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		A_4.setBackground(new Color(255, 228, 225));
		A_4.setBounds(23, 129, 137, 65);
		locationPanel.add(A_4);

		// B����
		JLabel B = new JLabel("B");
		B.setHorizontalAlignment(SwingConstants.CENTER);
		B.setForeground(Color.DARK_GRAY);
		B.setFont(new Font("�޸ո���T", Font.BOLD, 16));
		B.setBounds(164, 262, 16, 19);
		locationPanel.add(B);

		JButton B_1 = new JButton("B-1");
		B_1.setVerticalAlignment(SwingConstants.TOP);
		B_1.setHorizontalAlignment(SwingConstants.LEFT);
		B_1.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		B_1.setBackground(new Color(255, 235, 205));
		B_1.setBounds(23, 300, 137, 65);
		locationPanel.add(B_1);

		JButton B_2 = new JButton("B-2");
		B_2.setVerticalAlignment(SwingConstants.TOP);
		B_2.setHorizontalAlignment(SwingConstants.LEFT);
		B_2.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		B_2.setBackground(new Color(255, 235, 205));
		B_2.setBounds(177, 299, 137, 65);
		locationPanel.add(B_2);

		JButton B_3 = new JButton("B-3");
		B_3.setVerticalAlignment(SwingConstants.TOP);
		B_3.setHorizontalAlignment(SwingConstants.LEFT);
		B_3.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		B_3.setBackground(new Color(255, 235, 205));
		B_3.setBounds(23, 381, 137, 65);
		locationPanel.add(B_3);

		JButton B_4 = new JButton("B-4");
		B_4.setVerticalAlignment(SwingConstants.TOP);
		B_4.setHorizontalAlignment(SwingConstants.LEFT);
		B_4.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		B_4.setBackground(new Color(255, 235, 205));
		B_4.setBounds(177, 380, 137, 65);
		locationPanel.add(B_4);

		// ��� ȭ��
		JPanel paymentPanel = new JPanel();
		paymentPanel.setBackground(new Color(255, 250, 240));
		paymentPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(paymentPanel);
		paymentPanel.setLayout(null);

		// �ð� ���� :
		JLabel timeLabel = new JLabel("\uC8FC\uCC28 \uC2DC\uAC04");
		timeLabel.setForeground(Color.DARK_GRAY);
		timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		timeLabel.setBounds(33, 86, 91, 19);
		paymentPanel.add(timeLabel);

		// �ð� ���� (30��, 1�ð�, 1�ð� 30��, 2�ð�)
		JComboBox timeCheck = new JComboBox();
		timeCheck.setForeground(Color.WHITE);
		timeCheck.setModel(new DefaultComboBoxModel(new String[] { "�ð� ����", "30��", "1�ð�", "1�ð� 30��", "2�ð�" }));
		timeCheck.setMaximumRowCount(4);
		timeCheck.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		timeCheck.setBackground(new Color(255, 204, 102));
		timeCheck.setBounds(163, 77, 120, 36);
		paymentPanel.add(timeCheck);

		// �ݾ�:
		JLabel moneyLabel = new JLabel("\uACB0\uC81C \uAE08\uC561");
		moneyLabel.setForeground(Color.DARK_GRAY);
		moneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		moneyLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		moneyLabel.setBounds(83, 136, 68, 19);
		paymentPanel.add(moneyLabel);

		// ������ �ݾ� ���
		JLabel printMoney = new JLabel("");
		printMoney.setForeground(Color.DARK_GRAY);
		printMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		printMoney.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		printMoney.setBounds(163, 136, 60, 19);
		paymentPanel.add(printMoney);

		// ~��
		JLabel wonLabel = new JLabel("\uC6D0");
		wonLabel.setForeground(Color.DARK_GRAY);
		wonLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		wonLabel.setBounds(224, 136, 14, 19);
		paymentPanel.add(wonLabel);

		// �� �ݾ� �Է�:
		JLabel paymentLabel = new JLabel("\uC9C0\uBD88 \uAE08\uC561");
		paymentLabel.setForeground(Color.DARK_GRAY);
		paymentLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		paymentLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		paymentLabel.setBounds(33, 241, 91, 19);
		paymentPanel.add(paymentLabel);

		// �Ž�����:
		JLabel changeLabel = new JLabel("\uAC70\uC2A4\uB984\uB3C8");
		changeLabel.setForeground(Color.DARK_GRAY);
		changeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		changeLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		changeLabel.setBounds(87, 295, 64, 19);
		paymentPanel.add(changeLabel);

		// �Ž����� ���
		JLabel printChange = new JLabel("");
		printChange.setForeground(Color.DARK_GRAY);
		printChange.setHorizontalAlignment(SwingConstants.RIGHT);
		printChange.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		printChange.setBounds(163, 295, 60, 19);
		paymentPanel.add(printChange);

		// ~��
		JLabel changeWonLabel = new JLabel("\uC6D0");
		changeWonLabel.setForeground(Color.DARK_GRAY);
		changeWonLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		changeWonLabel.setBounds(224, 295, 14, 19);
		paymentPanel.add(changeWonLabel);

		// �� �ݾ� �Է�
		paymentField = new JTextField();
		paymentField.setHorizontalAlignment(SwingConstants.CENTER);
		paymentField.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		paymentField.setColumns(10);
		paymentField.setBounds(163, 233, 120, 36);
		paymentPanel.add(paymentField);

		// �������� ���� ��ư
		JButton btnNextPay = new JButton("NEXT");
		btnNextPay.setForeground(new Color(255, 255, 255));
		btnNextPay.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnNextPay.setBackground(new Color(255, 160, 122));
		btnNextPay.setBounds(123, 372, 97, 31);
		btnNextPay.setBorder(b1);
		paymentPanel.add(btnNextPay);

		// ���� �� ȭ��
		JPanel afterPanel = new JPanel();
		afterPanel.setBackground(new Color(255, 250, 240));
		afterPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(afterPanel);
		afterPanel.setLayout(null);

		// ������ �Ϸ�Ǿ��ٰ� �ȳ�
		JLabel afterBookLabel = new JLabel("\uC608\uB9E4\uAC00 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		afterBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		afterBookLabel.setForeground(Color.DARK_GRAY);
		afterBookLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		afterBookLabel.setBounds(97, 41, 149, 33);
		afterPanel.add(afterBookLabel);

		JLabel afterBookLabel2 = new JLabel("\uBC8C\uAE08\uC774 \uBD80\uACFC\uB420 \uC218 \uC788\uC73C\uB2C8");
		afterBookLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		afterBookLabel2.setForeground(Color.DARK_GRAY);
		afterBookLabel2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		afterBookLabel2.setBounds(77, 87, 189, 33);
		afterPanel.add(afterBookLabel2);

		JLabel afterBookLabel3 = new JLabel(
				"\uC2DC\uAC04 \uB0B4\uC5D0 \uB3CC\uC544\uC640\uC8FC\uC2DC\uAE30 \uBC14\uB78D\uB2C8\uB2E4.");
		afterBookLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		afterBookLabel3.setForeground(Color.DARK_GRAY);
		afterBookLabel3.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		afterBookLabel3.setBounds(62, 110, 220, 33);
		afterPanel.add(afterBookLabel3);

		// �̿� ���� ��ư
		JButton btnAfterEnd = new JButton("\uC774\uC6A9 \uC885\uB8CC");
		btnAfterEnd.setForeground(Color.WHITE);
		btnAfterEnd.setFont(new Font("�޸ո���T", Font.PLAIN, 17));
		btnAfterEnd.setBackground(new Color(255, 204, 102));
		btnAfterEnd.setBounds(108, 384, 128, 39);
		btnAfterEnd.setBorder(b1);
		afterPanel.add(btnAfterEnd);

		JButton btnPlusTime = new JButton("\uC2DC\uAC04 \uCD94\uAC00");
		btnPlusTime.setForeground(Color.WHITE);
		btnPlusTime.setFont(new Font("�޸ո���T", Font.PLAIN, 17));
		btnPlusTime.setBackground(new Color(255, 160, 122));
		btnPlusTime.setBounds(108, 334, 128, 39);
		btnPlusTime.setBorder(b1);
		afterPanel.add(btnPlusTime);

		// ã�� ��ư
		JButton btnFind = new JButton("\uC704\uCE58 \uCC3E\uAE30");
		btnFind.setBounds(108, 282, 128, 39);
		afterPanel.add(btnFind);
		btnFind.setForeground(new Color(255, 255, 255));
		btnFind.setFont(new Font("�޸ո���T", Font.PLAIN, 17));
		btnFind.setBackground(Color.PINK);
		btnFind.setBorder(b1);

		JLabel timerLabel = new JLabel("");
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerLabel.setForeground(Color.BLACK);
		timerLabel.setFont(new Font("�޸ո���T", Font.BOLD, 19));
		timerLabel.setBounds(108, 162, 127, 89);
		afterPanel.add(timerLabel);
		afterPanel.setVisible(false);

		// ���� �ð� �ʰ� ȭ��
		JPanel overPanel = new JPanel();
		overPanel.setBackground(new Color(255, 250, 240));
		overPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(overPanel);
		overPanel.setLayout(null);

		// ���� �ð��� �ʰ��Ǿ����ϴ�. ����
		JLabel notice = new JLabel(
				"\uC608\uB9E4\uD55C \uC8FC\uCC28 \uC2DC\uAC04\uC744 \uACBD\uACFC\uD558\uC168\uC2B5\uB2C8\uB2E4.");
		notice.setForeground(Color.DARK_GRAY);
		notice.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		notice.setBounds(57, 71, 235, 33);
		overPanel.add(notice);

		JLabel fineNotice = new JLabel("\uBC8C\uAE08\uC740");
		fineNotice.setForeground(Color.DARK_GRAY);
		fineNotice.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		fineNotice.setBounds(82, 102, 42, 19);
		overPanel.add(fineNotice);

		// ���� ���
		JLabel printFine = new JLabel("");
		printFine.setForeground(Color.DARK_GRAY);
		printFine.setHorizontalAlignment(SwingConstants.RIGHT);
		printFine.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		printFine.setBounds(136, 102, 60, 19);
		overPanel.add(printFine);

		JLabel fineNotice2 = new JLabel("\uC6D0\uC785\uB2C8\uB2E4.");
		fineNotice2.setForeground(Color.DARK_GRAY);
		fineNotice2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		fineNotice2.setBounds(200, 102, 60, 19);
		overPanel.add(fineNotice2);

		// ������ �ݾ�:
		JLabel paymentLabel2 = new JLabel("\uC9C0\uBD88 \uAE08\uC561");
		paymentLabel2.setForeground(Color.DARK_GRAY);
		paymentLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		paymentLabel2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		paymentLabel2.setBounds(57, 210, 68, 19);
		overPanel.add(paymentLabel2);

		// �ܵ�:
		JLabel changeLabel2 = new JLabel("\uAC70\uC2A4\uB984\uB3C8");
		changeLabel2.setForeground(Color.DARK_GRAY);
		changeLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		changeLabel2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		changeLabel2.setBounds(82, 259, 65, 19);
		overPanel.add(changeLabel2);

		// �ܵ� ���
		JLabel printChange2 = new JLabel("");
		printChange2.setForeground(Color.DARK_GRAY);
		printChange2.setHorizontalAlignment(SwingConstants.RIGHT);
		printChange2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		printChange2.setBounds(159, 259, 60, 19);
		overPanel.add(printChange2);

		// ~��
		JLabel changeWonLabel2 = new JLabel("\uC6D0");
		changeWonLabel2.setForeground(Color.DARK_GRAY);
		changeWonLabel2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		changeWonLabel2.setBounds(220, 259, 14, 19);
		overPanel.add(changeWonLabel2);

		// ���� �� �ݾ� �Է�
		paymentField2 = new JTextField();
		paymentField2.setHorizontalAlignment(SwingConstants.CENTER);
		paymentField2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		paymentField2.setColumns(10);
		paymentField2.setBounds(160, 201, 120, 36);
		overPanel.add(paymentField2);

		// Ȯ�� ��ư
		JButton fineOk = new JButton("\uD655\uC778");
		fineOk.setForeground(Color.WHITE);
		fineOk.setFont(new Font("�޸ո���T", Font.PLAIN, 17));
		fineOk.setBackground(Color.PINK);
		fineOk.setBounds(123, 371, 97, 31);
		fineOk.setBorder(b1);
		overPanel.add(fineOk);

		// ã�� ȭ��
		JPanel findPanel = new JPanel();
		findPanel.setBackground(new Color(255, 250, 240));
		findPanel.setBounds(0, 0, 344, 471);
		frame.getContentPane().add(findPanel);
		findPanel.setLayout(null);

		// ��ġ�� �˰� ���� ����� �̸�:
		JLabel findName = new JLabel("\uC774\uB984");
		findName.setHorizontalAlignment(SwingConstants.RIGHT);
		findName.setForeground(Color.DARK_GRAY);
		findName.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		findName.setBounds(96, 151, 28, 19);
		findPanel.add(findName);

		// ����� �̸� �Է�
		findNameField = new JTextField();
		findNameField.setHorizontalAlignment(SwingConstants.CENTER);
		findNameField.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		findNameField.setColumns(10);
		findNameField.setBounds(159, 142, 120, 36);
		findPanel.add(findNameField);

		// ���� ��ȣ �Է�
		findCarNumField = new JTextField();
		findCarNumField.setHorizontalAlignment(SwingConstants.CENTER);
		findCarNumField.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		findCarNumField.setColumns(10);
		findCarNumField.setBounds(159, 201, 120, 36);
		findPanel.add(findCarNumField);

		// ��ġ�� �˰� ���� ���� ��ȣ:
		JLabel findCarNum = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		findCarNum.setHorizontalAlignment(SwingConstants.RIGHT);
		findCarNum.setForeground(Color.DARK_GRAY);
		findCarNum.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		findCarNum.setBounds(50, 210, 74, 19);
		findPanel.add(findCarNum);

		// ã�� ���� ~ ����
		JLabel findNotice = new JLabel(
				"\uC704\uCE58\uB97C \uC54C\uACE0 \uC2F6\uC740 \uCC28\uB7C9\uC758 \uBC88\uD638\uC640");
		findNotice.setHorizontalAlignment(SwingConstants.CENTER);
		findNotice.setForeground(Color.DARK_GRAY);
		findNotice.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		findNotice.setBounds(54, 51, 236, 33);
		findPanel.add(findNotice);

		JLabel findNotice2 = new JLabel(
				"\uC608\uB9E4\uD558\uC2E0 \uC0AC\uC6A9\uC790\uC758 \uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		findNotice2.setHorizontalAlignment(SwingConstants.CENTER);
		findNotice2.setForeground(Color.DARK_GRAY);
		findNotice2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		findNotice2.setBounds(40, 73, 263, 33);
		findPanel.add(findNotice2);

		// ��ġ:
		JLabel locationNotice = new JLabel("\uB2D8\uC758 \uCC28\uB7C9 \uC704\uCE58\uB294");
		locationNotice.setForeground(Color.DARK_GRAY);
		locationNotice.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		locationNotice.setBounds(141, 297, 114, 19);
		findPanel.add(locationNotice);

		// ��ġ ���
		JLabel printLocation = new JLabel("");
		printLocation.setForeground(new Color(255, 99, 71));
		printLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		printLocation.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		printLocation.setBounds(113, 319, 60, 19);
		findPanel.add(printLocation);

		// ~�Դϴ�
		JLabel locationNotice2 = new JLabel("\uC785\uB2C8\uB2E4.");
		locationNotice2.setForeground(Color.DARK_GRAY);
		locationNotice2.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		locationNotice2.setBounds(178, 319, 46, 19);
		findPanel.add(locationNotice2);

		// �̸� ���
		JLabel printFindName = new JLabel("");
		printFindName.setForeground(new Color(255, 99, 71));
		printFindName.setHorizontalAlignment(SwingConstants.RIGHT);
		printFindName.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		printFindName.setBounds(76, 297, 60, 19);
		findPanel.add(printFindName);

		// �ǵ��ư��� ��ư
		JButton btnHome = new JButton("BACK");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnHome.setBackground(new Color(255, 182, 193));
		btnHome.setBounds(122, 396, 97, 31);
		btnHome.setBorder(b1);
		findPanel.add(btnHome);

		////////////////////////////////////
		// ù ȭ�� ���� ������ �ʵ��� ó��
		startPanel.setVisible(true);
		choicePanel.setVisible(false);
		userPanel.setVisible(false);
		locationPanel.setVisible(false);
		paymentPanel.setVisible(false);
		overPanel.setVisible(false);
		findPanel.setVisible(false);

		// ù ���� ȭ�� �׼�
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startPanel.setVisible(false);
				choicePanel.setVisible(true);
			}
		});

		// Ȩ ȭ�� �׼�
		// ���� ��ư�� ������ ���
		btnBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choicePanel.setVisible(false);
				// ����� ������ �޴� ȭ������ �̵�
				userPanel.setVisible(true);
			}
		});
		// ã�� ��ư�� ������ ���
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ȭ�� �ʱ�ȭ
				findNameField.setText("");
				findCarNumField.setText("");
				printFindName.setText("");
				printLocation.setText("");

				afterPanel.setVisible(false);
				// ã�� ȭ������ �̵�
				findPanel.setVisible(true);
			}
		});
		// ���� ��ư�� ������ ���
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���α׷� ����
				System.exit(0);
			}
		});

		// ���� �Է� â �׼�
		// ����� ���� �Է� â���� NEXT ��ư�� ������ ���
		btnNextUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �̸�, ��ȣ ���������
				if ((nameField.getText().equals("")) && (carNumField.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.");
				} // ���� ��ȣ ���������
				else if (carNumField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���� ��ȣ�� �Է����ּ���.");
				} // �̸� ���������
				else if (nameField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���.");
				} // ���� �Է��ϸ�
				else {
					// Ȯ�� â ����
					int result = JOptionPane.showConfirmDialog(null,
							"    " + nameField.getText() + " ��, " + carNumField.getText() + " �� "
									+ carTypeCheck.getSelectedItem().toString() + " ���� �����Ű���?",
							"����� ���� Ȯ��", JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION) {
						// �Է��� ���� ����
						u1.setName(nameField.getText());
						u1.setCar_number(Integer.parseInt(carNumField.getText()));
						u1.setCar_type(carTypeCheck.getSelectedItem().toString());

						userPanel.setVisible(false);
						// ��ġ ���� ȭ������ �̵�
						locationPanel.setVisible(true);
					}

				}
			}
		});
		// üũ�ڽ�(����� ���� ����)
		specialCheck.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {// �̺�Ʈ �߻� �� ȣ��
				if (e.getStateChange() == ItemEvent.SELECTED) {// üũ�ڽ� ���ý�
					// ����� ������
					u1.setSpecial(1);
				} else {// ���� �� �ҽ�
					// ����� ������ �ƴ�
					u1.setSpecial(0);
				}
			}
		});

		// ��ġ ���� â �׼�
		// ���ϴ� ��ġ ��ư Ŭ���� �ش� ��ġ ����
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

		// ��� â �׼�
		// ���ϴ� �ð� ���ý�
		timeCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int time = 0;
				if ((timeCheck.getSelectedItem()).equals("�ð� ����")) {
					JOptionPane.showMessageDialog(null, "�ð��� �����ϼ���.");
				} else if ((timeCheck.getSelectedItem()).equals("30��")) {
					// �ݾ� ����� ����
					time = 30;
				} else if ((timeCheck.getSelectedItem()).equals("1�ð�")) {
					time = 60;
				} else if ((timeCheck.getSelectedItem()).equals("1�ð� 30��")) {
					time = 90;
				} else {
					time = 120;
				}
				// �ݾ� ���
				printMoney.setText(Integer.toString(c1.price(u1, time)));
			}
		});
		// �� �ݾ� �Է�
		paymentField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ܵ� ���
				paymentAc(c1.getPrice(), printChange, paymentField);
			}
		});
		// ���� ȭ�鿡�� NEXT ��ư�� ������
		btnNextPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���� �� �ϰ� �Ѿ�� �ϸ�
				if ((timeCheck.getSelectedItem()).equals("�ð� ����")) {
					JOptionPane.showMessageDialog(null, "�ð��� �����ϼ���.");

					// �ݾ� �Է� â�� ����ִµ� �Ѿ�� �Ѵٸ�
				} else if (paymentField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�ݾ��� �Է��ϼ���.");

					// ������ ���� �ݾ׺��� ���� ���(�� ����)
				} else if (c1.getPrice() > Integer.parseInt(paymentField.getText())) {
					JOptionPane.showMessageDialog(null, "�ݾ��� �����մϴ�. �ٽ� �Է����ּ���.");

					// �ݾ� �Է��� ���������� �ߴٸ�
				} else {
					if ((timeCheck.getSelectedItem()).equals("�ð� ����")) {
						JOptionPane.showMessageDialog(null, "�ð��� �����ϼ���.");
					} else if ((timeCheck.getSelectedItem()).equals("30��")) {
						// ������ �ð��� 30���� �� CarPark time�� 30 �߰�
						c1.plusTime(30);
					} else if ((timeCheck.getSelectedItem()).equals("1�ð�")) {
						c1.plusTime(60);
					} else if ((timeCheck.getSelectedItem()).equals("1�ð� 30��")) {
						c1.plusTime(90);
					} else {
						c1.plusTime(120);
					}

					paymentPanel.setVisible(false);
					// ���� �� ȭ������ �̵�
					afterPanel.setVisible(true);

					// �ð� �߰� ���ؼ� ����(ȭ�� �ʱ� ���·�)
					paymentField.setText("");
					printMoney.setText("");
					printChange.setText("");
					timeCheck.setModel(
							new DefaultComboBoxModel(new String[] { "�ð� ����", "30��", "1�ð�", "1�ð� 30��", "2�ð�" }));

					SwingUtilities.invokeLater(new Runnable() {// �Ŀ� ����
						public void run() {
							// Ÿ�̸� ����, ������ 0.5��(������ 1��, 60000)
							t = new Timer(500, new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e2) {
									// timerLabel�� ���� �ð� ���
									timerLabel.setText(Integer.toString(c1.getTime()));
									// ī����
									c1.plusTime(-1);
								}
							});
							
							// Ÿ�̸� ����
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

		// ���� �� â �׼�
		// �ð� �߰� ��ư Ŭ����
		btnPlusTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ÿ�̸� ����, ������ 0.5��(������ 1��, 60000)
				t = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e2) {
						// timerLabel�� ���� �ð� ���
						timerLabel.setText(Integer.toString(c1.getTime()));
						// ī����
						c1.plusTime(-1);
					}
				});
				t.start();
				afterPanel.setVisible(false);
				// ���� â���� �̵�
				paymentPanel.setVisible(true);
			}
		});
		// ���� �� ȭ�鿡���� �̿� ����
		btnAfterEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ÿ�̸� ����
				t.stop();

				if (c1.leaveCarPark().equals("over")) { // ���� �ð� �������� ���
					afterPanel.setVisible(false);
					// ���� â ����
					overPanel.setVisible(true);
					// ���� �ٷ� ���
					printFine.setText(Integer.toString(c1.fine(u1)));
				} else {// �ð� ���� ������ ���
					//���� �ʱ�ȭ
					set(timerLabel);
					
					afterPanel.setVisible(false);
					// Ȩ ȭ������ �̵�
					choicePanel.setVisible(true);
				}
			}
		});

		// ���� â �׼�
		paymentField2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ܵ� ���
				paymentAc(c1.fine(u1), printChange2, paymentField2);
			}
		});
		// ���� ���� �� Ȯ�� ��ư
		fineOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ݾ� �Է� �� ���� ���
				if (paymentField2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�ݾ��� �Է��ϼ���.");

				// �ݾ��� �����ϰ� �Է� ���� ���
				} else if (Integer.parseInt(paymentField2.getText()) < c1.fine(u1)) {
					JOptionPane.showMessageDialog(null, "�ݾ��� �����մϴ�. �ٽ� �Է����ּ���.");

				// ���������� �ݾ� ����
				} else {
					//���� �ʱ�ȭ
					set(timerLabel);
					
					paymentField2.setText("");
					printChange2.setText("");

					overPanel.setVisible(false);
					// Ȩ ȭ������ �̵�
					choicePanel.setVisible(true);
				}
			}
		});

		// ã�� â �׼�
		// ���� ��ȣ �Է� �� ����
		findCarNumField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.stop();
				// ã�� ����� ������ �����ϴ� ����
				String name = findNameField.getText();
				int carNum = Integer.parseInt(findCarNumField.getText());

				// �̸��� ���� ��ȣ�� ���� ����� ������ �����ϴٸ�
				if (name.equals(u1.getName()) && carNum == u1.getCar_number()) {
					// ��ġ ���
					printFindName.setText(findNameField.getText());
					printLocation.setText(c1.getLocation());
				} else { // �̸��̳� ���� ��ȣ �� �ϳ��� ���� ����� ������ ����ġ
					// ��ġ ��� X
					JOptionPane.showMessageDialog(null, "����ڸ� ã�� �� �����ϴ�.");
					printFindName.setText("");
					printLocation.setText("");
				}
			}
		});
		// ã�� ȭ�鿡�� �ð� ȭ������ �̵�
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.restart();
				findPanel.setVisible(false);
				// ���� �� ȭ������ �̵�
				afterPanel.setVisible(true);
			}
		});
	}// end of initialize

	// �޼���
	// ��ġ �����ϴ� �޼���
	public void locationAc(JPanel locationPanel, JPanel paymentPanel, String location) {
		locationPanel.setVisible(false);
		paymentPanel.setVisible(true);
		c1.setLocation(location);
	}

	// �ܵ� ��� �޼���
	public void paymentAc(int pay, JLabel print, JTextField payment) {
		// textField�̹Ƿ� int Ÿ������ ��ȯ�� money�� ����
		int money = Integer.parseInt(payment.getText());
		if (money >= pay) {
			// label���� text�� �����ϹǷ� �ܵ��� String Ÿ������ ��ȯ
			String change = Integer.toString(money - pay);
			// �ܵ� ���
			print.setText(change);
		} else {
			// �Է��� �ݾ��� �����ؾ� �� �ݾ׺��� ���� ��� �޼��� ���
			JOptionPane.showMessageDialog(null, "�ݾ��� �����մϴ�. �ٽ� �Է����ּ���.");
		}
	}
	
	public void set(JLabel timerLabel) {
		// �ʱ�ȭ
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