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
                " FROM Case c JOIN c.vehicleId v JOIN v.colorCode cc WHERE c.caseType = :caseType GROUP BY cc.colorDescription")
        List<CountQueryResultDTO> colorForCaseType(@Param("caseType") String caseType);

        @Query("SELECT new  com.praktyka.dto.CountQueryResultDTO(v.brand, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v WHERE c.caseType = :caseType GROUP BY v.brand")
        List<CountQueryResultDTO> brandForCaseType(@Param("caseType") String caseType);

        @Query("SELECT new  com.praktyka.dto.CountQueryResultDTO(v.brand, v.model, COUNT(c.caseNumber))" +
                " FROM Case c JOIN c.vehicleId v WHERE c.caseType = :caseType GROUP BY v.brand, v.model")
        List<CountQueryResultDTO> modelForCaseType(@Param("caseType") String caseType);

        @Query("SELECT new  com.praktyka.dto.CountQueryResultDTO(function('to_char', c.filingDate, 'YYYY'), COUNT(c.caseNumber))" +
                " FROM Case c WHERE c.caseType = :caseType GROUP BY function('to_char', c.filingDate, 'YYYY')")
        List<CountQueryResultDTO> yearForCaseType(@Param("caseType") String caseType);


}