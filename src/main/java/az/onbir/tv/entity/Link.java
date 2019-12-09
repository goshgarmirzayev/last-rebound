/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.onbir.tv.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Goshgar
 */
@Entity
@Table(name = "link")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Link.findAll", query = "SELECT l FROM Link l")
        , @NamedQuery(name = "Link.findById", query = "SELECT l FROM Link l WHERE l.id = :id")
        , @NamedQuery(name = "Link.findByHeader", query = "SELECT l FROM Link l WHERE l.header = :header")
        , @NamedQuery(name = "Link.findByUrl", query = "SELECT l FROM Link l WHERE l.url = :url")})
public class Link implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;

    @Column(name = "width")
    private int iframeWidth;
    @Column(name = "height")
    private int iframeHeight;
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Match matchId;

    public int getIframeWidth() {
        return iframeWidth;
    }

    public void setIframeWidth(int iframeWidth) {
        this.iframeWidth = iframeWidth;
    }

    public int getIframeHeight() {
        return iframeHeight;
    }

    public void setIframeHeight(int iframeHeight) {
        this.iframeHeight = iframeHeight;
    }

    public Link() {
    }

    public Link(Integer id) {
        this.id = id;
    }

    public Link(Integer id, String header, String url) {
        this.id = id;
        this.header = header;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Match getMatchId() {
        return matchId;
    }

    public void setMatchId(Match matchId) {
        this.matchId = matchId;
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
        if (!(object instanceof Link)) {
            return false;
        }
        Link other = (Link) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "az.onbir.tv.entity.Link[ id=" + id + " ]";
    }

}
