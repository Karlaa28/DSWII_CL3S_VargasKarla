package pe.edu.cibertec.DSWII_CL3_VargasKarla.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {

    private final Path rootFolder = Paths.get("archivos");

    public void save(MultipartFile file) throws Exception {
        if (!file.getOriginalFilename().toLowerCase().endsWith(".pdf")) {
            throw new IllegalArgumentException("El archivo no es un PDF");
        }

        Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()));
    }

    public void savePDF(MultipartFile file) throws Exception {
        if (!file.getOriginalFilename().toLowerCase().endsWith(".pdf")) {
            throw new IllegalArgumentException("El archivo no es un PDF");
        }

        Files.copy(file.getInputStream(), this.rootFolder.resolve("Documentos").resolve(file.getOriginalFilename()));
    }

    public void saveDOC(MultipartFile file) throws Exception {
        if (!file.getOriginalFilename().toLowerCase().endsWith(".doc")) {
            throw new IllegalArgumentException("El archivo no es un DOC");
        }

        if (file.getSize() > 2 * 1024 * 1024) {
            throw new IllegalArgumentException("El archivo supera el tamaño máximo permitido (2MB)");
        }

        Files.copy(file.getInputStream(), this.rootFolder.resolve("Documentos").resolve(file.getOriginalFilename()));
    }

    public void save(List<MultipartFile> files) throws Exception {
        for (MultipartFile file : files) {
            this.save(file);
        }
    }
}

