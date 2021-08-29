package com.temzu.messenger.core.interfaces;

import com.temzu.messenger.model.Message;
import java.util.List;

public interface MessageService {

  List<Message> getAllMessages();

  Message getMessageById(Long id);

  Message saveOrUpdateMessage(Message message);

  void deleteMessageById(Long id);
}
