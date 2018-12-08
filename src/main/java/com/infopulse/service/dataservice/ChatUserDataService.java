package com.infopulse.service.dataservice;

import com.infopulse.entity.ChatUser;
import com.infopulse.exception.AlreadyExistException;
import com.infopulse.repository.ChatUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChatUserDataService {

    private ChatUserRepository chatUserRepository;

    public ChatUserDataService(ChatUserRepository chatUserRepository) {
        this.chatUserRepository = chatUserRepository;
    }

    public ChatUser createUser(ChatUser chatUser) {
        chatUser.setLastVisit(new Date());
        ChatUser dataBaseChatUser = chatUserRepository.findByLogin(chatUser.getLogin());
        if (dataBaseChatUser != null) {

            throw new AlreadyExistException("Login already exists");
        }

        return chatUserRepository.save(chatUser);
    }

    public List<ChatUser> getAllUsers() {
        return chatUserRepository.findAll()
                .stream()
                .filter(entity -> notAdmin(entity.getLogin()))
                .collect(Collectors.toList());
    }

    private boolean notAdmin(String login) {
        //todo
        return false;
    }
}
