package dependent;

import dependency.CustomerNotificationService;
import dependency.HttpTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private double cash;// preemitive type value
	private CustomerNotificationService cns;

	

	public ATMImpl(double cash12) {

		this.cash = cash12;
		System.out.println("in cnstr of" + getClass().getName() + " " + myTransport + " ");
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling dependency's method to inform the bank
		cns.alertCustomer("money credited!!!");
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
		cns.alertCustomer("money debited!!!");
	}
	// setter : setter Based D.I

	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter " + this.myTransport);
	}

	public void setCns(CustomerNotificationService cns) {
		System.out.println("in setter cns");
		this.cns = cns;
	}

	

	

	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
