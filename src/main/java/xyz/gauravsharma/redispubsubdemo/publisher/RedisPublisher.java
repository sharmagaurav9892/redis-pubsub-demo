package xyz.gauravsharma.redispubsubdemo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.gauravsharma.redispubsubdemo.entity.Product;

@RestController
public class RedisPublisher {

    @Autowired
    private RedisTemplate template;

    @Autowired
    private ChannelTopic channelTopic;

    @PostMapping("/publish")
    public String publish(@RequestBody Product product) {
        template.convertAndSend(channelTopic.getTopic(),product.toString());
        return "event published !!";
    }

}
