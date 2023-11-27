package com.example.springrestful_digitalorders.infrastructure.devis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/devis")
public class DevisControllerImpl implements DevisController{
}
