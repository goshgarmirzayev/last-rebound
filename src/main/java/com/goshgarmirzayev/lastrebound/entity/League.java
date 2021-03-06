package com.goshgarmirzayev.lastrebound.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
/**
 *
 * @author Goshgar
 *
 */
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
    @Basic(optional = true)
    @Size(min = 0, max = 1000)
    private String logoUrl;
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public League(@NotNull @Size(min = 0, max = 255) String name, @Size(min = 0, max = 1000) String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public League() {
    }

    public League(@NotNull Integer id, @NotNull @Size(min = 0, max = 255) String name, @NotNull @Size(min = 0, max = 1000) String logoUrl) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
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

    public String getLogoUrl() {
        return this.logoUrl;
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
