package com.outletsvclone.savc.product;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "product_category", indexes = {
        @Index(name = "tenant_pcat_idx", columnList = "tenant_id"),
        @Index(name = "code_pcat_idx", columnList = "code")
})
@Entity
public class ProductCategory {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "parent_cat_id", length = 100)
    private String parentCatId;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "description", length = 512)
    private String description;

    @Column(name = "image_url", length = 512)
    private String imageUrl;

    @Column(name = "visual_index")
    private Integer visualIndex;

    @Column(name = "tenant_id", nullable = false, length = 100)
    private String tenantId;

    @Column(name = "version")
    private Integer version;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "create_user", length = 100)
    private String createUser;

    @Column(name = "update_date")
    private Instant updateDate;

    @Column(name = "update_user", length = 100)
    private String updateUser;

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getVisualIndex() {
        return visualIndex;
    }

    public void setVisualIndex(Integer visualIndex) {
        this.visualIndex = visualIndex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getParentCatId() {
        return parentCatId;
    }

    public void setParentCatId(String parentCatId) {
        this.parentCatId = parentCatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}