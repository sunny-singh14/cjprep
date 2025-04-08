package org.example.annotations;

@Command(value = "logout", order = 2, description = "Logout from the system")
public class LogoutCommand {

    public void execute(Session session) {
        session.setActive(false);
    }
}
