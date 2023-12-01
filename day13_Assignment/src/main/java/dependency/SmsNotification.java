package dependency;

public class SmsNotification implements CustomerNotificationService {

	@Override
	public void alertCustomer(String mesg) {
	System.out.println("sms : "+mesg+this.getClass());

	}

}
