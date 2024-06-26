package com.tienda_k.services;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
  
    final String BucketName = "techshop-1e33d.appspot.com";   
    final String rutaSuperiorStorage = "techshop";
    final String rutaJsonFile = "firebase";
    final String archivoJsonFile = "techshop-1e33d-firebase-adminsdk-b9d2g-6162262237.json";
    
}
