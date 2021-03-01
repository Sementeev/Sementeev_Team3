package Lab4; //пакет Java классов

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //библиотека для события слушателя
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*; // Библиотека для GUI (построена на основе awt)

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
	static JComboBox combobox; // добавление JComboBox
	static JTextField radiusInput;
	String file_data = new String();
	public subversion() {
	final JFrame main_GUI = new JFrame("subversion");	// создание графического окна
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,400,435,450);
	main_GUI.setResizable(false); // фиксированный размер окна
	
	
	final JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	JLabel laba_info = new JLabel("Лабораторная работа №4"); // Отображение текста или изображения
	laba_info.setBounds(120,0,150,30);
	main_panel.add(laba_info);
	
	JButton button_exit = new JButton("Выход"); // добавляем кнопку
	button_exit.setBounds(270,200,120,40);
	ActionListener actionListener = new ListenerButton(); //создаем слушатель
	button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
	main_panel.add(button_exit);
	JButton button_info = new JButton("Информация"); // добавляем кнопку информация - Начало работы Разработчика 1
	button_info.setBounds(20,200,120,40);
	main_panel.add(button_info);
	button_info.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg1) {
	JOptionPane.showMessageDialog(main_panel, "Сементеев Антон Артемович \n Ильясов Максим Рустамович \n Ибрагимов Айдар Азатович  \n Сунагатов Ильгиз Рафилевич \n"  + file_data);
		}

				
	});
	JButton button_load = new JButton("Загрузить"); //добавил кнопку загрузки - Начало работы Разработчика 1      Лаба 4  
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

               // Конец работы разработчика 1        лаба 4
    
				// Конец работы разработчика 1
	JMenuBar bar = new JMenuBar(); // Создаем выпадающее меню -мНачало работы разработчика 2
	main_GUI.setJMenuBar(bar);
	JMenu menu = new JMenu("Меню");
	main_panel.add(menu); // Добавляем меню на главную панель
	bar.add(menu);
	final JMenuItem logo = new JMenuItem("Отобразить логотип УГАТУ");
	main_panel.add(logo);
	menu.add(logo); // Добавляем логотип на главную панель
	JMenuItem file_button = new JMenuItem("Загрузить файл в проект3"); // Добавляем в список элементов меню новую кнопку "Загрузить файл в проект3"
	main_panel.add(file_button);
	menu.add(file_button);

	JMenuItem exit = new JMenuItem("Выход"); // Добавляем в список элементов меню кнопку "Выход"
	main_panel.add(exit);
	menu.add(exit);
	exit.addActionListener(actionListener);

	class ListenerLogo implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {

	main_panel.add(logo); // вставляем Label на панель
	//File filepath = new File("src/main/java/Логотип УГАТУ.jpg");
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
	//String picture = filepath.getAbsolutePath();// вставляем логотип УГАТУ
	
	logo.setBounds(220,30,150,120); // задаем расположение окна и размер логотипа УГАТУ
	
	}

	}

	ActionListener logotype = new ListenerLogo(); // создаем слушатель для кнопки "Отобразить логотип УГАТУ"
	logo.addActionListener(logotype); // добавляем слушатель к кнопке "Отобразить логотип УГАТУ" - Конец работы разрабочика 2
	
	radiusInput = new JTextField(); // Начало работы разработчика 2      лаба 4
	radiusInput.setBounds(145,320,120,40);
	radiusInput.setToolTipText("Введите радиус круга");
	radiusInput.setHorizontalAlignment(JTextField.LEFT);
	main_panel.add(radiusInput);
	JLabel radius = new JLabel("Радиус"); // Отображение текста или изображения
	radius.setBounds(145,290,120,40);
	main_panel.add(radius); // Конец работы разработчика 2        лаба 4
	 
	String [] item = { // Создаем массив - Начало работы разработчика 3
			"Переместить логотип УГАТУ в верхний правый угол" , "Переместить логотип УГАТУ в середину" ,
			"Переместить логотип УГАТУ в верхний левый угол", "Отсортировать данные проект3"
			};

			class logobox implements ActionListener {

			     public void actionPerformed(ActionEvent push) {

			          if (combobox.getSelectedItem() == "Переместить логотип УГАТУ в верхний правый угол") {
			        	  logo.setBounds(200,30,150,120); // вставка Label в панель
			          }

			               if (combobox.getSelectedItem() == "Переместить логотип УГАТУ в середину") {
			               logo.setBounds(110,30,150,120);
		
			               }
			               if (combobox.getSelectedItem() == "Переместить логотип УГАТУ в верхний левый угол") {

			               logo.setBounds(20,30,150,120);
			       
			               }
			           }
			      }
			
			
			combobox = new JComboBox(item); // Присваиваем значения JComboBox
			combobox.setBounds(50,170,310,20);
			ActionListener listener = new logobox();
			combobox.addActionListener(listener);
			main_panel.add(combobox); // Добавляем JComboBox на главную панель - Конец работы разработчика 3
			
			
			JButton radios = new JButton("Расчет"); // добавляем кнопку     Начало работы разработчика 3     лаба 4
			radios.setBounds(20,320,120,40);
			main_panel.add(radios);
			radios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg1) {
					JOptionPane.showMessageDialog(main_panel, calculate()); 
				}

						
			});

		
	
	main_GUI.setVisible(true); 
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
	}
	
	public static String calculate () {
		if(radiusInput.getText().length()==0) return "Не введен радиус";
		if(!isDouble(radiusInput.getText())) return "Введено неверное значение";
		Double radios = Double.parseDouble(radiusInput.getText()); 
		if(radios<=0) return "Радиус должен быть больше 0";
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
	} // Конец работы разработчика 3        лаба 4
	
	
	public static void main(String[] args) { // интересные заметки: http://www.mstu.edu.ru/study/materials/java/
		subversion student= new subversion();
		
	}

}

