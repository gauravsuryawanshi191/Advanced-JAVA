package dependency;

public class EmailNotification implements CustomerNotificationService {

	@Override
	public void alertCustomer(String mesg) {
	System.out.println("EMAIL : "+mesg);

	}

}
