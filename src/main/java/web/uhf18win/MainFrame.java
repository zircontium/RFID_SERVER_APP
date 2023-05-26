package web.uhf18win;

import org.json.JSONObject;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.sql.Connection;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import web.UHF18.UHFReader;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private UHFReader uhf = new UHFReader();
	String[] s = {"COM1","COM2","COM3","COM4","COM5","COM6","COM7","COM8","COM9","COM10","COM11","COM12"};
	String[] bauds = {"9600bps","19200bps","38400bps","57600bps","115200bps"};
	String[] powers={"0 dBm","1 dBm","2 dBm","3 dBm","4 dBm","5 dBm","6 dBm","7 dBm","8 dBm","9 dBm",
			"10 dBm","11 dBm","12 dBm","13 dBm","14 dBm","15 dBm","16 dBm","17 dBm","18 dBm","19 dBm",
			"20 dBm","21 dBm","22 dBm","23 dBm","24 dBm","25 dBm","26 dBm","27 dBm","28 dBm","29 dBm","30 dBm"};
	private final JLabel label_4 = new JLabel();
	private int fCmdRet=0x30;
	private final JPanel panel_2 = new JPanel();
	private final JLabel label_3 = new JLabel();
	private final JComboBox comboBox = new JComboBox();
	private final JButton button = new JButton();
	private final JLabel label_6 = new JLabel();
	private final JDesktopPane desktopPane_1 = new JDesktopPane();
	private final JLabel label_1 = new JLabel();
	private final JLabel EPC_list = new JLabel();
	private final JComboBox comboBox_port = new JComboBox(s);
	private final JLabel label_5 = new JLabel();
	private final JComboBox comboBox_baud = new JComboBox(bauds);
	private final JButton bt_open = new JButton();
	private final JButton bt_close = new JButton();
	private final JLabel label_7 = new JLabel();
	private final JComboBox comboBox_power = new JComboBox(powers);
	private final JButton bt_power = new JButton();
	private final JComboBox comboBox_epc = new JComboBox();
	private final JRadioButton rb_psd = new JRadioButton();
	private final JRadioButton rb_epc = new JRadioButton();
	private final JRadioButton rb_tid = new JRadioButton();
	private final JRadioButton rb_user = new JRadioButton();
	private final ButtonGroup group=new ButtonGroup();
	private final ButtonGroup group1=new ButtonGroup();
	private final ButtonGroup group2=new ButtonGroup();
	private final JLabel addrLabel = new JLabel();
	private final JTextField text_num = new JTextField();
	private final JLabel label_8 = new JLabel();
	private final JTextField text_addr = new JTextField();
	private final JLabel label_9 = new JLabel();
	private final JTextField text_psd = new JTextField();
	private final JLabel label_10 = new JLabel();
	private final JTextField text_data = new JTextField();
	private final JButton bt_read = new JButton();
	private final JButton bt_write = new JButton();
	private final JButton bt_start = new JButton();
	private final JButton bt_stop = new JButton();
	private final JLabel label = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JTextField text_tagnum = new JTextField();
	private final DefaultListModel listmodel=new DefaultListModel();
	private final JList list = new JList(listmodel);
	private final JLabel ipLabel = new JLabel();
	private final JTextField text_ip = new JTextField();
	private final JLabel portLabel = new JLabel();
	private final JTextField text_port = new JTextField();
	private final JButton bt_con = new JButton();
	private final JButton bt_discon = new JButton();
	private final JPanel panel = new JPanel();
	private final JRadioButton rb_tcp = new JRadioButton();
	private final JRadioButton rb_com = new JRadioButton();
	private final JPanel panel_1 = new JPanel();
	private final JRadioButton rb_band1 = new JRadioButton();
	private final JRadioButton rb_band2 = new JRadioButton();
	private final JRadioButton rb_band3 = new JRadioButton();
	private final JRadioButton rb_band4 = new JRadioButton();
	private final JRadioButton rb_band5 = new JRadioButton();
	private final JButton bt_Region = new JButton();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the 
	 */
	public MainFrame() {
		setTitle("UHFReader18 Demo-Crieatazo");
		getContentPane().setLayout(null);
		setResizable(false);
		setBounds(100, 100, 754, 488);
		//setDefaultCloseOperation(JEXIT_ON_CLOSE);
		
		getContentPane().add(desktopPane_1);
		desktopPane_1.setLayout(null);
		desktopPane_1.setBounds(153, 305, 287, -228);
		
		comboBox_epc.setBounds(492, 152, 226, 30);
//		getContentPane().add(comboBox_epc);
		label_1.setBounds(23, 15, 65, 30);
		getContentPane().add(label_1);
		label_1.setText("Serial Port:");
		comboBox_port.setBounds(93, 15, 77, 30);
		getContentPane().add(comboBox_port);
		comboBox_port.setSelectedIndex(0);
		label_5.setBounds(175, 15, 65, 30);
		getContentPane().add(label_5);
		label_5.setText("Baud Rate:");
		comboBox_baud.setBounds(244, 15, 96, 30);
		getContentPane().add(comboBox_baud);
		comboBox_baud.setSelectedIndex(3);
		bt_open.setBounds(352, 15, 88, 30);
		bt_open.addActionListener(new Bt_openActionListener());
		getContentPane().add(bt_open);
		bt_open.setText("Open");
		bt_close.setBounds(446, 15, 88, 30);
		bt_close.addActionListener(new Bt_closeActionListener());
		
		getContentPane().add(bt_close);
		bt_close.setText("Close");

		EPC_list.setBounds(20, 95, 250, 30);
		getContentPane().add(EPC_list);
		EPC_list.setText("Electronic Product Code (EPC) List:");

		label_7.setBounds(20, 110, 40, 30);
//		getContentPane().add(label_7);
		label_7.setText("power:");
		
		comboBox_power.setBounds(64, 110, 72, 30);
//		getContentPane().add(comboBox_power);
		comboBox_power.setSelectedIndex(30);

		bt_power.setBounds(145, 110, 86, 30);
		bt_power.addActionListener(new Bt_powerActionListener());
//		getContentPane().add(bt_power);
		bt_power.setText("power setting");
		
		addrLabel.setBounds(395, 226, 120, 30);
//		getContentPane().add(addrLabel);
		addrLabel.setText("initial address:");
		
		text_num.setBounds(493, 276, 225, 30);
//		getContentPane().add(text_num);
		text_num.setText("04");
		
		label_8.setBounds(395, 276, 120, 30);
//		getContentPane().add(label_8);
		label_8.setText("word count:");
		
		text_addr.setBounds(493, 226, 225, 30);
//		getContentPane().add(text_addr);
		text_addr.setText("00");
		
		label_9.setBounds(395, 319, 72, 30);
	//	getContentPane().add(label_9);
		label_9.setText("access code:");
		
		text_psd.setBounds(494, 319, 224, 30);
//		getContentPane().add(text_psd);
		text_psd.setText("00000000");
		
		label_10.setBounds(395, 371, 49, 30);
//		getContentPane().add(label_10);
		label_10.setText("data:");
		
		text_data.setBounds(493, 371, 225, 30);
//		getContentPane().add(text_data);
		text_data.setText("00000000000000000000");
		
		bt_read.setBounds(492, 409, 106, 30);
		bt_read.addActionListener(new Bt_readActionListener());
//		getContentPane().add(bt_read);
		bt_read.setText("read data");
		
		bt_write.setBounds(604, 409, 114, 30);
		bt_write.addActionListener(new Bt_writeActionListener());
//		getContentPane().add(bt_write);
		bt_write.setText("write data");
		//table_epc.
		
		bt_start.setBounds(267, 392, 100, 40);
		bt_start.addActionListener(new Bt_startActionListener());
		getContentPane().add(bt_start);
		bt_start.setText("start");
		
		bt_stop.setBounds(387, 392, 100, 40);
		bt_stop.addActionListener(new Bt_stopActionListener());
		getContentPane().add(bt_stop);
		bt_stop.setText("stop");
		
		rb_epc.setBounds(470, 190, 78, 30);
//		getContentPane().add(rb_epc);
		rb_epc.setText("EPC Area");
		
		rb_tid.setBounds(553, 191, 78, 30);
//		getContentPane().add(rb_tid);
		rb_tid.setText("TID Area");
		
		rb_user.setBounds(632, 191, 86, 30);
//		getContentPane().add(rb_user);
		rb_user.setText("user area");
		
		rb_psd.setBounds(390, 190, 78, 30);
//		getContentPane().add(rb_psd);
		rb_psd.setText("reserved area");
		
//		getContentPane().add(label);
		label.setText("EPC No.:");
		label.setBounds(395, 164, 66, 18);
		
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridx = 4;
		gridBagConstraints_4.gridy = 0;
		
		label_4.setText("  ");

		panel_2.setLayout(new GridBagLayout());
		
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_8.insets = new Insets(0, 0, -10, 0);
		gridBagConstraints_8.ipady = 20;
		panel_2.add(label_3, gridBagConstraints_8);
		label_3.setText("Reader power:");
		
		panel_2.add(comboBox, new GridBagConstraints());
		
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
        gridBagConstraints_9.gridx = 4;

		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.gridy = 0;
		gridBagConstraints_10.gridx = 2;
		panel_2.add(label_6, gridBagConstraints_10);
		label_6.setText("    ");

		gridBagConstraints_9.fill = GridBagConstraints.VERTICAL;
		panel_2.add(button, gridBagConstraints_9);
		button.setText("set up");
		
		bt_discon.setEnabled(false);
		bt_discon.addActionListener(new Bt_disconActionListener());
		bt_con.setEnabled(false);
		bt_con.addActionListener(new Bt_conActionListener());
		bt_open.setEnabled(true);
		bt_close.setEnabled(false);//关闭
		bt_power.setEnabled(false);//功率
		bt_start.setEnabled(false);//开始
		bt_stop.setEnabled(false);//停止
		bt_read.setEnabled(false);//读
		bt_write.setEnabled(false);//写
		bt_Region.setEnabled(false);
		bt_Region.addActionListener(new Bt_RegionActionListener());
		rb_user.setSelected(true);
		group.add(rb_psd);
		group.add(rb_epc);
		group.add(rb_tid);
		group.add(rb_user);
		
		group1.add(rb_com);
		rb_com.setSelected(true);
		rb_com.addActionListener(new Rb_comActionListener());
		group1.add(rb_tcp);
		rb_tcp.addActionListener(new Rb_tcpActionListener());
//		getContentPane().add(label_2);
		label_2.setText("Number of sheets:");
		label_2.setBounds(37, 415, 40, 18);
		
//		getContentPane().add(text_tagnum);
		text_tagnum.setText("0");
		text_tagnum.setBounds(80, 413, 78, 22);

		getContentPane().add(list);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(100);
		list.setBounds(20, 137, 700, 234);
		
		getContentPane().add(ipLabel);
		ipLabel.setText("IP:");
		ipLabel.setBounds(23, 58, 62, 18);
		
		getContentPane().add(text_ip);
		text_ip.setText("135.7.47.28");
		text_ip.setBounds(45, 52, 125, 30);
		
		getContentPane().add(portLabel);
		portLabel.setText("Port:");
		portLabel.setBounds(175, 58, 62, 18);
		
		getContentPane().add(text_port);
		text_port.setText("6000");
		text_port.setBounds(208, 52, 133, 30);
		
		getContentPane().add(bt_con);
		bt_con.setText("open");
		bt_con.setBounds(352, 52, 88, 30);
		
		getContentPane().add(bt_discon);
		bt_discon.setText("close");
		bt_discon.setBounds(446, 52, 88, 30);
		
		//getContentPane().add(panel);
		//panel.setBounds(564, 15, 154, 36);

		getContentPane().add(rb_com);
		rb_com.setText("COM");
		rb_com.setBounds(564, 12, 54, 36);

		getContentPane().add(rb_tcp);
		rb_tcp.setText("TCP");
		rb_tcp.setBounds(564, 48, 54, 36);

		//getContentPane().add(panel_1);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setLayout(flowLayout);
		panel_1.setBounds(235, 85, 299, 65);
		
		panel_1.add(rb_band1);
		rb_band1.setText("User band");

		panel_1.add(rb_band2);
		rb_band2.setText("Chinese band2");

		panel_1.add(rb_band3);
		rb_band3.setText("US band");

		panel_1.add(rb_band4);
		rb_band4.setText("Korean band");

		panel_1.add(rb_band5);
		rb_band5.setText("EU band");
		
//		getContentPane().add(bt_Region);
		bt_Region.setText("Band settings");
		bt_Region.setBounds(545, 110, 86, 30);
		group2.add(rb_band1);
		group2.add(rb_band2);
		group2.add(rb_band3);
		group2.add(rb_band4);
		group2.add(rb_band5);
		rb_band1.setSelected(true);
	}
	
	private class Bt_openActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_open_actionPerformed(e);
		}
	}
	private class Bt_closeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_close_actionPerformed(e);
		}
	}
	
	private class Bt_powerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_power_actionPerformed(e);
		}
	}
	
	private class Bt_startActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_start_actionPerformed(e);
		}
	}
	private class Bt_stopActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_stop_actionPerformed(e);
		}
	}
	private class Bt_readActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_read_actionPerformed(e);
		}
	}
	private class Bt_writeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_write_actionPerformed(e);
		}
	}
	private class Rb_comActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rb_com_actionPerformed(e);
		}
	}
	private class Rb_tcpActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rb_tcp_actionPerformed(e);
		}
	}
	private class Bt_conActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_con_actionPerformed(e);
		}
	}
	private class Bt_disconActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_discon_actionPerformed(e);
		}
	}
	private class Bt_RegionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bt_Region_actionPerformed(e);
		}
	}
	//打开串口
	protected void bt_open_actionPerformed(ActionEvent e) {
		int ComPort=comboBox_port.getSelectedIndex()+1;
		byte ComAddr=(byte)255;
		byte baudRate=(byte)comboBox_baud.getSelectedIndex();
		if(baudRate>2)baudRate=(byte)(baudRate+2);
		fCmdRet=uhf.OpenByCom(ComPort, ComAddr, baudRate);
		if(fCmdRet==0)
		{
//			JOptionPane.showMessageDialog(null,"Connection Established\n","hint",JOptionPane.INFORMATION_MESSAGE);
			bt_close.setEnabled(true);//关闭
			bt_open.setEnabled(false);//打开
			//bt_power.setEnabled(true);//功率
			bt_start.setEnabled(true);//开始
			bt_stop.setEnabled(true);//停止
			bt_read.setEnabled(true);//读
			bt_write.setEnabled(true);//写
			bt_Region.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null,"Connection Failed\n","hint",JOptionPane.ERROR_MESSAGE);
		}
	}
	//关闭串口
	protected void bt_close_actionPerformed(ActionEvent e) {
		int FrmHandle=uhf.FrmHandle;
		fCmdRet=uhf.CloseByCom(FrmHandle);
		if(fCmdRet==0)
		{
			bt_close.setEnabled(false);//关闭
			bt_open.setEnabled(true);//打开
			//bt_power.setEnabled(false);//功率
			bt_start.setEnabled(false);//开始
			bt_stop.setEnabled(false);//停止
			bt_read.setEnabled(false);//读
			bt_write.setEnabled(false);//写
			bt_Region.setEnabled(false);
			listmodel.clear();
			comboBox_epc.removeAllItems();
			timeQyery=false;
		}
	}
	//设置功率
	protected void bt_power_actionPerformed(ActionEvent e) {
		byte power=30;
		fCmdRet = uhf.SetPower(power);
		if(fCmdRet!=0)
		{
			JOptionPane.showMessageDialog(null,"power setting failed\n","hint",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"The power setting is successful\n","hint",JOptionPane.ERROR_MESSAGE);
		}
	}
    
	public void timeVoid(){
        final Timer timer = new Timer();
        TimerTask tt=new TimerTask() { 
            @Override
            public void run() {
            	if(timeQyery)
            	{
            		if(Qyeryflag)return;
            		Qyeryflag=true;
            		Inventory();
            		Qyeryflag=false;
                    timer.cancel();
                    timeVoid();
            	}
            }
        };
        timer.schedule(tt, 200);
    }
	private void Inventory()
	{
		String[] EPC;
		EPC=uhf.Inventory();
		if(EPC != null )
		{
			
			for(int m=0;m<EPC.length;m++)
			{
				String sepc=EPC[m];
				// System.out.println(EPC[m])
				//if(!existinDB(EPC[m])){
				//addtoDB(EPC[m]))

				boolean inlist=false;
				for(int n=0;n<comboBox_epc.getItemCount();n++)
				{
					String temp=comboBox_epc.getItemAt(n).toString();
					if(temp.equals(sepc))
					{
						inlist=true;
						break;
					}
				}
				if(inlist==false)
				{
					listmodel.addElement(sepc);
					comboBox_epc.addItem(sepc);
					listmodel.addElement("loding...");
					// JOptionPane.showMessageDialog(null,"Getting VRN\n","hint",JOptionPane.INFORMATION_MESSAGE);
					try {
						DbFunctions db=new DbFunctions();
						Connection conn = db.connect_to_db("RFID_RES","postgres","root");

						var url = "https://myfastagnation.in/MTMSPG/GetTagDetails?SearchType=TagId&SearchValue=";
						var request = HttpRequest.newBuilder().GET().uri(URI.create(url+sepc)).build();
						var client = HttpClient.newBuilder().build();
						var res = client.send(request, HttpResponse.BodyHandlers.ofString());
						Object apiResponce = res.body();
						System.out.println("apires: " + apiResponce.toString());

						JSONObject object = new JSONObject(apiResponce.toString());
						String[] keys = JSONObject.getNames(object);
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();

						if (Objects.equals(object.get("ErrorMessage").toString(), "NONE")) {
							System.out.println("Valid Id");
							Object NpcDetails = object.get("npcitagDetails");
							JSONObject resObj = new JSONObject(NpcDetails.toString().substring(1, NpcDetails.toString().length()-1));
							Object vrn = resObj.get("VRN");
							String mainData = "VRN: " + vrn.toString() +" Time: " + dtf.format(now);
							listmodel.remove(1);
							listmodel.addElement(mainData);
							comboBox_epc.addItem(mainData);

							db.insert_row(conn,"Response_Table",sepc,vrn.toString(),dtf.format(now));
							JOptionPane.showMessageDialog(null,"Database Updated\n","",JOptionPane.INFORMATION_MESSAGE);
						} else {
							Object value = object.get("ErrorMessage");
							listmodel.remove(1);
							listmodel.addElement(value);
							comboBox_epc.addItem(value);
								db.insert_row(conn,"Response_Table",sepc,"NA",dtf.format(now));
								JOptionPane.showMessageDialog(null,"Error\n","",JOptionPane.INFORMATION_MESSAGE);
						}

					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}

				}

			}
			comboBox_epc.setSelectedIndex(0);
			text_tagnum.setText(String.valueOf(comboBox_epc.getItemCount()));
		}
		
	}
	private boolean timeQyery=false;//定时器执行标志
	private boolean Qyeryflag=false;//单次询查结束标志
	protected void bt_start_actionPerformed(ActionEvent e) {
		timeQyery=true;
		listmodel.clear();
		comboBox_epc.removeAllItems();
		timeVoid();
	}
	protected void bt_stop_actionPerformed(ActionEvent e) {
		timeQyery=false;
	}
	
	protected void bt_read_actionPerformed(ActionEvent e) {
		String EPC=comboBox_epc.getSelectedItem().toString();
		byte WordPtr = (byte)(0xff & Integer.parseInt(text_addr.getText(),16));
		byte Num =(byte)(0xff & Integer.parseInt(text_num.getText(),16));
		byte Mem=0;
		if(rb_psd.isSelected()){
			Mem=0;
		}
		if(rb_epc.isSelected()){
			Mem=1;
		}
		if(rb_tid.isSelected()){
			Mem=2;
		}
		if(rb_user.isSelected()){
			Mem=3;
		}
		byte[] Psd=new byte[4];
		Psd=uhf.stringToByte(text_psd.getText());
		String result=uhf.ReadData(EPC,WordPtr,Num,Mem,Psd);
		System.out.println(result);
		text_data.setText(result);
	}
	protected void bt_write_actionPerformed(ActionEvent e) {
		String EPC=comboBox_epc.getSelectedItem().toString();
		byte WordPtr = (byte)(0xff & Integer.parseInt(text_addr.getText(),16));
		byte Mem=0;
		if(rb_psd.isSelected()){
			Mem=0;
		}
		if(rb_epc.isSelected()){
			Mem=1;
		}
		if(rb_tid.isSelected()){
			Mem=2;
		}
		if(rb_user.isSelected()){
			Mem=3;
		}
		byte[] Psd=new byte[4];
		Psd=uhf.stringToByte(text_psd.getText());
        String str_data=text_data.getText();
        byte Num=(byte)(str_data.length()/4);
        byte[] Data;
        Data=uhf.stringToByte(str_data);
        fCmdRet=uhf.WriteData(EPC,WordPtr,Num,Data,Mem,Psd);
        if(fCmdRet!=0){
        	JOptionPane.showMessageDialog(null,"写数据失败","提示",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        	JOptionPane.showMessageDialog(null,"写数据成功","提示",JOptionPane.ERROR_MESSAGE);
        }
	}
	protected void rb_com_actionPerformed(ActionEvent e) {
		if(uhf.FrmHandle>1023)
			bt_discon_actionPerformed(e);
		bt_discon.setEnabled(false);
		bt_con.setEnabled(false);
		bt_open.setEnabled(true);
		bt_close.setEnabled(false);//关闭
		
	}
	protected void rb_tcp_actionPerformed(ActionEvent e) {
		if((uhf.FrmHandle>0)&&(uhf.FrmHandle<256))
			bt_close_actionPerformed(e);
		bt_discon.setEnabled(false);
		bt_con.setEnabled(true);
		bt_open.setEnabled(false);
		bt_close.setEnabled(false);//关闭
		
	}
	protected void bt_con_actionPerformed(ActionEvent e) {
        String ipaddr="";
        int Port=0;
        ipaddr = text_ip.getText().toString();
        Port = Integer.valueOf(text_port.getText());
		fCmdRet=uhf.OpenByTcp(ipaddr,Port);
		if(fCmdRet==0)
		{
			bt_discon.setEnabled(true);//关闭
			bt_con.setEnabled(false);//打开
			bt_power.setEnabled(true);//功率
			bt_start.setEnabled(true);//开始
			bt_stop.setEnabled(true);//停止
			bt_read.setEnabled(true);//读
			bt_write.setEnabled(true);//写
			bt_Region.setEnabled(true);
		}
	}
	protected void bt_discon_actionPerformed(ActionEvent e) {
		int FrmHandle=uhf.FrmHandle;
		fCmdRet=uhf.CloseByTcp(FrmHandle);
		if(fCmdRet==0)
		{
			bt_discon.setEnabled(false);//关闭
			bt_con.setEnabled(true);//打开
			bt_power.setEnabled(false);//功率
			bt_start.setEnabled(false);//开始
			bt_stop.setEnabled(false);//停止
			bt_read.setEnabled(false);//读
			bt_write.setEnabled(false);//写
			bt_Region.setEnabled(false);
			timeQyery=false;
			listmodel.clear();
			comboBox_epc.removeAllItems();
		}
	}
	protected void bt_Region_actionPerformed(ActionEvent e) {
		final byte MaxFre=(byte)0x3E;
		final byte MinFre=(byte)0x00;
//		byte MaxFre=0;
//		byte MinFre=0;
////		if(rb_band1.isSelected()){
//			MaxFre=(byte)0x3E;
//			MinFre=(byte)0x00;
//		}
//		if(rb_band2.isSelected()){
//			MaxFre=(byte)0x13;
//			MinFre=(byte)0x40;
//		}
//		if(rb_band3.isSelected()){
//			MaxFre=(byte)0x31;
//			MinFre=(byte)0x80;
//		}
//		if(rb_band4.isSelected()){
//			MaxFre=(byte)0x1F;
//			MinFre=(byte)0xC0;
//		}
//		if(rb_band5.isSelected()){
//			MaxFre=0x4E;
//			MinFre=0x00;
//		}
		fCmdRet = uhf.SetRegion(MaxFre, MinFre);
		if(fCmdRet==0)
		{
			JOptionPane.showMessageDialog(null,"successfully set","提示",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Setup failed","提示",JOptionPane.ERROR_MESSAGE);
		}
	}	


}
