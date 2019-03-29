package pl.haladyj.libraryStudentProject.utils;

public interface Converter<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}
