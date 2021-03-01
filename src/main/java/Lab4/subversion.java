package Lab4; //����� Java �������

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //���������� ��� ������� ���������
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class subversion {
	private static final String tmpFile = null;
	static JComboBox combobox; // ���������� JComboBox
	static JTextField radiusInput;
	String file_data = new String();
	public subversion() {
	final JFrame main_GUI = new JFrame("subversion");	// �������� ������������ ����
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,400,435,450);
	main_GUI.setResizable(false); // ������������� ������ ����
	
	
	final JPanel main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	JLabel laba_info = new JLabel("������������ ������ �4"); // ����������� ������ ��� �����������
	laba_info.setBounds(120,0,150,30);
	main_panel.add(laba_info);
	
	JButton button_exit = new JButton("�����"); // ��������� ������
	button_exit.setBounds(270,200,120,40);
	ActionListener actionListener = new ListenerButton(); //������� ���������
	button_exit.addActionListener(actionListener); // ��������� ��������� � ������
	main_panel.add(button_exit);
	JButton button_info = new JButton("����������"); // ��������� ������ ���������� - ������ ������ ������������ 1
	button_info.setBounds(20,200,120,40);
	main_panel.add(button_info);
	button_info.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg1) {
	JOptionPane.showMessageDialog(main_panel, "��������� ����� ��������� \n ������� ������ ���������� \n ��������� ����� ��������  \n ��������� ������ ��������� \n"  + file_data);
		}

				
	});
	JButton button_load = new JButton("���������"); //������� ������ �������� - ������ ������ ������������ 1      ���� 4  
    button_load.setBounds(145,250,120,40);
    main_panel.add(button_load);
    button_load.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg1) {
            FileDialog fd = new FileDialog(main_GUI);
            fd.setFile("*.txt");
            fd.setVisible(true);
        final String file = fd.getFile();
        final String dir = fd.getDirectory();
        if (dir == null || file == null || file.trim().length() == 0)
        return;
        File dir1 = new File(dir, file);
        try {
                FileReader bestfile = new FileReader(dir1.getAbsolutePath());
 
                BufferedReader bufferfromReader = new BufferedReader(new InputStreamReader(new FileInputStream(dir1.getAbsolutePath()), "UTF8"));
                String line;
                while ((line = bufferfromReader.readLine()) != null) {
                    System.out.println(line);
                    file_data+=line+'\n';
                }
               
                bufferfromReader.close();
            } catch (Exception exception) {
                System.out.println("Error while reading file line by line:" + exception.getMessage());
        }
        }
    });

               // ����� ������ ������������ 1        ���� 4
    
				// ����� ������ ������������ 1
	JMenuBar bar = new JMenuBar(); // ������� ���������� ���� -������� ������ ������������ 2
	main_GUI.setJMenuBar(bar);
	JMenu menu = new JMenu("����");
	main_panel.add(menu); // ��������� ���� �� ������� ������
	bar.add(menu);
	final JMenuItem logo = new JMenuItem("���������� ������� �����");
	main_panel.add(logo);
	menu.add(logo); // ��������� ������� �� ������� ������
	JMenuItem file_button = new JMenuItem("��������� ���� � ������3"); // ��������� � ������ ��������� ���� ����� ������ "��������� ���� � ������3"
	main_panel.add(file_button);
	menu.add(file_button);

	JMenuItem exit = new JMenuItem("�����"); // ��������� � ������ ��������� ���� ������ "�����"
	main_panel.add(exit);
	menu.add(exit);
	exit.addActionListener(actionListener);

	class ListenerLogo implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {

	main_panel.add(logo); // ��������� Label �� ������
	//File filepath = new File("src/main/java/������� �����.jpg");
	try {
		BufferedImage imgBuff = ImageIO.read(new URL ("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));
		
		logo.setIcon(new ImageIcon(imgBuff.getScaledInstance(150, 80, imgBuff.SCALE_DEFAULT)));
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//String picture = filepath.getAbsolutePath();// ��������� ������� �����
	
	logo.setBounds(220,30,150,120); // ������ ������������ ���� � ������ �������� �����
	
	}

	}

	ActionListener logotype = new ListenerLogo(); // ������� ��������� ��� ������ "���������� ������� �����"
	logo.addActionListener(logotype); // ��������� ��������� � ������ "���������� ������� �����" - ����� ������ ����������� 2
	
	radiusInput = new JTextField(); // ������ ������ ������������ 2      ���� 4
	radiusInput.setBounds(145,320,120,40);
	radiusInput.setToolTipText("������� ������ �����");
	radiusInput.setHorizontalAlignment(JTextField.LEFT);
	main_panel.add(radiusInput);
	JLabel radius = new JLabel("������"); // ����������� ������ ��� �����������
	radius.setBounds(145,290,120,40);
	main_panel.add(radius); // ����� ������ ������������ 2        ���� 4
	 
	String [] item = { // ������� ������ - ������ ������ ������������ 3
			"����������� ������� ����� � ������� ������ ����" , "����������� ������� ����� � ��������" ,
			"����������� ������� ����� � ������� ����� ����", "������������� ������ ������3"
			};

			class logobox implements ActionListener {

			     public void actionPerformed(ActionEvent push) {

			          if (combobox.getSelectedItem() == "����������� ������� ����� � ������� ������ ����") {
			        	  logo.setBounds(200,30,150,120); // ������� Label � ������
			          }

			               if (combobox.getSelectedItem() == "����������� ������� ����� � ��������") {
			               logo.setBounds(110,30,150,120);
		
			               }
			               if (combobox.getSelectedItem() == "����������� ������� ����� � ������� ����� ����") {

			               logo.setBounds(20,30,150,120);
			       
			               }
			           }
			      }
			
			
			combobox = new JComboBox(item); // ����������� �������� JComboBox
			combobox.setBounds(50,170,310,20);
			ActionListener listener = new logobox();
			combobox.addActionListener(listener);
			main_panel.add(combobox); // ��������� JComboBox �� ������� ������ - ����� ������ ������������ 3
			
			
			JButton radios = new JButton("������"); // ��������� ������     ������ ������ ������������ 3     ���� 4
			radios.setBounds(20,320,120,40);
			main_panel.add(radios);
			radios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg1) {
					JOptionPane.showMessageDialog(main_panel, calculate()); 
				}

						
			});

		
	
	main_GUI.setVisible(true); 
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
	}
	
	public static String calculate () {
		if(radiusInput.getText().length()==0) return "�� ������ ������";
		if(!isDouble(radiusInput.getText())) return "������� �������� ��������";
		Double radios = Double.parseDouble(radiusInput.getText()); 
		if(radios<=0) return "������ ������ ���� ������ 0";
		 return ("S=" + Math.PI * (radios * radios));
	}
	
	public static boolean isDouble(String x) throws NumberFormatException
	{
	    try {
	        Double.parseDouble(x);
	        return true;
	    } catch(Exception e) {
	        return false;
	    }
	} // ����� ������ ������������ 3        ���� 4
	
	
	public static void main(String[] args) { // ���������� �������: http://www.mstu.edu.ru/study/materials/java/
		subversion student= new subversion();
		
	}

}

