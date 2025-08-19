package com.estudos.clinica.gateway.cep;

import com.estudos.clinica.gateway.cep.data.output.CepIntegrationOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "buscaCep", url = "${gateway.busca-cep.url}")
public interface BuscaCepGateway {

    @GetMapping("/api/cep/v1/{cep}")
    CepIntegrationOutput validarCep(@PathVariable String cep);
}
