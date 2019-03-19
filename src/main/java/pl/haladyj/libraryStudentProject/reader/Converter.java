package pl.haladyj.libraryStudentProject.reader;

public interface Converter<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}