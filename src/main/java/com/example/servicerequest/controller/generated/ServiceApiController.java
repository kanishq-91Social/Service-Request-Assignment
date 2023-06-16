package com.example.servicerequest.controller.generated;

import com.example.servicerequest.model.generated.*;
import com.example.servicerequest.service.ServiceApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-14T12:42:44.555+05:30[Asia/Calcutta]")
@Controller
@RequestMapping("${openapi.serviceRequest.base-path:}")
public class ServiceApiController implements ServiceApi {

    @Autowired
    private ServiceApiService serviceApiService;
    private final ServiceApiDelegate delegate;

    public ServiceApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ServiceApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ServiceApiDelegate() {});
    }

    /**
     * POST /service/definition/v1/_create
     *
     * @param serviceDefinitionRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @ApiOperation(value = "", nickname = "serviceDefinitionV1CreatePost", notes = "", response = ServiceDefinitionResponse.class, tags={ "Service Definition", })
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Request accepted.", response = ServiceDefinitionResponse.class),
            @ApiResponse(code = 400, message = "Invalid input.", response = ErrorRes.class) })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/definition/v1/_create",
            produces = MediaType.APPLICATION_JSON_VALUE,//{ "*/*" },
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1CreatePost(ServiceDefinitionRequest serviceDefinitionRequest) {
        ServiceDefinitionResponse response = serviceApiService.createServiceDefinition(serviceDefinitionRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * POST /service/definition/v1/_search
     *
     * @param serviceDefinitionSearchRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @ApiOperation(value = "", nickname = "serviceDefinitionV1SearchPost", notes = "", response = ServiceDefinitionResponse.class, tags={ "Service Definition", })
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Request accepted.", response = ServiceDefinitionResponse.class),
            @ApiResponse(code = 400, message = "Invalid input.", response = ErrorRes.class) })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/definition/v1/_search",
            produces = MediaType.APPLICATION_JSON_VALUE,//{ "*/*" },
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1SearchPost(ServiceDefinitionSearchRequest serviceDefinitionSearchRequest) {
        return serviceApiService.serviceDefinitionV1SearchPost(serviceDefinitionSearchRequest);
    }

    /**
     * POST /service/v1/_create
     *
     * @param serviceRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @ApiOperation(value = "", nickname = "serviceV1CreatePost", notes = "", response = ServiceResponse.class, tags={ "Service", })
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Request accepted.", response = ServiceResponse.class),
            @ApiResponse(code = 400, message = "Invalid input.", response = ErrorRes.class) })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/v1/_create",
            produces = MediaType.APPLICATION_JSON_VALUE,//{ "*/*" },
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceResponse> serviceV1CreatePost(ServiceRequest serviceRequest) {
        ServiceResponse response = serviceApiService.createService(serviceRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * POST /service/v1/_search
     *
     * @param serviceSearchRequest  (optional)
     * @return Request accepted. (status code 202)
     *         or Invalid input. (status code 400)
     */
    @ApiOperation(value = "", nickname = "serviceV1SearchPost", notes = "", response = ServiceResponse.class, tags={ "Service", })
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Request accepted.", response = ServiceResponse.class),
            @ApiResponse(code = 400, message = "Invalid input.", response = ErrorRes.class) })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/service/v1/_search",
            produces = MediaType.APPLICATION_JSON_VALUE,//{ "*/*" },
            consumes = { "application/json" }
    )
    @Override
    public ResponseEntity<ServiceResponse> serviceV1SearchPost(ServiceSearchRequest serviceSearchRequest) {
        return serviceApiService.serviceV1SearchPost(serviceSearchRequest);
    }

    @Override
    public ServiceApiDelegate getDelegate() {
        return delegate;
    }

}
