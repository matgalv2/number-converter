package io.github.matgalv2.numberconverter.controller;

import io.github.matgalv2.numberconverter.dto.Data;
import io.github.matgalv2.numberconverter.service.NumberConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class NumberConverterController {

    private final NumberConverterService numberConverterService;

    @PostMapping("/convert")
    public ResponseEntity<?> getConvertedNumber(@Valid @RequestBody Data data) {
        return numberConverterService
                .convertNumber(data)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
