package com.infopulse.converter;

import com.infopulse.dto.ChatUserDto;
import com.infopulse.entity.ChatUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChatUserMapper {

    ChatUserMapper INSTANCE = Mappers.getMapper(ChatUserMapper.class);

    @Mapping(source = "ban", target = "isBanned")
    ChatUserDto chatUserToChatUserDto(ChatUser chatUser);

    @Mapping(source = "isBanned", target = "ban")
    ChatUser chatUserDtoToChatUser(ChatUserDto chatUserDto);

    @Mapping(source = "isBanned", target = "ban")
    List<ChatUserDto> chatUserToChatUserDto(List<ChatUser> chatUser);

}
