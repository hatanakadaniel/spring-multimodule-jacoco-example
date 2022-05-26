package com.hatanaka.springmultimodulejacocoexample.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hatanaka.springmultimodulejacocoexample.domain.DomainB;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class StepDefinition {

    private final TestRestTemplate testRestTemplate;
    private final ObjectMapper objectMapper;
    private RequestEntity.BodyBuilder bodyBuilder;
    private ResponseEntity<DomainB> responseEntity;
    private Map<String, List<String>> uriVariables = new HashMap<>();

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(final Object fromValue, final Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

    @When("chamar um {string} para {string}")
    public void chamarUmPara(final String method, final String path) {
        final URI uri = UriComponentsBuilder.fromPath(path).queryParams(CollectionUtils.toMultiValueMap(uriVariables)).build().toUri();
        bodyBuilder = RequestEntity.method(HttpMethod.resolve(method), uri);
        responseEntity = testRestTemplate.exchange(bodyBuilder.build(), DomainB.class);
    }

    @Then("deve retornar {int}")
    public void deveRetornar(int httpStatus) {
        Assertions.assertThat(responseEntity.getStatusCode().value()).isEqualTo(httpStatus);
    }

    @Given("uma request para feature um com parametros")
    public void umaRequestParaFeatureUmComParametros(final Map<String, List<String>> queryParametes) {
        uriVariables.putAll(queryParametes);
    }

    @And("a resposta deve ser")
    public void aRespostaDeveSer(final DomainB domainB) {
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(domainB);
    }
}
