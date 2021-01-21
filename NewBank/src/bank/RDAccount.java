package bank;

public class RDAccount extends Account{
double interestRate,amount,monthlyamount;
int months,age;
public RDAccount(double amount,int months,int age)
{
	this.amount=amount;
	this.months=months;
	this.age=age;
}
double calculateInterest()
{
	if(months<=6)
	{
		if(age<50)
		interestRate=(7.50/(double)100)*amount;
		else
			interestRate=(8.00/(double)100)*amount;
	}
	if(months>6 && months<=9)
	{

		if(age<50)
		interestRate=(7.75/(double)100)*amount;
		else
			interestRate=(8.25/(double)100)*amount;
	}if(months>9 && months<=12)
	{

		if(age<50)
		interestRate=(8.00/(double)100)*amount;
		else
			interestRate=(8.50/(double)100)*amount;
	}
	if(months>12 && months<=15)
	{

		if(age<50)
		interestRate=(8.25/(double)100)*amount;
		else
			interestRate=(8.75/(double)100)*amount;
	}
	if(months>15 && months<=18)
	{

		if(age<50)
		interestRate=(8.50/(double)100)*amount;
		else
			interestRate=(9.00/(double)100)*amount;
	}
	if(months>18 && months<=21)
	{

		if(age<50)
		interestRate=(8.75/(double)100)*amount;
		else
			interestRate=(9.25/(double)100)*amount;
	}

return interestRate;
}}
