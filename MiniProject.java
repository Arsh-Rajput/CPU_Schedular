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
		setSize(380,500);
		setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		setVisible(true);
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		JPanel arrival=new JPanel();
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
		arrival.setLayout(new BoxLayout(arrival,BoxLayout.Y_AXIS));
		burst.setLayout(new BoxLayout(burst,BoxLayout.Y_AXIS));
		JLabel arr=new JLabel("Arrival Time");
		JLabel brr=new JLabel("Burst Time");
		arrival.add(arr);
		burst.add(brr);
		for(int i=0;i<n;i++)
		{
			tfat[i]=new JTextField(5);
			tfbt[i]=new JTextField(5);
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
		}
        
		add(process);
		add(arrival);
		add(burst);
		add(schedule);		
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
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel mainy=new JPanel();
		mainy.setLayout(new BoxLayout(mainy,BoxLayout.Y_AXIS));
		setVisible(true);
		JPanel mainx=new JPanel();
		mainx.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		schedule=new JButton("Schedule");
		schedule.setBounds(10,10,40,10);
		JPanel arrival=new JPanel();
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
		arrival.setLayout(new BoxLayout(arrival,BoxLayout.Y_AXIS));
		burst.setLayout(new BoxLayout(burst,BoxLayout.Y_AXIS));
		JLabel arr=new JLabel("Arrival Time");
		JLabel brr=new JLabel("Burst Time");
		arrival.add(arr);
		burst.add(brr);
		for(int i=0;i<n;i++)
		{
			tfat[i]=new JTextField(5);
			tfbt[i]=new JTextField(5);
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
		}
        
		mainx.add(process);
		mainx.add(arrival);
		mainx.add(burst);
		mainy.add(mainx);
		mainy.add(Box.createRigidArea(new Dimension(0,30)));
		mainy.add(schedule);
		add(mainy);
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
		add(schedule);		
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
		add(schedule);		
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
	ShowResult(int n,int[]at,int bt[],int[]ct,int[]wt,int[]tt,int[]pc,String method)
	{
		setSize(520,320);
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
		result.setText("Process\tarrival\tburst \tcompletion \tturnaround \twaiting\n");
		for(i=0;i<n;i++)
		{
			String temp=new String();
			temp=result.getText();
			result.setText(temp+"\n"+pc[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tt[i]+"\t"+wt[i]);
		}
		String temp=new String();
		temp=result.getText();
		result.setText(temp+"\n\t\t\t"+act/n+"\t"+att/n+"\t"+awt/n);
		panel.add(result);
		add(panel);
	}
	ShowResult(int n,int bt[],int[]ct,int[]wt,int[]tt,int[]pc,String method)
	{
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
	}
	ShowResult(int n,int[]at,int bt[],int[]ct,int[]wt,int[]tt,int[]pc,int[]pt,String method)
	{
		setSize(620,320);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setVisible(true);
		int i;
		float awt=0,att=0,act=0;
		result=new JTextArea(60,17);
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		for(i=0;i<n;i++)
		{
			awt+=wt[i];
			att+=tt[i];
			act+=ct[i];
		}
		result.setText("Process\tarrival\tburst\tPriority \tcompletion \tturnaround \twaiting\n");
		for(i=0;i<n;i++)
		{
			String temp=new String();
			temp=result.getText();
			result.setText(temp+"\n"+pc[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+pt[i]+"\t"+ct[i]+"\t"+tt[i]+"\t"+wt[i]);
		}
		String temp=new String();
		temp=result.getText();
		result.setText(temp+"\n\t\t\t\t"+act/n+"\t"+att/n+"\t"+awt/n);
		panel.add(result);
		add(panel);
	}
}
class Welcome extends JFrame
{
	Welcome()
	{
		JRadioButton[] rb=new JRadioButton[10];
		setSize(400,400);
		setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
		setVisible(true);
		JPanel panel=new JPanel();
		JPanel pc=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		pc.setLayout(new GridLayout(5,2,50,40));

		JButton fcfs=new JButton("   FCFS ");
		fcfs.setBounds(10,10,30,10);
		JButton sjf=new JButton("    SJF   ");
		sjf.setBounds(10,10,30,10);
		JButton srtf=new JButton("   SRTF ");
		srtf.setBounds(10,10,30,10);
		JButton priority=new JButton("Priority");
		priority.setBounds(10,10,30,10);
		JSlider nop=new JSlider(1,10,1);
		ButtonGroup b=new ButtonGroup();
		for(int i=0;i<10;i++)
		{
			rb[i]=new JRadioButton(""+(i+1));
			b.add(rb[i]);
			pc.add(rb[i]);
		}
		fcfs.addActionListener(new ActionListener()
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
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		panel.add(srtf);
		panel.add(Box.createRigidArea(new Dimension(0,40)));
		panel.add(fcfs);
		panel.add(Box.createRigidArea(new Dimension(0,40)));
		panel.add(sjf);
		panel.add(Box.createRigidArea(new Dimension(0,40)));
		panel.add(priority);
		panel.add(Box.createRigidArea(new Dimension(0,40)));
		add(panel);
		add(pc);
	}
	
}
public class MiniProject
{
	public static void main(String [] args)
	{
		new Welcome();
	}
}