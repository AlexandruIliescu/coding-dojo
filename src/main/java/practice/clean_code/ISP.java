package practice.clean_code;

public class ISP {
}


interface EmailServiceIsp {
    void sendEmail(String recipient, String message);
}

interface SMSService {
    void sendSMS(String recipient, String message);
}

interface PushNotificationService {
    void sendPushNotification(String recipient, String message);
}

class NotificationService implements EmailServiceIsp, SMSService {
    private EmailServiceIsp emailService;
    private SMSService smsService;

    public NotificationService(EmailServiceIsp emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @Override
    public void sendEmail(String recipient, String message) {
        emailService.sendEmail(recipient, message);
    }

    @Override
    public void sendSMS(String recipient, String message) {
        smsService.sendSMS(recipient, message);
    }
}

// Client code example
class ExampleClientIsp {
    private EmailServiceIsp emailService;
    private SMSService smsService;

    ExampleClientIsp(EmailServiceIsp emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    void processNotification(String recipient, String message) {
        emailService.sendEmail(recipient, message);
        smsService.sendSMS(recipient, message);
    }
}
