package dependency;

public class NotificationService implements CustomerNotificationService {

	@Override
	public void alertCustomer(String mesg) {
		System.out.println("in cnstr of " +getClass().getName());

	}
	

}
