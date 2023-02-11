package io.github.matgalv2.numberconverter.controller;

import io.github.matgalv2.numberconverter.dto.Data;
import io.github.matgalv2.numberconverter.serivice.NumberConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class NumberConverterController {

    private final NumberConverterService numberConverterService;

    @GetMapping("/convert")
    public ResponseEntity<?> getConvertedNumber(@Valid @RequestBody Data data) {
        return numberConverterService
                .convertNumber(data)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
