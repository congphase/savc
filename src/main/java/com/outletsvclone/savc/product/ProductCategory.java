package com.outletsvclone.savc.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "product_category", indexes = {
        @Index(name = "tenant_pcat_idx", columnList = "tenant_id"),
        @Index(name = "code_pcat_idx", columnList = "code")
})
@Entity
@Getter
@Setter
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

}