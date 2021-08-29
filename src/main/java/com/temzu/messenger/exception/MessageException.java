package com.temzu.messenger.exception;

public class MessageException extends RuntimeException {

  private static final String MESSAGE_NOT_FOUND = "Message: with id %d not found";
  private static final String BAD_MESSAGE_ID = "id: %d, id should be greater than 0";

  public MessageException(String message) {
    super(message);
  }

  public static MessageException messageNotFound(Long id) {
    return new MessageException(String.format(MESSAGE_NOT_FOUND, id));
  }

  public static MessageException badMessageId(Long id) {
    return new MessageException(String.format(BAD_MESSAGE_ID, id));
  }
}
