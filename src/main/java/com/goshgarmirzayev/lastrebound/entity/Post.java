/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goshgarmirzayev.lastrebound.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Goshgar
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
        , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
        , @NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title")
        , @NamedQuery(name = "Post.findByApproved", query = "SELECT p FROM Post p WHERE p.approved = :approved")
        , @NamedQuery(name = "Post.findByInsertDateTime", query = "SELECT p FROM Post p WHERE p.insertDateTime = :insertDateTime")
        , @NamedQuery(name = "Post.findByLastUpdateTime", query = "SELECT p FROM Post p WHERE p.lastUpdateTime = :lastUpdateTime")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private boolean approved;
    @NotNull
    @Column(name = "drafted")
    private boolean drafted;
    @NotNull
    @Column(name = "scheduled")
    private boolean scheduled;

    public boolean isApproved() {
        return approved;
    }

    public boolean isDrafted() {
        return drafted;
    }

    public void setDrafted(boolean drafted) {
        this.drafted = drafted;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @Column(name = "schedule_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleTime;
    @Size(max = 255)
    @NotNull
    @Column(name = "thumbnail_path")
    private String thumbnailPath;
    @Column(name = "unique_slug", unique = true)
    @Size(min = 0, max = 255)
    private String slug;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(String title, String content, boolean approved, Date insertDateTime, Date lastUpdateTime, String thumbnailPath) {
        this.title = title;
        this.content = content;
        this.approved = approved;
        this.insertDateTime = insertDateTime;
        this.lastUpdateTime = lastUpdateTime;
        this.thumbnailPath = thumbnailPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "id=" + id + "";
    }

}
