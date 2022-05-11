package com.example.demo.mapper;

import com.example.demo.dto.ConnRequestDTO;
import com.example.demo.dto.ConnResponseDTO;
import com.example.demo.model.ConnModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ConnMapper {

    ConnRequestDTO modelConnRequestDto(ConnModel connModel);

    List<ConnRequestDTO> modelConnRequestDtoList(List<ConnModel> connModelList);

    ConnModel requestConnModel(ConnRequestDTO connRequestDTO);

    List<ConnModel> requestConnModelList(List<ConnModel> connModelList);

    @Mapping(target = "parent",source = "connModel.user.identity")
    ConnResponseDTO modelConnResponseDto(ConnModel connModel);

    List<ConnResponseDTO> modelConnResponseDtoList(List<ConnModel> connModelList);

    ConnModel responseConnModel(ConnResponseDTO connResponseDTO);

    List<ConnModel> responseConnModelList(List<ConnModel> connModelList);
}
