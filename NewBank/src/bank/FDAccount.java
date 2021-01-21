package bank;

public class FDAccount extends Account {
	double interestRate,amount;
	int days;
	int age;
	public FDAccount(double amount,int days,int age)
	{
		this.amount=amount;
		this.days=days;
		this.age=age;
	}
	double calculateInterest() {
		if(amount<10000000)
		{
			if(days>=7 && days<=14)
			{
				if(age<50)
					interestRate=(4.50*amount)/(double)100;
				else
					interestRate=(5.00*amount)/(double)100;	
			}
			if(days>=15 && days<=29)
			{
				if(age<50)
					interestRate=(4.75*amount)/(double)100;
				else
					interestRate=(5.25*amount)/(double)100;	
			}
			if(days>=30 && days<=45)
			{
				if(age<50)
					interestRate=(5.50*amount)/(double)100;
				else
					interestRate=(6.00*amount)/(double)100;	
			}
			if(days>=45 && days<=60)
			{
				if(age<50)
					interestRate=(7.00*amount)/(double)100;
				else
					interestRate=(7.50*amount)/(double)100;	
			}
			if(days>=61 && days<=184)
			{
				if(age<50)
					interestRate=(7.50*amount)/(double)100;
				else
					interestRate=(8.00*amount)/(double)100;	
			}
			if(days>=185 && days<=365)
			{
				if(age<50)
					interestRate=(8.00*amount)/(double)100;
				else
					interestRate=(8.50*amount)/(double)100;	
			}
		}
		return interestRate;
	}

}
