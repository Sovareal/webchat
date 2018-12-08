package com.infopulse.service.controllerservices;

import com.infopulse.converter.ChatUserConverter;
import com.infopulse.converter.ChatUserMapper;
import com.infopulse.dto.ChatUserDto;
import com.infopulse.service.dataservice.ChatUserDataService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ChatUserControllerService {

    private ChatUserDataService chatUserDataService;
    private ApplicationEventPublisher applicationEventPublisher;

    public ChatUserControllerService(ChatUserDataService chatUserDataService,
                                     ApplicationEventPublisher publisher){

        this.chatUserDataService = chatUserDataService;
        this.applicationEventPublisher = publisher;
    }
    //Converter Usage
    /*public void saveChatUser(ChatUserDto chatUserDto){
        ChatUserDto newChatUserDto = ChatUserConverter.convertFromEntity(
                chatUserDataService.createUser(ChatUserConverter.convertFromDto(chatUserDto)));

        newChatUserDto.setPassword(chatUserDto.getPassword());

        applicationEventPublisher.publishEvent(newChatUserDto);


    }*/

    public void saveChatUser(ChatUserDto chatUserDto){
        ChatUserDto newChatUserDto = ChatUserMapper.INSTANCE.chatUserToChatUserDto(
                chatUserDataService.createUser(ChatUserMapper.INSTANCE.chatUserDtoToChatUser(chatUserDto)));
        newChatUserDto.setPassword(chatUserDto.getPassword());

        applicationEventPublisher.publishEvent(newChatUserDto);
    }
    //Converter Usage
    /*public List<ChatUserDto> getAllUsers(){
        return ChatUserConverter
                .convertToListDto(chatUserDataService.getAllUsers());
    }*/

    public List<ChatUserDto> getAllUsers(){
        return ChatUserMapper.INSTANCE.chatUserToChatUserDto(chatUserDataService.getAllUsers());
    }
}
