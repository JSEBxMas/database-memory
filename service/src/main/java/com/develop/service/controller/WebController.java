package com.develop.service.controller;


import com.develop.service.dto.request.RequestDto;
import com.develop.service.dto.response.ResponseDto;
import com.develop.service.implement.service;
import com.develop.service.persistence.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicememoria")
public class WebController {

    @Autowired
    service service;

    @GetMapping("/obtner")
    public ResponseEntity<List<ResponseDto>> obtener() {
        return  ResponseEntity.ok(service.listarRegistros());
    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseDto> obtener(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(service.crear(requestDto));
    }


}
