package com.example.servicerequest.model.generated;

import java.util.Objects;
import com.example.servicerequest.model.generated.Pagination;
import com.example.servicerequest.model.generated.ResponseInfo;
import com.example.servicerequest.model.generated.Service;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServiceResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T12:42:44.555+05:30[Asia/Calcutta]")
public class ServiceResponse   {
  @JsonProperty("responseInfo")
  private ResponseInfo responseInfo;

  @JsonProperty("service")
  @Valid
  private List<Service> service = null;

  @JsonProperty("pagination")
  private Pagination pagination;

  public ServiceResponse responseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
    return this;
  }

  /**
   * Get responseInfo
   * @return responseInfo
  */
  @ApiModelProperty(value = "")

  @Valid

  public ResponseInfo getResponseInfo() {
    return responseInfo;
  }

  public void setResponseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
  }

  public ServiceResponse service(List<Service> service) {
    this.service = service;
    return this;
  }

  public ServiceResponse addServiceItem(Service serviceItem) {
    if (this.service == null) {
      this.service = new ArrayList<>();
    }
    this.service.add(serviceItem);
    return this;
  }

  /**
   * Get service
   * @return service
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Service> getService() {
    return service;
  }

  public void setService(List<Service> service) {
    this.service = service;
  }

  public ServiceResponse pagination(Pagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
  */
  @ApiModelProperty(value = "")

  @Valid

  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceResponse serviceResponse = (ServiceResponse) o;
    return Objects.equals(this.responseInfo, serviceResponse.responseInfo) &&
        Objects.equals(this.service, serviceResponse.service) &&
        Objects.equals(this.pagination, serviceResponse.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseInfo, service, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceResponse {\n");
    
    sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

