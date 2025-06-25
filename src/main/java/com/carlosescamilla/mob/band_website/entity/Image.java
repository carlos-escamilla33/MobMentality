package com.carlosescamilla.mob.band_website.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false)
    private String filename;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "processed_at")
    private Date processedAt;

    @Column(name = "enhancement_applied")
    private boolean enhancementApplied;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    public Image() {}

    public Image(String filename, String contentType) {
        this.filename = filename;
        this.contentType = contentType;
        this.createdAt = new Date();
        this.processedAt = null;
        this.enhancementApplied = false;
        this.rejectionReason = "";
    }

    public Long getId() {
        return id;
    }

    public String getContentType() {
        return contentType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getProcessedAt() {
        return processedAt;
    }

    public boolean isEnhancementApplied() {
        return enhancementApplied;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setProcessedAt(Date processedAt) {
        this.processedAt = processedAt;
    }

    public void setEnhancementApplied(boolean enhancementApplied) {
        this.enhancementApplied = enhancementApplied;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    @Override
    public String toString() {
        return "Image [id=" + id + ", filename=" + filename + ", createdAt=" + createdAt + ", processedAt="+processedAt;
    }

}
