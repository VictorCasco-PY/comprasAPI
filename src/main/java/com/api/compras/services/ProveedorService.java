//package com.api.compras.services;
//
//import com.api.compras.dto.ProveedorDTO;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class ProveedorService {
//
//    private final RestTemplate restTemplate;
//    private final String proveedoresApiUrl; // URL de la API de proveedores
//
//    public ProveedorService(RestTemplate restTemplate, @Value("${/provedores}") String proveedoresApiUrl) {
//        this.restTemplate = restTemplate;
//        this.proveedoresApiUrl = proveedoresApiUrl;
//    }
//
//    public ProveedorDTO getProveedorById(String proveedorId) {
//        String url = proveedoresApiUrl + "/proveedores/" + proveedorId; // URL para obtener el proveedor por ID
//        ResponseEntity<ProveedorDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, ProveedorDTO.class);
//
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//            return responseEntity.getBody();
//        } else {
//            // Manejar el error, por ejemplo, lanzar una excepción o devolver un valor predeterminado.
//            return null;
//        }
//    }
//}
