package com.temzu.messenger.controllers;

import com.temzu.messenger.core.interfaces.MessageService;
import com.temzu.messenger.model.Message;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

  private final MessageService messageService;

  @GetMapping
  public List<Message> getAllMessages() {
    return messageService.getAllMessages();
  }

  @GetMapping("/{id}")
  public Message getMessageById(@PathVariable Long id) {
    return messageService.getMessageById(id);
  }

  @PutMapping
  public Message saveMessage(Message message) {
    message.setId(null);
    return messageService.saveOrUpdateMessage(message);
  }

  @PostMapping
  public Message updateMessage(Message message) {
    return messageService.saveOrUpdateMessage(message);
  }

  @DeleteMapping("/{id}")
  public void deleteMessageById(@PathVariable Long id) {
    messageService.deleteMessageById(id);
  }


}
