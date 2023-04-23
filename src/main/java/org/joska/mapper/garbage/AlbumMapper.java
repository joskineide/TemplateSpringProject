//package org.joska.mapper.garbage;
//
//
//import org.joska.model.album.AlbumDomain;
//import org.joska.model.album.AlbumRequest;
//import org.joska.model.album.AlbumResponse;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
////@Mapper
//@Mapper(componentModel = "spring")
//public interface AlbumMapper {
//    AlbumMapper map = Mappers.getMapper(AlbumMapper.class);
//    @Mapping(target = "title", source = "title")
//    AlbumResponse domainToResponse(AlbumDomain domain);
//    AlbumDomain requestToDomain(AlbumRequest request);
//
//}
