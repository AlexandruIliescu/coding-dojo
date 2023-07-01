package practice.clean_code;

public class SRP {
}

// UserAuthenticationService handles user authentication logic
class UserAuthenticationService {
    boolean authenticateUser(String username, String password) {
        // Authentication logic here
        return false;
    }
}

// EmailService handles sending notification emails
class EmailService {
    void sendNotificationEmail(String recipient, String message) {
        // Email sending logic here
    }
}

// Client code example
class ExampleClient {
    private UserAuthenticationService authService;
    private EmailService emailService;

    ExampleClient() {
        authService = new UserAuthenticationService();
        emailService = new EmailService();
    }

    void processLogin(String username, String password) {
        if (authService.authenticateUser(username, password)) {
            String message = "Login successful";
            emailService.sendNotificationEmail(username, message);
        } else {
            String message = "Login failed";
            emailService.sendNotificationEmail(username, message);
        }
    }
}
