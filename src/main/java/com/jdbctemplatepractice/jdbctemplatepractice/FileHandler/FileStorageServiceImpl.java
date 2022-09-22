package com.jdbctemplatepractice.jdbctemplatepractice.FileHandler;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService{
    private final Path root = Paths.get("uploads");
    private static final Logger logger = LoggerFactory.getLogger(FileStorageServiceImpl.class);

    @Override
    public void init() {
        try {
            if(!Files.exists(root)){
                Files.createDirectory(root);
                logger.info(root.toAbsolutePath().toString());
            }   
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void store(MultipartFile file,int id) {
        try{
            Files.copy(file.getInputStream(), this.root.resolve(String.valueOf(id).concat(".pdf")));
        }catch(IOException c){
            c.printStackTrace();
        }
        
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    @Override
    public Path load(String filename) {
        try {
            Path file = root.resolve(filename);
            UrlResource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return (Path) resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

 

    @Override
    public void delete(String filename) {
        try {
            Files.delete(this.root.resolve(filename));    
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}

