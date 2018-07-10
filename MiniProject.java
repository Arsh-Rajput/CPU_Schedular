import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class FirstCFS extends JFrame
{
	JButton schedule;
	JTextField[] tfat;
	JTextField[] tfbt;
	int[] at;
	int[] bt;
	int[] ct;
	int[] wt;
	int[] tt;
	int[] pc;
	int j;
	FirstCFS(int n)
	{
		tfat=new JTextField[n];
		tfbt=new JTextField[n];
		JLabel[] pc=new JLabel[n];
		setSize(600,n*70+60);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		JPanel operate=new JPanel();
		operate.setOpaque(false);
		operate.setBackground(new Color(10,80,100,80));
		JLabel title=new JLabel("First Come First Serve",SwingConstants.CENTER);
		JLabel arr=new JLabel("Arrival Time");
		JLabel brr=new JLabel("Burst Time");
		arr.setFont(new Font("Calibre",Font.PLAIN,30));
		title.setFont(new Font("Calibre",Font.BOLD,30));
		brr.setFont(new Font("Calibre",Font.PLAIN,30));
		title.setForeground(Color.white);
		arr.setForeground(Color.white);
		brr.setForeground(Color.white);
		
		JPanel x=new JPanel();
		x.setLayout(new GridLayout(n+1,3,10,10));
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		x.add(Box.createRigidArea(new Dimension(30,10)));
		x.add(arr);
		x.add(brr);
		JPanel process=new JPanel();
		schedule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                schedule(n);
            }
		});
		process.setLayout(new BorderLayout());
		
		for(int i=0;i<n;i++)
		{
			tfat[i]=new JTextField(5);
			tfat[i].setPreferredSize(new Dimension(100,30));
			tfat[i].setFont(new Font("Serif",Font.PLAIN,30));
			tfbt[i]=new JTextField(5);
			tfbt[i].setPreferredSize(new Dimension(100,30));
			tfbt[i].setFont(new Font("Serif",Font.PLAIN,30));
			pc[i]=new JLabel("Process"+(i+1)); 
			pc[i].setFont(new Font("Calibre",Font.PLAIN,25));
			pc[i].setForeground(Color.white);
		
		}
		for(int i=0;i<n;i++)
		{
			x.add(pc[i]);
			x.add(tfat[i]);
			//arrival.add(Box.createRigidArea(new Dimension(0,20)));
			x.add(tfbt[i]);
			//burst.add(Box.createRigidArea(new Dimension(0,20)));
			
			//process.add(Box.createRigidArea(new Dimension(0,20)));
		}
        
		
		
		add(x,BorderLayout.CENTER);
		
		process.add(title);
		x.setOpaque(true);
		x.setBackground(new Color(80,80,80,80));
		process.setOpaque(false);
		process.setBackground(new Color(10,80,100,80));
		operate.add(schedule);
		/*z.setOpaque(true);
		z.setBackground(new Color(80,80,80,80));
		z.setLayout(new BorderLayout());
		z.add(schedule);
		//JLabel l=new JLabel("CPU Scheduling",SwingConstants.CENTER);
		*/
		//add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
		add(operate,BorderLayout.SOUTH);
		add(process,BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.EAST);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.WEST);		
	}
	public void schedule(int n)
	{
		at=new int[n];
		bt=new int[n];
		tt=new int[n];
		ct=new int[n];
		wt=new int[n];
		pc=new int[n];
		int i,x=0,temp;
		float awt=0,att=0,act=0;
		for(i=0;i<n;i++)
		{
			pc[i]=i+1;
			at[i]=Integer.valueOf(tfat[i].getText());
			bt[i]=Integer.valueOf(tfbt[i].getText());
		}
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
		       if(at[i]>at[j])
		       {
				temp=bt[i];
				bt[i]=bt[j];
				bt[j]=temp;
				temp=at[i];
				at[i]=at[j];
				at[j]=temp;
				temp=ct[i];
				ct[i]=ct[j];
				ct[j]=temp;
				temp=pc[i];
				pc[i]=pc[j];
				pc[j]=temp;
		       }
			}
		ct[0]=bt[0]+at[0];
		for(i=1;i<n;i++)
		{
			ct[i]=ct[i-1]+bt[i];
			if((x=at[i]-ct[i-1])>=1)
				ct[i]+=x;
		}
		for(i=0;i<n;i++)
			tt[i]=ct[i]-at[i];
		for(i=0;i<n;i++)
			wt[i]=tt[i]-bt[i];
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
		       if(pc[i]>pc[j])
		       {
				temp=bt[i];
				bt[i]=bt[j];
				bt[j]=temp;
				temp=at[i];
				at[i]=at[j];
				at[j]=temp;
				temp=ct[i];
				ct[i]=ct[j];
				ct[j]=temp;
				temp=pc[i];
				pc[i]=pc[j];
				pc[j]=temp;
		       }
			}
		new ShowResult(n,at,bt,ct,wt,tt,pc,"FCFS");
		}
}
class ShortestRTF extends JFrame
{
	JButton schedule;
	JTextField[] tfat;
	JTextField[] tfbt;
	int[] at;
	int[] bt;
	int[] ct;
	int[] wt;
	int[] tt;
	int[] pc;
	int[] btTemp;
	int j;
	ShortestRTF(int n)
	{
		tfat=new JTextField[n];
		tfbt=new JTextField[n];
		JLabel[] pc=new JLabel[n];
		setSize(380,500);
		setSize(600,n*70+60);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		JPanel operate=new JPanel();
		operate.setOpaque(false);
		operate.setBackground(new Color(10,80,100,80));
		JLabel title=new JLabel("Shortest Remaining Time First",SwingConstants.CENTER);
		JLabel arr=new JLabel("Arrival Time");
		JLabel brr=new JLabel("Burst Time");
		arr.setFont(new Font("Calibre",Font.PLAIN,30));
		title.setFont(new Font("Calibre",Font.BOLD,30));
		brr.setFont(new Font("Calibre",Font.PLAIN,30));
		title.setForeground(Color.white);
		arr.setForeground(Color.white);
		brr.setForeground(Color.white);
		
		JPanel x=new JPanel();
		x.setLayout(new GridLayout(n+1,3,10,10));
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		x.add(Box.createRigidArea(new Dimension(30,10)));
		x.add(arr);
		x.add(brr);
		JPanel process=new JPanel();
		schedule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                schedule(n);
            }
		});
		process.setLayout(new BorderLayout());
		
		for(int i=0;i<n;i++)
		{
			tfat[i]=new JTextField(5);
			tfat[i].setPreferredSize(new Dimension(100,30));
			tfat[i].setFont(new Font("Serif",Font.PLAIN,30));
			tfbt[i]=new JTextField(5);
			tfbt[i].setPreferredSize(new Dimension(100,30));
			tfbt[i].setFont(new Font("Serif",Font.PLAIN,30));
			pc[i]=new JLabel("Process"+(i+1)); 
			pc[i].setFont(new Font("Calibre",Font.PLAIN,25));
			pc[i].setForeground(Color.white);
		
		}
		for(int i=0;i<n;i++)
		{
			x.add(pc[i]);
			x.add(tfat[i]);
			//arrival.add(Box.createRigidArea(new Dimension(0,20)));
			x.add(tfbt[i]);
			//burst.add(Box.createRigidArea(new Dimension(0,20)));
			
			//process.add(Box.createRigidArea(new Dimension(0,20)));
		}
        
		
		
		add(x,BorderLayout.CENTER);
		
		process.add(title);
		x.setOpaque(true);
		x.setBackground(new Color(80,80,80,80));
		process.setOpaque(false);
		process.setBackground(new Color(10,80,100,80));
		operate.add(schedule);
		/*z.setOpaque(true);
		z.setBackground(new Color(80,80,80,80));
		z.setLayout(new BorderLayout());
		z.add(schedule);
		//JLabel l=new JLabel("CPU Scheduling",SwingConstants.CENTER);
		*/
		//add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
		add(operate,BorderLayout.SOUTH);
		add(process,BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.EAST);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.WEST);		

	}
	public void schedule(int n)
	{
		at=new int[n];
		bt=new int[n];
		tt=new int[n];
		ct=new int[n];
		wt=new int[n];
		pc=new int[n];
		btTemp=new int[n];
		int i,x=0,temp,index=0,nop,flag=0,min=0,count=0;
		float awt=0,att=0,act=0;
		for(i=0;i<n;i++)
		{
			pc[i]=i+1;
			at[i]=Integer.valueOf(tfat[i].getText());
			bt[i]=Integer.valueOf(tfbt[i].getText());
			btTemp[i]=bt[i];
		}
		/***************************
	Sorting process by arrival time
	************************************/

		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
				if(at[i]>at[j])
				{
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
				}
			}
		while(count<at[n-1])
		{
			nop=0;
			for(i=0;i<n;i++)
				if(at[i]<=count)
					nop++;
			if(nop==0)
			{
				count++ ;
			}
			else{
			/********************************
			finding very first non zero element in processes
			*********************************/
	
				for(j=0;j<nop;j++)
				if(bt[j]>0)
				{
					min=bt[j];
					index=j;
					break;
					
	
				}
	
			/********************************
			Finding minimum non zero process burst time
			*************************************/
		
				for(i=0;i<nop;i++)
					if(min>bt[i]&&bt[i]>0)
					{       if(min==bt[i])
							continue;
						min=bt[i];
						index=i ;
					}
	
				if(bt[index]>0)
				{
					bt[index]=bt[index]-1;
					count++;
					ct[index]=count;
					flag=0;
				}
				else
					count++;
			}
	
		}
		/**************************************
		sort by arrival then by bursttime  for same bt time
		*****************************************/
	
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{	
				if(at[i]>at[j])
				{
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
				}
			}
	
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
				if(bt[i]>bt[j])
				{
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
				}
			}
	
		for(i=0;i<n;i++)
			while(bt[i]>0)
			{
				bt[i]=bt[i]-1;
				count=count+1;
				ct[i]=count;
			}
	
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
				if(pc[i]>pc[j])
				{
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
				}
			}
		for(i=0;i<n;i++)
			tt[i]=ct[i]-at[i];
		for(i=0;i<n;i++)
			wt[i]=tt[i]-btTemp[i];
		new ShowResult(n,at,btTemp,ct,wt,tt,pc,"SRTF");
	}	
}

class PrioritySch extends JFrame
{
	JButton schedule;
	JTextField[] tfat;
	JTextField[] tfbt;
	JTextField[] tfpt;
	int[] at;
	int[] bt;
	int[] ct;
	int[] wt;
	int[] tt;
	int[] pc;
	int[] pt;
	int[] btTemp;
	int j;
	PrioritySch(int n)
	{
		tfat=new JTextField[n];
		tfbt=new JTextField[n];
		tfpt=new JTextField[n];
		JLabel[] pc=new JLabel[n];
		///////////////////////
		setSize(800,n*70+60);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		JPanel operate=new JPanel();
		operate.setOpaque(false);
		operate.setBackground(new Color(10,80,100,80));
		JLabel title=new JLabel("Priority Scheduling",SwingConstants.CENTER);
		JLabel arr=new JLabel("Arrival Time");
		JLabel brr=new JLabel("Burst Time");
		JLabel prr=new JLabel("Priority");
		arr.setFont(new Font("Calibre",Font.PLAIN,30));
		prr.setFont(new Font("Calibre",Font.PLAIN,30));
		title.setFont(new Font("Calibre",Font.BOLD,30));
		brr.setFont(new Font("Calibre",Font.PLAIN,30));
		title.setForeground(Color.white);
		prr.setForeground(Color.white);
		arr.setForeground(Color.white);
		brr.setForeground(Color.white);
		
		JPanel x=new JPanel();
		x.setLayout(new GridLayout(n+1,4,10,10));
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		x.add(Box.createRigidArea(new Dimension(30,10)));
		x.add(arr);
		x.add(brr);
		x.add(prr);
		JPanel process=new JPanel();
		schedule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                schedule(n);
            }
		});
		process.setLayout(new BorderLayout());
		
		for(int i=0;i<n;i++)
		{
			tfat[i]=new JTextField(5);
			
			tfat[i].setPreferredSize(new Dimension(100,30));
			tfat[i].setFont(new Font("Calibre",Font.PLAIN,30));
			tfbt[i]=new JTextField(5);
			tfbt[i].setPreferredSize(new Dimension(100,30));
			
			tfbt[i].setFont(new Font("Calibre",Font.PLAIN,30));
			pc[i]=new JLabel("Process"+(i+1)); 
			pc[i].setPreferredSize(new Dimension(100,30));
			pc[i].setFont(new Font("Calibre",Font.PLAIN,25));
			pc[i].setForeground(Color.white);
			tfpt[i]=new JTextField(5);
			tfpt[i].setPreferredSize(new Dimension(100,30));
			tfpt[i].setFont(new Font("Calibre",Font.PLAIN,25));
			//tfpt[i].setForeground(Color.white);
		}
		for(int i=0;i<n;i++)
		{
			x.add(pc[i]);
			x.add(tfat[i]);
			//arrival.add(Box.createRigidArea(new Dimension(0,20)));
			x.add(tfbt[i]);
			x.add(tfpt[i]);
			//burst.add(Box.createRigidArea(new Dimension(0,20)));
			
			//process.add(Box.createRigidArea(new Dimension(0,20)));
		}
        
		
		
		add(x,BorderLayout.CENTER);
		
		process.add(title);
		x.setOpaque(true);
		x.setBackground(new Color(80,80,80,80));
		process.setOpaque(false);
		process.setBackground(new Color(10,80,100,80));
		operate.add(schedule);

		//add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
		add(operate,BorderLayout.SOUTH);
		add(process,BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.EAST);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.WEST);		

		
		/*//////////////////////////
		setSize(600,500);
		setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		JPanel arrival=new JPanel();
		JPanel burst=new JPanel();
		JPanel process=new JPanel();
		JPanel prior=new JPanel();
		schedule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                schedule(n);
            }
		});
		process.setLayout(new BoxLayout(process,BoxLayout.Y_AXIS));
		arrival.setLayout(new BoxLayout(arrival,BoxLayout.Y_AXIS));
		prior.setLayout(new BoxLayout(prior,BoxLayout.Y_AXIS));
		burst.setLayout(new BoxLayout(burst,BoxLayout.Y_AXIS));
		JLabel arr=new JLabel("Arrival Time");
		JLabel brr=new JLabel("Burst Time");
		JLabel prr=new JLabel("Priority");
		arrival.add(arr);
		burst.add(brr);
		prior.add(prr);
		for(int i=0;i<n;i++)
		{
			tfat[i]=new JTextField(5);
			tfbt[i]=new JTextField(5);
			tfpt[i]=new JTextField(5);
			pc[i]=new JLabel("Process"+(i+1)); 
		
		}
		for(int i=0;i<n;i++)
		{
			arrival.add(tfat[i]);
			arrival.add(Box.createRigidArea(new Dimension(0,20)));
			burst.add(tfbt[i]);
			burst.add(Box.createRigidArea(new Dimension(0,20)));
			process.add(pc[i]);
			process.add(Box.createRigidArea(new Dimension(0,20)));
			prior.add(tfpt[i]);
			prior.add(Box.createRigidArea(new Dimension(0,20)));
		}
        
		add(process);
		add(arrival);
		add(burst);
		add(prior);
		add(schedule);*/		
	}
	public void schedule(int n)
	{
		at=new int[n];
		bt=new int[n];
		tt=new int[n];
		ct=new int[n];
		wt=new int[n];
		pc=new int[n];
		pt=new int[n];
		btTemp=new int[n];
		int i,x=0,temp,index=0,nop,flag=0,min=0,count=0;
		for(i=0;i<n;i++)
		{
			pc[i]=i+1;
			at[i]=Integer.valueOf(tfat[i].getText());
			bt[i]=Integer.valueOf(tfbt[i].getText());
			pt[i]=Integer.valueOf(tfpt[i].getText());
			btTemp[i]=bt[i];
		}
				/***************************
		Sorting process by arrival time

	
		***********************************/
	
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
				if(at[i]>at[j])
				{
					temp=pt[i];
					pt[i]=pt[j];
					pt[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
		       }
			}
		while(count<at[n-1])
		{
			nop=0;
			for(i=0;i<n;i++)
				if(at[i]<=count)
					nop++;
			if(nop==0)
			{
				count++ ;
			}
			else
			{
			/********************************
			finding very first non zero element in processes
			*********************************/
				for(i=0;i<nop;i++)
				if(bt[i]>0)
				{
					min=pt[i];
					index=i;
					break;
				}
			/********************************
			Finding minimum non zero process burst time
			*************************************/

				for(i=0;i<nop;i++)
					if(min>pt[i]&&bt[i]>0)
					{       if(min==pt[i])
							continue;
						min=pt[i];
						index=i ;
					}
				if(bt[index]>0)
				{
					bt[index]=bt[index]-1;
					count++;
					ct[index]=count;
	
					flag=0;
				}
				else
					count++;
			}

		}
	/**************************************
	sort by arrival then by bursttime  for same bt time
	*****************************************/
       /*
	for(i=0;i<4;i++)
		for(j=i+1;j<5;j++)
		{
		       if(at[i]>at[j])
		       {
				temp=pt[i];
				pt[i]=pt[j];
				pt[j]=temp;
				temp1=bt[i];
				bt[i]=bt[j];
				bt[j]=temp1;
				temp3=at[i];
				at[i]=at[j];
				at[j]=temp3;
				temp2=ct[i];
				ct[i]=ct[j];
				ct[j]=temp2;
				temp4=pc[i];
				pc[i]=pc[j];
				pc[j]=temp4;
		       }
		}      */

		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
				if(pt[i]>pt[j])
				{
					temp=pt[i];
					pt[i]=pt[j];
					pt[j]=temp;
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
				}
			}

		for(i=0;i<n;i++)
			while(bt[i]>0)
			{
				bt[i]=bt[i]-1;
				count=count+1;
				ct[i]=count;
	

			}
	
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)	
			{
				if(pc[i]>pc[j])
				{
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
					temp=pt[i];
					pt[i]=pt[j];
					pt[j]=temp;
				}
			}
		for(i=0;i<n;i++)
			tt[i]=ct[i]-at[i];
		for(i=0;i<n;i++)
			wt[i]=tt[i]-btTemp[i];
		new ShowResult(n,at,btTemp,ct,wt,tt,pc,pt,"PRIOR");
	
	}
		
}


class ShortestJF extends JFrame
{
	JButton schedule;
	JTextField[] tfbt;
	int[] bt;
	int[] ct;
	int[] wt;
	int[] tt;
	int[] pc;
	int[] btTemp;
	int j;
	ShortestJF(int n)
	{
		tfbt=new JTextField[n];
		JLabel[] pc=new JLabel[n];
		
		setSize(400,n*70+60);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		JPanel operate=new JPanel();
		operate.setOpaque(false);
		operate.setBackground(new Color(10,80,100,80));
		JLabel title=new JLabel("Shortest Job First",SwingConstants.CENTER);
		
		JLabel brr=new JLabel("Burst Time");
		
		title.setFont(new Font("Calibre",Font.BOLD,30));
		brr.setFont(new Font("Calibre",Font.PLAIN,30));
		title.setForeground(Color.white);
		
		brr.setForeground(Color.white);
		
		JPanel x=new JPanel();
		x.setLayout(new GridLayout(n+1,2,10,10));
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		x.add(Box.createRigidArea(new Dimension(30,10)));
		x.add(brr);
		JPanel process=new JPanel();
		schedule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                schedule(n);
            }
		});
		process.setLayout(new BorderLayout());
		
		for(int i=0;i<n;i++)
		{
			
			tfbt[i]=new JTextField(5);
			tfbt[i].setPreferredSize(new Dimension(100,30));
			tfbt[i].setFont(new Font("Calibre",Font.PLAIN,30));
			pc[i]=new JLabel("Process"+(i+1)); 
			pc[i].setFont(new Font("Calibre",Font.PLAIN,25));
			pc[i].setForeground(Color.white);
		
		}
		for(int i=0;i<n;i++)
		{
			x.add(pc[i]);
			
			//arrival.add(Box.createRigidArea(new Dimension(0,20)));
			x.add(tfbt[i]);
			//burst.add(Box.createRigidArea(new Dimension(0,20)));
			
			//process.add(Box.createRigidArea(new Dimension(0,20)));
		}
        
		
		
		add(x,BorderLayout.CENTER);
		
		process.add(title);
		x.setOpaque(true);
		x.setBackground(new Color(80,80,80,80));
		process.setOpaque(false);
		process.setBackground(new Color(10,80,100,80));
		operate.add(schedule);
		
		//add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
		add(operate,BorderLayout.SOUTH);
		add(process,BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.EAST);
		add(Box.createRigidArea(new Dimension(30,10)),BorderLayout.WEST);		

		/*
		setSize(250,500);
		setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		JPanel burst=new JPanel();
		JPanel process=new JPanel();
		schedule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                schedule(n);
            }
		});
		process.setLayout(new BoxLayout(process,BoxLayout.Y_AXIS));
		burst.setLayout(new BoxLayout(burst,BoxLayout.Y_AXIS));
		JLabel brr=new JLabel("Burst Time");
		burst.add(brr);
		for(int i=0;i<n;i++)
		{
			tfbt[i]=new JTextField(5);
			pc[i]=new JLabel("Process"+(i+1)); 
		
		}
		for(int i=0;i<n;i++)
		{
			burst.add(tfbt[i]);
			burst.add(Box.createRigidArea(new Dimension(0,40)));
			process.add(pc[i]);
			process.add(Box.createRigidArea(new Dimension(0,40)));
		}
        
		add(process);
		add(burst);
		add(schedule);	*/	
	}
	public void schedule(int n)
	{
		bt=new int[n];
		tt=new int[n];
		ct=new int[n];
		wt=new int[n];
		pc=new int[n];
		btTemp=new int[n];

		int i,x=0,temp,count=0;
		for(i=0;i<n;i++)
		{
			pc[i]=i+1;
			bt[i]=Integer.valueOf(tfbt[i].getText());
			btTemp[i]=bt[i];
		}
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
		       if(bt[i]>bt[j])
		       {
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
				}
			}

		for(i=0;i<n;i++)
			while(bt[i]>0)
			{
				bt[i]=bt[i]-1;
				count=count+1;
				ct[i]=count;
			}
		for(i=0;i<n-1;i++)
			for(j=i+1;j<n;j++)
			{
				if(pc[i]>pc[j])
				{
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=ct[i];
					ct[i]=ct[j];
					ct[j]=temp;
					temp=pc[i];
					pc[i]=pc[j];
					pc[j]=temp;
				}
			}

		for(i=0;i<n;i++)
			tt[i]=ct[i];
		for(i=0;i<n;i++)
			wt[i]=tt[i]-btTemp[i];
	
		new ShowResult(n,btTemp,ct,wt,tt,pc,"SJF");
	}
}


class ShowResult extends JFrame
{
	JTextArea result;
	JLabel arr[];
	JLabel brr[];
	JLabel crr[];
	JLabel trr[];
	JLabel wrr[];
	JLabel prr[];
	JLabel ptr[];
	ShowResult(int n,int[]at,int bt[],int[]ct,int[]wt,int[]tt,int[]pc,String method)
	{
		
		int i;
		arr=new JLabel[n+2];
		brr=new JLabel[n+2];
		crr=new JLabel[n+2];
		trr=new JLabel[n+2];
		wrr=new JLabel[n+2];
		prr=new JLabel[n+2];
		setSize(1200,n*70+100);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		JLabel title=new JLabel("Scheduling Criteria Table",SwingConstants.CENTER);
		title.setFont(new Font("Calibre",Font.BOLD,30));
		title.setForeground(Color.white);
		float awt=0,att=0,act=0;
		result=new JTextArea(50,17);
		arr[0]=new JLabel("Arrival Time",SwingConstants.CENTER);
		arr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		arr[0].setForeground(Color.white);
		brr[0]=new JLabel("Burst Time",SwingConstants.CENTER);
		brr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		brr[0].setForeground(Color.white);
		crr[0]=new JLabel("Compelition Time",SwingConstants.CENTER);
		crr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		crr[0].setForeground(Color.white);
		trr[0]=new JLabel("TurnArount Time",SwingConstants.CENTER);
		trr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		trr[0].setForeground(Color.white);
		wrr[0]=new JLabel("Waiting Time",SwingConstants.CENTER);
		wrr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		wrr[0].setForeground(Color.white);
		prr[0]=new JLabel("Process",SwingConstants.CENTER);
		prr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		prr[0].setForeground(Color.white);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(n+2,6,10,10));
		for(i=0;i<n;i++)
		{
			awt+=wt[i];
			att+=tt[i];
			act+=ct[i];
		}
		result.setText("Process\tarrival\tburst \tcompletion \tturnaround \twaiting\n");
		panel.add(prr[0]);
		panel.add(arr[0]);
		panel.add(brr[0]);
		panel.add(crr[0]);
		panel.add(trr[0]);
		panel.add(wrr[0]);
		for(i=0;i<n;i++)
		{
			arr[i]=new JLabel(String.valueOf(at[i]),SwingConstants.CENTER);
			arr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			arr[i].setForeground(Color.white);
			brr[i]=new JLabel(String.valueOf(bt[i]),SwingConstants.CENTER);
			brr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			brr[i].setForeground(Color.white);
			crr[i]=new JLabel(String.valueOf(ct[i]),SwingConstants.CENTER);
			crr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			crr[i].setForeground(Color.white);
			trr[i]=new JLabel(String.valueOf(tt[i]),SwingConstants.CENTER);
			trr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			trr[i].setForeground(Color.white);
			wrr[i]=new JLabel(String.valueOf(wt[i]),SwingConstants.CENTER);
			wrr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			wrr[i].setForeground(Color.white);
			prr[i]=new JLabel(String.valueOf(pc[i]),SwingConstants.CENTER);
			prr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			prr[i].setForeground(Color.white);
			panel.add(prr[i]);
			panel.add(arr[i]);
			panel.add(brr[i]);
			panel.add(crr[i]);
			panel.add(trr[i]);
			panel.add(wrr[i]);
			
		}
		JLabel l1=new JLabel("Average",SwingConstants.CENTER);
		l1.setFont(new Font("Calibre",Font.PLAIN,30));
		l1.setForeground(Color.white);
		panel.add(l1);
		JLabel l2=new JLabel(String.valueOf(act/n),SwingConstants.CENTER);
		l2.setFont(new Font("Calibre",Font.PLAIN,30));
		l2.setForeground(Color.white);
		panel.add(l2);
		JLabel l3=new JLabel(String.valueOf(att/n),SwingConstants.CENTER);
		l3.setFont(new Font("Calibre",Font.PLAIN,30));
		l3.setForeground(Color.white);
		panel.add(l3);
		JLabel l4=new JLabel(String.valueOf(awt/n),SwingConstants.CENTER);
		l4.setFont(new Font("Calibre",Font.PLAIN,30));
		l4.setForeground(Color.white);
		panel.add(l4);
		panel.add(Box.createRigidArea(new Dimension(30,10)));
		panel.add(Box.createRigidArea(new Dimension(30,10)));
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		JPanel x=new JPanel();
		x.setLayout(new BorderLayout());
		x.add(title);
		x.setOpaque(true);
		x.setBackground(new Color(80,80,80,80));
		panel.setOpaque(true);
		panel.setBackground(new Color(80,80,80,80));
		add(x,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
	}
	ShowResult(int n,int bt[],int[]ct,int[]wt,int[]tt,int[]pc,String method)
	{
		int i;
		brr=new JLabel[n+2];
		crr=new JLabel[n+2];
		trr=new JLabel[n+2];
		wrr=new JLabel[n+2];
		prr=new JLabel[n+2];
		setSize(900,n*70+100);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		JLabel title=new JLabel("Scheduling Criteria Table",SwingConstants.CENTER);
		title.setFont(new Font("Calibre",Font.BOLD,30));
		title.setForeground(Color.white);
		float awt=0,att=0,act=0;
		result=new JTextArea(50,17);
		brr[0]=new JLabel("Burst Time",SwingConstants.CENTER);
		brr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		brr[0].setForeground(Color.white);
		crr[0]=new JLabel("Compelition Time",SwingConstants.CENTER);
		crr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		crr[0].setForeground(Color.white);
		trr[0]=new JLabel("TurnArount Time",SwingConstants.CENTER);
		trr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		trr[0].setForeground(Color.white);
		wrr[0]=new JLabel("Waiting Time",SwingConstants.CENTER);
		wrr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		wrr[0].setForeground(Color.white);
		prr[0]=new JLabel("Process",SwingConstants.CENTER);
		prr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		prr[0].setForeground(Color.white);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(n+2,6,10,10));
		for(i=0;i<n;i++)
		{
			awt+=wt[i];
			att+=tt[i];
			act+=ct[i];
		}
		result.setText("Process\tarrival\tburst \tcompletion \tturnaround \twaiting\n");
		panel.add(prr[0]);
		panel.add(brr[0]);
		panel.add(crr[0]);
		panel.add(trr[0]);
		panel.add(wrr[0]);
		for(i=0;i<n;i++)
		{
			
			brr[i]=new JLabel(String.valueOf(bt[i]),SwingConstants.CENTER);
			brr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			brr[i].setForeground(Color.white);
			crr[i]=new JLabel(String.valueOf(ct[i]),SwingConstants.CENTER);
			crr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			crr[i].setForeground(Color.white);
			trr[i]=new JLabel(String.valueOf(tt[i]),SwingConstants.CENTER);
			trr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			trr[i].setForeground(Color.white);
			wrr[i]=new JLabel(String.valueOf(wt[i]),SwingConstants.CENTER);
			wrr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			wrr[i].setForeground(Color.white);
			prr[i]=new JLabel(String.valueOf(pc[i]),SwingConstants.CENTER);
			prr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			prr[i].setForeground(Color.white);
			panel.add(prr[i]);
			panel.add(brr[i]);
			panel.add(crr[i]);
			panel.add(trr[i]);
			panel.add(wrr[i]);
			
		}
		JLabel l1=new JLabel("Average",SwingConstants.CENTER);
		l1.setFont(new Font("Calibre",Font.PLAIN,30));
		l1.setForeground(Color.white);
		panel.add(l1);
		JLabel l2=new JLabel(String.valueOf(act/n),SwingConstants.CENTER);
		l2.setFont(new Font("Calibre",Font.PLAIN,30));
		l2.setForeground(Color.white);
		panel.add(l2);
		JLabel l3=new JLabel(String.valueOf(att/n),SwingConstants.CENTER);
		l3.setFont(new Font("Calibre",Font.PLAIN,30));
		l3.setForeground(Color.white);
		panel.add(l3);
		JLabel l4=new JLabel(String.valueOf(awt/n),SwingConstants.CENTER);
		l4.setFont(new Font("Calibre",Font.PLAIN,30));
		l4.setForeground(Color.white);
		panel.add(l4);
		panel.add(Box.createRigidArea(new Dimension(30,10)));
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		JPanel x=new JPanel();
		x.setLayout(new BorderLayout());
		x.add(title);
		x.setOpaque(true);
		x.setBackground(new Color(80,80,80,80));
		panel.setOpaque(true);
		panel.setBackground(new Color(80,80,80,80));
		add(x,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
	
	
	
	/*
		setSize(420,320);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setVisible(true);
		int i;
		float awt=0,att=0,act=0;
		result=new JTextArea(50,17);
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		for(i=0;i<n;i++)
		{
			awt+=wt[i];
			att+=tt[i];
			act+=ct[i];
		}
		result.setText("Process\tburst \tcompletion \tturnaround \twaiting\n");
		for(i=0;i<n;i++)
		{
			String temp=new String();
			temp=result.getText();
			result.setText(temp+"\n"+pc[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tt[i]+"\t"+wt[i]);
		}
		String temp=new String();
		temp=result.getText();
		result.setText(temp+"\n\t\t"+act/n+"\t"+att/n+"\t"+awt/n);
		panel.add(result);
		add(panel);
	*/
	}
	ShowResult(int n,int[]at,int bt[],int[]ct,int[]wt,int[]tt,int[]pc,int[]pt,String method)
	{
		int i;
		arr=new JLabel[n+2];
		brr=new JLabel[n+2];
		crr=new JLabel[n+2];
		trr=new JLabel[n+2];
		wrr=new JLabel[n+2];
		prr=new JLabel[n+2];
		ptr=new JLabel[n+2];
		setSize(1400,n*70+100);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		JLabel title=new JLabel("Scheduling Criteria Table",SwingConstants.CENTER);
		title.setFont(new Font("Calibre",Font.BOLD,30));
		title.setForeground(Color.white);
		float awt=0,att=0,act=0;
		result=new JTextArea(50,17);
		arr[0]=new JLabel("Arrival Time",SwingConstants.CENTER);
		arr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		arr[0].setForeground(Color.white);
		ptr[0]=new JLabel("Priority",SwingConstants.CENTER);
		ptr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		ptr[0].setForeground(Color.white);
		brr[0]=new JLabel("Burst Time",SwingConstants.CENTER);
		brr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		brr[0].setForeground(Color.white);
		crr[0]=new JLabel("Compelition Time",SwingConstants.CENTER);
		crr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		crr[0].setForeground(Color.white);
		trr[0]=new JLabel("TurnArount Time",SwingConstants.CENTER);
		trr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		trr[0].setForeground(Color.white);
		wrr[0]=new JLabel("Waiting Time",SwingConstants.CENTER);
		wrr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		wrr[0].setForeground(Color.white);
		prr[0]=new JLabel("Process",SwingConstants.CENTER);
		prr[0].setFont(new Font("Calibre",Font.PLAIN,30));
		prr[0].setForeground(Color.white);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(n+2,7,10,10));
		for(i=0;i<n;i++)
		{
			awt+=wt[i];
			att+=tt[i];
			act+=ct[i];
		}
		result.setText("Process\tarrival\tburst \tcompletion \tturnaround \twaiting\n");
		panel.add(prr[0]);
		panel.add(arr[0]);
		panel.add(brr[0]);
		panel.add(ptr[0]);
		panel.add(crr[0]);
		panel.add(trr[0]);
		panel.add(wrr[0]);
		for(i=0;i<n;i++)
		{
			arr[i]=new JLabel(String.valueOf(at[i]),SwingConstants.CENTER);
			arr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			arr[i].setForeground(Color.white);
			brr[i]=new JLabel(String.valueOf(bt[i]),SwingConstants.CENTER);
			brr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			brr[i].setForeground(Color.white);
			ptr[i]=new JLabel(String.valueOf(pt[i]),SwingConstants.CENTER);
			ptr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			ptr[i].setForeground(Color.white);
			crr[i]=new JLabel(String.valueOf(ct[i]),SwingConstants.CENTER);
			crr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			crr[i].setForeground(Color.white);
			trr[i]=new JLabel(String.valueOf(tt[i]),SwingConstants.CENTER);
			trr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			trr[i].setForeground(Color.white);
			wrr[i]=new JLabel(String.valueOf(wt[i]),SwingConstants.CENTER);
			wrr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			wrr[i].setForeground(Color.white);
			prr[i]=new JLabel(String.valueOf(pc[i]),SwingConstants.CENTER);
			prr[i].setFont(new Font("Calibre",Font.PLAIN,30));
			prr[i].setForeground(Color.white);
			panel.add(prr[i]);
			panel.add(arr[i]);
			panel.add(brr[i]);
			panel.add(ptr[i]);
			panel.add(crr[i]);
			panel.add(trr[i]);
			panel.add(wrr[i]);
			
		}
		JLabel l1=new JLabel("Average",SwingConstants.CENTER);
		l1.setFont(new Font("Calibre",Font.PLAIN,30));
		l1.setForeground(Color.white);
		panel.add(l1);
		JLabel l2=new JLabel(String.valueOf(act/n),SwingConstants.CENTER);
		l2.setFont(new Font("Calibre",Font.PLAIN,30));
		l2.setForeground(Color.white);
		panel.add(l2);
		JLabel l3=new JLabel(String.valueOf(att/n),SwingConstants.CENTER);
		l3.setFont(new Font("Calibre",Font.PLAIN,30));
		l3.setForeground(Color.white);
		panel.add(l3);
		JLabel l4=new JLabel(String.valueOf(awt/n),SwingConstants.CENTER);
		l4.setFont(new Font("Calibre",Font.PLAIN,30));
		l4.setForeground(Color.white);
		panel.add(l4);
		panel.add(Box.createRigidArea(new Dimension(30,10)));
		panel.add(Box.createRigidArea(new Dimension(30,10)));
		panel.add(Box.createRigidArea(new Dimension(30,10)));
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		JPanel x=new JPanel();
		x.setLayout(new BorderLayout());
		x.add(title);
		x.setOpaque(true);
		x.setBackground(new Color(80,80,80,80));
		panel.setOpaque(true);
		panel.setBackground(new Color(80,80,80,80));
		add(x,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
	}
}
class Welcome extends JFrame
{
	Welcome()
	{
		JPanel p2=new JPanel();
		JRadioButton[] rb=new JRadioButton[12];
		setSize(800,700);
		setContentPane(new JLabel(new ImageIcon("212.jpg")));
		setResizable(false);
		setLayout(new BorderLayout(100,100));
		setLocationRelativeTo(null);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,60,60));
		setVisible(true);
		p2.setSize(0,0);
		p2.setOpaque(true);
		p2.setBackground(new Color(80,80,80,80));
		JPanel panel=new JPanel();
		panel.setSize(150,200);
		JPanel pc=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		pc.setLayout(new GridLayout(4,3,60,40));
		pc.setOpaque(true);
		pc.setBackground(new Color(80,80,80,80));
		JButton fcfs=new JButton("   FCFS ");
		fcfs.setFont(new Font("Calibre",Font.PLAIN,25));
		fcfs.setBounds(10,10,100,20);
		JButton sjf=new JButton("    SJF   ");
		sjf.setBounds(10,10,100,20);
		sjf.setFont(new Font("Calibre",Font.PLAIN,25));
		JButton srtf=new JButton("   SRTF ");
		srtf.setBounds(10,10,100,20);
		srtf.setFont(new Font("Calibre",Font.PLAIN,25));
		JButton priority=new JButton("Priority");
		priority.setBounds(10,100,60,20);
		priority.setFont(new Font("Calibre",Font.PLAIN,25));
		ButtonGroup b=new ButtonGroup();
		fcfs.setEnabled(false);
		srtf.setEnabled(false);
		sjf.setEnabled(false);
		priority.setEnabled(false);
		for(int i=0;i<12;i++)
		{
			rb[i]=new JRadioButton(""+(i+1));
			rb[i].setFont(new Font("Calibre",Font.PLAIN,25));
			b.add(rb[i]);
			pc.add(rb[i]);
		}
		for(int i=0;i<12;i++)
		{
			rb[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					fcfs.setEnabled(true);
					srtf.setEnabled(true);
					sjf.setEnabled(true);
					priority.setEnabled(true);
				}
			});
			
		}
		
		fcfs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                int n=5;
				for(int i=0;i<12;i++)
					if(rb[i].isSelected())
					{
						n=i+1;
						break;
					}
				new FirstCFS(n);
				
            }
		});
		sjf.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent e)
            {
                int n=5;
				for(int i=0;i<10;i++)
					if(rb[i].isSelected())
					{
						n=i+1;
						break;
					}
				new ShortestJF(n);
            }
		});
		srtf.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent e)
            {
                int n=5;
				for(int i=0;i<10;i++)
					if(rb[i].isSelected())
					{
						n=i+1;
						break;
					}
				new ShortestRTF(n);
            }
		});
		priority.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
                int n=5;
				for(int i=0;i<10;i++)
					if(rb[i].isSelected())
					{
						n=i+1;
						break;
					}
				new PrioritySch(n);
            }
		});
		panel.setOpaque(true);
		panel.setBackground(new Color(0,0,0,0));
		panel.add(Box.createRigidArea(new Dimension(0,0)));
		panel.add(srtf);
		panel.add(Box.createRigidArea(new Dimension(0,40)));
		panel.add(fcfs);
		panel.add(Box.createRigidArea(new Dimension(0,40)));
		panel.add(sjf);
		panel.add(Box.createRigidArea(new Dimension(0,40)));
		panel.add(priority);
		//panel.add(Box.createRigidArea(new Dimension(0,40)));
		p2.add(panel);
		p2.add(pc);
		add(p2,BorderLayout.CENTER);
		JLabel l=new JLabel("CPU Scheduling",SwingConstants.CENTER);
		l.setFont(new Font("Calibre",Font.PLAIN,50));
		l.setForeground(Color.white);
		add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.SOUTH);
		//add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.NORTH);
		add(l,BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.EAST);
		add(Box.createRigidArea(new Dimension(0,20)),BorderLayout.WEST);
		
		
	}
	
}
public class MiniProject
{
	public static void main(String [] args)
	{
		new Welcome();
	}
}