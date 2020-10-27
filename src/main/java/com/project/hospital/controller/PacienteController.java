package com.project.hospital.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/paciente", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {

}
