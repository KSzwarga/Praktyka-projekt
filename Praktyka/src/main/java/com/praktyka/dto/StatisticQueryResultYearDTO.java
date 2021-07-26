package com.praktyka.dto;

import java.util.List;

public class StatisticQueryResultYearDTO {
    private String year;
    private List<StatisticQueryResultDTO> results;

    public StatisticQueryResultYearDTO(String year, List<StatisticQueryResultDTO> results) {
        this.year = year;
        this.results = results;
    }

    public List<StatisticQueryResultDTO> getResults() {
        return results;
    }

    public void setResults(List<StatisticQueryResultDTO> results) {
        this.results = results;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
