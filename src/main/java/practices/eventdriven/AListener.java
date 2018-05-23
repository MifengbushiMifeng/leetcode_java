package practices.eventdriven;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AListener implements ApplicationListener<ContentEvent> {

    @Override
    public void onApplicationEvent(ContentEvent contentEvent) {

        System.out.println("Received the content!");

    }
}
