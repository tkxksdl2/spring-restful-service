package com.tkxksdl2.rest.webservices.restfulwebservice.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2", "value3", "value4");
    }

    @GetMapping("/filtering/dynamic")
    @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SomeBean.class))})
    public MappingJacksonValue filterDynamic(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field4");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
