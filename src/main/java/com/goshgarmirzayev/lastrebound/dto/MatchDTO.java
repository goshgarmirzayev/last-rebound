package com.goshgarmirzayev.lastrebound.dto;

import org.hibernate.exception.DataException;

import java.util.Date;

public class MatchDTO {
    private Integer id;
    private String name;
    private Date begindate;

    public MatchDTO(Integer id, String name, Date begindate) {
        this.id = id;
        this.name = name;
        this.begindate = begindate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }
}
