package com.spring.tdd.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "widget_productName_idx", columnNames = "productName"))
public class WidgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String productName;
    private String productDetail;

    public WidgetEntity() {
    }

    public WidgetEntity(final String productName, final String productDetail) {
        this.productName = productName;
        this.productDetail = productDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(final String productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WidgetEntity that = (WidgetEntity) o;
        return Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName);
    }

    @Override
    public String toString() {
        return "WidgetEntity{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDetail='" + productDetail + '\'' +
                '}';
    }
}
