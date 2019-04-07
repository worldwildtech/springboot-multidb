package tech.worldwide.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.worldwide.data.datamodel.UplodedFile;

public interface UploadedFileRepository extends JpaRepository<UplodedFile, Integer> {

}