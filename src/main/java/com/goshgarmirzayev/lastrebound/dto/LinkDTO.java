package com.goshgarmirzayev.lastrebound.dto;

public class LinkDTO {
    private Integer id;
    private String header;
    private String url;

    public LinkDTO(Integer id, String header, String url) {
        this.id = id;
        this.header = header;
        this.url = url;
    }

    public LinkDTO() {

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
