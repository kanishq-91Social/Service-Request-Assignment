package com.example.servicerequest.model.generated;

import java.util.Objects;
import com.example.servicerequest.model.generated.Role;
import com.example.servicerequest.model.generated.TenantRole;
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
 * This is acting ID token of the authenticated user on the server. Any value provided by the clients will be ignored and actual user based on authtoken will be used on the server.
 */
@ApiModel(description = "This is acting ID token of the authenticated user on the server. Any value provided by the clients will be ignored and actual user based on authtoken will be used on the server.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T12:42:44.555+05:30[Asia/Calcutta]")
public class UserInfo   {
  @JsonProperty("tenantId")
  private String tenantId;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("mobile")
  private String mobile;

  @JsonProperty("email")
  private String email;

  @JsonProperty("primaryrole")
  @Valid
  private List<Role> primaryrole = new ArrayList<>();

  @JsonProperty("additionalroles")
  @Valid
  private List<TenantRole> additionalroles = null;

  public UserInfo tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Unique Identifier of the tenant to which user primarily belongs
   * @return tenantId
  */
  @ApiModelProperty(required = true, value = "Unique Identifier of the tenant to which user primarily belongs")
  @NotNull


  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public UserInfo id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * User id of the authenticated user. Will be deprecated in future
   * @return id
  */
  @ApiModelProperty(value = "User id of the authenticated user. Will be deprecated in future")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UserInfo userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Unique user name of the authenticated user
   * @return userName
  */
  @ApiModelProperty(required = true, value = "Unique user name of the authenticated user")
  @NotNull


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserInfo mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * mobile number of the autheticated user
   * @return mobile
  */
  @ApiModelProperty(value = "mobile number of the autheticated user")


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public UserInfo email(String email) {
    this.email = email;
    return this;
  }

  /**
   * email address of the authenticated user
   * @return email
  */
  @ApiModelProperty(value = "email address of the authenticated user")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserInfo primaryrole(List<Role> primaryrole) {
    this.primaryrole = primaryrole;
    return this;
  }

  public UserInfo addPrimaryroleItem(Role primaryroleItem) {
    this.primaryrole.add(primaryroleItem);
    return this;
  }

  /**
   * List of all the roles for the primary tenant
   * @return primaryrole
  */
  @ApiModelProperty(required = true, value = "List of all the roles for the primary tenant")
  @NotNull

  @Valid

  public List<Role> getPrimaryrole() {
    return primaryrole;
  }

  public void setPrimaryrole(List<Role> primaryrole) {
    this.primaryrole = primaryrole;
  }

  public UserInfo additionalroles(List<TenantRole> additionalroles) {
    this.additionalroles = additionalroles;
    return this;
  }

  public UserInfo addAdditionalrolesItem(TenantRole additionalrolesItem) {
    if (this.additionalroles == null) {
      this.additionalroles = new ArrayList<>();
    }
    this.additionalroles.add(additionalrolesItem);
    return this;
  }

  /**
   * array of additional tenantids authorized for the authenticated user
   * @return additionalroles
  */
  @ApiModelProperty(value = "array of additional tenantids authorized for the authenticated user")

  @Valid

  public List<TenantRole> getAdditionalroles() {
    return additionalroles;
  }

  public void setAdditionalroles(List<TenantRole> additionalroles) {
    this.additionalroles = additionalroles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(this.tenantId, userInfo.tenantId) &&
        Objects.equals(this.id, userInfo.id) &&
        Objects.equals(this.userName, userInfo.userName) &&
        Objects.equals(this.mobile, userInfo.mobile) &&
        Objects.equals(this.email, userInfo.email) &&
        Objects.equals(this.primaryrole, userInfo.primaryrole) &&
        Objects.equals(this.additionalroles, userInfo.additionalroles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, id, userName, mobile, email, primaryrole, additionalroles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    primaryrole: ").append(toIndentedString(primaryrole)).append("\n");
    sb.append("    additionalroles: ").append(toIndentedString(additionalroles)).append("\n");
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

