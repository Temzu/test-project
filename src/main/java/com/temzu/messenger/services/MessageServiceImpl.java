package com.temzu.messenger.services;

import com.temzu.messenger.core.interfaces.MessageService;
import com.temzu.messenger.exception.MessageException;
import com.temzu.messenger.model.Message;
import com.temzu.messenger.repositories.MessageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

  private final MessageRepository messageRepository;

  @Override
  public List<Message> getAllMessages() {
    return messageRepository.findAll();
  }

  @Override
  public Message getMessageById(Long id) {
    checkId(id);
    return messageRepository.findById(id).orElseThrow(() -> MessageException.messageNotFound(id));
  }

  @Override
  public Message saveOrUpdateMessage(Message message) {
    if (message.getId() != null) checkId(message.getId());
    return messageRepository.save(message);
  }

  @Override
  public void deleteMessageById(Long id) {
    checkId(id);
    messageRepository.deleteById(id);
  }

  private void checkId(Long id) {
    if (id <= 0) throw MessageException.badMessageId(id);
  }
}
