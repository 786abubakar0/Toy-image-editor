import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class image_circle implements ActionListener {
	static JFileChooser fc2,fc;
	static JFrame f=new JFrame();
	static JFrame f2=new JFrame();
	static File file=null;
	static File file2=null;
	
	static editimage o;
	static JButton save,reset,b2,b3,b4,b5,b6,b7,b8,b9,rapply,rback,bapply,bback,brapply,brback,mapply,mback;
	static JPanel sidebar,below,image,resize,border,bright,mix,filechooser1;
	static JSlider bslider;
	
	static JLabel imagelabel,l1,l2,l3,l4,l5,location,imagetype;
	static ImageIcon img;
	static int width,height;
	
	static JComboBox cb1,cb2,filetype;
	
	static Color[] colorarray= {Color.BLACK,Color.BLUE,Color.GRAY,Color.GREEN,Color.ORANGE,Color.WHITE,Color.YELLOW};
	
	static JTextField t1,t2,t3;
	static String directoryname;
	
	
public static void main(String[] args) 
{
	
	
	JPanel panelarray[]=new JPanel[15];
	JButton buttonarray[]=new JButton[20];
	JLabel labelarray[]=new JLabel[20];
	
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 width = (int)screenSize.getWidth();
	 height = (int)screenSize.getHeight();
	
	
	
	
	
	
	
	//filechooser
			
        	
		    fc=new JFileChooser();
		    //fc.setBounds(0,0,width-100,height-100);
		    fc.setVisible(true);
			f.add(fc);
			
			
			
			 fc.addActionListener(new ActionListener()
			    {
			        public void actionPerformed(ActionEvent arg0)
			        {
			        	 
			        	
			        	filechooser1=new JPanel();
			        	filechooser1.setLayout(null);
			        	filechooser1.setBounds(0, 0, width, height);
			        	fc2=new JFileChooser();
			        	fc2.setBounds(0, 0, width-100, height-100);
			        	filechooser1.add(fc2);
			        	fc2.addActionListener(new ActionListener()
					    {
					        public void actionPerformed(ActionEvent arg0)
					        {
					        	try {
					        		File secondfile=fc2.getSelectedFile();
					        		filechooser1.setVisible(false);
					        		image.setVisible(true);
					        		sidebar.setVisible(true);
					        		below.setVisible(true);
						        	o.combine(secondfile);
						        	apply();
						        	
					        	}
					        	catch(Exception e)
					        	{
					        		JOptionPane.showMessageDialog(null, "Choose image file");
					        		image.setVisible(false);
					        		sidebar.setVisible(false);
					        		below.setVisible(false);
					        		filechooser1.setVisible(true);
					        	}
					        
					     }
					    });
			        	
			        	file=fc.getSelectedFile();
			        	fc.setVisible(false);

			        	 image=createpanel(width/4 + 10,0,width-(width/4 + 10),height-(210),true);
			        	 sidebar=createpanel(0,0,width/4,height-210,true);
			        	 below=createpanel(0,height-200,width,200,true);
			        	 
			        	
			        	
			        	image_circle bu=new image_circle();
			        	
			        	 b2=bu.createbutton(50,10,300,50,true,"1-grayscale",sidebar);
			        	 b3=bu.createbutton(50,70,300,50,true,"2-resize",sidebar);
			        	 b4=bu.createbutton(50,130,300,50,true,"3-rotateclockwise",sidebar);
			        	 b5=bu.createbutton(50,190,300,50,true,"4-rotatecounterclockwise",sidebar);
			        	 b6=bu.createbutton(50,250,300,50,true,"5-border",sidebar);
			        	 b7=bu.createbutton(50,310,300,50,true,"6-bright",sidebar);
			        	 b8=bu.createbutton(50,370,300,50,true,"7-mixcolor",sidebar);
			        	 b9=bu.createbutton(50,430,300,50,true,"8-combine",sidebar);
			        	
			        	
			        	 imagelabel=createlabel(width/4 + 10,0,width-(width/4 + 10),height-(210),true,"",image);
			        	
			        	try
			        	{
			        		o=new editimage(file);
			        	}
			        	catch(Exception error)
			        	{
			        		JOptionPane.showMessageDialog(null, "Choose image file");
			        		image.setVisible(false);
			        		sidebar.setVisible(false);
			        		below.setVisible(false);
			        		fc.setVisible(true);
			        	}
			        	
			        	try {
			        		
			        		img=new ImageIcon(editimage.read);
			        	}
			        	catch(Exception e)
			        	{
			        		JOptionPane.showMessageDialog(null, "Choose image file");
			        		image.setVisible(false);
			        		sidebar.setVisible(false);
			        		below.setVisible(false);
			        		fc.setVisible(true);
			        	}
			        	image.setLayout(new FlowLayout());
			        	imagelabel=new JLabel(img);
			        	image.add(imagelabel);
			        	
			        	
			        	save=bu.createbutton(width-200,50,75,25,true,"Save",below);
			        	reset=bu.createbutton(width-300,50,75,25,true,"Reset",below);
			        			
			        	
			        	resize=createpanel(0,0,width/4,height-210,false);
			        	border=createpanel(0,0,width/4,height-210,false);
			        	bright=createpanel(0,0,width/4,height-210,false);
			        	mix=createpanel(0,0,width/4,height-210,false);
			        	
			        	
			        	
			    		
			    		
			    		l1=new JLabel("Width");
			    		l1.setBounds(10,100,50,50);
			    		l1.setForeground(Color.WHITE);
			    		resize.add(l1);
			    		
			    		l2=new JLabel("Height");
			    		l2.setBounds(10,160,50,50);
			    		l2.setForeground(Color.WHITE);
			    		resize.add(l2);
			    		
			    		l3=new JLabel("Color");
			    		l3.setBounds(10,100,50,50);
			    		l3.setForeground(Color.WHITE);
			    		border.add(l3);
			    		
			    		l4=new JLabel("Brightness");
			    		l4.setBounds(10,100,100,50);
			    		l4.setForeground(Color.WHITE);
			    		bright.add(l4);
			    		
			    		l5=new JLabel("Choose Type");
			    		l5.setBounds(10,100,100,50);
			    		l5.setForeground(Color.WHITE);
			    		mix.add(l5);
			    		
			    		location=new JLabel("File name");
			    		location.setBounds(100,20,60,25);
			    		location.setForeground(Color.WHITE);
			    		below.add(location);
			    		
			    		imagetype=new JLabel("Image type");
			    		imagetype.setBounds(100,50,100,25);
			    		imagetype.setForeground(Color.WHITE);
			    		below.add(imagetype);
			    		
			    		String bordercolor[]= {"Black","Blue","Gray","Green","Orange","White","Yellow"};
			    		cb1=new JComboBox(bordercolor);
			    		cb1.setBounds(60,100,300,50);
			    		border.add(cb1);
			    		
			    		String mixtype[]= {"1-rgb","2-rbg","3-grb","4-gbr","5-brg","6-bgr"};
			    		cb2=new JComboBox(mixtype);
			    		cb2.setBounds(60,150,300,50);
			    		mix.add(cb2);
			    		
			    		String types[]= {"jpg","png"};
			    		filetype=new JComboBox(types);
			    		filetype.setBounds(200,50,200,25);
			    		below.add(filetype);
			    		
			    		
			    		
			    		bslider=new JSlider(JSlider.HORIZONTAL,-100,100,0);
			    		bslider.getPaintTicks();
			    		bslider.setBounds(40,160,300,50);
			    		bslider.setForeground(Color.WHITE);
			    		bright.add(bslider);
			    		
			    		t1=new JTextField(Integer.toString(o.width));
			    		t1.setBounds(60,100,300,50);
			    		resize.add(t1);
			    		//t1.setVisible(false);
			    		
			    		t2=new JTextField(Integer.toString(o.height));
			    		t2.setBounds(60,160,300,50);
			    		resize.add(t2);
			    		//t2.setVisible(false);
			    		
			    		t3=new JTextField("File name");
			    		t3.setText("File name");
			    		t3.setBounds(200,20,200,25);
			    		below.add(t3);
			    		
			    		
			    		rapply=bu.createbutton(300,400,75,25,true,"Apply",resize);
			    		bapply=bu.createbutton(300,400,75,25,true,"Apply",border);
			    		rback=bu.createbutton(215,400,75,25,true,"Back",resize);
			    		bback=bu.createbutton(215,400,75,25,true,"Back",border);
			    		brapply=bu.createbutton(300,400,75,25,true,"Apply",bright);
			    		brback=bu.createbutton(215,400,75,25,true,"Back",bright);
			    		mapply=bu.createbutton(300,400,75,25,true,"Apply",mix);
			    		mback=bu.createbutton(215,400,75,25,true,"Back",mix);
			    		
			    		
			    		
			    		resize.setVisible(false);
			    		border.setVisible(false);
			    		bright.setVisible(false);
			    		mix.setVisible(false);
			    		filechooser1.setVisible(false);
			    		
			    		f.add(resize);
			    		f.add(border);
			    		f.add(bright);
			    		f.add(mix);
			    		f.add(filechooser1);
			    		
			        }
			        });
			 
			
			        
			 
			 
			 	f.setSize(width,height);
				f.setVisible(true);
				f.setLayout(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				 
}



public static JPanel createpanel(int x,int y,int width,int height,boolean panelvisible)
{
	JPanel p=new JPanel();
	p.setLayout(null);	   
	p.setBounds(x, y, width, height);
	p.setBackground(Color.BLACK);
	p.setVisible(panelvisible);
	f.add(p);
	f.setVisible(true);
	
	return p;
}

public JButton createbutton(int x,int y,int width,int height,boolean panelvisible,String text,JPanel p)
{
	JButton b=new JButton(text);
	b.setBounds(x,y,width,height);
	b.addActionListener(this);
	p.add(b);
	p.setVisible(panelvisible);
	b.setBackground(Color.WHITE);
	 b.setHorizontalAlignment(SwingConstants.LEFT);
	return b;
}

public static JLabel createlabel(int x,int y,int width,int height,boolean panelvisible,String text,JPanel p)
{
	JLabel l=new JLabel(text);
	l.setBounds(x,y,width,height);
	p.add(l);
	p.setVisible(panelvisible);
	
	return l;
}



@Override
public void actionPerformed(ActionEvent e) {
	try {
	if(e.getSource()==b2 )
	{
		o.grayscale();
		apply();
	}
	
	if(e.getSource()==b3 )
	{
		
		sidebar.setVisible(false);
		t1.setVisible(true);
		t2.setVisible(true);
		t1.setText(Integer.toString(o.width));
		t2.setText(Integer.toString(o.height));
		rapply.setVisible(true);
		resize.setVisible(true);
	}
	
	if(e.getSource()==b4 )
	{
		o.rotateclock();
		apply();
		
	}
	
	if(e.getSource()==b5)
	{
		o.rotatecounter();
		apply();
	}
	
	if(e.getSource()==b6)
	{
		sidebar.setVisible(false);
		/*resize.setVisible(false);
		bapply.setVisible(true);
		bback.setVisible(true);
		*/
		border.setVisible(true);
		
	}
	
	if(e.getSource()==b7)
	{
		sidebar.setVisible(false);
		bright.setVisible(true);
	}
	if(e.getSource()==b8)
	{
		sidebar.setVisible(false);
		mix.setVisible(true);
	}
	
	if(e.getSource()==b9)
	{
		sidebar.setVisible(false);
		below.setVisible(false);
		image.setVisible(false);
		filechooser1.setVisible(true);

	}
	
	if(e.getSource()==rapply)
	{
		try
    	{
    		int width=Integer.parseInt(t1.getText());
			int height=Integer.parseInt(t2.getText());
			o.resize(width, height);
			apply();

   }
		
   catch(Exception excep)
   {
	   JOptionPane.showMessageDialog(null, "Choose image file");
   }
	}
	
	if(e.getSource()==bapply)
	{
		int index=cb1.getSelectedIndex();
		o.border(colorarray[index]);
		apply();
	}
	
	if(e.getSource()==brapply)
	{
		int b=bslider.getValue();
		o.bright(b);
		apply();
	}
	
	if(e.getSource()==mapply)
	{
		int i=cb2.getSelectedIndex();
		o.mixcolor(i);
		apply();
	}
	if(e.getSource()==rback)
	{
		/*l1.setVisible(false);
		l2.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		*/
		resize.setVisible(false);
		sidebar.setVisible(true);
	}
	
	if(e.getSource()==bback)
	{
		border.setVisible(false);
		sidebar.setVisible(true);
		o.isnew2=0;
	}
	
	if(e.getSource()==brback)
	{
		sidebar.setVisible(true);
		bright.setVisible(false);
		o.isnew=0;
		
	}
	if(e.getSource()==mback)
	{
		sidebar.setVisible(true);
		mix.setVisible(false);
		o.isnew1=0;
		
	}
	
	if(e.getSource()==reset )
	{
		o=new editimage(file);
		apply();

	}
	
	if(e.getSource()==save)
	{
		
		o.save(fc2.getCurrentDirectory().getAbsolutePath(),t3.getText(),(String)filetype.getSelectedItem()) ;
		File f=new File("test.png");
		f.delete();
		
		JPanel array[]= {sidebar,below,image,resize,border,bright,mix,filechooser1};
		for(int i=0;i<array.length;i++)
		{
			array[i].setVisible(false);
		}
		fc.setVisible(true);
		
	}
	}
	catch(Exception exception)
	{
		JOptionPane.showMessageDialog(null, "do correct steps!");
	}
}

public static void apply()
{	
	
	image.removeAll();
	image.setVisible(false);
	img=new ImageIcon(editimage.write);
	imagelabel=new JLabel(img);
	image.add(imagelabel);
	image.setVisible(true);
	image.revalidate();
}
}

class editimage
{
	static BufferedImage mid=null;
	static BufferedImage mid2=null;
	static BufferedImage mid3=null;
	static BufferedImage read=null;
	static BufferedImage write=null;

	
	File img;
	int width,height;
	static int isnew=0;
	static int isnew1=0;
	static int isnew2=0;
	
	public editimage()
	{
		
	}
	public editimage(File img) throws Exception
	{
		this.img=img;
		
		read=ImageIO.read(img);
	
		write=copy(read);
		width=read.getWidth();
		height=read.getHeight();
		
		ImageIO.write(write, "png",new File ("test.png"));
		read=ImageIO.read(new File("test.png"));
		
	}
	
public void setwh()
{
	width=read.getWidth();
	height=read.getHeight();
}
	
	public void grayscale() throws Exception	//1
	{
		write=new BufferedImage(read.getWidth(),read.getHeight(),BufferedImage.TYPE_INT_ARGB);
		for(int i=0;i<read.getWidth();i++)
		{
			for(int j=0;j<read.getHeight();j++)
			{
				Color c1=new Color(read.getRGB(i, j)); 	//read color
				
				int r=c1.getRed();
				int g=c1.getGreen();
				int b=c1.getBlue();
				int a=c1.getAlpha();
				
				int gray=(r+g+b)/3;
				
				Color c2=new Color(gray,gray,gray,a);	//write color
				
				write.setRGB(i, j,c2.getRGB() );
				
				
			}
		}
		ImageIO.write(write, "png",new File ("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
	
	}
	
	public void resize(int width,int height) throws Exception	//2
	{
		write=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g=write.createGraphics();
		g.drawImage(read,0,0,width,height,null);
		g.dispose();
		
		ImageIO.write(write,"png",new File("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
		
	}
	
	public void rotateclock() throws Exception	//3
	{
		write=new BufferedImage(read.getHeight(),read.getWidth(),BufferedImage.TYPE_INT_ARGB);
		for(int i=0;i<read.getWidth();i++)
		{
			for(int j=0;j<read.getHeight();j++)
			{
				Color c=new Color(read.getRGB(i, j));
				
				
				write.setRGB( read.getHeight()-j-1,i, c.getRGB());
				
			}
		}
		
		ImageIO.write(write, "png", new File("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
	}
	
	public void rotatecounter() throws Exception	//4
	{	
		write=new BufferedImage(read.getHeight(),read.getWidth(),BufferedImage.TYPE_INT_ARGB);
		for(int i=0;i<read.getWidth();i++)
		{
			for(int j=0;j<read.getHeight();j++)
			{
				Color c=new Color(read.getRGB(i, j));
				
				
				write.setRGB(j, read.getWidth()-i-1, c.getRGB());
				
			}
		}
		
		ImageIO.write(write, "png", new File("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
	
	}
	
	public void border(Color bcolor) throws Exception	//5
	{
		
		int k=-1;
		int l=0;
		if(isnew2==0)
		{
			mid3=new BufferedImage(read.getWidth(),read.getHeight(),BufferedImage.TYPE_INT_ARGB);
			mid3=copy(read);
			isnew2++;
		}
		
		write=new BufferedImage(mid3.getWidth()+50,mid3.getHeight()+50,BufferedImage.TYPE_INT_ARGB);

		for(int i=0;i<write.getWidth();i++)
		{
			Color cborder=null;
			l=0;

			for(int j=0;j<write.getHeight();j++)
			{
				
				
				if((i>=0 && i<25) || (j>=0 && j<25) || (i>=mid3.getWidth()+25) || (j>=mid3.getHeight()+25))
				{
					cborder=bcolor;
				}
				else
				{
					if(l==0)
					{
						k++;
					}
					cborder=new Color(mid3.getRGB(k, l));
					l++;
				}
				
				write.setRGB(i, j, cborder.getRGB());
				
			}
			
			
		}
		
		ImageIO.write(write,"png",new File("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
	
	}
	
	public void bright(int b) throws Exception	//5
	{
		int brightness=b;
		
		if(isnew==0)
		{
			mid=new BufferedImage(read.getWidth(),read.getHeight(),BufferedImage.TYPE_INT_ARGB);
			mid=copy(read);
			isnew++;
		}
		
		write=new BufferedImage(mid.getWidth(),mid.getHeight(),BufferedImage.TYPE_INT_ARGB);
		
		for(int i=0;i<mid.getWidth();i++)
		{
			for(int j=0;j<mid.getHeight();j++)
			{
				Color c1=new Color(mid.getRGB(i, j));	//reading file
				int red,green,blue;
				if(b>0)
				{
					red=(c1.getRed()+brightness>255)	? 	255:c1.getRed()+brightness;
					green=(c1.getGreen()+brightness>255)	?	255:(c1.getGreen()+brightness);
					blue=(c1.getBlue()+brightness>255)	?	255:(c1.getBlue()+brightness);
				}
				else {
					red=(c1.getRed()+brightness<0)	? 	0:c1.getRed()+brightness;
					green=(c1.getGreen()+brightness<0)	?	0:(c1.getGreen()+brightness);
					blue=(c1.getBlue()+brightness<0)	?	0:(c1.getBlue()+brightness);
				}
				Color c2=new Color(red,green,blue,c1.getAlpha());	//writing file
				
				write.setRGB(i, j, c2.getRGB());
				
			}
		}
		

		ImageIO.write(write, "png", new File("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
		
	}
	
	public void mixcolor(int choice) throws Exception	//6
	{
		if(isnew1==0)
		{
			mid2=new BufferedImage(read.getWidth(),read.getHeight(),BufferedImage.TYPE_INT_ARGB);
			mid2=copy(read);
			isnew1++;
		}
		write=new BufferedImage(mid2.getWidth(),mid2.getHeight(),BufferedImage.TYPE_INT_ARGB);
		
		
		for(int i=0;i<mid2.getWidth();i++)
		{
			for(int j=0;j<mid2.getHeight();j++)
			{
				Color c1=new Color(mid2.getRGB(i, j));	//read
				Color c2=null;
				int r=c1.getRed();
				int g=c1.getGreen();
				int b=c1.getBlue();
				int a=c1.getAlpha();
				if(choice==0)
					c2=new Color(r,g,b,a);	//write
				else if(choice==1)
					c2=new Color(r,b,g,a);	//write
				else if(choice==2)
					c2=new Color(g,r,b,a);	//write
				else if(choice==3)
					c2=new Color(g,b,r,a);	//write
				else if(choice==4)
					c2=new Color(b,r,g,a);	//write
				else if(choice==5)
					c2=new Color(b,g,r,a);	//write
				write.setRGB(i, j, c2.getRGB());	
			}
		}
		
		ImageIO.write(write, "png", new File("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
	}
	
	public void combine(File second) throws Exception	//7
	{
		
		BufferedImage s=ImageIO.read(second);
		BufferedImage max1=null;
		if(read.getHeight()>s.getHeight())
		{
			max1=read;
		}
		else 
		{
			max1=s;
		}
		write=new BufferedImage(read.getWidth()+s.getWidth(),max1.getHeight(),BufferedImage.TYPE_INT_ARGB);
				
		for(int i=0;i<read.getWidth();i++)
		{
			for(int j=0;j<read.getHeight();j++)
			{
				Color c1=new Color(read.getRGB(i, j));
				write.setRGB(i, j, c1.getRGB());		
			}
		}
		
		int m=read.getWidth();
		
		for(int k=0;k<s.getWidth();k++)
		{
			for(int l=0;l<s.getHeight();l++)
			{
				Color c2=new Color(s.getRGB(k, l));
				write.setRGB(m, l, c2.getRGB());
				
			}
			m++;
		}

		ImageIO.write(write, "png", new File("test.png"));
		read=ImageIO.read(new File("test.png"));
		setwh();
		
	}
	
	public void save(String directory,String name,String type) throws Exception	//8
	{
		write=copy(read);
		
		ImageIO.write(write	,"png", new File(String.format("test.png")));
		String filename=String.format(directory+"\\"+name+"."+type);

		if(type.equals("jpg"))
		{
			filename=String.format(directory+"\\"+name+"."+"jpg");
			File f=new File(filename);
			BufferedImage i=ImageIO.read(new File("test.png"));
			BufferedImage j=new BufferedImage(i.getWidth(),i.getHeight(),BufferedImage.TYPE_INT_ARGB);
			
			for(int k=0;k<j.getWidth();k++)
			{
				for(int l=0;l<j.getHeight();l++)
				{
					Color c=new Color(i.getRGB(k, l));
					j.setRGB(k,l,c.getRGB());
				}
			}
			
			ImageIO.write(j, "png", f);
		}
		else
		{
			File f=new File(filename);
			BufferedImage i=ImageIO.read(new File("test.png"));
			ImageIO.write(i,type,f);	//enter location of saving file
		}
		
		
		JOptionPane.showMessageDialog(null, "Saved! see your documents");
	}
	
	public BufferedImage copy(BufferedImage in)
	{
		write=new BufferedImage(in.getWidth(),in.getHeight(),BufferedImage.TYPE_INT_ARGB);
		for(int i=0;i<in.getWidth();i++)
		{
			for(int j=0;j<in.getHeight();j++)
			{
				Color c=new Color(in.getRGB(i, j));
				write.setRGB(i, j, c.getRGB());
			}
		}

		return write;	//out
	}
	
	
	
	
}
