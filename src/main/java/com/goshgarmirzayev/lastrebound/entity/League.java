package com.goshgarmirzayev.lastrebound.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "league")
public class League {
    @Id
    @NotNull
    @GeneratedValue
    private Integer id;
    @NotNull
    @Basic(optional = false)
    @Size(min = 0, max = 255)
    private String name;
    @OneToMany(mappedBy = "leagueId", fetch = FetchType.LAZY)
    private List<Match> matchList;

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    public League(@NotNull @Size(min = 0, max = 255) String name) {
        this.name = name;
    }

    public League() {
    }

    public League(@NotNull Integer id, @NotNull @Size(min = 0, max = 255) String name, @NotNull @Size(min = 0, max = 2000) String streamUrl) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
