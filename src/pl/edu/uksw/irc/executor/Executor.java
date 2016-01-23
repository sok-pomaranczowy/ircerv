package pl.edu.uksw.irc.executor;

import pl.edu.uksw.irc.dto.MessageDTO;
import pl.edu.uksw.irc.queue.EventBus;

/**
 * Created by sok_pomaranczowy on 23.01.16.
 */
public class Executor implements Runnable {

    private EventBus eventBus;

    public Executor(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void run() {
        while (true) {
            MessageDTO incomingEvent = eventBus.getIncomingEvent();

            switch()

            MessageDTO outgoingMessage = null;
            eventBus.pushOutgoingEvent(outgoingMessage);
        }
    }
}