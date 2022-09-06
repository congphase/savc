package com.outletsvclone.savc.product;

public class Product {
    //// TO-DO:
    // Unsigned datatype for int-typed attributes?

    private Long id;
    private String code;
    private String name;
    private String parentCatId;
    private int depth;
    private String description;
    private String imageUrl;
    private Long visualIndex;
    private String tenantId;
    private int version;
    private String createdDate;
    private String createUser;
    private String updateDate;
    private String updateUser;

    // Constructor with properties set
    public Product() {
    }

    // Constructor with all properties
    public Product(Long id,
                   String code,
                   String name,
                   String parentCatId,
                   int depth,
                   String description,
                   String imageUrl,
                   Long visualIndex,
                   String tenantId,
                   int version,
                   String createdDate,
                   String createUser,
                   String updateDate,
                   String updateUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.parentCatId = parentCatId;
        this.depth = depth;
        this.description = description;
        this.imageUrl = imageUrl;
        this.visualIndex = visualIndex;
        this.tenantId = tenantId;
        this.version = version;
        this.createdDate = createdDate;
        this.createUser = createUser;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
    }

    // Constructor with all except id (in the case the DB automatically generates for it)
    public Product(String code,
                   String name,
                   String parentCatId,
                   int depth,
                   String description,
                   String imageUrl,
                   Long visualIndex,
                   String tenantId,
                   int version,
                   String createdDate,
                   String createUser,
                   String updateDate,
                   String updateUser) {
        this.code = code;
        this.name = name;
        this.parentCatId = parentCatId;
        this.depth = depth;
        this.description = description;
        this.imageUrl = imageUrl;
        this.visualIndex = visualIndex;
        this.tenantId = tenantId;
        this.version = version;
        this.createdDate = createdDate;
        this.createUser = createUser;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getParentCatId() {
        return parentCatId;
    }

    public int getDepth() {
        return depth;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getVisualIndex() {
        return visualIndex;
    }

    public String getTenantId() {
        return tenantId;
    }

    public int getVersion() {
        return version;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    // To-string(s)
    @Override // This annotation is added automatically by IDE
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentCatId='" + parentCatId + '\'' +
                ", depth=" + depth +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", visualIndex=" + visualIndex +
                ", tenantId='" + tenantId + '\'' +
                ", version=" + version +
                ", createdDate='" + createdDate + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
