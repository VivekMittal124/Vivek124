package bank;

public class SBAccount extends Account{
	double interestRate,amount;
	String type;
	public SBAccount(String type,double amount)
	{
		this.type=type;
		this.amount=amount;
	}
	String str="Normal";
	double calculateInterest()
	{
		if(type.equals(str))
			interestRate=((double)4/100)*amount;
		else
			interestRate=((double)6/100)*amount;
		return interestRate;
	}

}
