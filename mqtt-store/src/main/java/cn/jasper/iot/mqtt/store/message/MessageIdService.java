package cn.jasper.iot.mqtt.store.message;

import cn.jasper.iot.mqtt.common.message.IMessageIdService;
import cn.jasper.iot.mqtt.store.cache.MessageIdCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息ID操作
 */
@Service
public class MessageIdService implements IMessageIdService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageIdService.class);

    @Autowired
    private MessageIdCache messageIdCache;

    @Override
    public int getNextMessageId() {
        return messageIdCache.getNextMessageId();
    }

    @Override
    public void releaseMessageId(int messageId) {
        //释放报文ID，未实现
    }

    /**
     * 每次重启的时候初始化
     */
    public void init() {
        messageIdCache.cleanMessageId();
    }
}
