package com.example.servicerequest.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Pagination details
 */
@ApiModel(description = "Pagination details")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T12:42:44.555+05:30[Asia/Calcutta]")
public class Pagination   {
  @JsonProperty("limit")
  private BigDecimal limit = new BigDecimal("10");

  @JsonProperty("offSet")
  private BigDecimal offSet = new BigDecimal("0");

  @JsonProperty("totalCount")
  private BigDecimal totalCount;

  @JsonProperty("sortBy")
  private String sortBy;

  /**
   * Sorting order
   */
  public enum OrderEnum {
    ASC("asc"),
    
    DESC("desc");

    private String value;

    OrderEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OrderEnum fromValue(String value) {
      for (OrderEnum b : OrderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("order")
  private OrderEnum order;

  public Pagination limit(BigDecimal limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Limit for total no of records in single search max limit should be defined as environment variable
   * maximum: 100
   * @return limit
  */
  @ApiModelProperty(value = "Limit for total no of records in single search max limit should be defined as environment variable")

  @Valid
@DecimalMax("100") 
  public BigDecimal getLimit() {
    return limit;
  }

  public void setLimit(BigDecimal limit) {
    this.limit = limit;
  }

  public Pagination offSet(BigDecimal offSet) {
    this.offSet = offSet;
    return this;
  }

  /**
   * offset or page no
   * @return offSet
  */
  @ApiModelProperty(value = "offset or page no")

  @Valid

  public BigDecimal getOffSet() {
    return offSet;
  }

  public void setOffSet(BigDecimal offSet) {
    this.offSet = offSet;
  }

  public Pagination totalCount(BigDecimal totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Total count for a particular criteria
   * @return totalCount
  */
  @ApiModelProperty(readOnly = true, value = "Total count for a particular criteria")

  @Valid

  public BigDecimal getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(BigDecimal totalCount) {
    this.totalCount = totalCount;
  }

  public Pagination sortBy(String sortBy) {
    this.sortBy = sortBy;
    return this;
  }

  /**
   * result sorting order
   * @return sortBy
  */
  @ApiModelProperty(value = "result sorting order")


  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
  }

  public Pagination order(OrderEnum order) {
    this.order = order;
    return this;
  }

  /**
   * Sorting order
   * @return order
  */
  @ApiModelProperty(value = "Sorting order")


  public OrderEnum getOrder() {
    return order;
  }

  public void setOrder(OrderEnum order) {
    this.order = order;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagination pagination = (Pagination) o;
    return Objects.equals(this.limit, pagination.limit) &&
        Objects.equals(this.offSet, pagination.offSet) &&
        Objects.equals(this.totalCount, pagination.totalCount) &&
        Objects.equals(this.sortBy, pagination.sortBy) &&
        Objects.equals(this.order, pagination.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(limit, offSet, totalCount, sortBy, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pagination {\n");
    
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offSet: ").append(toIndentedString(offSet)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

