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

        /*
        FilesManagement dataBase = new FilesManagement("C:\\Users\\kacper.szwarga\\Desktop\\Skrypty");
        String testFile = "Test.txt";
        dataBase.createFile(testFile,"Some content");
        dataBase.exists(testFile);
        dataBase.info(testFile);
        dataBase.readFile(testFile);
        dataBase.info("10/10/2021","07/07/2021");
        */
    }
}
