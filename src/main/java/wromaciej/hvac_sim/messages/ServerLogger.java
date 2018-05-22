package wromaciej.hvac_sim.messages;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Logger used for saving all actions done by all users
 */

@Component
public class ServerLogger implements Logger {
    @Override
    public void log(Date date, String message) {

    }
}
