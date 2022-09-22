package com.jdbctemplatepractice.jdbctemplatepractice.FileHandler;

import java.nio.file.Path;
import java.util.stream.Stream;



import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void init();

	void store(MultipartFile file,int id);

	Stream<Path> loadAll();

	Path load(String filename);

	/*Resource loadAsResource(String filename);*/

	void delete(String filename);
}
