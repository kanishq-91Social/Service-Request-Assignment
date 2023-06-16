package com.example.servicerequest.service;

import com.example.servicerequest.controller.generated.ServiceApiDelegate;
import com.example.servicerequest.dao.ServiceDAO;
import com.example.servicerequest.dao.ServiceDefinitionDAO;
import com.example.servicerequest.model.generated.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class ServiceApiService implements ServiceApiDelegate {

    @Autowired
    private ServiceDefinitionDAO serviceDefinitionDAO;

    @Autowired
    private ServiceDAO serviceDAO;
    public ServiceDefinitionResponse createServiceDefinition(ServiceDefinitionRequest serviceDefinitionRequest) {
        //validate infos
        RequestInfo requestInfo = serviceDefinitionRequest.getRequestInfo();
        ResponseInfo responseInfo = getResponseInfo(requestInfo);
        ServiceDefinitionResponse response = new ServiceDefinitionResponse();
        response.setResponseInfo(responseInfo);
        ServiceDefinition sd = serviceDefinitionRequest.getServiceDefinition();
        try {
            String res = readFromURL("https://random-data-api.com/api/v2/users?size=1");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(res).get("address");
            JsonNode addressNode = mapper.createObjectNode().set("address", node);
            sd.setAdditionalDetails(addressNode);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        serviceDefinitionDAO.insert(sd);
        response.addServiceDefinitionItem(sd);
        return response;
    }

    public String readFromURL(String urlStr) throws MalformedURLException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                sb.append(line);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    @Override
    public ResponseEntity<ServiceDefinitionResponse> serviceDefinitionV1SearchPost(ServiceDefinitionSearchRequest serviceDefinitionSearchRequest) {
        ServiceDefinitionResponse serviceDefinitionResponse = new ServiceDefinitionResponse();
        serviceDefinitionResponse.setPagination(serviceDefinitionSearchRequest.getPagination());
        serviceDefinitionResponse.setResponseInfo(getResponseInfo(serviceDefinitionSearchRequest.getRequestInfo()));
        ServiceDefinitionCriteria serviceDefinitionCriteria = serviceDefinitionSearchRequest.getServiceDefinitionCriteria();
        List<ServiceDefinition> searchResult = serviceDefinitionDAO.findByCriteria(serviceDefinitionCriteria, serviceDefinitionSearchRequest.getPagination());
        if(searchResult != null) searchResult.forEach(serviceDefinition -> serviceDefinitionResponse.addServiceDefinitionItem(serviceDefinition));
        return new ResponseEntity<>(serviceDefinitionResponse, HttpStatus.OK);
    }

    public ServiceResponse createService(ServiceRequest serviceRequest) {
        //validate infos
        RequestInfo requestInfo = serviceRequest.getRequestInfo();
        ResponseInfo responseInfo = getResponseInfo(requestInfo);
        ServiceResponse response = new ServiceResponse();
        response.setResponseInfo(responseInfo);
        com.example.servicerequest.model.generated.Service service = serviceRequest.getService();
        serviceDAO.insert(service);
        response.addServiceItem(service);
        return response;
    }

    @Override
    public ResponseEntity<ServiceResponse> serviceV1SearchPost(ServiceSearchRequest serviceSearchRequest) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setPagination(serviceSearchRequest.getPagination());
        serviceResponse.setResponseInfo(getResponseInfo(serviceSearchRequest.getRequestInfo()));
        ServiceCriteria serviceCriteria = serviceSearchRequest.getServiceDefinition();
        List<com.example.servicerequest.model.generated.Service> searchResult = serviceDAO.findByCriteria(serviceCriteria, serviceSearchRequest.getPagination());
        if(searchResult != null) searchResult.forEach(service -> serviceResponse.addServiceItem(service));
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    public ResponseInfo getResponseInfo(@NotNull RequestInfo requestInfo) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setApiId(requestInfo.getApiId());
        responseInfo.setVer(requestInfo.getVer());
//        responseInfo.setTs(requestInfo.getTs()); //if its a timestamp then should it be different from the request timestamp?
        responseInfo.setMsgId(requestInfo.getMsgId());
        return responseInfo;
    }
}
