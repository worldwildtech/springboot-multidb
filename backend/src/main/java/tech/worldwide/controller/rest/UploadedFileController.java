package tech.worldwide.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import tech.worldwide.data.datamodel.UplodedFile;
import tech.worldwide.data.repository.UploadedFileRepository;

@RestController
@RequestMapping("uploaded-file")
public class UploadedFileController {

    @Autowired UploadedFileRepository uploadedFileRepository;

    @GetMapping public List<UplodedFile> list() {
        return uploadedFileRepository.findAll();
    }

    @GetMapping("{id}") public UplodedFile get(@PathVariable Integer id) throws NotFoundException {
        return uploadedFileRepository.findById(id).orElseThrow(() -> new NotFoundException("Data mismatch"));
    }

    @PostMapping public void create(@RequestBody UplodedFile uplodedFile) {
        uploadedFileRepository.save(uplodedFile);
    }

    @PutMapping public void update(@RequestBody UplodedFile uplodedFile) throws NotFoundException {
        uploadedFileRepository.findById(uplodedFile.getId()).orElseThrow(() -> new NotFoundException("Data mismatch"));
        uploadedFileRepository.save(uplodedFile);
    }

    @DeleteMapping public void delete(@RequestBody UplodedFile uplodedFile) throws NotFoundException {
        uploadedFileRepository.findById(uplodedFile.getId()).orElseThrow(() -> new NotFoundException("Data mismatch"));
        uploadedFileRepository.delete(uplodedFile);
    }

}