package com.praktyka.dto;

import java.util.List;

public class StatisticQueryResultDTO {
    private String group;
    private List<CountQueryResultDTO> results;

    public StatisticQueryResultDTO(String group, List<CountQueryResultDTO> results) {
        this.group = group;
        this.results = results;
    }




    public List<CountQueryResultDTO> getResults() {
        return results;
    }

    public void setResults(List<CountQueryResultDTO> results) {
        this.results = results;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
