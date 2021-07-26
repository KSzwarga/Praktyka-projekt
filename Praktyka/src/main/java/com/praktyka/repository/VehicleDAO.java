package com.praktyka.repository;


import com.praktyka.dto.CountQueryResultDTO;
import com.praktyka.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.List;


@Repository
public interface VehicleDAO extends CrudRepository<Vehicle, String>{
        List<Vehicle> findByColorCode(String colorCode);
        @Query("SELECT new  com.praktyka.dto.CountQueryResultDTO(cc.colorDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v JOIN v.colorCode cc JOIN c.caseTypeCode ct WHERE ct.caseTypeCode = :caseType GROUP BY cc.colorDescription")
        List<CountQueryResultDTO> colorForCaseType(@Param("caseType") String caseType);

        @Query("SELECT new  com.praktyka.dto.CountQueryResultDTO(v.brand, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v  JOIN c.caseTypeCode ct WHERE ct.caseTypeCode = :caseType GROUP BY v.brand")
        List<CountQueryResultDTO> brandForCaseType(@Param("caseType") String caseType);

        @Query("SELECT new  com.praktyka.dto.CountQueryResultDTO(CONCAT(v.brand, ',', v.model), COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v  JOIN c.caseTypeCode ct WHERE ct.caseTypeCode = :caseType GROUP BY v.brand, v.model")
        List<CountQueryResultDTO> modelForCaseType(@Param("caseType") String caseType);

        @Query("SELECT new  com.praktyka.dto.CountQueryResultDTO(function('to_char', c.filingDate, 'YYYY'), COUNT(c.caseNumber))" +
                " FROM Case c  JOIN c.caseTypeCode ct WHERE ct.caseTypeCode = :caseType GROUP BY function('to_char', c.filingDate, 'YYYY')")
        List<CountQueryResultDTO> yearForCaseType(@Param("caseType") String caseType);

        @Query("SELECT DISTINCT(cc.colorDescription) from Vehicle v JOIN v.colorCode cc")
        List<String> distinctColors();

        @Query("SELECT DISTINCT(v.brand) from Vehicle v")
        List<String> distinctBrands();

        @Query("SELECT DISTINCT v.brand, v.model from Vehicle v")
        List<String> distinctModels();

        @Query("SELECT DISTINCT function('to_char', c.filingDate, 'YYYY') from Case c")
        List<String> distinctYears();

        @Query("SELECT new com.praktyka.dto.CountQueryResultDTO(ct.caseTypeDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v JOIN v.colorCode cc JOIN c.caseTypeCode ct WHERE cc.colorDescription = :color GROUP BY ct.caseTypeDescription")
        List<CountQueryResultDTO> caseTypeForColor(@Param("color") String color);

        @Query("SELECT new com.praktyka.dto.CountQueryResultDTO(ct.caseTypeDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v JOIN c.caseTypeCode ct WHERE v.brand = :brand GROUP BY ct.caseTypeDescription")
        List<CountQueryResultDTO> caseTypeForBrand(@Param("brand") String brand);

        @Query("SELECT new com.praktyka.dto.CountQueryResultDTO(ct.caseTypeDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v JOIN c.caseTypeCode ct WHERE CONCAT(v.brand, ',', v.model) = :model  GROUP BY ct.caseTypeDescription")
        List<CountQueryResultDTO> caseTypeForModel(@Param("model") String model);

        @Query("SELECT new com.praktyka.dto.CountQueryResultDTO(ct.caseTypeDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.caseTypeCode ct WHERE function('to_char', c.filingDate, 'YYYY') =:year GROUP BY ct.caseTypeDescription")
        List<CountQueryResultDTO> caseTypeForYear(@Param("year") String year);

        @Query("SELECT new com.praktyka.dto.CountQueryResultDTO(ct.caseTypeDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v JOIN v.colorCode cc JOIN c.caseTypeCode ct WHERE cc.colorDescription = :color and function('to_char', c.filingDate, 'YYYY')= :year  GROUP BY ct.caseTypeDescription")
        List<CountQueryResultDTO> statisticsByYearByColor(@Param("year") String year, @Param("color") String color);

        @Query("SELECT new com.praktyka.dto.CountQueryResultDTO(ct.caseTypeDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v  JOIN c.caseTypeCode ct WHERE v.brand = :brand and function('to_char', c.filingDate, 'YYYY')= :year  GROUP BY ct.caseTypeDescription")
        List<CountQueryResultDTO> statisticsByYearByBrand(@Param("year") String year, @Param("brand") String brand);

        @Query("SELECT new com.praktyka.dto.CountQueryResultDTO(ct.caseTypeDescription, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v  JOIN c.caseTypeCode ct WHERE CONCAT(v.brand, ',', v.model) = :model and function('to_char', c.filingDate, 'YYYY')= :year  GROUP BY ct.caseTypeDescription")
        List<CountQueryResultDTO> statisticsByYearByModel(@Param("year") String year, @Param("model") String model);

}