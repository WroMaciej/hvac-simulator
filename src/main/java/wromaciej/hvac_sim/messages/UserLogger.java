package wromaciej.hvac_sim.messages;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Logger used for saving all actions of actual model
 */

@Component
public class UserLogger implements Logger {
    @Override
    public void log(Date date, String message) {

    }
}
