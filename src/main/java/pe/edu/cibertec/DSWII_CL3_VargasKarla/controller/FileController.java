package pe.edu.cibertec.DSWII_CL3_VargasKarla.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.DSWII_CL3_VargasKarla.model.response.ResponseFile;
import pe.edu.cibertec.DSWII_CL3_VargasKarla.service.FileService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/files")
public class FileController {

    private final FileService fileService;

    @PostMapping("/filespdf")
    @PreAuthorize("hasRole('SUPERVISOR')")
    public ResponseEntity<ResponseFile> uploadPDF(@RequestParam("file") MultipartFile file) {
        try {
            fileService.savePDF(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseFile.builder().message("Archivo PDF subido con éxito").build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseFile.builder().error(e.getMessage()).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseFile.builder().error("Error interno del servidor").build());
        }
    }

    @PostMapping("/filesdoc")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseFile> uploadDOC(@RequestParam("file") MultipartFile file) {
        try {
            fileService.saveDOC(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseFile.builder().message("Archivo DOC subido con éxito").build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseFile.builder().error(e.getMessage()).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseFile.builder().error("Error interno del servidor").build());
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseFile> uploadFiles(@RequestParam("files") List<MultipartFile> files) {
        try {
            fileService.save(files);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseFile.builder().message("Los archivos fueron cargados correctamente al servidor").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseFile.builder().error("Error interno del servidor").build());
        }
    }
}
