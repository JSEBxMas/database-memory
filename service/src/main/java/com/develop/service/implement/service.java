package com.develop.service.implement;

import com.develop.service.dto.request.RequestDto;
import com.develop.service.dto.response.ResponseDto;
import com.develop.service.persistence.Item;
import com.develop.service.persistence.ddatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class service {

    @Autowired
    ddatabase database;

    public ResponseDto crear (RequestDto requestDto){
        Item item = database.crear(new Item(requestDto.getId(), requestDto.getNombre(), requestDto.getEdad()));
        return ResponseDto.builder()
                .edad(item.getEdad())
                .id(item.getId())
                .nombre(item.getNombre())
                .build();
    }

    public List<ResponseDto> listarRegistros(){
        List<ResponseDto> reponse = new ArrayList<>();
        for(Item item : database.listar()){
            reponse.add(ResponseDto.builder()
                    .edad(item.getEdad())
                    .id(item.getId())
                    .nombre(item.getNombre())
                    .build());
        }
        return reponse;
    }

}
