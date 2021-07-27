package com.praktyka;

import com.praktyka.dto.CaseDTO;
import com.praktyka.model.Case;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.typeMap(Case.class, CaseDTO.class)
                .addMappings(m -> m.map(src -> src.getCaseTypeCode().getCaseTypeCode(), CaseDTO::setCaseTypeCode));
        modelMapper.getConfiguration().setAmbiguityIgnored(false);
        return modelMapper;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
