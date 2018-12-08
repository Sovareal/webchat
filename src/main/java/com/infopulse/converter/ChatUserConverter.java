package com.infopulse.converter;

import com.infopulse.dto.ChatUserDto;
import com.infopulse.entity.ChatUser;

import java.util.List;
import java.util.stream.Collectors;

public class ChatUserConverter {

    public static ChatUser convertFromDto(ChatUserDto dto) {
        ChatUser user = new ChatUser();
        user.setName(dto.getName());
        user.setLogin(dto.getLogin());
        return user;
    }

    public static ChatUserDto convertFromEntity(ChatUser user) {
        ChatUserDto dto = new ChatUserDto();
        dto.setLogin(user.getLogin());
        dto.setName(user.getName());
        dto.setIsBanned(user.getBan() != null);
        return dto;
    }

    public static List<ChatUserDto> convertToListDto(List<ChatUser> users) {
        return users.stream()
                .map(entity -> convertFromEntity(entity))
                .collect(Collectors.toList());
    }
}
