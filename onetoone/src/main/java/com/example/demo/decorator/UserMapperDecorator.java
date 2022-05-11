package com.example.demo.decorator;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserModel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserMapperDecorator implements UserMapper {

    @Setter(onMethod = @__({@Autowired}))
    private UserMapper mapper;


    @Override
    public UserRequestDTO modelUserRequestDto(UserModel userModel) {
        return mapper.modelUserRequestDto(userModel);
    }

    @Override
    public List<UserRequestDTO> modelUserRequestDtoList(List<UserModel> userModelList) {
        return mapper.modelUserRequestDtoList(userModelList);
    }

    @Override
    public UserModel requestUserModel(UserRequestDTO userRequestDTO) {
        return mapper.requestUserModel(userRequestDTO);
    }

    @Override
    public List<UserModel> requestUserModelList(List<UserRequestDTO> userRequestDTOList) {
        return mapper.requestUserModelList(userRequestDTOList);
    }

    @Override
    public UserResponseDTO modelUserResponseDto(UserModel userModel) {
        UserResponseDTO userResponseDTO = mapper.modelUserResponseDto(userModel);
        userResponseDTO.getConn().setParent(userModel.getIdentity());
        return userResponseDTO;
    }



    @Override
    public List<UserResponseDTO> modelUserResponseDtoList(List<UserModel> userModelList) {
        List<UserResponseDTO> list = new ArrayList<>();
        for(UserModel dto:userModelList)
            list.add(modelUserResponseDto(dto));
        return list;
    }

    @Override
    public UserModel responseUserModel(UserResponseDTO userResponseDTO) {
        return mapper.responseUserModel(userResponseDTO);
    }

    @Override
    public List<UserModel> responseUserModelList(List<UserResponseDTO> userResponseDTOList) {
        return mapper.responseUserModelList(userResponseDTOList);
    }

    @Override
    public void modelRequestUserModel(UserModel userModel, UserRequestDTO userRequestDTO) {
        mapper.modelRequestUserModel(userModel, userRequestDTO);
    }
}
