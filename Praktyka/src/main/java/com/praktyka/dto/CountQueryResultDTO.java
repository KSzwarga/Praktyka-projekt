package com.praktyka.dto;

public class CountQueryResultDTO {
    private String key;
    private Long count;

    public CountQueryResultDTO(String key, Long count) {
        this.key = key;
        this.count = count;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
