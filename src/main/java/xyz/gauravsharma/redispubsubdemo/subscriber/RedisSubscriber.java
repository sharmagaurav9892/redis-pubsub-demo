package xyz.gauravsharma.redispubsubdemo.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisSubscriber implements MessageListener {


    @Override
    public void onMessage(Message message, byte[] bytes) {
        log.info("Consumed event : {}",message);
    }
}
