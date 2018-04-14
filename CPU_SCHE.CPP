#include<stdio.h>
#include<conio.h>
void srtf()
{
	clrscr();
	/****************************************************
	/////////////////////////////////////////////////////

	pc=> process no
	at=> arrival time
	bt=> burst time
	ct=> complition time
	tt=> turnaround time
	wt=> waiting time
	nop=> no. of process within current time
	******************************************************
	///////////////////////////////////////////////////////
	*/

	int count=0,i,pc[10],n,flag=0,at[10],temp4,bttemp[10],bt[10],ct[10],tt[10],wt[10],nop=0,j,index,min,temp1,temp2,temp3;
	float awt=0,att=0,act=0;
	printf("Enter no. of process:(max 10) ");
	scanf("%d",&n);
	clrscr();
	for(i=0;i<n;i++)
	{
		pc[i]=i+1;
		ct[i]=0;
	}
	for(i=0;i<n;i++)
	{
		pc[i]=i+1;
		ct[i]=0;
	}
	clrscr();
	printf("Enter arrival time: \n");
	for(i=0;i<n;i++)
	{
		printf("process %d: ",i+1);
		scanf("%d",&at[i]);
	}
	printf("Enter burst time: \n");
	for(i=0;i<n;i++)
	{
		printf("process %d: ",i+1);
		scanf("%d",&bt[i]);
		bttemp[i]=bt[i];
	}
	clrscr();

	/***************************
	Sorting process by arrival time
	************************************/

	for(i=0;i<n-1;i++)
		for(j=i+1;j<n;j++)
		{
		       if(at[i]>at[j])
		       {
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
	getch();
	/**************************************
	sort by arrival then by bursttime  for same bt time
	*****************************************/

	for(i=0;i<n-1;i++)
		for(j=i+1;j<n;j++)
		{
		       if(at[i]>at[j])
		       {
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
		}

	for(i=0;i<n-1;i++)
		for(j=i+1;j<n;j++)
		{
		       if(bt[i]>bt[j])
		       {
				temp4=pc[i];
				pc[i]=pc[j];
				pc[j]=temp4;
				temp1=bt[i];
				bt[i]=bt[j];
				bt[j]=temp1;
				temp2=ct[i];
				ct[i]=ct[j];
				ct[j]=temp2;
				temp3=at[i];
				at[i]=at[j];
				at[j]=temp3;
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
				temp1=bt[i];
				bt[i]=bt[j];
				bt[j]=temp1;
				temp2=ct[i];
				ct[i]=ct[j];
				ct[j]=temp2;
				temp3=at[i];
				at[i]=at[j];
				at[j]=temp3;
				temp4=pc[i];
				pc[i]=pc[j];
				pc[j]=temp4;
		       }
		}

	clrscr();
	for(i=0;i<n;i++)
		tt[i]=ct[i]-at[i];
	for(i=0;i<n;i++)
		wt[i]=tt[i]-bttemp[i];
	for(i=0;i<n;i++)
	{
		awt+=wt[i];
		att+=at[i];
		act+=ct[i];
	}
	act/=n;
	awt/=n;
	att/=n;
	printf("**************************************************\n");
	printf("**********Shortest Remaining Time First***********\n");
	printf("**************************************************\n\n");
	printf("process || arrival time || burst time||complition || turnarount || waiting time\n");
	for(i=0;i<n;i++)
		printf("%d\t\t%d\t\t%d     \t%d\t\t%d\t   %d\n",pc[i],at[i],bttemp[i],ct[i],tt[i],wt[i]);
	printf("Average: \t\t\t     \t%f\t%f   %f",act,att,awt);
	getch();

}
void sjf()
{
	clrscr();
	/****************************************************
	/////////////////////////////////////////////////////

	pc=> process no
	at=> arrival time
	bt=> burst time
	ct=> complition time
	tt=> turnaround time
	wt=> waiting time
	nop=> no. of process within current time
	******************************************************
	///////////////////////////////////////////////////////
	*/

	int count=0,i,pc[10],n,temp4,bttemp[10],bt[10],ct[10],tt[10],wt[10],j,index,min,temp1,temp2,temp3;
	float awt=0,att=0,act=0;
	printf("Enter no. of process:(max 10) ");
	scanf("%d",&n);
	clrscr();
	printf("Enter Burst time: \n");
	for(i=0;i<n;i++)
	{
		pc[i]=i+1;
		ct[i]=0;
	}
	for(i=0;i<n;i++)
	{
		printf("process %d: ",i+1);
		scanf("%d",&bt[i]);
		bttemp[i]=bt[i];
	}
	clrscr();

	for(i=0;i<n-1;i++)
		for(j=i+1;j<n;j++)
		{
		       if(bt[i]>bt[j])
		       {
				temp4=pc[i];
				pc[i]=pc[j];
				pc[j]=temp4;
				temp1=bt[i];
				bt[i]=bt[j];
				bt[j]=temp1;
				temp2=ct[i];
				ct[i]=ct[j];
				ct[j]=temp2;
		       }
		}

	for(i=0;i<n;i++)
		while(bt[i]>0)
		{
			bt[i]=bt[i]-1;
			count=count+1;
			ct[i]=count;
		}
	getch();

	for(i=0;i<n-1;i++)
		for(j=i+1;j<n;j++)
		{
		       if(pc[i]>pc[j])
		       {
				temp1=bt[i];
				bt[i]=bt[j];
				bt[j]=temp1;
				temp2=ct[i];
				ct[i]=ct[j];
				ct[j]=temp2;
				temp4=pc[i];
				pc[i]=pc[j];
				pc[j]=temp4;
		       }
		}

	clrscr();
	for(i=0;i<n;i++)
		tt[i]=ct[i];
	for(i=0;i<n;i++)
		wt[i]=tt[i]-bttemp[i];
	for(i=0;i<n;i++)
	{
		att+=tt[i];
		awt+=wt[i];
		act+=ct[i];
	}
	att/=n;
	act/=n;
	awt/=n;
	printf("**************************************************\n");
	printf("****************Shortest Job First****************\n");
	printf("**************************************************\n\n");
	printf("process  ||  tburst time  ||  complition  ||  turnarount  ||  waiting time\n");
	for(i=0;i<n;i++)
		printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n",pc[i],bttemp[i],ct[i],tt[i],wt[i]);
	printf("Average:   \t\t\t%f\t%f\t%f",act,att,awt);
	getch();
}

void fcfs()
{       clrscr();
	int at[10],bt[10],ct[10],tt[10],wt[10],n,i,x=0;
	float awt=0,att=0,act=0;
	printf("Enter no of process: ");
	scanf("%d",&n);
	printf("Enter arival time\n");
	for(i=0;i<n;i++)
		scanf("%d",&at[i]);
	printf("Enter burst time\n");
	for(i=0;i<n;i++)
		scanf("%d",&bt[i]);
	clrscr();
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
	printf("**************************************************\n");
	printf("************* First Come First Serve *************\n");
	printf("**************************************************\n\n");
	printf("Process\tat\tbt\tct\ttt\twt\n");
	for(i=0;i<n;i++)
		printf("%d\t%d  \t%d\t%d\t%d\t%d\n",i,at[i],bt[i],ct[i],tt[i],wt[i]);
	for(i=0;i<n;i++)
	{
		awt+=wt[i];
		att+=tt[i];
		act+=ct[i];
	}
	awt/=n;
	att/=n;
	act/=n;
	printf("average= \t\t%.2f\t%.2f\t%.2f",act,att,awt);
	getch();
}
void prior()
{
	clrscr();
	/****************************************************
	/////////////////////////////////////////////////////

	pc=> process no
	at=> arrival time
	bt=> burst time
	ct=> complition time
	tt=> turnaround time
	wt=> waiting time
	nop=> no. of process within current time
	******************************************************
	///////////////////////////////////////////////////////
	*/

	int count=0,i,pc[10],n,pt[10],temp,flag=0,at[10],temp4,bttemp[10],bt[10],ct[10],tt[10],wt[10],nop=0,j,index,min,temp1,temp2,temp3;
	float awt=0,att=0,act=0;
	printf("Enter no. of process:(max 10) ");
	scanf("%d",&n);
	clrscr();
	for(i=0;i<n;i++)
	{
		pc[i]=i+1;
		ct[i]=0;
	}
	printf("Enter priority\n");
	for(i=0;i<n;i++)
	{
		printf("Process %d: ",i+1);
		scanf("%d",&pt[i]);

	}
	printf("Enter arrival time\n");
	for(i=0;i<n;i++)
	{
		printf("Process %d: ",i+1);
		scanf("%d",&at[i]);

	}
	printf("Enter burst time\n");
	for(i=0;i<n;i++)
	{
		printf("Process %d: ",i+1);
		scanf("%d",&bt[i]);
		bttemp[i]=bt[i];
	}
	clrscr();

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
		else{
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
	getch();
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
				temp4=pc[i];
				pc[i]=pc[j];
				pc[j]=temp4;
				temp1=bt[i];
				bt[i]=bt[j];
				bt[j]=temp1;
				temp2=ct[i];
				ct[i]=ct[j];
				ct[j]=temp2;
				temp3=at[i];
				at[i]=at[j];
				at[j]=temp3;
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
				temp1=bt[i];
				bt[i]=bt[j];
				bt[j]=temp1;
				temp2=ct[i];
				ct[i]=ct[j];
				ct[j]=temp2;
				temp3=at[i];
				at[i]=at[j];
				at[j]=temp3;
				temp4=pc[i];
				pc[i]=pc[j];
				pc[j]=temp4;
				temp=pt[i];
				pt[i]=pt[j];
				pt[j]=temp;
		       }
		}

	clrscr();
	for(i=0;i<n;i++)
		tt[i]=ct[i]-at[i];
	for(i=0;i<n;i++)
		wt[i]=tt[i]-bttemp[i];
	for(i=0;i<n;i++)
	{
		att+=tt[i];
		awt+=wt[i];
		act+=ct[i];
	}
	att/=n;
	act/=n;
	awt/=n;
	printf("**************************************************\n");
	printf("*************** Priority Scheduler ***************\n");
	printf("**************************************************\n\n");
	printf("process || priority || arrival || burst||complition||turnaround||waiting\n");
	for(i=0;i<n;i++)
		printf("%d\t\t%d\t%d  \t   %d    \t%d    \t%d\t   %d\n",pc[i],pt[i],at[i],bttemp[i],ct[i],tt[i],wt[i]);
	printf("Average:   \t\t\t\t%f\t%f  %f",act,att,awt);
	getch();

}

void main()
{
	clrscr();
	int ch;
	printf("**************************************************\n");
	printf("***************** CPU Scheduler ******************\n");
	printf("**************************************************\n\n");
	printf("1: First Come First Serve\n");
	printf("2: Shortest Job First\n");
	printf("3: Shortest Remaining Time First\n");
	printf("4: Priority Scheduling\n\n");
	printf("Enter choice: ");
	scanf("%d",&ch);
	switch(ch)
	{
		case 1: fcfs();
			break;
		case 2: sjf();
			break;
		case 3: srtf();
			break;
		case 4: prior();
			break;
		default: printf("Enter correct choice ");
	}
}