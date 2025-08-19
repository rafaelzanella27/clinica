package com.estudos.clinica.gateway.cep.data.output;

import lombok.Data;

@Data
public class CepIntegrationOutput {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;

}
