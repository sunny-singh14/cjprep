package org.example.annotations;

@Command(value = "login", order = 1, description = "Login to the system")
public class LoginCommand {

    public void execute(Session session) {
        session.setActive(true);
    }
}
