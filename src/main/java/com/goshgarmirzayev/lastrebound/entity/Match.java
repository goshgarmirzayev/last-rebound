/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goshgarmirzayev.lastrebound.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Goshgar
 */
@Entity
@Table(name = "oyun")
@XmlRootElement
public class Match implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "header")
    private String header;
    @Basic(optional = false)
    @NotNull
    @Column(name = "begin_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;
    @OneToMany(mappedBy = "matchId", fetch = FetchType.LAZY)
    private List<Link> linkList;
    @NotNull
    @Column(name = "link_opened_time")
    private Date linkOpenedTime;
    @JoinColumn(name = "league_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private League leagueId;

    public League getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(League leagueId) {
        this.leagueId = leagueId;
    }

    public Date getLinkOpenedTime() {
        return linkOpenedTime;
    }

    public void setLinkOpenedTime(Date linkOpenedTime) {
        this.linkOpenedTime = linkOpenedTime;
    }

    public Match() {
    }

    public Long getTime() {
        return beginDate.getTime();
    }


    public Match(Integer id) {
        this.id = id;
    }

    public Match(Integer id, String header, Date beginDate) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
    }


    public Match(String header, Date beginDate, Date linkOpenedTime) {
        this.header = header;
        this.beginDate = beginDate;
        this.linkOpenedTime = linkOpenedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @XmlTransient
    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "az.onbir.tv.entity.Match[ id=" + id + " ]";
    }
}
