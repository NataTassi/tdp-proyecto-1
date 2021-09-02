package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/tdp.png"));
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		setLocationRelativeTo(null); 
		
		init();
		setVisible(true);
	}
	
	private void init() {
		initTabWithInformation();
		initStartDate();
		initStudentImage();
	}
	
	private void initTabWithInformation() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 250));
		
		JLabel idLabel = new JLabel("LU");
		JLabel lastNameLabel = new JLabel("Apellido");
		JLabel firstNameLabel = new JLabel("Nombre");
		JLabel mailLabel = new JLabel("E-mail");
		JLabel githubUrlLabel = new JLabel("Github URL");
		
		JTextField idTextField = new JTextField(String.valueOf(studentData.getId()));
		JTextField lastNameTextField = new JTextField(studentData.getLastName());
		JTextField firstNameTextField = new JTextField(studentData.getFirstName());
		JTextField mailTextField = new JTextField(studentData.getMail());
		JTextField githubUrlTextField = new JTextField(studentData.getGithubURL());
		
		GroupLayout informationLayout = new GroupLayout(tabInformation);
		tabInformation.setLayout(informationLayout);
		informationLayout.setAutoCreateGaps(true);
		informationLayout.setAutoCreateContainerGaps(true);
		
		informationLayout.setHorizontalGroup(informationLayout.createSequentialGroup()
			.addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(idLabel)
				.addComponent(lastNameLabel)
				.addComponent(firstNameLabel)
				.addComponent(mailLabel)
				.addComponent(githubUrlLabel)
			)
			.addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(idTextField)
				.addComponent(lastNameTextField)
				.addComponent(firstNameTextField)
				.addComponent(mailTextField)
				.addComponent(githubUrlTextField)
			)
		);
		informationLayout.setVerticalGroup(informationLayout.createSequentialGroup()
			.addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(idLabel)
				.addComponent(idTextField)
			)
			.addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lastNameLabel)
				.addComponent(lastNameTextField)
			)
			.addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(firstNameLabel)
				.addComponent(firstNameTextField)
			)
			.addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(mailLabel)
				.addComponent(mailTextField)
			)
			.addGroup(informationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(githubUrlLabel)
				.addComponent(githubUrlTextField)
			)
		);
		
		idLabel.setPreferredSize(new Dimension(125, 23));
		informationLayout.linkSize(SwingConstants.HORIZONTAL | SwingConstants.VERTICAL,
			idLabel, lastNameLabel, firstNameLabel, mailLabel, githubUrlLabel
		);
		idTextField.setPreferredSize(new Dimension(300, 23));
		informationLayout.linkSize(SwingConstants.HORIZONTAL | SwingConstants.VERTICAL,
			idTextField, lastNameTextField, firstNameTextField, mailTextField, githubUrlTextField
		);
		
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
	}
	
	private void initStartDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date dateTime = new Date();
		String date = dateFormat.format(dateTime);
		String time = timeFormat.format(dateTime);
		String initInfo = String.format("Esta ventana fue generada el %s a las: %s", date, time);
		JLabel initInfoLabel = new JLabel(initInfo);
		contentPane.add(initInfoLabel, BorderLayout.SOUTH);
	}
	
	private void initStudentImage() {
		JPanel imageContainer = new JPanel(new GridBagLayout());
		imageContainer.setPreferredSize(new Dimension(150, 250));
		try {
			BufferedImage image = ImageIO.read(getClass().getClassLoader().getResource("images/student.jpeg"));
			int imageSide = 155;
			Image scaledImage = image.getScaledInstance(imageSide, imageSide, Image.SCALE_SMOOTH);
			JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
			imageLabel.setBorder(new EmptyBorder(20, 0, 0, 30));
			imageLabel.setPreferredSize(new Dimension(imageSide, imageSide));
			imageContainer.add(imageLabel);
			contentPane.add(imageContainer, BorderLayout.EAST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
